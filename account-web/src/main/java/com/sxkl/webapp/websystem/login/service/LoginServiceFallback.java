package com.sxkl.webapp.websystem.login.service;

import org.springframework.stereotype.Component;

import com.sxkl.webapp.websystem.common.service.BaseServiceFallback;

/**
 * @author: wangyao
 * @date: 2018年4月12日 下午3:48:56
 * @description: 
 */
@Component
public class LoginServiceFallback extends BaseServiceFallback implements LoginService{

	@Override
	public String registe(String name, String password) {
		return getServiceErrorResult();
	}

	@Override
	public String login(String name, String password) {
		return getServiceErrorResult();
	}
	
	@Override
	public String checkName(String name) {
		return getServiceErrorResult();
	}
	
	@Override
	public String getPublicKey() {
		return getServiceErrorResult();
	}
	
	@Override
	public String getUserId(String name) {
		return getServiceErrorResult("获取用户ID失败");
	}
}
