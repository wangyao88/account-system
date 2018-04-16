package com.sxkl.webapp.websystem.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sxkl.webapp.common.Constants;
import com.sxkl.webapp.common.OperationResult;
import com.sxkl.webapp.websystem.common.controller.BaseController;
import com.sxkl.webapp.websystem.login.service.LoginService;

/**
 * @author: wangyao
 * @date: 2018年4月12日 上午10:41:15
 * @description: 
 */
@Controller
public class LoginController extends BaseController{

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public ModelAndView loginPage(){
		return configurePage("login/login");
	}
	
	@GetMapping("")
	public ModelAndView empty(){
		return loginPage();
	}
	
	@GetMapping("/login")
	public ModelAndView login(){
		return loginPage();
	}
	
	@PostMapping("/checkName")
	@ResponseBody
	public String checkName(String name){
		return loginService.checkName(name);
	}
	
	@PostMapping("/registe")
	@ResponseBody
	public String registe(String name, String password){
		return loginService.registe(name,password);
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String login(String name, String password, HttpServletRequest request){
		String result = loginService.login(name,password);
		OperationResult operationResult = OperationResult.deserialize(result);
		if(operationResult.isStatus()){
			request.getSession().setAttribute(Constants.USER_KEY_IN_SESSION, name);
		}
		return result;
	}
	
	@PostMapping("/getPublicKey")
	@ResponseBody
	public String getPublicKey(){
		return loginService.getPublicKey();
	}
}
