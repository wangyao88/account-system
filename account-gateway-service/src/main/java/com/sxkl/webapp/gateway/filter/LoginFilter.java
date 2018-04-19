package com.sxkl.webapp.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sxkl.webapp.common.Constants;
import com.sxkl.webapp.common.OperationResult;
import com.sxkl.webapp.gateway.service.LoginService;
import com.sxkl.webapp.utils.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: wangyao
 * @date: 2018年4月12日 下午5:11:26
 * @description: 
 */
@Slf4j
@Component
public class LoginFilter extends ZuulFilter {

	@Autowired
	private LoginService loginService;
	
	@Override
	public boolean shouldFilter() {
		HttpServletRequest request = getRequest();
		String url = request.getServletPath();
		System.out.println("url----------"+url);
		if(url.contains("checkName") || url.contains("registe") || url.contains("login")){
			return false;
		}
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = getRequest(ctx);
//		boolean isLogin = isLogin(request);
//		if(!isLogin){
//			log.error("用户未登录");
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseStatusCode(401);
//			return null;
//		}
//		String name = getName(request);
//		loginService.refreshUserLoginStatus(name);
		return null;
	}

	private boolean isLogin(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(Constants.USER_KEY_IN_SESSION);
		return ObjectUtils.isNotNull(obj);
	}
	
	private String getName(HttpServletRequest request) {
		return request.getSession().getAttribute(Constants.USER_KEY_IN_SESSION).toString();
	}

	@Override
	public String filterType() {
		return "pre";//路由之前过滤
	}

	@Override
	public int filterOrder() {
		return 0;
	}
	
	private HttpServletRequest getRequest(){
		RequestContext ctx = RequestContext.getCurrentContext();
		return getRequest(ctx);
	}
	
	private HttpServletRequest getRequest(RequestContext ctx){
		HttpServletRequest request = ctx.getRequest();
		return request;
	}

}
