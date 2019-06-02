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
	$(function(){
		var pid=$("select[name='selectproductId']").val();
		chprodu(pid);
		
	});
	function chprodu(pid){
		$.ajax({
			"url":"${pageContext.request.contextPath}/Sellservlet",
			"data":"reqfg=getsellpro&productId="+pid,
			"type":"post",
			"dataType":"json",
			"success":function(resText){
				$("input[name='productPrice']").val(resText.productprice);
				$("input[name='oldprice']").val(resText.productprice);
				$("input[name='sellnum']").val(resText.productnum);
				$("input[name='productnum']").val(resText.productnum);
				var price=$("input[name='oldprice']").val();
				var num=$("input[name='sellnum']").val();
				$("input[name='productmoney']").val(price*num);
			},"error":function(){
				alert("服务器忙");
			}
			
		});
		
	}
	function pricemoney(price){
		var oldprice=$("input[name='oldprice']").val();
		 oldprice=window.parseFloat(oldprice);
		 price=window.parseFloat(price);
		if(price<oldprice){
			alert("不可以比库存价还低");
			$("input[name='productPrice']").val(oldprice);
			return;
		}
	}
	function produnum(num){
		var sellnum=$("input[name='sellnum']").val();
		sellnum=window.parseInt(sellnum);
		num=window.parseInt(num);
		if(num>sellnum){
			alert("超出库存数量");
			return;
		}
		var price=$("input[name='productPrice']").val();
		var money=num*price;
		$("input[name='productmoney']").val(money);
	}
	</script>
</head>
<body>
${tip }
	<table>
		<tr>
			<td>&nbsp;当前位置&gt;&gt;销售信息管理&gt;&gt;销售管理&gt;&gt;</td>

		</tr>
	</table>
	<form action="${pageContext.request.contextPath}/Sellservlet" method="post">
		<table>
			<tr>
				<td>请选择销售商品:</td>
				<td><select name="selectproductId"
					onchange="chprodu(this.value)">
						<c:forEach var="sell" items="${sellproduct }">
					<option value="${sell.product.id }">${sell.product.productname}
								</option>
						</c:forEach>
				</select>
				</td>
				<td>请选择客户:</td>
				<td><select name="selectcustome">
						<c:forEach var="sellct" items="${sellcoustome }">
							<option value="${sellct.id }">${sellct.custname }</option>

						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="reqfg" value="addsell">
					<input type="hidden" name="oldprice"> 
					<input type="hidden"  name="sellnum"></td>
			</tr>
			<tr>
				<td>单价：</td>
				<td><input type="text" name="productPrice"
					value="${pram.productPrice }" onblur="pricemoney(this.value)">
				</td>
				<td>数量：</td>
				<td><input type="text" name="productnum"
					value="${pram.productnum }" onblur="produnum(this.value)">
				</td>
			</tr>
			<tr>
				<td>金额:</td>
				<td><input type="text" name="productmoney"
					value="${pram.productmoney }" readonly="readonly"></td>
				<td>操作员:</td>
				<td><input type="text" name="operator"
					value="${user.username }"></td>
			</tr>
			<tr>
				<td>批准人:</td>
				<td><input type="text" name="allwebperson"
					value="${pram.allwebperson }"></td>
				<td>备注:</td>
				<td><textarea rows="" cols="" name="memo"></textarea></td>
			</tr>
			<tr>
			<td rowspan="2" >
			<input type="submit" value="保存">&nbsp;&nbsp;
			<input type="reset" value="重置">
			
			</td>
			</tr>
		</table>
	</form>
</body>
</html>