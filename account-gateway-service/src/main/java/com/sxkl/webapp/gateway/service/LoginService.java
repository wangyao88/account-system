package com.sxkl.webapp.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: wangyao
 * @date: 2018年4月12日 上午11:33:23
 * @description:
 */
@FeignClient(name = "logincenter-service", fallback = LoginServiceFallback.class)
public interface LoginService {

	@PostMapping("/refreshUserLoginStatus")
	String refreshUserLoginStatus(@RequestParam("name")String name);
}
