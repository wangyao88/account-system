package com.sxkl.webapp.websystem.tally.controller;

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
import com.sxkl.webapp.websystem.category.service.CategoryService;
import com.sxkl.webapp.websystem.common.controller.BaseController;
import com.sxkl.webapp.websystem.common.utils.RequestUtils;
import com.sxkl.webapp.websystem.tally.service.TallyService;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午12:50:27
 * @description: 
 */
@Controller
@RequestMapping("/tally")
public class TallyController extends BaseController{
	
	@Autowired
	private TallyService tallyService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/index")
	public ModelAndView index(HttpServletRequest request){
		return configurePage("tally/index",request);
	}
	
	@GetMapping("/list")
	public ModelAndView list(HttpServletRequest request){
		return configurePage("tally/list",request);
	}
	
	@PostMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest request){
		String categoryName = request.getParameter("categoryName");
		String accountId = request.getParameter("accountId");
		String categoryType = request.getParameter("categoryType");
		String categoryServiceResult = categoryService.getCategoryId(categoryName,accountId,categoryType);
		OperationResult categoryServiceOperationResult = OperationResult.deserialize(categoryServiceResult);
		if(!categoryServiceOperationResult.isStatus()){
			return OperationResult.configurateFailureResult(categoryServiceOperationResult.getData().toString());
		}
		JsonObject json = RequestUtils.convert2Json(request);
		String categoryId = categoryServiceOperationResult.getData().toString();
		json.addProperty("categoryId",categoryId);
		return tallyService.saveTally(json.toString());
	}
	
	@PostMapping("/findPage")
	@ResponseBody
	public String findPage(HttpServletRequest request){
		JsonObject json = RequestUtils.convert2Json(request);
		String pageIndex = request.getParameter("pageIndex");
		String pageSize = request.getParameter("pageSize");
		return tallyService.findTallyPage(json.toString(),pageIndex,pageSize);
	}
	
	@PostMapping("/getSumMoney")
	@ResponseBody
	public String getSumMoney(HttpServletRequest request){
		JsonObject json = RequestUtils.convert2Json(request);
		return tallyService.getSumMoney(json.toString());
	}
}
