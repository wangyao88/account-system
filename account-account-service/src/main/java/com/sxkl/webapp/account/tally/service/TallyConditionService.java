package com.sxkl.webapp.account.tally.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sxkl.webapp.account.tally.entity.Tally;
import com.sxkl.webapp.utils.DateUtil;
import com.sxkl.webapp.utils.ObjectUtils;
import com.sxkl.webapp.utils.StringUtils;

/**
 * @author: wangyao
 * @date: 2018年4月25日 下午12:39:16
 * @description: 
 */
public class TallyConditionService {
	
	private static final Map<String,String> dateTypeMap = Maps.newHashMap();
	private static final Map<String,Integer> calendarMap = Maps.newHashMap();
	private static final Map<String,String> formateMap = Maps.newHashMap();
	
	static{
		dateTypeMap.put("year", "'%Y'");
		dateTypeMap.put("month", "'%Y-%m'");
		dateTypeMap.put("day", "'%Y-%m-%d'");
		
		calendarMap.put("year", Calendar.YEAR);
		calendarMap.put("month", Calendar.MONTH);
		calendarMap.put("day", Calendar.DAY_OF_MONTH);
		
		formateMap.put("year", DateUtil.DATE_FORMAT_YYYY);
		formateMap.put("month", DateUtil.DATE_FORMAT_YYYY_MM);
		formateMap.put("day", DateUtil.DATE_FORMAT_YYYY_MM_DD);
	}

	public static List<String> getDateRange(Tally tally){
		return getDateRange(tally,null);
	}
	
	public static List<String> getDateRange(Tally tally, String dateType){
		if(StringUtils.isEmpty(dateType)){
			dateType = "month";
		}
		List<String> monthRanges = Lists.newArrayList();
		if(ObjectUtils.isNull(tally.getBeginDate()) && ObjectUtils.isNull(tally.getEndDate())){
			monthRanges = getDateRange(getDefaultBeginDate(),getDefaultEndDate(),dateType);
		}
		if(ObjectUtils.isNotNull(tally.getBeginDate()) && ObjectUtils.isNull(tally.getEndDate())){
			monthRanges = getDateRange(tally.getBeginDate(),getDefaultEndDate(),dateType);
		}
		if(ObjectUtils.isNull(tally.getBeginDate()) && ObjectUtils.isNotNull(tally.getEndDate())){
			monthRanges = getDateRange(getDefaultBeginDate(),tally.getEndDate(),dateType);
		}
		if(ObjectUtils.isNotNull(tally.getBeginDate()) && ObjectUtils.isNotNull(tally.getEndDate())){
			monthRanges = getDateRange(tally.getBeginDate(),tally.getEndDate(),dateType);
		}
		return monthRanges;
	}
	
	private static List<String> getDateRange(Date bagin, Date end, String dateType){
		List<String> monthRanges = Lists.newArrayList();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(end);
		calendar.add(calendarMap.get(dateType), 1);
		end = calendar.getTime();
		calendar.setTime(bagin);
		while(calendar.getTime().before(end)){
			String date = DateUtil.parseDateToStr(calendar.getTime(), formateMap.get(dateType));
			monthRanges.add(date);
			calendar.add(calendarMap.get(dateType), 1);
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

	public static String getInAndOutSumLineDataSql(Tally tally) {
		String dateType = getDefaultDateType();
		String dateTypeKey = tally.getDateType();
		if(StringUtils.isNotEmpty(dateTypeKey) && dateTypeMap.containsKey(dateTypeKey)){
			dateType = dateTypeMap.get(dateTypeKey);
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select DATE_FORMAT(create_date,")
		   .append(dateType)
		   .append(") as month,category_type as categoryType, sum(money) as money from a_tally ")
		   .append("where ");
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
		sql.append("create_date >= '")
		   .append(beginDateStr)
		   .append("' and create_date <= '")
		   .append(endDateStr)
		   .append("' ");
		if(StringUtils.isNotEmpty(tally.getAccountId())){
			sql.append("and account_id = '")
			   .append(tally.getAccountId())
			   .append("' ");
		}
		sql.append("group by category_type,month");
		return sql.toString();
	}
	
	private static String getDefaultDateType(){
		return "'%y-%m-%d'";
	}
	
	public static void main(String[] args) {
		String date = DateUtil.parseDateToStr(new Date(), "yyyy");
		System.out.println(date);
	}
}
