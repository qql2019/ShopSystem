<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function clk(val) {
		document.forms[0].reqfg.value = val;
		document.forms[0].submit();
	}
function fou(){
	
}
</script>
</head>
<body>
	<table>
		<tr>
			<td>&nbsp;&nbsp;当前位置&gt;&gt;基础信息管理&gt;&gt;商品入库查询&gt;&gt;</td>
		</tr>
	</table>
	<form action="${pageContext.request.contextPath }/Inservlet" method="post" target="bottomm">
		<table width="80%">
			<tr>
				<td><input type="hidden" name="reqfg" value="finallyInlike"></td>
			</tr>
			<tr>
				<td><select name="inselect">
						<option value="tb_product.id">编号</option>
						<option value="productname">商品名</option>
						<option value="indate">入库日期</option>
				</select> <input type="text" name="intext" value="${listin }" onfocus="fou()" >&nbsp;&nbsp; <input
					type="button" value="查询" onclick="clk('finallyInlike')">&nbsp;&nbsp;
					<input type="button" value="查询所有" onclick="clk('finallyIn')">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>