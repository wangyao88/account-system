package com.sxkl.webapp.websystem.common.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:49:02
 * @description: 
 */
public class RequestUtils {
	
	public static JsonObject convert2Json(HttpServletRequest request){
		Enumeration<String> parameterNames = request.getParameterNames();
		JsonObject json = new JsonObject();
		while (parameterNames.hasMoreElements()) {
			String name = parameterNames.nextElement();
			String value = request.getParameter(name);
			json.addProperty(name, value);
		}
		return json;
	}

	public static String convert2JsonString(HttpServletRequest request){
		JsonObject json = convert2Json(request);
		return json.toString();
	}
}
