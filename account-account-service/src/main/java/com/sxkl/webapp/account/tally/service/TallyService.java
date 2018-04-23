package com.sxkl.webapp.account.tally.service;

import java.util.Date;
import java.util.List;

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
public class TallyService {

	@Autowired
	private ITallyJpaDao tallyDao;

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
					for (int i = 0; i < size; i++) {
						predicateArr[i] = predicates.get(i);
					}
					query.where(predicateArr);
					return null;
				}
			};
			Page<Tally> pages =  tallyDao.findAll(specification, pageable);
			return OperationResult.configurateSuccessDataGridResult(pages.getContent(), pages.getTotalPages());
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取账本条目失败！错误信息："+e.getMessage());
		}
	}
}
