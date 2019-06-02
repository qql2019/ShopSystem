package com.cissst.bysales.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cissst.bysales.daomain.Users;
import com.cissst.bysales.service.Usersservice;
import com.cissst.bysales.service.impl.Usersserverimpl;

/**
 * 处理登录注销
 * 
 * @author Administrator
 * 
 */
public class Userservlet extends HttpServlet {
	private Usersservice userr = new Usersserverimpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rem = request.getParameter("reqfg");
		if ("userlogin".equals(rem)) {
			userlogin(request, response);
		} else if ("loginout".equals(rem)) {
			loginout(request, response);
		}
	}

	// 处理注销
	private void loginout(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}

	// 处理登录
	private void userlogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		Users user = userr.islogin(username, userpass);
		// 登录成功
		if (user != null) {
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/index/index.jsp");
		} else {// 失败
			request.setAttribute("tip", "用户名或密码错误");
			
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}

	}
}
