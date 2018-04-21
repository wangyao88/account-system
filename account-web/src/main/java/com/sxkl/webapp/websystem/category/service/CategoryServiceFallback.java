package com.sxkl.webapp.websystem.category.service;

import org.springframework.stereotype.Component;

import com.sxkl.webapp.websystem.common.service.BaseServiceFallback;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午12:49:37
 * @description: 
 */
@Component
public class CategoryServiceFallback extends BaseServiceFallback implements CategoryService {

	@Override
	public String getIncomeCategory(String accountId) {
		return getServiceErrorResult("获取收入类别失败");
	}

	@Override
	public String addRootIncomeCategory(String name, String accountId) {
		return getServiceErrorResult("添加收入类别失败");
	}

	@Override
	public String addChildIncomeCategory(String name, String parentId, String accountId) {
		return getServiceErrorResult("添加收入子类别失败");
	}

	@Override
	public String updateIncomeCategory(String id, String name) {
		return getServiceErrorResult("修改收入类别失败");
	}

	@Override
	public String getOutcomeCategory(String accountId) {
		return getServiceErrorResult("获取支出类别失败");
	}

	@Override
	public String addRootOutcomeCategory(String name, String accountId) {
		return getServiceErrorResult("添加支出类别失败");
	}

	@Override
	public String addChildOutcomeCategory(String name, String parentId, String accountId) {
		return getServiceErrorResult("添加支出子类别失败");
	}

	@Override
	public String updateOutcomeCategory(String id, String name) {
		return getServiceErrorResult("修改支出类别失败");
	}

	@Override
	public String getCategory(String name, String accountId, String categoryType) {
		return getServiceErrorResult("获取类别失败");
	}

}
