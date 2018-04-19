package com.sxkl.webapp.websystem.category.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午12:48:34
 * @description: 
 */
@FeignClient(name = "gateway-service/account-service/", fallback = CategoryServiceFallback.class)
public interface CategoryService {

	@PostMapping("/getIncomeCategory")
	String getIncomeCategory(@RequestParam("accountId")String accountId);
}
