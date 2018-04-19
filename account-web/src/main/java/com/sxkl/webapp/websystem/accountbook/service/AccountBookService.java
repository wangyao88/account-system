package com.sxkl.webapp.websystem.accountbook.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:49:02
 * @description: 
 */
@FeignClient(name = "gateway-service/account-service/", fallback = AccountBookServiceFallback.class)
public interface AccountBookService {

	@PostMapping("/save")
	String save(@RequestParam("account")String account);

	@PostMapping("/update")
	String update(@RequestParam("account")String account);
	
	@PostMapping("/getAccountBooks")
	String getAccountBooks(@RequestParam("userId")String userId);
}
