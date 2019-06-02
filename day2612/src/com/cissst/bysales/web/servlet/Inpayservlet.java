package com.cissst.bysales.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Inpay;
import com.cissst.bysales.service.Inpayserver;
import com.cissst.bysales.service.impl.Inpayserviceimpl;
import com.cissst.bysales.utils.ConverUtils;
import com.cissst.bysales.utils.StringUtils;

public class Inpayservlet extends HttpServlet {
private Inpayserver inpayser=new Inpayserviceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		 String menth=request.getParameter("reqfg");
		 if("addinpayUI".equals(menth)){
			 addinpayUI(request,response);
		 }else if("getselectIn".equals(menth)){
			 getselectIn(request,response);
		 }else if("addinpay".equals(menth)){
			 addinpay(request,response);
		 }else if("finallyinpaylike".equals(menth)){
			 finallyinpaylike(request,response);
		 }else if("finallyinpay".equals(menth)){
			 finallyinpay(request,response);
		 }
	}
//查询
private void finallyinpay(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Inpay> listinpay = inpayser.finallyinpay();
		request.setAttribute("listinpay", listinpay);
		request.getRequestDispatcher("/inpay/inpayquest.jsp").forward(request, response);
		
	}


private void finallyinpaylike(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	String selectinpay = request.getParameter("selectinpay");
	String inpaytext = request.getParameter("inpaytext");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put(selectinpay, inpaytext);
		List<Inpay> listinpay = inpayser.finallyinpaylike(map);
		request.setAttribute("listinpay", listinpay);
		request.getRequestDispatcher("/inpay/inpayquest.jsp").forward(request, response);
		
		
	}


//添加
	private void addinpay(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String inId = request.getParameter("inId");
		String inmoneystr = request.getParameter("inmoney");
		double inmoney = Double.parseDouble(inmoneystr);
		String paymoneystr = request.getParameter("paymoney");
		double paymoney = Double.parseDouble(paymoneystr);
		String supplername = request.getParameter("supplername");
		String balancestr = request.getParameter("balance");
		double balance = Double.parseDouble(balancestr);
		String operator = request.getParameter("operator");
		String allwebpersion = request.getParameter("allwebpersion");
		String memo = request.getParameter("memo");
		String maxid = inpayser.finallMaxid();
		//生成结账订单编号
		String nextRKJKString = StringUtils.finaRKJKString(maxid);
		//得到结账时间
		java.sql.Date paydate = ConverUtils.forutilDatemstring(new Date());
		//传入实体
		Inpay inpay=new Inpay(nextRKJKString,supplername,paymoney,balance,
				paydate,operator,allwebpersion,inmoney,memo);
		In in=new In();
		//设置入库商品id
		in.setId(inId);
		//设置结账商品id
		inpay.setIn(in);
		//传入
		int rowcan = inpayser.addInpay(inpay);
		if(rowcan>0){
			out.print("<script>alert(\"结账成功\");window.location.href=\""+request.getContextPath()+"/Inpayservlet?reqfg=addinpayUI\"</script>");
			
		}else{
			request.setAttribute("tip", "结账失败");
			request.getRequestDispatcher("/Inpayservlet?reqfg=addinpayUI").forward(request, response);
		}
		
	}

//根据入库编号获取入库信息
	private void getselectIn(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String inid=request.getParameter("inId");
		In selectid=inpayser.finallyInid(inid);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//忽略product","indate"属性
		JsonConfig jsonc=new JsonConfig();
		jsonc.setExcludes(new String[]{"product","indate"});
		JSONObject jsonobj=JSONObject.fromObject(selectid,jsonc);
		String jsons = jsonobj.toString();
		out.print(jsons);
		out.close();
		
	}

//处理请求
	private void addinpayUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<In> paylist=inpayser.finallywithBlank();
		request.setAttribute("paylist", paylist);
		request.getRequestDispatcher("/in/addinpayUI.jsp").forward(request, response);
		
	}

}
