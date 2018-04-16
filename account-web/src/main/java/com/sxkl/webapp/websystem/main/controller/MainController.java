package com.sxkl.webapp.websystem.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sxkl.webapp.websystem.common.controller.BaseController;

/**
 * @author: wangyao
 * @date: 2018年4月13日 下午3:47:37
 * @description: 
 */
@Controller()
public class MainController extends BaseController{

	@GetMapping("/main")
	public ModelAndView main(HttpServletRequest request){
		return configurePage("main/main",request);
	}
}
