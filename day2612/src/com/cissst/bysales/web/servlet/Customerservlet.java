package com.cissst.bysales.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cissst.bysales.daomain.Customer;
import com.cissst.bysales.service.Customerserver;
import com.cissst.bysales.service.impl.Customerserverimpl;

@SuppressWarnings("serial")
public class Customerservlet extends HttpServlet {
		private Customerserver custserver= new Customerserverimpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断执行那个方法
				String mereq=request.getParameter("reqfg");//mereq为jsp页面表单隐藏域对象
				if("addcust".equals(mereq)){
					addcust(request,response);
				}else if("finallcust".equals(mereq)){
					finallcust(request,response);
				}else if("finacustlike".equals(mereq)){
					finacustlike(request,response);
				}			
		
	}
	//添加客户
	public void addcust(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			//获取表单数据
			PrintWriter out=response.getWriter();
			String custname=request.getParameter("custname");
			String custattr=request.getParameter("custattr");
			String custtel=request.getParameter("custtel");
			String custpersion=request.getParameter("custpersion");
			String custpertel=request.getParameter("custpertel");
			String custfax=request.getParameter("custfax");
			String custemail=request.getParameter("custemail");
			String custQQ=request.getParameter("custQQ");
			String custbank=request.getParameter("custbank");
			String custaccountno=request.getParameter("custaccountno");
			String custmeno=request.getParameter("custmeno");
			String custpostcod=request.getParameter("custpostcod");
			Customer customer=new Customer(custname, custattr, custtel, custpersion, custpertel, custfax, custemail, custQQ, custbank,
					custaccountno, custmeno, custpostcod);
			int rows=custserver.addcust(customer);
			if(rows>0){
				out.print("<script>alert(\"添加成功\");window.location.href=\""+request.getContextPath()+"/customer/addCustomer.jsp\"</script>");
			}else{
				request.setAttribute("tip", "添加失败");
				request.getRequestDispatcher("/customer/addCustomer.jsp").forward(request, response);
			}
			
	}
	//用于接收并处理查询所有客户的请求
	public void finallcust(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Customer> cuslist=custserver.finallcust();
		request.setAttribute("cuslist",cuslist );
		request.getRequestDispatcher("/customer/custrequest.jsp").forward(request, response);
		
	}
	// 用于接收并处理根据客户全名模糊查询客户的请求
	public void finacustlike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String custName=request.getParameter("custName");
		List<Customer> cuslist=custserver.finacustlike(custName);
		request.setAttribute("cuslist", cuslist);
		request.getRequestDispatcher("/customer/custrequest.jsp").forward(request, response);
	}
}
