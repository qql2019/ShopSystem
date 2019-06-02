package com.cissst.bysales.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.service.Saveservice;
import com.cissst.bysales.service.impl.Saveserviceimpl;

public class Saveservlet extends HttpServlet {
private  Saveservice save=new Saveserviceimpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String meter = request.getParameter("reqfg");
		if("finalsavelike".equals(meter)){
			finalsavelike(request,response);
		}else if("finalsave".equals(meter)){
			finalsave(request,response);
		}
	
	}
//查询
private void finalsave(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Save> listsave = save.finalsave();
		request.setAttribute("listsave", listsave);
		request.getRequestDispatcher("/save/savequest.jsp").forward(request, response);
		
		
	}


	//模糊查询
	private void finalsavelike(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("product");
		List<Save> listsave = save.finalsavelike(parameter);
		request.setAttribute("listsave", listsave);
		request.getRequestDispatcher("/save/savequest.jsp").forward(request, response);
		
	}

}
