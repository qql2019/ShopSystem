package com.cissst.bysales.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}

	@Override
	public String getParameter(String name) {
		//获取请求内容单个
		String value=request.getParameter(name);
		if(value!=null){
			
				try {
					value=new String(value.getBytes("ISO-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return value;
	}
	//获取请求内容多个
	@Override
	public String[] getParameterValues(String name) {
		String[] value=request.getParameterValues(name);
		if(value!=null){
			for (int i = 0; i < value.length; i++) {
				try {
					value[i]=new String(value[i].getBytes("ISO-8859-1"),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	
}
