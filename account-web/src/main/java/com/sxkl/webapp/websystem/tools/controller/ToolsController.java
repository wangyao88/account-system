package com.sxkl.webapp.websystem.tools.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sxkl.webapp.websystem.common.controller.BaseController;

/**
 * @author: wangyao
 * @date: 2018年4月26日 上午9:45:01
 * @description: 
 */
@RestController
@RequestMapping("/tools")
public class ToolsController extends BaseController{

	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request){
		return configurePage("tools/index",request);
	}
	
	@GetMapping("/calculator")
	public ModelAndView calculator(HttpServletRequest request){
		return configurePage("tools/calculator",request);
	}
	
	@GetMapping("/calendar")
	public ModelAndView calendar(HttpServletRequest request){
		return configurePage("tools/calendar",request);
	}
}
