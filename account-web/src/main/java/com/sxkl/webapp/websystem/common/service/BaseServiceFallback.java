package com.sxkl.webapp.websystem.common.service;

import com.sxkl.webapp.common.Constants;
import com.sxkl.webapp.common.OperationResult;

/**
 * @author: wangyao
 * @date: 2018年4月12日 下午3:48:56
 * @description: 
 */
public class BaseServiceFallback{

	protected String getServiceErrorResult(){
		return OperationResult.configurateFailureResult(Constants.SERVICE_ERROR);
	}
}
