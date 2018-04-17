package com.sxkl.webapp.websystem.accountbook.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.sxkl.webapp.utils.DateUtil;
import com.sxkl.webapp.websystem.accountbook.service.AccountBookService;
import com.sxkl.webapp.websystem.common.controller.BaseController;
import com.sxkl.webapp.websystem.common.utils.RequestUtils;
import com.sxkl.webapp.websystem.login.service.LoginService;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午2:24:51
 * @description: 
 */
@Controller
@RequestMapping("/accountbook")
public class AccountBookController extends BaseController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private AccountBookService accountBookService;

	@GetMapping("/index")
	public ModelAndView main(HttpServletRequest request){
		return configurePage("accountbook/accountbook",request);
	}
	
	@PostMapping("/save")
	public ModelAndView save(HttpServletRequest request){
		JsonObject json = RequestUtils.convert2Json(request);
		json.addProperty("createDate", DateUtil.parseDateToStr(new Date(), DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
		String name = getUserName(request);
		String userId = loginService.getUserId(name);
		json.addProperty("userId",userId);
		String reuslt = accountBookService.save(json.toString());
		return configurePage("accountbook/accountbook",request);
	}
}
