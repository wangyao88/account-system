package com.sxkl.webapp.websystem.news.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:49:02
 * @description: 
 */
@FeignClient(name = "gateway-service/news-service/", fallback = NewsServiceFallback.class)
public interface NewsService {

	@PostMapping("/getRecentTopAll")
	String getRecentTopAll();
}
