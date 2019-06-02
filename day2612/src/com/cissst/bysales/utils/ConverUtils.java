package com.cissst.bysales.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * 处理时间工具类
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class ConverUtils {
	/**
	 * 将字符串转为java.sql.Date 日期
	 * @author Administrator
	 *
	 */	
public static Date formstring(String datstr){
	if(datstr==null||datstr.length()==0){
		throw new RuntimeException("日期格式无效");
	}
	//设置时间格式
	SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
	Date sqldate=null;
	try {
		//将字符串转为指定格式java.util.Date
		java.util.Date utdate=sm.parse(datstr);
		//获取毫秒数
		long time=utdate.getTime();
		//通过构造方法转为sql.date
		sqldate= new Date(time);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sqldate;
}

/**
 *    java.util.Date转java.sql.Date
 * @param date
 * @return
 */
public static Date forutilDatemstring(java.util.Date date) {
	if(date==null){
		throw new RuntimeException("传入日期格式无效");
	}
	Date sqlDate=null;
	//获取传入的util.date毫秒数
	 long time=date.getTime();
	 //通过sql.date的构造方法转
	 sqlDate=new Date(time);
	return sqlDate;
}




}
