package com.sxkl.webapp.websystem.accountbook.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.sxkl.webapp.common.OperationResult;
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
		OperationResult loginServiceOperationResult = getUserId(loginService,request);
		if(!loginServiceOperationResult.isStatus()){
			return configurePage("accountbook/accountbook","获取用户ID失败。",request);
		}
		json.addProperty("userId",loginServiceOperationResult.getData().toString());
		String accountBookServiceResult = accountBookService.save(json.toString());
		OperationResult accountBookServiceOperationResult = OperationResult.deserialize(accountBookServiceResult);
		if(!accountBookServiceOperationResult.isStatus()){
			return configurePage("accountbook/accountbook","保存账本失败！错误信息：获取用户ID失败。",request);
		}
		return configurePage("accountbook/accountbook","账本保存成功",request);
	}
	
	@PostMapping("/update")
	public ModelAndView update(HttpServletRequest request){
		JsonObject json = RequestUtils.convert2Json(request);
		String accountBookServiceResult = accountBookService.update(json.toString());
		OperationResult accountBookServiceOperationResult = OperationResult.deserialize(accountBookServiceResult);
		if(!accountBookServiceOperationResult.isStatus()){
			return configurePage("accountbook/accountbook","修改账本失败！错误信息：获取用户ID失败。",request);
		}
		return configurePage("accountbook/accountbook","账本修改成功",request);
	}
	
	@PostMapping("/getAccountBooks")
	@ResponseBody
	public String getAccountBooks(HttpServletRequest request){
		OperationResult loginServiceOperationResult = getUserId(loginService,request);
		if(!loginServiceOperationResult.isStatus()){
			return OperationResult.configurateFailureResult("获取用户ID失败。");
		}
		String userId = loginServiceOperationResult.getData().toString();
		return accountBookService.getAccountBooks(userId);
	}
}
