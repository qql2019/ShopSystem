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
			<td>库存编号</td>
			<td>商品名</td>
			<td>库存数量</td>
			<td>库存单价</td>
			<td>库存总价</td>
			<td>备注</td>
		</tr>
		<c:choose>
			<c:when test="${empty listsave }">
				<tr>
					<td>暂无商品</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="sa" items="${listsave}" varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${sa.id }</td>
						<td>${sa.product }</td>
						<td>${sa.productnum }</td>
						<td>${sa.productprice }</td>
						<td>${sa.productmoney }</td>
						<td>${sa.memo }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>