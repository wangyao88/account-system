package com.sxkl.webapp.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxkl.webapp.news.service.NewsService;

/**
 * @author: wangyao
 * @date: 2018年4月27日 上午10:11:48
 * @description: 
 */
@RestController
public class NewsControoler {

	@Autowired
	private NewsService newsService;
	
	@PostMapping("/getRecentTopAll")
	public String getRecentTopAll(){
		return newsService.getRecentTopAll();
	}
}
