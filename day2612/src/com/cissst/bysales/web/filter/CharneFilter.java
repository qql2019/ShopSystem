package com.cissst.bysales.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;

import com.cissst.bysales.utils.MyHttpServletRequest;


/**
 * 解决请求乱码拦截器
 * Servlet Filter implementation class CharneFilter
 */
@WebFilter("/CharneFilter")
public class CharneFilter implements Filter {

    
   

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)req; 
		//拦截器设置字符集
		MyHttpServletRequest mys=new MyHttpServletRequest(request);
		//放行
		chain.doFilter(mys, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
