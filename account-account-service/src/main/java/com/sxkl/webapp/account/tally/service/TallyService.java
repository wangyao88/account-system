package com.sxkl.webapp.account.tally.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.sxkl.webapp.account.tally.dao.ITallyJpaDao;
import com.sxkl.webapp.account.tally.entity.CategoryLineData;
import com.sxkl.webapp.account.tally.entity.Serie;
import com.sxkl.webapp.account.tally.entity.Tally;
import com.sxkl.webapp.common.OperationResult;
import com.sxkl.webapp.utils.DateUtil;
import com.sxkl.webapp.utils.ObjectUtils;
import com.sxkl.webapp.utils.StringUtils;

/**
 * @author: wangyao
 * @date: 2018年4月23日 上午9:22:45
 * @description: 
 */
@Service
public class TallyService{

	@Autowired
	private ITallyJpaDao tallyDao;
	@PersistenceContext
	private EntityManager entityManager;
	
	public String save(Tally tally) {
		try {
			if(ObjectUtils.isNull(tally.getMoney())){
				return OperationResult.configurateFailureResult("金额不能为空");
			}
			tallyDao.save(tally);
			return OperationResult.configurateSuccessResult("记账成功");
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("记账失败！错误信息："+e.getMessage());
		}
	}
	
	@SuppressWarnings("serial")
	public String findPage(Tally tally, int pageIndex, int pageSize){
		try {
			Pageable pageable = PageRequest.of(pageIndex,pageSize);
			Specification<Tally> specification = new Specification<Tally>(){
				@Override
				public Predicate toPredicate(Root<Tally> root, CriteriaQuery<?> query,CriteriaBuilder criteriaBuilder) {
					conigureCriteriaQuery(tally, root, query, criteriaBuilder);
					return null;
				}
			};
			Page<Tally> pages =  tallyDao.findAll(specification, pageable);
			int total = pages.getTotalPages();
			List<Tally> sumMoneys = getSearchSumMoney(tally);
			List<Tally> datas = pages.getContent();
			List<Tally> result = Lists.newArrayList(datas);
			result.addAll(sumMoneys);
			return OperationResult.configurateSuccessDataGridResult(result, total);
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取账本条目失败！错误信息："+e.getMessage());
		}
	}
	
	private List<Tally> getSearchSumMoney(Tally tally){
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
			Root<Tally> root = criteriaQuery.from(Tally.class);
			criteriaQuery.groupBy(root.get("categoryType"));
			conigureCriteriaQuery(tally, root, criteriaQuery, criteriaBuilder);
			criteriaQuery.multiselect(root.get("categoryType").alias("categoryType"),criteriaBuilder.sum(root.get("money")).alias("money"));
			TypedQuery<Tuple> typedQuery = entityManager.createQuery(criteriaQuery);
			List<Tuple> datas = typedQuery.getResultList();
			List<Tally> result = Lists.newArrayList();
			for(Tuple tuple : datas){
				String categoryType = tuple.get("categoryType").toString();
				String money = tuple.get("money").toString();
				result.add(new Tally(categoryType,Float.parseFloat(money)));
			}
			return result;
		} catch (Exception e) {
			return Lists.newArrayList();
		}
	}
	
	@SuppressWarnings("serial")
	public String getSumMoney(Tally tally){
		try {
			Specification<Tally> specification = new Specification<Tally>(){
				@Override
				public Predicate toPredicate(Root<Tally> root, CriteriaQuery<?> query,CriteriaBuilder criteriaBuilder) {
					query.multiselect(root.get("categoryType"),criteriaBuilder.sum(root.get("money")));
					conigureCriteriaQuery(tally, root, query, criteriaBuilder);
					query.groupBy(root.get("categoryType"));
					return null;
				}
			};
			List<Tally> tallies = tallyDao.findAll(specification);
			return OperationResult.configurateSuccessResult(tallies);
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取账本收支总额失败！错误信息："+e.getMessage());
		}
	}
	
	public List<Tally> getSumPerAccount(){
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Tally> root = criteriaQuery.from(Tally.class);
		criteriaQuery.groupBy(root.get("categoryType"),root.get("accountId"));
		criteriaQuery.multiselect(root.get("accountId").alias("accountId"),
								  root.get("categoryType").alias("categoryType"),
								  criteriaBuilder.sum(root.get("money")).alias("money"));
		TypedQuery<Tuple> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Tuple> datas = typedQuery.getResultList();
		List<Tally> result = Lists.newArrayList();
		for(Tuple tuple : datas){
			String accountId = tuple.get("accountId").toString();
			String categoryType = tuple.get("categoryType").toString();
			String money = tuple.get("money").toString();
			result.add(new Tally(accountId,categoryType,Float.parseFloat(money)));
		}
		return result;
	}
	
	private void conigureCriteriaQuery(Tally tally, Root<Tally> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = Lists.newArrayList();
		Path<String> accountIdPath = root.get("accountId");
		predicates.add(criteriaBuilder.equal(accountIdPath, tally.getAccountId()));
		if(StringUtils.isNotEmpty(tally.getCategoryType())){
			Path<String> categoryTypePath = root.get("categoryType");  
			predicates.add(criteriaBuilder.equal(categoryTypePath, tally.getCategoryType()));
		}
		if(ObjectUtils.isNotNull(tally.getBeginDate())){
			Path<Date> createDatePath = root.get("createDate");  
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(createDatePath, tally.getBeginDate()));
		}
		if(ObjectUtils.isNotNull(tally.getEndDate())){
			Path<Date> createDatePath = root.get("createDate");  
			predicates.add(criteriaBuilder.lessThanOrEqualTo(createDatePath, tally.getEndDate()));
		}
		int size = predicates.size();
		Predicate[] predicateArr = new Predicate[size];
		query.where(predicates.toArray(predicateArr));
	}

	public String getCategoryData(Tally tally) {
		try {
			TallyConditionService.initTallyDate(tally);
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
			Root<Tally> root = criteriaQuery.from(Tally.class);
			criteriaQuery.groupBy(root.get("categoryName"));
			conigureCriteriaQuery(tally, root, criteriaQuery, criteriaBuilder);
			criteriaQuery.multiselect(root.get("categoryName").alias("categoryName"),criteriaBuilder.sum(root.get("money")).alias("money"));
			TypedQuery<Tuple> typedQuery = entityManager.createQuery(criteriaQuery);
			List<Tuple> datas = typedQuery.getResultList();
			List<Tally> result = Lists.newArrayList();
			for(Tuple tuple : datas){
				String categoryName = tuple.get("categoryName").toString();
				String money = tuple.get("money").toString();
				Tally bean = new Tally();
				bean.setCategoryName(categoryName);
				bean.setMoney(Float.parseFloat(money));
				result.add(bean);
			}
			return OperationResult.configurateSuccessResult(result);
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取账本类别统计数据失败！错误信息："+e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public String getCategoryLineData(Tally tally) {
		try {
			String sql = TallyConditionService.getCategoryLineDataSql(tally);
			Query query = entityManager.createNativeQuery(sql);
			List<Object[]> data = query.getResultList();
			Map<String, Object[]> map = Maps.uniqueIndex(data, new Function<Object[], String>() {
				public String apply(Object[] from) {
					return StringUtils.appendJoinEmpty(from[0].toString(), from[1].toString());
				}
			});
			
			Set<String> categoryNameSet = Sets.newHashSet();
			CategoryLineData categoryLineData = new CategoryLineData();
			for(Object[] objs : data){
				categoryNameSet.add(objs[1].toString());
			}
			int categoryNameSetSize = categoryNameSet.size();
			String[] categoryNames = new String[categoryNameSetSize];
			categoryLineData.setLegendData(categoryNameSet.toArray(categoryNames));
			
			List<String> monthRanges = TallyConditionService.getDateRange(tally);
			
			String[] months = new String[monthRanges.size()];
			categoryLineData.setXAxisData(monthRanges.toArray(months));
			Serie[] series = new Serie[categoryNameSetSize];
			for (int i = 0; i < categoryNameSetSize; i++) {
				String categoryName = categoryNames[i];
				Serie serie = new Serie();
				serie.setName(categoryName);
				serie.setType("line");
				List<Float> serieDatas = Lists.newArrayList();
				for(String month : monthRanges){
					String key = StringUtils.appendJoinEmpty(month,categoryName);
					if(map.containsKey(key)){
						Object money = map.get(key)[2];
						serieDatas.add(Float.valueOf(money.toString()));
						continue;
					}
					serieDatas.add(0.0f);
				}
				Float[] dataArr = new Float[serieDatas.size()];
				serie.setData(serieDatas.toArray(dataArr));
				series[i] = serie;
			}
			categoryLineData.setSeriesData(series);
			return OperationResult.configurateSuccessResult(categoryLineData);
		} catch (Exception e) {
			e.printStackTrace();
			return OperationResult.configurateFailureResult("获取账本类别折线统计数据失败！错误信息："+e.getMessage());
		}
	}
	
	public String getInAndOutSumData(Tally tally) {
		try {
			TallyConditionService.initTallyDate(tally);
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
			Root<Tally> root = criteriaQuery.from(Tally.class);
			criteriaQuery.groupBy(root.get("categoryType"));
			conigureCriteriaQuery(tally, root, criteriaQuery, criteriaBuilder);
			criteriaQuery.multiselect(root.get("categoryType").alias("categoryType"),criteriaBuilder.sum(root.get("money")).alias("money"));
			TypedQuery<Tuple> typedQuery = entityManager.createQuery(criteriaQuery);
			List<Tuple> datas = typedQuery.getResultList();
			List<Tally> result = Lists.newArrayList();
			for(Tuple tuple : datas){
				String categoryType = tuple.get("categoryType").toString();
				categoryType = categoryType.equals("INCOME") ? "收入" : "支出";
				String money = tuple.get("money").toString();
				Tally bean = new Tally();
				bean.setCategoryType(categoryType);
				bean.setMoney(Float.parseFloat(money));
				result.add(bean);
			}
			return OperationResult.configurateSuccessResult(result);
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取综合统计饼图数据失败！错误信息："+e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public String getInAndOutSumLineData(Tally tally) {
		try {
			String sql = TallyConditionService.getInAndOutSumLineDataSql(tally);
			Query query = entityManager.createNativeQuery(sql);
			List<Object[]> data = query.getResultList();
			Map<String, Object[]> map = Maps.uniqueIndex(data, new Function<Object[], String>() {
				public String apply(Object[] from) {
					String categoryType = from[1].toString().equals("INCOME") ? "收入" : "支出";
					return StringUtils.appendJoinEmpty(from[0].toString(), categoryType);
				}
			});
			
			Set<String> categoryTypeSet = Sets.newHashSet();
			CategoryLineData categoryLineData = new CategoryLineData();
			for(Object[] objs : data){
				String categoryType = objs[1].toString().equals("INCOME") ? "收入" : "支出";
				categoryTypeSet.add(categoryType);
			}
			int categoryTypeSetSize = categoryTypeSet.size();
			String[] categoryTypes = new String[categoryTypeSetSize];
			categoryLineData.setLegendData(categoryTypeSet.toArray(categoryTypes));
			
			List<String> dateRanges = TallyConditionService.getDateRange(tally,tally.getDateType());
			
			String[] dates = new String[dateRanges.size()];
			categoryLineData.setXAxisData(dateRanges.toArray(dates));
			Serie[] series = new Serie[categoryTypeSetSize];
			for (int i = 0; i < categoryTypeSetSize; i++) {
				String categoryType = categoryTypes[i];
				Serie serie = new Serie();
				serie.setName(categoryType);
				serie.setType("line");
				List<Float> serieDatas = Lists.newArrayList();
				for(String date : dateRanges){
					String key = StringUtils.appendJoinEmpty(date,categoryType);
					if(map.containsKey(key)){
						Object money = map.get(key)[2];
						serieDatas.add(Float.valueOf(money.toString()));
						continue;
					}
					serieDatas.add(0.0f);
				}
				Float[] dataArr = new Float[serieDatas.size()];
				serie.setData(serieDatas.toArray(dataArr));
				series[i] = serie;
			}
			categoryLineData.setSeriesData(series);
			return OperationResult.configurateSuccessResult(categoryLineData);
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取总和统计折线图数据失败！错误信息："+e.getMessage());
		}
	}
	
	public String getDynamicData() {
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
			Root<Tally> root = criteriaQuery.from(Tally.class);
			
			Path<String> categoryTypePath = root.get("categoryType");
			Predicate categoryTypePredicate = criteriaBuilder.equal(categoryTypePath, "OUTCOME");
			Path<Date> createDatePath = root.get("createDate");  
			Predicate beginDatePredicate = criteriaBuilder.greaterThanOrEqualTo(createDatePath, DateUtil.getOneYearAgo());
			criteriaQuery.where(categoryTypePredicate,beginDatePredicate);
			
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get("createDate")));
			
			criteriaQuery.multiselect(root.get("createDate").alias("createDate"),root.get("money").alias("money"));
			TypedQuery<Tuple> typedQuery = entityManager.createQuery(criteriaQuery);
			typedQuery.setFirstResult(0);
			typedQuery.setMaxResults(1000);
			List<Tuple> datas = typedQuery.getResultList();
			List<Tally> result = Lists.newArrayList();
			for(Tuple tuple : datas){
				String createDate = tuple.get("createDate").toString();
				String money = tuple.get("money").toString();
				Tally bean = new Tally();
				bean.setCreateDate(DateUtil.parseStrToDate(createDate, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
				bean.setMoney(Float.parseFloat(money));
				result.add(bean);
			}
			return OperationResult.configurateSuccessResult(result);
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取动态支出数据失败！错误信息："+e.getMessage());
		}
	}
}
