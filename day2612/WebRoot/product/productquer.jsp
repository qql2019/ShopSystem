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
			<td>编号</td>
			<td>书名</td>
			<td>作者</td>
			<td>单价</td>
			<td>光盘数量</td>
			<td>供应商</td>
			<td>出版日期</td>
			<td>备注</td>
		</tr>
	
			<c:choose>
				<c:when test="${empty plist }">
				<tr>
						<td >暂无商品</td>
						</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="pro" items="${ plist}" varStatus="var">
						<tr>
						<td>${var.count }</td>
						<td>${pro.productno }</td>
						<td>${pro.productname }</td>
						<td>${pro.productauth }</td>
						<td>${pro.price }</td>
						<td>${pro.diskno }</td>
						<td>${pro.suppler.supplername }</td>
						<td>${pro.pubdate }</td>
						<td>${pro.memo }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		
	</table>
</body>
</html>