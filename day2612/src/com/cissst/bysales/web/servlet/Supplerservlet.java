package com.cissst.bysales.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cissst.bysales.daomain.Suppler;
import com.cissst.bysales.service.Supplerservser;
import com.cissst.bysales.service.impl.Supplerserverimpl;

public class Supplerservlet extends HttpServlet {

	Supplerservser supser = new Supplerserverimpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String meth = request.getParameter("reqfg");
		if ("addSuppler".equals(meth)) {
			addSuppler(request, response);
		} else if ("finallsuppler".equals(meth)) {
			finallsuppler(request, response);
		} else if ("finasupplerlike".equals(meth)) {
			finasupplerlike(request, response);
		}

	}

	// 添加
	private void addSuppler(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String supplername = request.getParameter("supplername");
		String suppleraddr = request.getParameter("suppleraddr");
		String supplertel = request.getParameter("supplertel");
		String supplerper = request.getParameter("supplerper");
		String supplerphone = request.getParameter("supplerphone");
		String supplerEmal = request.getParameter("supplerEmal");
		String supplerQQ = request.getParameter("supplerQQ");
		String supplerpost = request.getParameter("supplerpost");
		String supplerfax = request.getParameter("supplerfax");
		String supplerbank = request.getParameter("supplerbank");
		String suppleraccounton = request.getParameter("suppleraccounton");
		String supplermeno = request.getParameter("supplermeno");
		Suppler sup = new Suppler(supplername, suppleraddr, supplertel,
				supplerper, supplerphone, supplerEmal, supplerQQ, supplerpost,
				supplerfax, supplerbank, suppleraccounton, supplermeno);
		int row = supser.addsupple(sup);
		if (row > 0) {
			out.print("<script>alert(\"添加成功\");window.location.href=\""
					+ request.getContextPath()
					+ "/suppler/addSuppler.jsp\"</script>");
		} else {
			request.setAttribute("tip", "添加失败");
			request.getRequestDispatcher("/suppler/addSuppler.jsp").forward(
					request, response);
		}
	}

	// 查询
	private void finallsuppler(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Suppler> supplerlist = supser.supplerfinally();
		request.setAttribute("supplerlist", supplerlist);
		request.getRequestDispatcher("/suppler/supplerquer.jsp").forward(
				request, response);

	}

	// 模糊查询supplerlike未创建
	private void finasupplerlike(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String supplername = request.getParameter("supplername");
		List<Suppler> supplerlist = supser.supplerfinallylike(supplername);
		request.setAttribute("supplerlist", supplerlist);
		request.getRequestDispatcher("/suppler/supplerquer.jsp").forward(
				request, response);
	}
}
