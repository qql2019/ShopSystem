<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body >
${tip }
	<table width="100%" align="center">
		<tr>
			<td>序号</td>
			<td >入库编号</td>
			<td>商品</td>
			<td>库单价</td>
			<td>库数量</td>
			<td>商品入库金额</td>
			<td>入库时间</td>
			<td>入库人</td>
			<td>批准人</td>
			<td>欠款</td>
			<td>是否结清</td>
			<td>备注</td>
		</tr>
		<c:choose>
			<c:when test="${empty listin }">
				<tr>
					<td>暂无库存</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="lin" items="${listin }" varStatus="var">
					<tr>
						<td>${var.count }</td>
						<td>${lin.id }</td>
						<td>${lin.product }</td>
						<td>${lin.inprice }</td>
						<td>${lin.innum }</td>
						<td>${lin.inmeny }</td>
						<td>${lin.indate }</td>
						<td>${lin.persnon }</td>
						<td>${lin.inallperson }</td>
						<td>${lin.balance }</td>
						<td>${lin.closeaccount }</td>
						<td>${lin.memo }</td>
					</tr>

				</c:forEach>

			</c:otherwise>
		</c:choose>

	</table>
</body>
</html>