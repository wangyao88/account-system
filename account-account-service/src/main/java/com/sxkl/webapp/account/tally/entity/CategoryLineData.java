package com.sxkl.webapp.account.tally.entity;

import lombok.Data;

/**
 * @author: wangyao
 * @date: 2018年4月25日 上午10:40:58
 * @description: 
 */
@Data
public class CategoryLineData {
	 
	private String[] legendData;
	private String[] xAxisData;
	private Serie[] seriesData;
}
