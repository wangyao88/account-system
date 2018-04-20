package com.sxkl.webapp.account.category.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
			List<Category> categoris = categoryDao.findByTypeAndAccountId(type,accountId);
			return OperationResult.configurateSuccessResult(categoris);
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

	public String addRootIncomeCategory(String name, String accountId) {
		try {
			Category category = new Category();
			category.setAccountId(accountId);
			category.setCreateDate(new Date());
			category.setName(name);
			category.setType(CategoryType.INCOME.toString());
			categoryDao.save(category);
			return OperationResult.configurateSuccessResult("类别保存成功");
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("类别保存失败！错误信息："+e.getMessage());
		}
	}

	public String addChildIncomeCategory(String name, String parentId, String accountId) {
		try {
			Category category = new Category();
			category.setAccountId(accountId);
			category.setCreateDate(new Date());
			category.setName(name);
			category.setType(CategoryType.INCOME.toString());
			category.setParentId(parentId);
			categoryDao.save(category);
			return OperationResult.configurateSuccessResult("子类别保存成功");
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("子类别保存失败！错误信息："+e.getMessage());
		}
	}

	public String updateIncomeCategory(String id, String name) {
		try {
		    Optional<Category> optional = categoryDao.findById(id);
		    Category result = optional.get();
			result.setName(name);
			categoryDao.save(result);
			return OperationResult.configurateSuccessResult("类别修改成功");
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("类别修改失败！错误信息："+e.getMessage());
		}
	}
}
