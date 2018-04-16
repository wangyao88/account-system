package com.sxkl.webapp.websystem.login.service;

import org.springframework.stereotype.Component;

import com.sxkl.webapp.common.Constants;
import com.sxkl.webapp.common.OperationResult;

/**
 * @author: wangyao
 * @date: 2018年4月12日 下午3:48:56
 * @description: 
 */
@Component
public class LoginServiceFallback implements LoginService{

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
	
	private String getServiceErrorResult(){
		return OperationResult.configurateFailureResult(Constants.SERVICE_ERROR);
	}
}
