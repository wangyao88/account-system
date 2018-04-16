package com.sxkl.webapp.logincenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxkl.webapp.common.OperationResult;
import com.sxkl.webapp.logincenter.service.RSACoderService;
import com.sxkl.webapp.logincenter.service.UserService;

/**
 * @author: wangyao
 * @date: 2018年4月10日 上午11:05:05
 * @description: 
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RSACoderService rsaCoderService;
	
	@PostMapping("/checkName")
	public String checkName(String name){
		return userService.checkName(name);
	}
	
	@PostMapping("/registe")
	public String registe(String name, String password){
		userService.registe(name,password);
		return OperationResult.configurateSuccessResult("用户注册成功");
	}
	
	@PostMapping("/refreshUserLoginStatus")
	public String refreshUserLoginStatus(String name){
		return userService.refreshUserLoginStatus(name);
	}
	
	@PostMapping("/login")
	public String login(String name, String password){
		return userService.login(name,password);
	}
	
	@PostMapping("/getPassword")
	public String getPassword(String password){
		return userService.getPassword(password);
	}
	
	@PostMapping("/getPublicKey")
	public String getPublicKey(){
		return rsaCoderService.getPublicKey();
	}
}
