package com.sxkl.webapp.account.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxkl.webapp.account.category.service.CategoryService;

/**
 * @author: wangyao
 * @date: 2018年4月19日 上午11:27:45
 * @description: 
 */
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/getIncomeCategory")
	public String getIncomeCategory(String accountId){
		return categoryService.getIncomeCategory(accountId);
	}
	
	@PostMapping("/addRootIncomeCategory")
	public String addRootIncomeCategory(String name, String accountId){
		return categoryService.addRootIncomeCategory(name,accountId);
	}
	
	@PostMapping("/addChildIncomeCategory")
	public String addChildIncomeCategory(String name, String parentId, String accountId){
		return categoryService.addChildIncomeCategory(name,parentId,accountId);
	}
	
	@PostMapping("/updateIncomeCategory")
	public String updateIncomeCategory(String id, String name){
		return categoryService.updateIncomeCategory(id,name);
	}
	
	@PostMapping("/getOutcomeCategory")
	public String getOutcomeCategory(String accountId){
		return categoryService.getOutcomeCategory(accountId);
	}
	
	@PostMapping("/addRootOutcomeCategory")
	public String addRootOutcomeCategory(String name, String accountId){
		return categoryService.addRootOutcomeCategory(name,accountId);
	}
	
	@PostMapping("/addChildOutcomeCategory")
	public String addChildOutcomeCategory(String name, String parentId, String accountId){
		return categoryService.addChildOutcomeCategory(name,parentId,accountId);
	}
	
	@PostMapping("/updateOutcomeCategory")
	public String updateOutcomeCategory(String id, String name){
		return categoryService.updateOutcomeCategory(id,name);
	}
	
	@PostMapping("/getCategory")
	public String getCategory(String name, String accountId, String categoryType) {
		return categoryService.getCategory(name,accountId,categoryType);
	}
	
	@PostMapping("/getCategoryId")
	public String getCategoryId(String name, String accountId, String categoryType) {
		return categoryService.getCategoryId(name,accountId,categoryType);
	}
}
