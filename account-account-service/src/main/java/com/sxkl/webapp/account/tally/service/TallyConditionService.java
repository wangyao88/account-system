package com.sxkl.webapp.account.tally.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;
import com.sxkl.webapp.account.tally.entity.Tally;
import com.sxkl.webapp.utils.DateUtil;
import com.sxkl.webapp.utils.ObjectUtils;

/**
 * @author: wangyao
 * @date: 2018年4月25日 下午12:39:16
 * @description: 
 */
public class TallyConditionService {

	public static List<String> getDateRange(Tally tally){
		List<String> monthRanges = Lists.newArrayList();
		if(ObjectUtils.isNull(tally.getBeginDate()) && ObjectUtils.isNull(tally.getEndDate())){
			monthRanges = getDateRange(getDefaultBeginDate(),getDefaultEndDate());
		}
		if(ObjectUtils.isNotNull(tally.getBeginDate()) && ObjectUtils.isNull(tally.getEndDate())){
			monthRanges = getDateRange(tally.getBeginDate(),getDefaultEndDate());
		}
		if(ObjectUtils.isNull(tally.getBeginDate()) && ObjectUtils.isNotNull(tally.getEndDate())){
			monthRanges = getDateRange(getDefaultBeginDate(),tally.getEndDate());
		}
		if(ObjectUtils.isNotNull(tally.getBeginDate()) && ObjectUtils.isNotNull(tally.getEndDate())){
			monthRanges = getDateRange(tally.getBeginDate(),tally.getEndDate());
		}
		return monthRanges;
	}
	
	private static List<String> getDateRange(Date bagin, Date end){
		List<String> monthRanges = Lists.newArrayList();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(bagin);
		while(calendar.getTime().before(end)){
			String date = DateUtil.parseDateToStr(calendar.getTime(), DateUtil.DATE_FORMAT_YYYY_MM);
			monthRanges.add(date);
			calendar.add(Calendar.MONTH, 1);
		}
		return monthRanges;
	}
	
	private static Date getDefaultBeginDate() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -1);
		return calendar.getTime();
	}
	
	private static Date getDefaultEndDate() {
		return new Date();
	}
	
	public static String getCategoryLineDataSql(Tally tally){
		StringBuilder sql = new StringBuilder();
		sql.append("select DATE_FORMAT(create_date,'%Y-%m') as month,category_name as categoryName, sum(money) as money from a_tally ")
		   .append("where account_id = '")
		   .append(tally.getAccountId())
		   .append("' and category_type='")
		   .append(tally.getCategoryType())
		   .append("' ");
		Date beginDate = getDefaultBeginDate();
		Date endDate = getDefaultEndDate();
		if(ObjectUtils.isNotNull(tally.getBeginDate()) && ObjectUtils.isNull(tally.getEndDate())){
			beginDate = tally.getBeginDate();
			endDate = getDefaultEndDate();
		}
		if(ObjectUtils.isNull(tally.getBeginDate()) && ObjectUtils.isNotNull(tally.getEndDate())){
			beginDate = getDefaultBeginDate();
			endDate = tally.getEndDate();
		}
		if(ObjectUtils.isNotNull(tally.getBeginDate()) && ObjectUtils.isNotNull(tally.getEndDate())){
			beginDate = tally.getBeginDate();
			endDate = tally.getEndDate();
		}
		String beginDateStr = DateUtil.parseDateToStr(beginDate, DateUtil.DATE_FORMAT_YYYY_MM_DD);
		String endDateStr = DateUtil.parseDateToStr(endDate, DateUtil.DATE_FORMAT_YYYY_MM_DD);
		sql.append("and create_date >= '");
		sql.append(beginDateStr);
		sql.append("' and create_date <= '");
		sql.append(endDateStr);
		sql.append("' group by category_name,month");
		return sql.toString();
	}
	
	public static void initTallyDate(Tally tally){
		Date beginDate = getDefaultBeginDate();
		Date endDate = getDefaultEndDate();
		if(ObjectUtils.isNotNull(tally.getBeginDate()) && ObjectUtils.isNull(tally.getEndDate())){
			beginDate = tally.getBeginDate();
		}
		if(ObjectUtils.isNull(tally.getBeginDate()) && ObjectUtils.isNotNull(tally.getEndDate())){
			endDate = tally.getEndDate();
		}
		if(ObjectUtils.isNotNull(tally.getBeginDate()) && ObjectUtils.isNotNull(tally.getEndDate())){
			beginDate = tally.getBeginDate();
			endDate = tally.getEndDate();
		}
		tally.setBeginDate(beginDate);
		tally.setEndDate(endDate);
	}
}
