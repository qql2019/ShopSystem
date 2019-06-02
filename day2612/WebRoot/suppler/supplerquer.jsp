<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" align="center">
		<tr>
			<td>序号</td>
			<td>商家名</td>
			<td>地址</td>
			<td>电话</td>
			<td>联系人</td>
			<td>联系方式</td>
			<td>邮箱</td>
			<td>QQ</td>
			<td>邮编</td>
			<td>传真</td>
			<td>开户银行</td>
			<td>银行卡号</td>
			<td>备注</td>
		</tr>
		<c:choose>
			<c:when test="${empty supplerlist }">
				<tr>
					<td>暂无此商家</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="sup" items="${supplerlist }" varStatus="var">
					<tr>
						<td>${var.count }</td>
						<td>${sup.supplername}</td>
						<td>${sup.suppleraddr}</td>
						<td>${sup.supplertel}</td>
						<td>${sup.supplerper}</td>
						<td>${sup.supplerphone}</td>
						<td>${sup.supplerEmal}</td>
						<td>${sup.supplerQQ}</td>
						<td>${sup.supplerpost}</td>
						<td>${sup.supplerfax}</td>
						<td>${sup.supplerbank}</td>
						<td>${sup.suppleraccounton}</td>
						<td>${sup.supplermeno}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>