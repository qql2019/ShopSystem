<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>当前页面&nbsp;&nbsp;基础信息管理&gt;&gt;商品页面&gt;&gt;</td>
</tr>
</table>
${tip }
<form action="${pageContext.request.contextPath }/Productservlet" method="post">
<table width="80%" align="center">
<tr>
<td><input type="hidden" name="reqfg" value="addproduct"> </td>
</tr>
<tr>
<td>商品编号</td>
<td><input type="text" name="productno" value="${param.productno }"> </td>
<td>商品名称:</td>
<td><input type="text" name="productname" value="${param.productname }">  </td>
</tr>
<tr>
<td>作者：</td>
<td><input type="text" name="productauth" value="${param.productauth }"> </td>
<td>单价；</td>
<td><input type="text" name="price" value="${param.price }"> </td>
</tr>
<tr>
<td>光盘</td>
<td><input type="text" name="diskno" value="${param.diskno }"> </td>
<td>供应商：</td>
<td>
<select name="suppler">
<c:forEach var="sup" items="${selectip }">
<option value="${sup.id }">${sup.supplername }</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>出版日期</td>
<td><input type="text" name="pubdate" value="${param.pubdate }"> </td>
<td>备注</td>
<td>
<textarea rows="" cols="" name="memo">${param.memo }</textarea>
 </td>
</tr>
<tr>
<td colspan="3" align="center">
<input type="submit" value="保存" >&nbsp;&nbsp;
<input type="reset" value="重置">
</td>
</tr>
</table>

</form>
</body>
</html>