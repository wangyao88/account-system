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
		return getServiceErrorResult("获取收入类别类别失败");
	}

}
