<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var inId = $("select[name='selectInId']").val();
		seleIn(inId);
	});

	function seleIn(inId) {
		$.ajax({
			"url" : "${pageContext.request.contextPath}/Rkthservlet",
			"data" : "reqfg=getInid&inId=" + inId,
			"type" : "post",
			"dataType" : "json",
			"success" : function(resText) {
				$("input[name='productprice']").val(resText.inprice);
				$("input[name='productnum']").val(resText.innum);
				$("input[name='oldnum']").val(resText.innum);
				$("input[name='productmoney']").val(resText.inmeny);
				$("input[name='productname']").val(resText.productname);
				$("input[name='supplername']").val(resText.supplername);

			},
			"error" : function() {
				alert("服务器错误");
			}
		});
	}
	function pronum(num) {
		var oldnum = $("input[ name='oldnum']").val();
		oldnum = window.parseInt(oldnum);
		num = window.parseInt(num);
		if (num > oldnum) {
			alert("数量不能高于入库数量");
			$("input[name='productnum']").val(oldnum);
			return;
		}
		var price = $("input[name='productprice']").val();
		var money = num * price;
		$("input[name='productmoney']").val(money);
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>当前页面&nbsp;&nbsp;库存信息管理&gt;&gt;入库退货页面&gt;&gt;</td>
		</tr>
	</table>
	<form action="${pageContext.request.contextPath }/Rkthservlet"
		method="post">
		<table width="80%">
			<tr>
				<td>请选择入库编号</td>
				<td><select name="selectInId" onchange="seleIn(this.value)">
						<c:forEach var="in" items="${selectin }">
							<option value="${in.id }">${in.id }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="hidden" name="reqfg" value="addRkth">
				</td>
				<td><input type="hidden" name="oldnum"></td>
			</tr>

			<tr>
				<td>商品:</td>
				<td><input type="text" name="productname"
					value="${param.productname }" readonly="readonly"></td>
				<td>供应商:</td>
				<td><input type="text" name="supplername"
					value="${param.supplername }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>单价:</td>
				<td><input type="text" name="productprice"
					value="${param.productprice }" readonly="readonly"></td>
				<td>数量:</td>
				<td><input type="text" name="productnum"
					value="${param.productnum }" onblur="pronum(this.value)"></td>
			</tr>
			<tr>
				<td>操作员:</td>
				<td><input type="text" name="operator"
					value="${user.username }" readonly="readonly"></td>
				<td>批准人:</td>
				<td><input type="text" name="allowebperson"
					value="${param.allowebperson }"></td>
			</tr>
			<tr>
				<td>金额:</td>
				<td><input type="text" name="productmoney"
					value="${param.productmoney }" readonly="readonly"></td>
				<td>备注:</td>
				<td><textarea rows="" cols="" name="memo"></textarea></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="保存"> <input
					type="reset" value="重置"></td>
			</tr>
		</table>

	</form>
</body>
</html>