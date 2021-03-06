package com.sxkl.webapp.websystem.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.sxkl.webapp.common.Constants;
import com.sxkl.webapp.common.OperationResult;
import com.sxkl.webapp.utils.ObjectUtils;
import com.sxkl.webapp.utils.StringUtils;
import com.sxkl.webapp.websystem.login.service.LoginService;

/**
 * @author: wangyao
 * @date: 2018年4月13日 下午3:53:02
 * @description: 
 */
public class BaseController {

	protected ModelAndView configurePage(String viewName){
		ModelAndView mv = new ModelAndView();
		mv.setViewName(viewName);
		return mv;
	}
	
	protected ModelAndView configurePage(String viewName, HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Object obj = request.getSession().getAttribute(Constants.USER_KEY_IN_SESSION);
		if(ObjectUtils.isNull(obj)){
			viewName = "login/login";
		}else{
			request.getSession().setAttribute(Constants.USER_KEY_IN_SESSION,obj);
		}
		mv.addObject(Constants.USER_KEY_IN_SESSION,obj);
		mv.setViewName(viewName);
		return mv;
	}
	
	protected ModelAndView configurePage(String viewName, String msg, HttpServletRequest request) {
		ModelAndView mv = configurePage(viewName,request);
		mv.addObject("error_msg", msg);
		return mv;
	}
	
	protected String getUserName(HttpServletRequest request){
		Object obj = request.getSession().getAttribute(Constants.USER_KEY_IN_SESSION);
		if(ObjectUtils.isNotNull(obj)){
			return obj.toString();
		}
		return StringUtils.EMPTY;
	}
	
	protected OperationResult getUserId(LoginService loginService, HttpServletRequest request){
		String name = getUserName(request);
		String loginServiceResult = loginService.getUserId(name);
		return OperationResult.deserialize(loginServiceResult);
	}
}
