package com.sxkl.webapp.websystem.news.service;

import org.springframework.stereotype.Component;

import com.sxkl.webapp.websystem.common.service.BaseServiceFallback;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:49:54
 * @description: 
 */
@Component
public class NewsServiceFallback extends BaseServiceFallback implements NewsService{

	@Override
	public String getRecentTopAll() {
		return getServiceErrorResult("获取时事新闻失败");
	}

	
}
