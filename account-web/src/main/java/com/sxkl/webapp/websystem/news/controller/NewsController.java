package com.sxkl.webapp.websystem.news.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sxkl.webapp.websystem.common.controller.BaseController;
import com.sxkl.webapp.websystem.news.service.NewsService;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午12:50:27
 * @description: 
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController{
	
	@Autowired
	private NewsService newsOService;

	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request){
		return configurePage("news/index",request);
	}
	
	@PostMapping("/getRecentTopAll")
	@ResponseBody
	public String getRecentTopAll(){
		return newsOService.getRecentTopAll();
	}
}
