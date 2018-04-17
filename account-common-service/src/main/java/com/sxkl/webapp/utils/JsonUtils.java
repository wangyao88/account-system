package com.sxkl.webapp.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午5:44:45
 * @description: 
 */
public class JsonUtils {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object convert2Bean(String json, Class clazz){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.fromJson(json, clazz);
	}
}
