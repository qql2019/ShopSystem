package com.cissst.bysales.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public class StringUtils {
/**
 * 传入的类型格式RK201812041550590000000001
 * @param oldstr 传入字符串
 * @return 增加1字符串
 */
public static String finallyNextString(String oldstr){
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	//获取当前时间
	String datestr=sdf.format(new Date());
	StringBuffer sb=new StringBuffer();
	//判断旧的字符串
	if(oldstr==null||oldstr.length()==0){
		//追加
		sb.append("RK");
		sb.append(datestr);
		sb.append("000000001");
	}else{
		//正则表达式进行校验
		String regex="RK\\d{23}";
		if(!oldstr.matches(regex)){
			throw new RuntimeException("传入字符串和格式不匹配");
		}
		//返回一个新字符串
	String afterstr=oldstr.substring(16);
	//继续返回一个新字符串
	String prestr= oldstr.substring(0, 16);
	//将第一个字符串转long类型
	long after=Long.parseLong(afterstr);
	//给long类型数加1
	after=after+1;
	//参数的字符串表示形式
	afterstr=String.valueOf(after);
	//追加第二个字符串
	sb.append(prestr);
	
	//循环遍历第一个字符串如果小于第一个字符串长度追加0
	for (int i = 0; i <9-afterstr.length(); i++) {
		sb.append("0");
	}
	sb.append(afterstr);
	}
	return sb.toString();
}

/**
 * 入库结账编号RKJK20181208144448000000003
 * @param oldstr 字符串
 * @return 增加1的字符串
 */
public static String finaRKJKString(String oldstr){
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	String destr = sdf.format(new Date());
	StringBuffer sb=new StringBuffer();
	if(oldstr==null||oldstr.length()==0){
		sb.append("RKJK");
		sb.append(destr);
		sb.append("000000001");
	}else{
		String regex="RKJK\\d{23}";
		if(!oldstr.matches(regex)){
			throw new RuntimeException("字符串格式不匹配");
		}
		String afstr = oldstr.substring(18);
		long after = Long.parseLong(afstr);
		after=after+1;
		afstr = String.valueOf(after);
		 sb.append("RKJK");
		 sb.append(destr);
		 for (int i = 0; i < 9-afstr.length(); i++) {
			sb.append("0");
		}
		 sb.append(afstr);
		
	}
	return sb.toString();
	
}
/**
 * 传入字符格式XS20181208144448000000001 增加1返回
 * @param oldstr 字符串
 * @return 增加1
 */
public static String finaXSString(String oldstr){
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	String sdfstr=sdf.format(new Date());
	StringBuffer sb=new StringBuffer();
	if(oldstr==null||oldstr.length()==0){
		sb.append("XS");
		sb.append(sdfstr);
		sb.append("000000001");
	}else{
		String regx="XS\\d{23}";
		if(oldstr.contains(sdfstr)){
			throw new RuntimeException("时间格式不对");
		}
		String after = oldstr.substring(18);
		long afterlo = Long.parseLong(after);
		afterlo=afterlo+1;
		after=String.valueOf(afterlo);
		sb.append("XS");
		sb.append(sdfstr);
		for (int i = 0; i < after.length(); i++) {
			sb.append("0");
			
		}
		sb.append(after);
	}
	
	return sb.toString();
	
}
/**
 * 传入字符格式RKTH20181208144448000000001 增加1返回
 * @param oldstr 字符串
 * @return 增加1
 */
public static String finaRKThString(String oldstr){
	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	String sdfstr=sdf.format(new Date());
	StringBuffer sb=new StringBuffer();
	if(oldstr==null||oldstr.length()==0){
		sb.append("RKTh");
		sb.append(sdfstr);
		sb.append("000000001");
	}else{
		String regx="RKTh\\d{23}";
		if(oldstr.contains(sdfstr)){
			throw new RuntimeException("时间格式不对");
		}
		String after = oldstr.substring(18);
		long afterlo = Long.parseLong(after);
		afterlo=afterlo+1;
		after=String.valueOf(afterlo);
		sb.append("RKTh");
		sb.append(sdfstr);
		for (int i = 0; i < after.length(); i++) {
			sb.append("0");
			
		}
		sb.append(after);
	}
	
	return sb.toString();
	
}
}
