<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" Src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
//获取入库商品
$(function(){
	var pid=$("select[name='selectname']").val();
	chan(pid);
});
//局部刷新  出版社  商品名  单价
function chan(pid){
	$.ajax({
		"url":"${pageContext.request.contextPath}/Inservlet",
		"data":"reqfg=getservletid&productId="+pid,
		"type":"post",
		"dataType":"json",
		"success":function(reText){
		//此处val的值必须和实体类一致
			$("input[name='inprice']").val(reText.price);
			$("input[name='oldprice']").val(reText.price);
			$("input[name='supplername']").val(reText.supplernamestr);
		},"error":function(){
			alert("服务器忙");
		}
		
	});
}
//修改书价格，判断
function chprice(price){
	var oldprice=$("input[name='oldprice']").val();
	//转译价格为小数型
	var oldprice=window.parseFloat(oldprice);
	var price=window.parseFloat(price);
	if(price>oldprice){
		alert("进价不能比原价高");
		$("input[name='inprice']").val(oldprice);
		return;
	}
	if(price<=0){
		alert("这书不是免费的");
		$("input[name='inprice']").val(oldprice);
	}
}
//计算总价
function chnum(num){
	var price=$("input[name='inprice']").val();
	var meny=price*num;
	$("input[name='inmeny']").val(meny);
}
</script>
</head>
<body>
${tip }
	<table>
		<tr>
			<td>当前位置&nbsp;&nbsp;库存信息管理&gt;&gt;仓库信息管理&gt;&gt;</td>
		</tr>
	</table>
	${tip }
	<form action="${pageContext.request.contextPath }/Inservlet"
		method="post">
		<table width="80%" align="center">
			<tr>
				<td>请选择入库商品&nbsp;&nbsp; </td><td><select name="selectname"
					onchange="chan(this.value)">
						<c:forEach var="pro" items="${selectproduct }">
							<option value="${pro.id }">${pro.productname }</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="reqfg" value="addIn">
				<input type="hidden" name="oldprice"><%--存取页面中原有的价格 --%>
				</td>
			</tr>
			<tr>
				<td>单价：</td>
				<td><input type="text" name="inprice" value="${param.inprice }" onchange="chprice(this.value)">
				</td>
				<td>数量:</td>
				<td><input type="text" name="innum" value="${param.innum }" onchange="chnum(this.value)"
					></td>
			</tr>
			<tr>
				<td>供应商:</td>
				<td><input type="text" name="supplername" ></td>
				<td>金额:</td>
				<td><input type="text" name="inmeny" value="${param.inmeny }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>入库人:</td>
				<td><input type="text" name="persnon" value="${user.username }"
					readonly="readonly"></td>
				<td>批准人:</td>
				<td><input type="text" name="inallperson"
					value="${param.inallperson }"></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><textarea rows="" cols="" name="memo">${param.memo }</textarea><br>
				</td>
			</tr><br>
			<tr>
				<td colspan="2"  align="center"><input type="submit" value="保存">&nbsp;&nbsp;
					<input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>