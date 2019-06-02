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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cissst.bysales.daomain.Users;

/**
 *是否登录拦截器
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		//获取会话
	HttpSession session=request.getSession();
	//获取会话中的用户名
		Users user=(Users)session.getAttribute("user");
		//获取请求地址
		String path=request.getServletPath();
		//获取请求方法名
		String meth=request.getParameter("reqfg");
		//指定请求地址
		String excude1="/login.jsp";
		String excude2="/Userservlet";
		//没有登录让用户去登陆
		if(user==null){
			//判断请求是否是login.jsp
			if(excude1.contains(path)){
				chain.doFilter(request, response);
				return;
			}
			//判断是否是userlogin方法
			if(excude2.contains(path)&&meth.equals("userlogin")){
				chain.doFilter(request, response);
				return;
			}
			//重定向到登陆页面
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			//登陆放行
		chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
