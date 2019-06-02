<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
a:LINK {
	text-decoration: none;
}
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>

</head>
<body>
<div id="aa" class="easyui-accordion" style="width:300px;height:200px;" fit="true">  
    <div title="基础信息管理" data-options="iconCls:'icon-save'" style="overflow:auto;padding:30px;"> 
           <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/customer/addCustomer.jsp" target="right">客户信息管理</a></h3>
       <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/customer/countper.jsp" target="right">客户信息查询</a></h3>
       <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/Productservlet?reqfg=addproductUI" target="right">商品信息管理</a></h3>
       <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/product/productrest.jsp" target="right">商品信息查询</a></h3>
    <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/suppler/addSuppler.jsp" target="right">供应商信息管理</a></h3> 
        <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/suppler/selectsupplerper.jsp" target="right">供应商信息查询</a></h3>  

    </div>  
    <div title="库存信息管理 " data-options="iconCls:'icon-reload',selected:true" style="padding:30px;">  
      <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/Inservlet?reqfg=addInUI" target="right">入库管理</a></h3>
        <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/Inpayservlet?reqfg=addinpayUI" target="right">入库结账</a></h3>
       <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/in/inper.jsp" target="right">入库查询</a></h3>
       <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/save/saveper.jsp" target="right">库存查询</a></h3>
       <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/inpay/inpayper.jsp" target="right">入结账信息查询</a></h3>
       
       <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/Rkthservlet?reqfg=addRkthUI" target="right">入库退货</a></h3>
       
       
    </div>  
    <div title="销售信息管理" data-options="iconCls:'icon-reload',selected:true" style="padding:30px;">  
    <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/Sellservlet?reqfg=addsellUI" target="right">商品销售</a></h3>
       <h3 style="color:#0099FF;"><a href="${pageContext.request.contextPath }/"target="right">销售查询</a></h3>
    </div>  
</div>  
</body>
</html>