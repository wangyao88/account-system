package com.sxkl.webapp.websystem.category.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sxkl.webapp.common.OperationResult;
import com.sxkl.webapp.websystem.category.entity.Category;
import com.sxkl.webapp.websystem.category.service.CategoryService;
import com.sxkl.webapp.websystem.category.service.TreeService;
import com.sxkl.webapp.websystem.common.controller.BaseController;

import net.sf.json.JSONArray;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午12:50:27
 * @description: 
 */
@Controller
@RequestMapping("/outcomecategory")
public class OutcomeCategoryController extends BaseController{

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request){
		return configurePage("category/outcomecategory",request);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/getOutcomeCategory")
	@ResponseBody
	public String getOutcomeCategory(String accountId){
		String categoryServiceResult = categoryService.getOutcomeCategory(accountId);
		OperationResult categoryServiceOperationResult = OperationResult.deserialize(categoryServiceResult);
		Object data = categoryServiceOperationResult.getData();
		JSONArray array = JSONArray.fromObject(data);
		Collection<Category> categories = JSONArray.toCollection(array, Category.class);
		return TreeService.newTreeService(categories).getTree();
	}
	
	@PostMapping("/addRootOutcomeCategory")
	@ResponseBody
	public String addRootOutcomeCategory(String name, String accountId){
		return categoryService.addRootOutcomeCategory(name,accountId);
	}
	
	@PostMapping("/addChildOutcomeCategory")
	@ResponseBody
	public String addChildOutcomeCategory(String name, String parentId, String accountId){
		return categoryService.addChildOutcomeCategory(name,parentId,accountId);
	}
	
	@PostMapping("/updateOutcomeCategory")
	@ResponseBody
	public String updateOutcomeCategory(String id, String name){
		return categoryService.updateOutcomeCategory(id,name);
	}
 }
