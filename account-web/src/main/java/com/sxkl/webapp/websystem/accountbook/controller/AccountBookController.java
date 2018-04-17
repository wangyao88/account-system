package com.sxkl.webapp.websystem.accountbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sxkl.webapp.websystem.common.controller.BaseController;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午2:24:51
 * @description: 
 */
@Controller
@RequestMapping("/accountbook")
public class AccountBookController extends BaseController {

	@GetMapping("/index")
	public ModelAndView main(HttpServletRequest request){
		return configurePage("accountbook/accountbook",request);
	}
}
