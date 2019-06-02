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

import com.cissst.bysales.daomain.Customer;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.daomain.Sell;
import com.cissst.bysales.service.Customerserver;
import com.cissst.bysales.service.Sellserver;
import com.cissst.bysales.service.impl.Customerserverimpl;
import com.cissst.bysales.service.impl.Sellserverimpl;
import com.cissst.bysales.utils.ConverUtils;
import com.cissst.bysales.utils.StringUtils;

public class Sellservlet extends HttpServlet {
private Sellserver serv=new Sellserverimpl();
	private Customerserver cust=new Customerserverimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String meter = request.getParameter("reqfg");
		if("addsell".equals(meter)){
			addsell(request,response);
		}else if("getsellpro".equals(meter)){
			getsellpro(request,response);
		}else if("addsellUI".equals(meter)){
			addsellUI(request,response);
		}
	}


	private void addsellUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			List<Save> finallist = serv.finallsaveproduct();
			request.setAttribute("sellproduct", finallist);
			List<Customer> finallcust = cust.finallcust();
			request.setAttribute("sellcoustome", finallcust);
			request.getRequestDispatcher("/sell/addsell.jsp").forward(request, response);
		
	}


	private void getsellpro(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String idstr = request.getParameter("productId");
		int id = Integer.parseInt(idstr);
		Save byPK = serv.finallsaveproductByPK(id);
		JsonConfig config=new JsonConfig();
		config.setExcludes(new String[]{"product"});
		JSONObject object = JSONObject.fromObject(byPK,config);
		out.print(object.toString());
		out.close();
	}


	private void addsell(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String parameter = request.getParameter("selectproductId");
		int selectproductId = Integer.parseInt(parameter);
		String selectcustomestr = request.getParameter("selectcustome");
			int selectcustome = Integer.parseInt(selectcustomestr);
			String  productPricestr= request.getParameter("productPrice");
			double productPrice = Double.parseDouble(productPricestr);
			String productnumstr = request.getParameter("productnum");
			int productnum = Integer.parseInt(productnumstr);
			String productmoneystr = request.getParameter("productmoney");
			double productmoney = Double.parseDouble(productmoneystr);
			String operator = request.getParameter("operator");
			String allwebperson = request.getParameter("allwebperson");
			String memo = request.getParameter("memo");
			//获取销售商品最大id
			String maxId = serv.finMaxId();
			//生成一个销售id
			String nextString = StringUtils.finallyNextString(maxId);
			java.sql.Date selldate = ConverUtils.forutilDatemstring(new Date());
			Sell sell=new Sell(nextString,productPrice,productnum,productmoney,selldate,
					operator,allwebperson,memo,productmoney,"否");
			Product pro=new Product();
			pro.setId(selectproductId);
			Customer cus=new Customer();
			cus.setId(selectcustome);
			sell.setProduct(pro);
			sell.setCustomer(cus);
			int row = serv.addsell(sell);
			if(row>0){
			
			out.print("<script>alert(\"销售成功\");window.location.href=\""
							+ request.getContextPath()
							+ "/Sellservlet?reqfg=addsellUI\"</script>");
				} else {
					request.setAttribute("tip", "录入失败");
					request.getRequestDispatcher("/Sellservlet?reqfg=addsellUI").forward(
							request, response);
				}
			
			
			
			
			
			
			
	}

}
