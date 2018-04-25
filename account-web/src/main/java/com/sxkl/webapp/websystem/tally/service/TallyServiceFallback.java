package com.sxkl.webapp.websystem.tally.service;

import org.springframework.stereotype.Component;

import com.sxkl.webapp.websystem.common.service.BaseServiceFallback;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:49:54
 * @description: 
 */
@Component
public class TallyServiceFallback extends BaseServiceFallback implements TallyService{

	@Override
	public String saveTally(String account) {
		return getServiceErrorResult("保存账本条目失败");
	}

	@Override
	public String findTallyPage(String tally, String pageIndex, String pageSize) {
		return getServiceErrorResult("分页查询失败");
	}

	@Override
	public String getSumMoney(String tally) {
		return getServiceErrorResult("查询账本条目总额失败");
	}

	@Override
	public String getCategoryData(String tally) {
		return getServiceErrorResult("统计失败");
	}

	@Override
	public String getCategoryLineData(String tally) {
		return getServiceErrorResult("折线统计失败");
	}

	@Override
	public String getInAndOutSumData(String tally) {
		return getServiceErrorResult("获取综合统计饼图数据失败");
	}
}
