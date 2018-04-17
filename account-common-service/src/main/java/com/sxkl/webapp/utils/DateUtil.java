package com.sxkl.webapp.utils;

import java.sql.Timestamp;  
import java.text.DateFormat;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.GregorianCalendar;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.LinkedHashMap;  
import java.util.List;  
  
/** 
 * ���ڹ����� 
 */  
public class DateUtil{  
      
    // ==��ʽ����==   
    /** 
     * ���ڸ�ʽ����ݣ����磺2004��2008 
     */  
    public static final String DATE_FORMAT_YYYY = "yyyy";  
      
      
    // ==��ʽ������ ==   
    /** 
     * ���ڸ�ʽ����ݺ��·ݣ����磺200707��200808 
     */  
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";  
  
    /** 
     * ���ڸ�ʽ����ݺ��·ݣ����磺200707��2008-08 
     */  
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";  
  
      
    // ==��ʽ��������==   
    /** 
     * ���ڸ�ʽ�������գ����磺050630��080808 
     */  
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";  
  
    /** 
     * ���ڸ�ʽ�������գ��ú�ֿܷ������磺06-12-25��08-08-08 
     */  
    public static final String DATE_FORMAT_YY_MM_DD = "yy-MM-dd";  
  
    /** 
     * ���ڸ�ʽ�������գ����磺20050630��20080808 
     */  
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";  
      
    /** 
     * ���ڸ�ʽ�������գ��ú�ֿܷ������磺2006-12-25��2008-08-08 
     */  
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";  
      
    /** 
     * ���ڸ�ʽ�������գ����磺2016.10.05 
     */  
    public static final String DATE_FORMAT_POINTYYYYMMDD = "yyyy.MM.dd";  
      
    /** 
     * ���ڸ�ʽ�������գ����磺2016��10��05�� 
     */  
    public static final String DATE_TIME_FORMAT_YYYY��MM��DD�� = "yyyy��MM��dd��";  
      
      
    // ==��ʽ�������� ʱ�� ==   
      
    /** 
     * ���ڸ�ʽ��������ʱ�֣����磺200506301210��200808081210 
     */  
    public static final String DATE_FORMAT_YYYYMMDDHHmm = "yyyyMMddHHmm";  
  
    /** 
     * ���ڸ�ʽ��������ʱ�֣����磺20001230 12:00��20080808 20:08 
     */  
    public static final String DATE_TIME_FORMAT_YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";  
      
    /** 
     * ���ڸ�ʽ��������ʱ�֣����磺2000-12-30 12:00��2008-08-08 20:08 
     */  
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";  
      
      
    // ==��ʽ�������� ʱ����==   
    /** 
     * ���ڸ�ʽ��������ʱ���룬���磺20001230120000��20080808200808 
     */  
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";  
      
    /** 
     * ���ڸ�ʽ��������ʱ���룬�������ú�ֿܷ���ʱ������ð�ŷֿ� 
     * ���磺2005-05-10 23��20��00��2008-08-08 20:08:08 
     */  
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";  
  
      
    // ==��ʽ�������� ʱ���� ����==   
    /** 
     * ���ڸ�ʽ��������ʱ������룬���磺20001230120000123��20080808200808456 
     */  
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";  
      
      
    // ==�����ʽ==  
    /** 
     * ���ڸ�ʽ������ʱ�֣����磺10-05 12:00 
     */  
    public static final String DATE_FORMAT_MMDDHHMI = "MM-dd HH:mm";  
  
      
    /* ************���߷���***************   */  
      
    /**  
     * ��ȡĳ���ڵ���� 
     * @param date  
     * @return  
     */  
    public static Integer getYear(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        return cal.get(Calendar.YEAR);  
    }    
      
    /** 
     * ��ȡĳ���ڵ��·� 
     * @param date 
     * @return 
     */  
    public static Integer getMonth(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        return cal.get(Calendar.MONTH) + 1;  
    }  
      
    /** 
     * ��ȡĳ���ڵ����� 
     * @param date 
     * @return 
     */  
    public static Integer getDay(Date date){  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
         int day=cal.get(Calendar.DATE);//��ȡ��  
         return day;  
    }  
      
    /** 
     * ��ʽ��Dateʱ�� 
     * @param time Date����ʱ�� 
     * @param timeFromat String���͸�ʽ 
     * @return ��ʽ������ַ��� 
     */  
    public static String parseDateToStr(Date time, String timeFromat){  
        DateFormat dateFormat=new SimpleDateFormat(timeFromat);  
        return dateFormat.format(time);  
    }  
      
    /** 
     * ��ʽ��Timestampʱ�� 
     * @param timestamp Timestamp����ʱ�� 
     * @param timeFromat 
     * @return ��ʽ������ַ��� 
     */  
    public static String parseTimestampToStr(Timestamp timestamp,String timeFromat){  
        SimpleDateFormat df = new SimpleDateFormat(timeFromat);  
        return df.format(timestamp);  
    }  
      
    /** 
     * ��ʽ��Dateʱ�� 
     * @param time Date����ʱ�� 
     * @param timeFromat String���͸�ʽ 
     * @param defaultValue Ĭ��ֵΪ��ǰʱ��Date 
     * @return ��ʽ������ַ��� 
     */  
    public static String parseDateToStr(Date time, String timeFromat, final Date defaultValue){  
        try{  
            DateFormat dateFormat=new SimpleDateFormat(timeFromat);  
            return dateFormat.format(time);  
        }catch (Exception e){  
            if(defaultValue!=null)  
                return parseDateToStr(defaultValue, timeFromat);  
            else  
                return parseDateToStr(new Date(), timeFromat);  
        }  
    }  
      
    /** 
     * ��ʽ��Dateʱ�� 
     * @param time Date����ʱ�� 
     * @param timeFromat String���͸�ʽ 
     * @param defaultValue Ĭ��ʱ��ֵString���� 
     * @return ��ʽ������ַ��� 
     */  
    public static String parseDateToStr(Date time, String timeFromat, final String defaultValue){  
        try{  
            DateFormat dateFormat=new SimpleDateFormat(timeFromat);  
            return dateFormat.format(time);  
        }catch (Exception e){  
            return defaultValue;  
        }  
    }  
      
    /** 
     * ��ʽ��Stringʱ�� 
     * @param time String����ʱ�� 
     * @param timeFromat String���͸�ʽ 
     * @return ��ʽ�����Date���� 
     */  
    public static Date parseStrToDate(String time, String timeFromat) {  
        if (time == null || time.equals("")) {  
            return null;  
        }  
          
        Date date=null;  
        try{  
            DateFormat dateFormat=new SimpleDateFormat(timeFromat);  
            date=dateFormat.parse(time);  
        }catch(Exception e){  
              
        }  
        return date;  
    }  
      
    /** 
     * ��ʽ��Stringʱ�� 
     * @param strTime String����ʱ�� 
     * @param timeFromat String���͸�ʽ 
     * @param defaultValue �쳣ʱ���ص�Ĭ��ֵ 
     * @return 
     */  
    public static Date parseStrToDate(String strTime, String timeFromat,  
            Date defaultValue) {  
        try {  
            DateFormat dateFormat = new SimpleDateFormat(timeFromat);  
            return dateFormat.parse(strTime);  
        } catch (Exception e) {  
            return defaultValue;  
        }  
    }  
      
    /** 
     * ��strTimeΪ2008-9ʱ����Ϊ2008-9-1 00:00��ʽ����ʱ�䣬�޷�ת������null. 
     * @param strTime 
     * @return 
     */  
    public static Date strToDate(String strTime) {  
        if(strTime==null || strTime.trim().length()<=0)  
            return null;  
          
        Date date = null;  
        List<String> list = new ArrayList<String>(0);  
          
        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);  
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS);  
        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);  
        list.add(DATE_TIME_FORMAT_YYYYMMDD_HH_MI);  
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISS);  
        list.add(DATE_FORMAT_YYYY_MM_DD);  
        //list.add(DATE_FORMAT_YY_MM_DD);  
        list.add(DATE_FORMAT_YYYYMMDD);  
        list.add(DATE_FORMAT_YYYY_MM);  
        list.add(DATE_FORMAT_YYYYMM);  
        list.add(DATE_FORMAT_YYYY);  
          
          
        for (Iterator iter = list.iterator(); iter.hasNext();) {  
            String format = (String) iter.next();  
            if(strTime.indexOf("-")>0 && format.indexOf("-")<0)  
                continue;  
            if(strTime.indexOf("-")<0 && format.indexOf("-")>0)  
                continue;  
            if(strTime.length()>format.length())  
                continue;  
            date = parseStrToDate(strTime, format);  
            if (date != null)  
                break;  
        }  
  
        return date;  
    }  
      
    /** 
     * ������������֮��������·� 
     * @param beginDateStr ��ʼ���ڣ����پ�ȷ��yyyy-MM 
     * @param endDateStr �������ڣ����پ�ȷ��yyyy-MM 
     * @return yyyy-MM���ڼ��� 
     */    
    public static List<String> getMonthListOfDate(String beginDateStr, String endDateStr) {    
        // ָ��Ҫ������ʱ���ʽ    
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");    
        // ���ص��·��б�    
        String sRet = "";    
    
        // ����һЩ����    
        Date beginDate = null;    
        Date endDate = null;    
    
        GregorianCalendar beginGC = null;    
        GregorianCalendar endGC = null;    
        List<String> list = new ArrayList<String>();    
    
        try {    
            // ���ַ���parse������    
            beginDate = f.parse(beginDateStr);    
            endDate = f.parse(endDateStr);    
    
            // ��������    
            beginGC = new GregorianCalendar();    
            beginGC.setTime(beginDate);    
    
            endGC = new GregorianCalendar();    
            endGC.setTime(endDate);    
    
            // ֱ������ʱ����ͬ    
            while (beginGC.getTime().compareTo(endGC.getTime()) <= 0) {    
                sRet = beginGC.get(Calendar.YEAR) + "-"    
                        + (beginGC.get(Calendar.MONTH) + 1);    
                list.add(sRet);    
                // ����Ϊ��λ������ʱ��    
                beginGC.add(Calendar.MONTH, 1);    
            }    
            return list;    
        } catch (Exception e) {    
            e.printStackTrace();    
            return null;    
        }    
    }    
    
    /**  
     * �����������ڶ�֮����������� 
     * @param beginDateStr ��ʼ����  �����پ�ȷ��yyyy-MM-dd 
     * @param endDateStr ��������  �����پ�ȷ��yyyy-MM-dd 
     * @return yyyy-MM-dd���ڼ��� 
     */    
    public static List<String> getDayListOfDate(String beginDateStr, String endDateStr) {    
        // ָ��Ҫ������ʱ���ʽ    
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");    
    
        // ����һЩ����    
        Date beginDate = null;    
        Date endDate = null;    
    
        Calendar beginGC = null;    
        Calendar endGC = null;    
        List<String> list = new ArrayList<String>();    
    
        try {    
            // ���ַ���parse������    
            beginDate = f.parse(beginDateStr);    
            endDate = f.parse(endDateStr);    
    
            // ��������    
            beginGC = Calendar.getInstance();    
            beginGC.setTime(beginDate);    
    
            endGC = Calendar.getInstance();    
            endGC.setTime(endDate);    
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    
    
            // ֱ������ʱ����ͬ    
            while (beginGC.getTime().compareTo(endGC.getTime()) <= 0) {    
    
                list.add(sdf.format(beginGC.getTime()));    
                // ����Ϊ��λ������ʱ��    
                beginGC.add(Calendar.DAY_OF_MONTH, 1);    
            }    
            return list;    
        } catch (Exception e) {    
            e.printStackTrace();    
            return null;    
        }    
    }    
    
    /** 
     * ��ȡ�������ָ��ǰ����������ݼ��� 
     * @param before �������ǰ���� 
     * @param behind ������ݺ����� 
     * @return ���� 
     */  
    public static List<Integer> getYearListOfYears(int before,int behind) {  
        if (before<0 || behind<0) {  
            return null;  
        }  
        List<Integer> list = new ArrayList<Integer>();    
        Calendar c = null;    
        c = Calendar.getInstance();    
        c.setTime(new Date());    
        int currYear = Calendar.getInstance().get(Calendar.YEAR);    
    
        int startYear = currYear - before;    
        int endYear = currYear + behind;    
        for (int i = startYear; i < endYear; i++) {    
            list.add(Integer.valueOf(i));    
        }    
        return list;    
    }  
      
    /**  
     * ��ȡ��ǰ������һ���еڼ���  
     * @param date  
     * @return  
     */    
    public static Integer getWeekthOfYear(Date date) {    
        Calendar c = new GregorianCalendar();    
        c.setFirstDayOfWeek(Calendar.MONDAY);    
        c.setMinimalDaysInFirstWeek(7);    
        c.setTime(date);    
    
        return c.get(Calendar.WEEK_OF_YEAR);    
    }   
  
    /** 
     * ��ȡĳһ������ڵ�ʼ��ʱ�� 
     * ʵ����getWeekList(2016)����52��(��2016-12-26��2017-01-01) 
     * @param ��� 
     * @return 
     */    
    public static HashMap<Integer,String> getWeekTimeOfYear(int year) {    
        HashMap<Integer,String> map = new LinkedHashMap<Integer,String>();    
        Calendar c = new GregorianCalendar();    
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);    
        int count = getWeekthOfYear(c.getTime());    
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    
        String dayOfWeekStart = "";    
        String dayOfWeekEnd = "";    
        for (int i = 1; i <= count; i++) {    
            dayOfWeekStart = sdf.format(getFirstDayOfWeek(year, i));    
            dayOfWeekEnd = sdf.format(getLastDayOfWeek(year, i));    
            map.put(Integer.valueOf(i), "��"+i+"��(��"+dayOfWeekStart + "��" + dayOfWeekEnd+")");    
        }    
        return map;    
    
    }    
        
    /**  
     * ��ȡĳһ���������  
     * @param year  
     * @return  
     */    
    public static Integer getWeekCountOfYear(int year){    
        Calendar c = new GregorianCalendar();    
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);    
        int count = getWeekthOfYear(c.getTime());    
        return count;    
    }    
      
    /**  
     * ��ȡָ�����������ܵĵ�һ��  
     * @param date  
     * @return  
     */    
    public static Date getFirstDayOfWeek(Date date) {    
        Calendar c = new GregorianCalendar();    
        c.setFirstDayOfWeek(Calendar.MONDAY);    
        c.setTime(date);    
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday    
        return c.getTime();    
    }    
    
    /**  
     * ��ȡָ�����������ܵ����һ��  
     * @param date  
     * @return  
     */    
    public static Date getLastDayOfWeek(Date date) {  
        Calendar c = new GregorianCalendar();  
        c.setFirstDayOfWeek(Calendar.MONDAY);  
        c.setTime(date);  
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday  
        return c.getTime();  
    }  
    
    /**  
     * ��ȡĳ��ĳ�ܵĵ�һ��  
     * @param year Ŀ����� 
     * @param week Ŀ������ 
     * @return  
     */    
    public static Date getFirstDayOfWeek(int year, int week) {    
        Calendar c = new GregorianCalendar();    
        c.set(Calendar.YEAR, year);    
        c.set(Calendar.MONTH, Calendar.JANUARY);    
        c.set(Calendar.DATE, 1);    
    
        Calendar cal = (GregorianCalendar) c.clone();  
        cal.add(Calendar.DATE, week * 7);    
    
        return getFirstDayOfWeek(cal.getTime());    
    }    
    
    /**  
     * ��ȡĳ��ĳ�ܵ����һ��  
     * @param year Ŀ����� 
     * @param week Ŀ������ 
     * @return  
     */    
    public static Date getLastDayOfWeek(int year, int week) {    
        Calendar c = new GregorianCalendar();    
        c.set(Calendar.YEAR, year);    
        c.set(Calendar.MONTH, Calendar.JANUARY);    
        c.set(Calendar.DATE, 1);    
    
        Calendar cal = (GregorianCalendar) c.clone();    
        cal.add(Calendar.DATE, week * 7);    
    
        return getLastDayOfWeek(cal.getTime());    
    }    
        
    /**  
     * ��ȡĳ��ĳ�µĵ�һ��  
     * @param year Ŀ����� 
     * @param month Ŀ���·� 
     * @return  
     */    
    public static Date getFirstDayOfMonth(int year,int month){    
        month = month-1;    
        Calendar   c   =   Calendar.getInstance();       
        c.set(Calendar.YEAR, year);    
        c.set(Calendar.MONTH, month);    
            
        int day = c.getActualMinimum(c.DAY_OF_MONTH);    
    
        c.set(Calendar.DAY_OF_MONTH, day);  
        c.set(Calendar.HOUR_OF_DAY, 0);  
        c.set(Calendar.MINUTE, 0);  
        c.set(Calendar.SECOND, 0);  
        c.set(Calendar.MILLISECOND, 0);  
        return c.getTime();  
    }    
        
    /**  
     * ��ȡĳ��ĳ�µ����һ��  
     * @param year Ŀ����� 
     * @param month Ŀ���·� 
     * @return  
     */    
    public static Date getLastDayOfMonth(int year,int month){    
        month = month-1;    
        Calendar   c   =   Calendar.getInstance();       
        c.set(Calendar.YEAR, year);    
        c.set(Calendar.MONTH, month);    
        int day = c.getActualMaximum(c.DAY_OF_MONTH);    
        c.set(Calendar.DAY_OF_MONTH, day);  
        c.set(Calendar.HOUR_OF_DAY, 23);  
        c.set(Calendar.MINUTE, 59);  
        c.set(Calendar.SECOND, 59);  
        c.set(Calendar.MILLISECOND, 999);  
        return c.getTime();    
    }    
    
    /**  
     * ��ȡĳ������Ϊ���ڼ�  
     * @param date  
     * @return String "����*" 
     */    
    public static String getDayWeekOfDate1(Date date) {    
         String[] weekDays = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};  
         Calendar cal = Calendar.getInstance();  
         cal.setTime(date);  
  
         int w = cal.get(Calendar.DAY_OF_WEEK) - 1;  
         if (w < 0)  
             w = 0;  
           
         return weekDays[w];  
    }    
      
    /** 
     * ���ָ�����ڵ����ڼ��� 
     * @param date 
     * @return int  
     */   
    public static Integer getDayWeekOfDate2(Date date){    
        Calendar aCalendar = Calendar.getInstance();    
        aCalendar.setTime(date);       
        int weekDay = aCalendar.get(Calendar.DAY_OF_WEEK);       
        return weekDay;  
    }  
      
    /** 
     * ��֤�ַ����Ƿ�Ϊ���� 
     * ��֤��ʽ:YYYYMMDD��YYYY_MM_DD��YYYYMMDDHHMISS��YYYYMMDD_HH_MI��YYYY_MM_DD_HH_MI��YYYYMMDDHHMISSSSS��YYYY_MM_DD_HH_MI_SS 
     * @param strTime 
     * @return nullʱ����false;trueΪ���ڣ�false��Ϊ���� 
     */  
    public static boolean validateIsDate(String strTime) {  
        if (strTime == null || strTime.trim().length() <= 0)  
            return false;  
          
        Date date = null;  
        List<String> list = new ArrayList<String>(0);  
          
        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);  
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS);  
        list.add(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);  
        list.add(DATE_TIME_FORMAT_YYYYMMDD_HH_MI);  
        list.add(DATE_TIME_FORMAT_YYYYMMDDHHMISS);  
        list.add(DATE_FORMAT_YYYY_MM_DD);  
        //list.add(DATE_FORMAT_YY_MM_DD);  
        list.add(DATE_FORMAT_YYYYMMDD);  
        //list.add(DATE_FORMAT_YYYY_MM);  
        //list.add(DATE_FORMAT_YYYYMM);  
        //list.add(DATE_FORMAT_YYYY);  
          
        for (Iterator iter = list.iterator(); iter.hasNext();) {  
            String format = (String) iter.next();  
            if(strTime.indexOf("-")>0 && format.indexOf("-")<0)  
                continue;  
            if(strTime.indexOf("-")<0 && format.indexOf("-")>0)  
                continue;  
            if(strTime.length()>format.length())  
                continue;  
            date = parseStrToDate(strTime.trim(), format);  
            if (date != null)  
                break;  
        }  
          
        if (date != null) {  
            System.out.println("���ɵ�����:"+DateUtil.parseDateToStr(date, DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS, "--null--"));  
            return true;  
        }  
        return false;  
    }  
      
    /** 
     * ��ָ�����ڵ�ʱ�����ʽΪ�� 
     * @param date 
     * @return 
     */  
    public static Date formatHhMmSsOfDate(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime();  
    }  
      
    /** 
     * ���ָ��ʱ��Ӽ������������(������������0)  
     * @param date ָ������ 
     * @param year �����������ɸ� 
     * @param month �����������ɸ� 
     * @param day �����������ɸ� 
     * @param hour Сʱ���������ɸ� 
     * @param minute �������������ɸ� 
     * @param second �����������ɸ� 
     * @param millisecond �������������ɸ� 
     * @return ���������� 
     */  
    public static Date addDate(Date date,int year,int month,int day,int hour,int minute,int second,int millisecond){  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        c.add(Calendar.YEAR, year);//�Ӽ�����  
        c.add(Calendar.MONTH, month);//�Ӽ�����  
        c.add(Calendar.DATE, day);//�Ӽ�����  
        c.add(Calendar.HOUR,hour);//�Ӽ�Сʱ��  
        c.add(Calendar.MINUTE, minute);//�Ӽ�������  
        c.add(Calendar.SECOND, second);//�Ӽ���  
        c.add(Calendar.MILLISECOND, millisecond);//�Ӽ�������  
          
        return c.getTime();  
    }  
      
    /** 
     * ����������ڵ�ʱ���֮�� 
     * @param startDate 
     * @param endDate 
     * @return 
     */  
    public static Long getDistanceTimestamp(Date startDate,Date endDate){  
        long daysBetween=(endDate.getTime()-startDate.getTime()+1000000)/(3600*24*1000);  
        return daysBetween;  
    }  
      
    /** 
     * �ж϶���ʱ���Ƿ�Ϊͬ��ͬ�� 
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static Boolean compareIsSameMonth(Date date1,Date date2){  
        boolean flag = false;  
        int year1  = getYear(date1);  
        int year2 = getYear(date2);  
        if(year1 == year2){  
            int month1 = getMonth(date1);  
            int month2 = getMonth(date2);  
            if(month1 == month2)flag = true;  
        }  
        return flag;  
    }  
      
     /**  
     * �������ʱ����������������Сʱ���ٷֶ�����  
     * @param str1 ʱ����� 1 ��ʽ��1990-01-01 12:00:00  
     * @param str2 ʱ����� 2 ��ʽ��2009-01-01 12:00:00  
     * @return long[] ����ֵΪ��{��, ʱ, ��, ��}  
     */   
    public static long[] getDistanceTime(Date one, Date two) {   
        long day = 0;   
        long hour = 0;   
        long min = 0;   
        long sec = 0;   
        try {   
             
            long time1 = one.getTime();   
            long time2 = two.getTime();   
            long diff ;   
            if(time1<time2) {   
                diff = time2 - time1;   
            } else {   
                diff = time1 - time2;   
            }   
            day = diff / (24 * 60 * 60 * 1000);   
            hour = (diff / (60 * 60 * 1000) - day * 24);   
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);   
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        long[] times = {day, hour, min, sec};   
        return times;   
    }   
      
    /**  
     * ����ʱ����������������Сʱ���ٷֶ�����  
     * @param str1 ʱ����� 1 ��ʽ��1990-01-01 12:00:00  
     * @param str2 ʱ����� 2 ��ʽ��2009-01-01 12:00:00  
     * @return String ����ֵΪ��{��, ʱ, ��, ��} 
     */   
    public static long[] getDistanceTime(String str1, String str2) {   
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);   
        Date one;   
        Date two;   
        long day = 0;   
        long hour = 0;   
        long min = 0;   
        long sec = 0;   
        try {   
            one = df.parse(str1);   
            two = df.parse(str2);   
            long time1 = one.getTime();   
            long time2 = two.getTime();   
            long diff ;   
            if(time1<time2) {   
                diff = time2 - time1;   
            } else {   
                diff = time1 - time2;   
            }   
            day = diff / (24 * 60 * 60 * 1000);   
            hour = (diff / (60 * 60 * 1000) - day * 24);   
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);   
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);   
        } catch (ParseException e) {   
            e.printStackTrace();   
        }   
        long[] times = {day, hour, min, sec};   
        return times;   
    }   
      
    /**  
     * ����ʱ��֮�������������  
     * @param one ʱ����� 1��  
     * @param two ʱ����� 2��  
     * @return �������  
     */   
    public static Long getDistanceDays(String str1, String str2) throws Exception{   
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);   
        Date one;   
        Date two;   
        long days=0;   
        try {   
            one = df.parse(str1);   
            two = df.parse(str2);   
            long time1 = one.getTime();   
            long time2 = two.getTime();   
            long diff ;   
            if(time1<time2) {   
                diff = time2 - time1;   
            } else {   
                diff = time1 - time2;   
            }   
            days = diff / (1000 * 60 * 60 * 24);   
        } catch (ParseException e) {   
            e.printStackTrace();   
        }   
        return days;   
    }   
      
    /** 
     * ��ȡָ��ʱ������� 00:00:00.000 ��ʱ�� 
     * @param date 
     * @return 
     */  
    public static Date getDayBeginTime(final Date date) {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.set(Calendar.HOUR_OF_DAY, 0);  
            c.set(Calendar.MINUTE, 0);  
            c.set(Calendar.SECOND, 0);  
            c.set(Calendar.MILLISECOND, 0);  
            return c.getTime();  
    }  
      
    /** 
     * ��ȡָ��ʱ������� 23:59:59.999 ��ʱ�� 
     * @param date 
     * @return 
     */  
    public static Date getDayEndTime(final Date date) {  
            Calendar c = Calendar.getInstance();  
            c.setTime(date);  
            c.set(Calendar.HOUR_OF_DAY, 23);  
            c.set(Calendar.MINUTE, 59);  
            c.set(Calendar.SECOND, 59);  
            c.set(Calendar.MILLISECOND, 999);  
            return c.getTime();  
    }  
     
      
    public static void main(String [] args){  
        try {  
            DateUtil dateUtil = new DateUtil();  
            System.out.println();  
              
        } catch (Exception e) {  
            // TODO: handle exception  
        }  
          
    }  
      
}  

