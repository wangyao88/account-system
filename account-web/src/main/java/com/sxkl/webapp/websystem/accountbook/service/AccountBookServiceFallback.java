package com.sxkl.webapp.websystem.accountbook.service;

import org.springframework.stereotype.Component;

import com.sxkl.webapp.websystem.common.service.BaseServiceFallback;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:49:54
 * @description: 
 */
@Component
public class AccountBookServiceFallback extends BaseServiceFallback implements AccountBookService{

	@Override
	public String save(String account) {
		return getServiceErrorResult("保存账本失败");
	}

	@Override
	public String getAccountBooks(String userId) {
		return getServiceErrorResult("获取账本列表失败");
	}

	@Override
	public String update(String account) {
		return getServiceErrorResult("更新账本失败");
	}

}
