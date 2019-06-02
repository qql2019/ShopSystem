package com.cissst.bysales.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Suppler;
import com.cissst.bysales.service.Productserver;
import com.cissst.bysales.service.Supplerservser;
import com.cissst.bysales.service.impl.Productserverimpl;
import com.cissst.bysales.service.impl.Supplerserverimpl;
import com.cissst.bysales.utils.ConverUtils;

public class Productservlet extends HttpServlet {
	private Supplerservser supp = new Supplerserverimpl();
	private Productserver prd = new Productserverimpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断执行那个方法
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String mef = request.getParameter("reqfg");
		if ("addproduct".equals(mef)) {
			addproduct(request, response);
		} else if ("addproductUI".equals(mef)) {
			addproductUI(request, response);
		} else if ("finallyproduct".equals(mef)) {
			finallyproduct(request, response);
		} else if ("finallyproductlike".equals(mef)) {
			finallyproductlike(request, response);
		}

	}

	// 获取供应商
	private void addproductUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Suppler> selectip = supp.supplerfinally();
		request.setAttribute("selectip", selectip);
		request.getRequestDispatcher("/product/addproduct.jsp").forward(
				request, response);

	}

	/**
	 * 用于接收并处理新增商品的请求
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addproduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String productno = request.getParameter("productno");
		String productname = request.getParameter("productname");
		String productauth = request.getParameter("productauth");
		String pricestr = request.getParameter("price");
		String disknostr = request.getParameter("diskno");
		String supplerstr = request.getParameter("suppler");
		String pubdatestr = request.getParameter("pubdate");
		String memo = request.getParameter("memo");
		double price = Double.parseDouble(pricestr);
		int diskno = Integer.parseInt(disknostr);
		int suppler = Integer.parseInt(supplerstr);
		Date pubdate = ConverUtils.formstring(pubdatestr);
		Product pro = new Product(productno, productname, productauth, price,
				diskno, pubdate, memo);
		Suppler sup = new Suppler();
		sup.setId(suppler);
		pro.setSuppler(sup);
		int row = prd.addProduct(pro);
		if (row > 0) {
			out.print("<script>alert(\"添加成功\");window.location.href=\""
					+ request.getContextPath()
					+ "/Productservlet?reqfg=addproductUI\"</script>");
		} else {
			request.setAttribute("tip", "信息错误");
			request.getRequestDispatcher("/product/addproduct.jsp").forward(
					request, response);

		}

	}

	// 查询商品
	private void finallyproduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> plist = prd.fialyProduct();
		request.setAttribute("plist", plist);
		request.getRequestDispatcher("/product/productquer.jsp").forward(
				request, response);
	}

	// 模糊查询
	private void finallyproductlike(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取键
		String contname = request.getParameter("contname");
		// 获取值
		String contnametext = request.getParameter("contnametext");
		// 创建集合
		Map<String, Object> map = new HashMap<String, Object>();
		// 加入集合
		map.put(contname, contnametext);
		// 调用方法
		List<Product> plist = prd.finyproductlike(map);
		// 放入请求
		request.setAttribute("plist", plist);
		// 转发
		request.getRequestDispatcher("/product/productquer.jsp").forward(
				request, response);

	}

}
