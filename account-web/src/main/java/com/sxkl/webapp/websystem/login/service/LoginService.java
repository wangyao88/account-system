package com.sxkl.webapp.websystem.login.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: wangyao
 * @date: 2018年4月12日 上午11:33:23
 * @description:
 */
@FeignClient(name = "gateway-service/logincenter-service/", fallback = LoginServiceFallback.class)
public interface LoginService {

	@PostMapping("/registe")
	String registe(@RequestParam("name")String name, @RequestParam("password")String password);

	@PostMapping("/login")
	String login(@RequestParam("name")String name, @RequestParam("password")String password);

	@PostMapping("/checkName")
	String checkName(@RequestParam("name")String name);
	
	@PostMapping("/getUserId")
	String getUserId(@RequestParam("name")String name);

	@PostMapping("/getPublicKey")
	String getPublicKey();
}
