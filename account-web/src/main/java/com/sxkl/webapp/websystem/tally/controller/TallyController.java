package com.sxkl.webapp.websystem.tally.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sxkl.webapp.websystem.common.controller.BaseController;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午12:50:27
 * @description: 
 */
@Controller
@RequestMapping("/tally")
public class TallyController extends BaseController{

	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request){
		return configurePage("tally/tally",request);
	}
}
