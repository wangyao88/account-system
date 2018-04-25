package com.sxkl.webapp.account.tally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxkl.webapp.account.tally.entity.Tally;
import com.sxkl.webapp.account.tally.service.TallyService;
import com.sxkl.webapp.utils.JsonUtils;

/**
 * @author: wangyao
 * @date: 2018年4月23日 上午9:24:52
 * @description: 
 */
@RestController
public class TallyController {

	@Autowired
	private TallyService tallService;
	
	@PostMapping("/saveTally")
	public String save(String tally){
		Tally bean = (Tally) JsonUtils.convert2Bean(tally, Tally.class);
		return tallService.save(bean);
	}
	
	@PostMapping("/findTallyPage")
	public String findTallyPage(String tally, int pageIndex, int pageSize){
		Tally bean = (Tally) JsonUtils.convert2Bean(tally, Tally.class);
		return tallService.findPage(bean, pageIndex, pageSize);
	}
	
	@PostMapping("/getSumMoney")
	public String getSumMoney(String tally){
		Tally bean = (Tally) JsonUtils.convert2Bean(tally, Tally.class);
		return tallService.getSumMoney(bean);
	}
	
	@PostMapping("/getCategoryData")
	public String getCategoryData(String tally){
		Tally bean = (Tally) JsonUtils.convert2Bean(tally, Tally.class);
		return tallService.getCategoryData(bean);
	}
	
	@PostMapping("/getCategoryLineData")
	public String getCategoryLineData(String tally){
		Tally bean = (Tally) JsonUtils.convert2Bean(tally, Tally.class);
		return tallService.getCategoryLineData(bean);
	}
	
	@PostMapping("/getInAndOutSumData")
	public String getInAndOutSumData(String tally){
		Tally bean = (Tally) JsonUtils.convert2Bean(tally, Tally.class);
		return tallService.getInAndOutSumData(bean);
	}
}
