package com.sxkl.webapp.websystem.tally.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:49:02
 * @description: 
 */
@FeignClient(name = "gateway-service/account-service/", fallback = TallyServiceFallback.class)
public interface TallyService {

	@PostMapping("/saveTally")
	String saveTally(@RequestParam("tally")String tally);

	@PostMapping("/findTallyPage")
	String findTallyPage(@RequestParam("tally")String tally, @RequestParam("pageIndex")String pageIndex, @RequestParam("pageSize")String pageSize);

	@PostMapping("/getSumMoney")
	String getSumMoney(@RequestParam("tally")String tally);

	@PostMapping("/getCategoryData")
	String getCategoryData(@RequestParam("tally")String tally);

	@PostMapping("/getCategoryLineData")
	String getCategoryLineData(@RequestParam("tally")String tally);

	@PostMapping("/getInAndOutSumData")
	String getInAndOutSumData(@RequestParam("tally")String tally);

	@PostMapping("/getInAndOutSumLineData")
	String getInAndOutSumLineData(@RequestParam("tally")String tally);
}
