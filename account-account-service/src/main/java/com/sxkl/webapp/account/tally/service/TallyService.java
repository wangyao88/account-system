package com.sxkl.webapp.account.tally.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

import com.google.common.collect.Lists;
import com.sxkl.webapp.account.tally.dao.ITallyJpaDao;
import com.sxkl.webapp.account.tally.entity.Tally;
import com.sxkl.webapp.common.OperationResult;
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
}
