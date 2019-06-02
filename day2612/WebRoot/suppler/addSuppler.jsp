<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<table>
		<tr>
			<td>当前位置&nbsp;&nbsp;基础信息管理&gt;&gt;供应商信息管理&gt;&gt;</td>
		</tr>
	</table>
	${tip }
	<form action="${pageContext.request.contextPath }/Supplerservlet"
		method="post">
		<table width="70%" align="center">
			<tr>
				<td><input type="hidden" name="reqfg" value="addSuppler">
				</td>
			</tr>
			<tr>
				<td>供应商名称:</td>
				<td><input type="text" name="supplername"
					value="${param.supplername }"></td>

				<td>地址:</td>
				<td><input type="text" name="suppleraddr"
					value="${param.suppleraddr }"></td>
			</tr>
			<tr>
				<td>电话:</td>
				<td><input type="text" name="supplertel"
					value="${param.supplertel }"></td>

				<td>联系人:</td>
				<td><input type="text" name="supplerper"
					value="${param.supplerper }"></td>
			</tr>
			<tr>
				<td>联系人方式:</td>
				<td><input type="text" name="supplerphone"
					value="${param.supplerphone }"></td>
				<td>邮箱:</td>
				<td><input type="text" name="supplerEmal"
					value="${param.supplerEmal }"></td>


			</tr>
			<tr>
				<td>QQ:</td>
				<td><input type="text" name="supplerQQ"
					value="${param.supplerQQ }"></td>
				<td>邮编:</td>
				<td><input type="text" name="supplerpost"
					value="${param.supplerpost }"></td>


			</tr>
			<tr>
				<td>传真:</td>
				<td><input type="text" name="supplerfax"
					value="${param.supplerfax }"></td>
				<td>开户银行:</td>
				<td><input type="text" name="supplerbank"
					value="${param.supplerbank }"></td>


			</tr>
			<tr>
				<td>银行卡号:</td>
				<td><input type="text" name="suppleraccounton"
					value="${param.suppleraccounton }"></td>
				<td>备注:</td>
				<td><textarea rows="" cols="" name="supplermeno">${param.supplermeno }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="保存">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="重置"></td>
			</tr>
		</table>

	</form>
</body>
</html>