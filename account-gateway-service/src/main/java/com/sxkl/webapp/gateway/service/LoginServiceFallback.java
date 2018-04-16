package com.sxkl.webapp.gateway.service;

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
	public String refreshUserLoginStatus(String name) {
		return OperationResult.configurateFailureResult(Constants.SERVICE_ERROR);
	}
}
