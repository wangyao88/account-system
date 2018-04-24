package com.sxkl.webapp.websystem.statistics;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.sxkl.webapp.websystem.common.controller.BaseController;
import com.sxkl.webapp.websystem.common.utils.RequestUtils;
import com.sxkl.webapp.websystem.tally.service.TallyService;

/**
 * @author: wangyao
 * @date: 2018年4月24日 下午4:34:46
 * @description: 
 */
@Controller
@RequestMapping("/statistics")
public class StatisticsController extends BaseController{

	@Autowired
	private TallyService tallyService;

	@GetMapping("/income/index")
	public ModelAndView index(HttpServletRequest request){
		return configurePage("statistics/income_statistics_index",request);
	}
	
	@PostMapping("/getIncomeCategoryData")
	@ResponseBody
	public String getIncomeCategoryData(HttpServletRequest request){
		JsonObject json = RequestUtils.convert2Json(request);
		return tallyService.getIncomeCategoryData(json.toString());
	}
}
