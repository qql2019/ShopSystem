<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="100%">
		<tr>
			<td>序号</td>
			<td>订单号</td>
			<td>商品名</td>
			<td>供应商</td>
			<td>本次付款</td>
			<td>欠款</td>
			<td>付款时间</td>
			<td>操作员</td>
			<td>审批人</td>
			<td>应付</td>
			<td>备注</td>
		</tr>
		<c:choose>
			<c:when test="${empty listinpay }">
				<tr>
					<td>暂无商品</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="inp" items="${listinpay }" varStatus="var">
					<tr>
						<td>${var.count }</td>
						<td>${inp.id }</td>
						<td>${inp.product }</td>
						<td>${inp.suppleyname }</td>
						<td>${inp.paymoney }</td>
						<td>${inp.balance }</td>
						<td>${inp.paydate }</td>
						<td>${inp.operator }</td>
						<td>${inp.allwebpersion }</td>
						<td>${inp.inmoney }</td>
						<td>${inp.memo }</td>

					</tr>

				</c:forEach>

			</c:otherwise>
		</c:choose>

	</table>
</body>
</html>