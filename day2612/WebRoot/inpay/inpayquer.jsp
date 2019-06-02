<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function  slectinpay(val){
	document.forms[0].reqfg.value=val;
	document.forms[0].submit();
}
</script>
</head>
<body>
<table>
		<tr>
			<td>&nbsp;&nbsp;当前位置&gt;&gt;基础信息管理&gt;&gt;商品入库结账查询&gt;&gt;</td>
		</tr>
	</table>
	<form action="${pageContext.request.contextPath }/Inpayservlet" method="post" target="bottom">
	<table width="80%">
	<tr>
	<td><input type="hidden" name="reqfg" value="finallyinpaylike"> </td>
	</tr>
	<tr>
	<td>
	<select name="selectinpay">
	<option value="productname">商品名</option>
	<option value="suppleyname">供应商</option>
	<option value="paydate">付款时间</option>
	</select>
	<input type="text" name="inpaytext">&nbsp;&nbsp;
	<input type="button" value="查询" onclick="slectinpay('finallyinpaylike')">&nbsp;&nbsp;
	<input type="button" value="查询全部"  onclick="slectinpay('finallyinpay')">
	</td>
	</tr>
	
	</table>
	
	
	</form>
</body>
</html>