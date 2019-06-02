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
	<table width="100%" align="center">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>住址</td>
			<td>联系人</td>
			<td>联系人电话</td>
			<td>传真</td>
			<td>邮箱</td>
			<td>QQ</td>
			<td>开户银行</td>
			<td>开户账户</td>
			<td>邮编</td>
			<td>备注</td>
		</tr>
		<c:choose>
			<c:when test="${empty cuslist }">
				<tr>
					<td>暂无信息
					<td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="cut" items="${cuslist }" varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${cut.custname }</td>
						<td>${cut.custattr }</td>
						<td>${cut.custtel }</td>
						<td>${cut.custpersion }</td>
						<td>${cut.custpertel }</td>
						<td>${cut.custfax }</td>
						<td>${cut.custemail }</td>
						<td>${cut.custQQ }</td>
						<td>${cut.custbank }</td>
						<td>${cut.custaccountno }</td>
						<td>${cut.custmeno }</td>
						<td>${cut.custpostcod }</td>
					</tr>
				</c:forEach>

			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>