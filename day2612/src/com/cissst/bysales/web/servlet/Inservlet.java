package com.cissst.bysales.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.service.Insaveserver;
import com.cissst.bysales.service.Productserver;
import com.cissst.bysales.service.impl.Insaveserverimpl;
import com.cissst.bysales.service.impl.Productserverimpl;
import com.cissst.bysales.utils.ConverUtils;
import com.cissst.bysales.utils.StringUtils;

/**
 * 处理入库
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Inservlet extends HttpServlet {
	private Productserver pser = new Productserverimpl();
	private Insaveserver inserver = new Insaveserverimpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rem = request.getParameter("reqfg");
		if ("addIn".equals(rem)) {
			addIn(request, response);
		} else if ("addInUI".equals(rem)) {
			addInUI(request, response);
		} else if ("getservletid".equals(rem)) {
			getservletid(request, response);
		}else if("finallyIn".equals(rem)){
			finallyIn(request,response);
		}else if("finallyInlike".equals(rem)){
			finallyInlike(request,response);
		}

	}
	//模糊查询
private void finallyInlike(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String inselect = request.getParameter("inselect");
		String intext = request.getParameter("intext");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put(inselect, intext);
		List<In> listin = inserver.finallyInlike(map);
		request.setAttribute("listin", listin);
		request.getRequestDispatcher("/in/inquer.jsp").forward(request, response);
		
	}

	//查询商品
	private void finallyIn(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<In> listin=inserver.finallyIn();
		request.setAttribute("listin", listin);
		request.getRequestDispatcher("/in/inquer.jsp").forward(request, response);	
	}

	// 根据选择的商品获取商品名 单价 出版社
	private void getservletid(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String productId = request.getParameter("productId");
		int id = Integer.parseInt(productId);
		Product procu = pser.finallyid(id);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JsonConfig jsoncifg = new JsonConfig();
		// 不设置suppler pubdate
		jsoncifg.setExcludes(new String[] { "suppler", "pubdate" });
		JSONObject jsonobj = JSONObject.fromObject(procu, jsoncifg);
		String jsonstr = jsonobj.toString();
		out.print(jsonstr);
		out.close();

	}

	// 处理页面请求
	private void addInUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Product> selectproduct = pser.fialyProduct();
		request.setAttribute("selectproduct", selectproduct);
		request.getRequestDispatcher("/in/addinUI.jsp").forward(request,
				response);

	}

	// 添加到仓库
	@SuppressWarnings("unused")
	private void addIn(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String productst = request.getParameter("selectname");
		int product = Integer.parseInt(productst);
		String inpricest = request.getParameter("inprice");
		double inprice = Double.parseDouble(inpricest);
		String innumst = request.getParameter("innum");
		int innum = Integer.parseInt(innumst);
		String inmenyst = request.getParameter("inmeny");
		double inmeny = Double.parseDouble(inmenyst);
		String persnon = request.getParameter("persnon");
		String inallperson = request.getParameter("inallperson");
		String memo = request.getParameter("memo");
		// 获取最大Id
		String maxpk = inserver.finalMaxpk();
		// 转util.date为sql.date
		String nextString = StringUtils.finallyNextString(maxpk);
		java.sql.Date indate = ConverUtils.forutilDatemstring(new Date());
		In in = new In(nextString, inprice, innum, inmeny, indate, persnon,
				inallperson, inmeny, "否", memo);
		// 获取商品id
		Product productt = new Product();
		productt.setId(product);
		// 设置id
		in.setProduct(productt);
		int row = inserver.addin(in);
		if (row > 0) {
			out.print("<script>alert(\"入库成功\");window.location.href=\""
					+ request.getContextPath()
					+ "/Inservlet?reqfg=addInUI\"</script>");
		} else {
			request.setAttribute("tip", "录入失败");
			request.getRequestDispatcher("/Inservlet?reqfg=addInUI").forward(
					request, response);
		}

	}
}
