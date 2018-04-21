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

	@PostMapping("/addRootIncomeCategory")
	String addRootIncomeCategory(@RequestParam("name")String name, @RequestParam("accountId")String accountId);

	@PostMapping("/addChildIncomeCategory")
	String addChildIncomeCategory(@RequestParam("name")String name, @RequestParam("parentId")String parentId, @RequestParam("accountId")String accountId);

	@PostMapping("/updateIncomeCategory")
	String updateIncomeCategory(@RequestParam("id")String id, @RequestParam("name")String name);

	
	@PostMapping("/getOutcomeCategory")
	String getOutcomeCategory(@RequestParam("accountId")String accountId);

	@PostMapping("/addRootOutcomeCategory")
	String addRootOutcomeCategory(@RequestParam("name")String name, @RequestParam("accountId")String accountId);

	@PostMapping("/addChildOutcomeCategory")
	String addChildOutcomeCategory(@RequestParam("name")String name, @RequestParam("parentId")String parentId, @RequestParam("accountId")String accountId);

	@PostMapping("/updateOutcomeCategory")
	String updateOutcomeCategory(@RequestParam("id")String id, @RequestParam("name")String name);

	@PostMapping("/getCategory")
	String getCategory(@RequestParam("name")String name, @RequestParam("accountId")String accountId, @RequestParam("categoryType")String categoryType);
}
