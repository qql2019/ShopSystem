package com.cissst.bysales.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Rkth;
import com.cissst.bysales.service.Inpayserver;
import com.cissst.bysales.service.Insaveserver;
import com.cissst.bysales.service.Rkthserver;
import com.cissst.bysales.service.impl.Inpayserviceimpl;
import com.cissst.bysales.service.impl.Insaveserverimpl;
import com.cissst.bysales.service.impl.Rkthserverimpl;
import com.cissst.bysales.utils.ConverUtils;
import com.cissst.bysales.utils.StringUtils;

public class Rkthservlet extends HttpServlet {
private Insaveserver inser=new Insaveserverimpl();
	private Inpayserver inpayser=new Inpayserviceimpl();
	private Rkthserver rkthd=new Rkthserverimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	//处理开始请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html；charset=UTF-8");
		
		String meter = request.getParameter("reqfg");
		if("addRkthUI".equals(meter)){
			addRkthUI(request,response);
		}else if("getInid".equals(meter)){
			getInid(request,response);
		}else if("addRkth".equals(meter)){
			addRkth(request,response);
		}
	}

private void addRkth(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
		String selectInId = request.getParameter("selectInId");
		String productname = request.getParameter("productname");
		String supplername = request.getParameter("supplername");
		String productpricestr = request.getParameter("productprice");
		double productprice = Double.parseDouble(productpricestr);
		String productnumstr = request.getParameter("productnum");
		int productnum = Integer.parseInt(productnumstr);
		String operator = request.getParameter("operator");
		String allowebperson = request.getParameter("allowebperson");
		String productmoneystr = request.getParameter("productmoney");
		double productmoney = Double.parseDouble(productmoneystr);
		String memo = request.getParameter("memo");
		String maxId = rkthd.maxId();
		String nextString = StringUtils.finaRKThString(maxId);
		java.sql.Date rkthdate = ConverUtils.forutilDatemstring(new Date());
		In in = inpayser.finallyInid(selectInId);
		Rkth rkth=new Rkth(nextString, productname, supplername, productprice, productmoney,
				rkthdate, operator, allowebperson, productmoney, "否", productnum, memo);
		rkth.setIn(in);
		int row = rkthd.addRuth(rkth);
		if(row>0){
			out.print("<script>alert(\"添加成功\");window.location.href=\""
					+ request.getContextPath()
					+ "/Rkthservlet?reqfg=addRkthUI\"</script>");
		} else {
			request.setAttribute("tip", "信息错误");
			request.getRequestDispatcher("/Rkthservlet?reqfg=addRkthUI").forward(
					request, response);

		}
	}

	//处理页面异步刷新
	private void getInid(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String inId = request.getParameter("inId");
		if(inId==null){
			request.getRequestDispatcher("/save/addRkthUI.jsp").forward(request, response);
			return;
		}
		In finallInid = inpayser.finallyInid(inId);
		int sumnum = rkthd.finallsumById(inId);

		if(finallInid==null){
			out.print("网站建设中");
			return;
		}
		//设置数量为入库数量-退货数量
		finallInid.setInnum(finallInid.getInnum()-sumnum);
		//设置欠款金额为入库金额-退货金额
		finallInid.setInmeny(finallInid.getInmeny()-sumnum*finallInid.getInprice());
		
		JsonConfig config=new JsonConfig();
		config.setExcludes(new String[]{"product","indate"});
		JSONObject object = JSONObject.fromObject(finallInid,config);
		out.print(object.toString());
		out.close();
	}


	private void addRkthUI(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		List<In> selectInId = inser.finallyInBlank();
		if(selectInId==null||selectInId.size()==0){
			out.print("网站异常");
		}
		request.setAttribute("selectin", selectInId);
		request.getRequestDispatcher("/save/addRkthUI.jsp").forward(request, response);
		
	}

}
