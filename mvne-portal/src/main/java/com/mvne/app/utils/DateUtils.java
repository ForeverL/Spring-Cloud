package com.mvne.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

import org.joda.time.DateTime;

import com.mvne.app.exception.SystemException;


/***********************************************************  
* @ClassName : DateUtils  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 下午4:33:33  
***********************************************************/ 
public class DateUtils {
	
	private DateUtils(){}
	
	private static ThreadLocal threadLocal = new ThreadLocal();
	
    public static SimpleDateFormat getDateFormat(String pattern) {
        
        HashMap<String,SimpleDateFormat> dfMap = (HashMap<String,SimpleDateFormat>) threadLocal.get();
        if (dfMap == null) {
            dfMap = new HashMap<String,SimpleDateFormat>();  
            threadLocal.set(dfMap);
        }
        SimpleDateFormat df = dfMap.get(pattern);
        if(df==null){
            df = new SimpleDateFormat(pattern);
        }
        return df;
    }
	
	final static String Format_MmDdHhMmSs="MM-dd HH:mm:ss";
	final static String Format_YyyyMmDdHhMmSs="yyyy-MM-dd HH:mm:ss";
	final static String Format_YyyyMmDd="yyyyMMdd";
	final static String Format_yyyyMMddHHmmss="yyyyMMddHHmmss";
	final static String Format_MMddHH="MM-dd HH";
	final static String Format_YyyyMm="yyyyMM";
	final static String Format_Hhmmss="HHmmss";
	final static String Format_DdHhMm="dd HH:mm";
	final static String Format_HhMm = "HH:mm";

//	/**MM-dd HH:mm:ss*/
//	static SimpleDateFormat sd_1;
//	/**yyyy-MM-dd HH:mm:ss*/
//	static SimpleDateFormat sd_2;
//	/**yyyyMMdd*/
//	static SimpleDateFormat sd_3;
//	/**yyyyMMddHHmmss*/
//	static SimpleDateFormat sd_4;
//	/**MM-dd HH*/
//	static SimpleDateFormat sd_5;
//	/**yyyyMM*/
//	static SimpleDateFormat sd_6;
	
	/**格式化日期为字符串(date_MM-dd HH:mm:ss)*/
	public static String formatDateToMMddHHmmSS(Date date){
		try{
			return getDateFormat(Format_MmDdHhMmSs).format(date);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+date
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**格式化日期为字符串(date_dd HH:mm)*/
	public static String formatDateToddHHmm(Date date){
		try{
			return getDateFormat(Format_DdHhMm).format(date);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+date
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**格式化日期为字符串(date_HH:mm)*/
	public static String formatDateToHHmm(Date date){
		try{
			return getDateFormat(Format_HhMm).format(date);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+date
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**格式化日期为字符串(date_MM-dd HH )
	 * */
	public static String formatDateToMMDDHH(Date date){
		try{
			return getDateFormat(Format_MMddHH).format(date);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+date
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**日期转换为字符串出错(date_yyyy-MM-dd HH:mm:ss)*/
	public static String formatDateYYYYmmDDhhMMss(Date date){
		if(null==date)
			return "";
		try{
			return getDateFormat(Format_YyyyMmDdHhMmSs).format(date);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+date
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**日期转换为字符串出错(HH:mm:ss)*/
    public static String formatDateHHmmss(Date date){
        try{
            return getDateFormat(Format_Hhmmss).format(date);
        }catch(Exception e){
            throw new SystemException("日期转换为字符串错误:date-"+date
                    +",默认:"+TimeZone.getDefault());
        }
    }
    
	
	
	/**日期转换为字符串出错(date_yyyyMMdd)*/
	public static String formatDateToYYYYMMDD(Date date){
		try{
			return getDateFormat(Format_YyyyMmDd).format(date);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+date
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	public static int formatDateToIntYYYYMMDD(Date date){
        try{
            return Integer.parseInt(getDateFormat(Format_YyyyMmDd).format(date));
        }catch(Exception e){
            throw new SystemException("日期转换为字符串错误:date-"+date
                    +",默认:"+TimeZone.getDefault());
        }
    }
	
	
	/**日期转换为字符串出错(date_yyyyMMddHHmmss)*/
	public static String formatDateYYYYmmDDhhMMss_(Date date){
		try{
			return getDateFormat(Format_yyyyMMddHHmmss).format(date);
		}catch(Exception e){
			throw new SystemException("日期转换为整形错误:date-"+date
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**字符串转换为日期(date_yyyy-MM-dd HH:mm:ss)*/
	public static Date formatString(String datestring){
		try{
			return getDateFormat(Format_YyyyMmDdHhMmSs).parse(datestring);
		}catch(Exception e){
			throw new SystemException("字符串转换为日期出错,str:"+datestring
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	
	/**字符串转换为日期出错(date_yyyyMMdd)*/
	public static Date formatString_YYYYMMDD(String datestring){
		try{
			return getDateFormat(Format_YyyyMmDd).parse(datestring);
		}catch(Exception e){
			throw new SystemException("字符串转换为日期出错,str:"+datestring
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**字符串转换为日期出错(date_yyyyMM)*/
	public static Date formatString_YYYYMM(String stridatestringng){
		try{
			return getDateFormat(Format_YyyyMm).parse(stridatestringng);
		}catch(Exception e){
			throw new SystemException("字符串转换datestring错,str:"+stridatestringng
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**字符串转换为日期出错(date_yyyyMMddHHmmss)*/
	public static Date formatStringYYYYMMDDHHMMSS(String datestring){
		try{
			return getDateFormat(Format_yyyyMMddHHmmss).parse(datestring);
		}catch(Exception e){
			throw new SystemException("字符串转换为日期出错,str:"+datestring
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**Long数字转换为日期类型的字符串出错(date_yyyy-MM-dd HH:mm:ss)*/
	public static String formatDateYYYYmmDDhhMMSs(long dateTm){
		try{
			return getDateFormat(Format_YyyyMmDdHhMmSs).format(dateTm);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+dateTm
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**Long数字转换为日期类型的字符串出错(date_yyyy-MM-dd HH:mm:ss)*/
	public static String formatDateYYYYmmDDhhMMss(long dateTm){
		try{
			return getDateFormat(Format_yyyyMMddHHmmss).format(dateTm);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+dateTm
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**格式化当前日期为字符串(date_yyyyMMddHHmmss)*/
	public static String nowFormat(){
		try{
			return getDateFormat(Format_yyyyMMddHHmmss).format(DateUtils.getNowDate());
		}catch(Exception e){
			throw new SystemException("当前日期转换为字符串出错"
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**格式化当前日期为字符串(date_yyyy-MM-dd HH:mm:ss)*/
	public static String nowFormat_(){
		try{
			return getDateFormat(Format_YyyyMmDdHhMmSs).format(DateUtils.getNowDate());
		}catch(Exception e){
			throw new SystemException("当前日期转换为字符串出错"
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**格式化当前日期为字符串(date_yyyyMMdd)*/
	public static String nowFormat__(){
		try{
			return getDateFormat(Format_YyyyMmDd).format(DateUtils.getNowDate());
		}catch(Exception e){
			throw new SystemException("当前日期转换为字符串出错"
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**日期转换为字符串出错(date_yyyyMM)*/
	public static String formatDateToYYYYMM(Date date){
		try{
			return getDateFormat(Format_YyyyMm).format(date);
		}catch(Exception e){
			throw new SystemException("日期转换为字符串错误:date-"+date
					+",默认:"+TimeZone.getDefault());
		}
	}
	
	/**获取当前系统时间*/
	public static Date getNowDate(){
		return new Date();
	}
	
	/**获取两个时间点之间的时间段*/
	public static String[] getBetweenTwoDays(Date startTm,Date endTm){
		/**Modify by liny 20150129 如果跨年，则该算法有误
		DateTime dateTime_startTm=new DateTime(startTm);
		int startTm_day=dateTime_startTm.getDayOfYear();
		DateTime dateTime_endTm=new DateTime(endTm);
		int endTm_day=dateTime_endTm.getDayOfYear();
		int dispatch=endTm_day-startTm_day;
		if(dispatch==0){
			return new String[]{DateUtils.formatDateToYYYYMMDD(startTm)};
		}else if(dispatch<0){
			dispatch=startTm_day-endTm_day;
			dateTime_startTm=new DateTime(endTm);
			dateTime_endTm=new DateTime(startTm);
		}
		**/
		DateTime dateTime_startTm=new DateTime(startTm);
		int dispatch = 0;
		try {
			dispatch = daysBetween(startTm, endTm);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dispatch==0){
			return new String[]{DateUtils.formatDateToYYYYMMDD(startTm)};
		}else if(dispatch<0){
			dispatch = java.lang.Math.abs(dispatch);
			dateTime_startTm=new DateTime(endTm);
		}
		
		String[] days=new String[dispatch+1];
		for(int i=0;i<=dispatch;i++){
			Date date=dateTime_startTm.plusDays(i).toDate();
			days[i]=DateUtils.formatDateToYYYYMMDD(date);
		}
		return days;
	}
	
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 *字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate, String bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	
	
	/**获取前一天的时间点***/
	public static Date getBeforeDate(int lastdays){
		DateTime beforeDate=new DateTime();
		Date d=beforeDate.withHourOfDay(0)
				  .withSecondOfMinute(0)
				  .withMinuteOfHour(0)
				  .withMillisOfSecond(0)
				  .minusDays(lastdays-1).toDate();
		return d;
	}
	
	/**获取前一分钟的时间点***/
	public static Date getBeforeMinuteDate(int lastMinutes){
		DateTime beforeDate=new DateTime();
		Date d=beforeDate.minusMinutes(lastMinutes).toDate();
		return d;
	}
	
    public static Date getPlusDate(Date date,int days){
        DateTime beforeDate=new DateTime(date);
        Date d=beforeDate.withHourOfDay(0)
                  .withSecondOfMinute(0)
                  .withMinuteOfHour(0)
                  .withMillisOfSecond(0).plusDays(days).toDate();
        return d;
    }
	
//	public static boolean isOutOfMemoryDate(Date startDay){
//	  
//        Date beforeDate= getBeforeDate(RoamConstans.LOAD_DATA_TO_MEMORY_DAYS);
//        if(startDay.before(beforeDate)){
//            return true;
//        }
//        return false;
//	}
	
	public static Date pluSeconds(Date date,int second){
		DateTime dateTime=new DateTime(date);
		return dateTime.plusSeconds(second).toDate();
	}
	
	public static Date minusHours(Date date,int hour){
		DateTime dateTime=new DateTime(date);
		return dateTime.minusHours(hour).toDate();
	}
	
	public static Date plusHours(Date date,int hour){
		DateTime dateTime=new DateTime(date);
		return dateTime.plusHours(hour).toDate();
	}
	
	public static Date minusDay(Date date,int day){
		DateTime dateTime=new DateTime(date);
		return dateTime.minusDays(day).toDate();
	}
	
	public static Date plusDay(Date date,int day){
		DateTime dateTime=new DateTime(date);
		return dateTime.plusDays(day).toDate();
	}
	
	public static Date plusMonth(Date date,int month){
		DateTime dateTime=new DateTime(date);
		return dateTime.plusMonths(month).toDate();
	}
	
	public static Date minusMonth(Date date,int month){
		DateTime dateTime=new DateTime(date);
		return dateTime.minusMonths(month).toDate();
	}
	
	public static String minusDay(String date,int day){
		date = date.substring(0,4)+"-"+date.substring(4, 6)+"-"+date.substring(6,8);
		try{
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			return formatDateToYYYYMMDD(minusDay(sd.parse(date),day));
		}catch(Exception e){
			throw new SystemException("获取以"+date+"往前推"+day+"天时出错,默认:"+TimeZone.getDefault());
		}
	}
	
	public static String minusMonth(String date,int month){
		date = date.substring(0,4)+"-"+date.substring(4, 6);
		try{
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM");
			return formatDateToYYYYMM(minusMonth(sd.parse(date),month));
		}catch(Exception e){
			throw new SystemException("获取以"+date+"往前推"+month+"个月时出错,默认:"+TimeZone.getDefault());
		}
	}
	
	public static Date getFirstDayOfMonth(Date date){
	    String dateStr = formatDateToYYYYMM(date);
	    dateStr = dateStr +"01";
	    return formatString_YYYYMMDD(dateStr);
	}
	
	public static Date getFirstDayOfMonth(String dateyyyyMMdd){
        String dateStr = dateyyyyMMdd.substring(0,6);
        dateStr = dateStr +"01";
        return formatString_YYYYMMDD(dateStr);
    }
	public static void main(String[] args) throws ParseException
    {
		System.out.println(nowDay());
	    /*int s = 14*60 +30;
	    System.out.println(s/15);
	    int dayCount = 3;
        StringBuilder sb=new StringBuilder();
        Set<String> monthSet = new HashSet<String>();
        Date nowDate=new Date();
        //话单通话日
        sb.append("(");
        
        for(int i=0;i<dayCount;i++){
            if(i!=0){
                sb.append(" or ");
            }
            String dateStr = DateUtils.
            formatDateToYYYYMMDD(DateUtils.minusDay(nowDate, i));
            
            sb.append("CDR_DT=").append(dateStr);
            monthSet.add(dateStr.substring(0,6));
        }       
        sb.append(")");
        
        sb.append(" and (");
        boolean firstMonth = false;
        for(String month : monthSet){
            if(!firstMonth){
                firstMonth = true;
            }else{
                sb.append(" or ");
            }
            sb.append(" CDR_MONTH=").append(month);
        }
        sb.append(")");
        
//        sb.append(DataDict.getString(RoamConstans.D_TASKSQLCONTEXT));
        System.out.println(sb.toString());*/
    }
	
	/**
	 * 计算两个日期之间相差的分钟数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @param bdate
	 *            时间间隔
	 * @return 相差分钟数
	 * @throws ParseException
	 */
	public static int minutesBetween(Date smdate, Date bdate,int minute)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_minutes = (time2 - time1) / (1000 * 60 * minute);

		return Integer.parseInt(String.valueOf(between_minutes));
	}
	
	
	/**获取两个时间点之间的时间段
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @param minute        
	 * 			  时间间隔   
	 * @return 相差多少个minute分钟
	 * @throws ParseException
	 * 
	 */
	public static String[] getBetweenTwoMinutes(Date startTm,Date endTm,int minute){
		DateTime dateTime_startTm=new DateTime(startTm);
		int dispatch = 0;
		try {
			dispatch = minutesBetween(startTm, endTm ,minute);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dispatch<=0){
			return new String[]{};
		}
		
		String[] days=new String[dispatch];
		for(int i=0;i<dispatch;i++){
			Date date=dateTime_startTm.plusMinutes(minute*i).toDate();
			days[i]=DateUtils.formatDateYYYYmmDDhhMMss_(date);
		}
		return days;
	}
	
	
	/**时间加一天
	 * 
	 * @param date
	 *            时间
	 * @throws ParseException
	 * 
	 */
	public static Date addOneDay(Date date,int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
	
	
	/**时间减一天并转换为number类型的年月日
	 * 
	 * @param date
	 *            时间
	 * @throws ParseException
	 * 
	 */
	public static int addOneDay(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		String day = formatDateToYYYYMMDD(cal.getTime());
		return Integer.parseInt(day);
	}
	
	/**时间减一个月并转换为number类型的年月
	 * 
	 * @param date
	 *            时间
	 * @throws ParseException
	 * 
	 */
	public static int addOneMonth(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		String month = formatDateToYYYYMM(cal.getTime());
		return Integer.parseInt(month);
	}
	
	/**
	 * 获取当前月最后一天
	 * @return
	 */
	public static String getLastMonthDay() {
    	Calendar cale = null;
		cale = Calendar.getInstance();
    	// 获取当月第一天和最后一天
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String firstday, lastday;
		// 获取前月的第一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		firstday = format.format(cale.getTime());
		// 获取前月的最后一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		lastday = format.format(cale.getTime());
		return lastday;
    }
	
	/**
	 * 计算和当前时间差日期
	 * @return
	 * @throws ParseException 
	 */
	public static Integer getBetweenDay(Integer bTime){
		String dateString = String.valueOf(bTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		Date nowDate = null;
		try {
			date = sdf.parse(dateString);
			date = sdf.parse(sdf.format(date));
			nowDate = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		long time1 = cal.getTimeInMillis();
		cal.setTime(nowDate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**时间加一天
	 * 
	 * @param date
	 *            时间
	 * @throws ParseException
	 * 
	 */
	public static Integer addOneDay(Integer bTime, int day){
		String dateString = String.valueOf(bTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		Date date1 = cal.getTime();
		sdf.format(date1);
		return Integer.parseInt(sdf.format(date1));
	}
	
	/**当前时间返回Integer
	 * 
	 * @param date
	 *            时间
	 * @throws ParseException
	 * 
	 */
	public static Integer nowDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		return Integer.parseInt(sdf.format(date));
	}
	
}
