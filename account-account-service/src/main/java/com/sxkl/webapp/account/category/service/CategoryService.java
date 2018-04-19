package com.sxkl.webapp.account.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sxkl.webapp.account.category.dao.ICategoryJpaDao;
import com.sxkl.webapp.account.category.entity.Category;
import com.sxkl.webapp.account.category.entity.CategoryType;
import com.sxkl.webapp.common.OperationResult;

/**
 * @author: wangyao
 * @date: 2018年4月19日 上午10:30:32
 * @description: 
 */
@Service
public class CategoryService {

	@Autowired
	private ICategoryJpaDao categoryDao;
	
	public String getIncomeCategory(String accountId){
		return getCategory(CategoryType.INCOME.toString(),accountId);
	}
	
	public String getOutcomeCategory(String accountId){
		return getCategory(CategoryType.OUTCOME.toString(),accountId);
	}
	
	private String getCategory(String type, String accountId){
		try {
			System.out.println("accountId---------------"+accountId);
			List<Category> categoris = categoryDao.findByTypeAndAccountId(type,accountId);
			String result = OperationResult.configurateSuccessResult(categoris);
			System.out.println(result);
			return result;
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取类别失败！错误信息："+e.getMessage());
		}
	}
	
	public String getCategoryPage(int pageIndex, int pageSize, String type, String accountId){
		try {
			Pageable pageable = PageRequest.of(pageIndex,pageSize);
			Page<Category> categoris = categoryDao.findByTypeAndAccountId(type,accountId,pageable);
			return OperationResult.configurateSuccessResult(categoris.getContent());
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("获取类别失败！错误信息："+e.getMessage());
		}
	}
	
	public String save(Category category){
		try {
			categoryDao.save(category);
			return OperationResult.configurateSuccessResult("类别保存成功");
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("类别保存失败！错误信息："+e.getMessage());
		}
	}
}
