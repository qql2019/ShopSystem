<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function ch(val) {
		document.forms[0].reqfg.value = val;
		document.forms[0].submit();
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>&nbsp;&nbsp;当前位置&gt;&gt;基础信息管理&gt;&gt;客户查询 &gt;&gt;</td>

		</tr>
	</table>
	<form action="${pageContext.request.contextPath }/Customerservlet"
		method="post" target="countshow">
		<table width="80%">
			<tr>
				<td><input type="hidden" name="reqfg" value="finacustlike"></td>
			</tr>
			<tr>
				<td>客户查询&nbsp;&nbsp;<input type="text" name="custName">&nbsp;&nbsp;<input
					type="button" value="查询" onclick="ch('finacustlike')">
					&nbsp;&nbsp;<input type="button" value="查询所有"
					onclick="ch('finallcust')">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>