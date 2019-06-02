<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var inid=$("select[name='inId']").val();
		chan(inid);

	});
	function chan(inid){
		//alert(inid);
		$.ajax({
			"url":"${pageContext.request.contextPath}/Inpayservlet",
			"data":"reqfg=getselectIn&inId="+inid,
			"type":"post",
			"dataType":"json",
			"success":function(resText){
				$("input[name='inmoney']").val(resText.balance);
				$("input[name='supplername']").val(resText.supplername);
				$("input[name='paymoney']").val(resText.balance);
				$("input[name='inmentid']").val(resText.balance);
			},"error":function(){
				alert("服务器错误");
			}
		});
	}
	function setpaymoney(money){
		var inmentid=$("input[name='inmentid']").val();
		inmentid=window.parseFloat(inmentid);
		money=window.parseFloat(money);
		if(money>inmentid){
			alert("付款价不能比应付还高");
			$("input[name='paymoney']").val(money);
		}
		if(money<=0){
			alert("价格太错了");
			$("input[name='paymoney']").val(inmentid);
		}
		$("input[name='balance']").val(inmentid-money);
	}
</script>
</head>
<body>
<table>
	<tr>
		<td>当前位置&nbsp;&nbsp;库存信息管理&gt;&gt;入库付款管理&gt;&gt;</td>
	</tr>
</table>
<form action="${pageContext.request.contextPath }/Inpayservlet"
	method="post">
	<table width="80%" align="center">
		<tr><td>请输入编号:</td>
			<td><select name="inId" onchange="chan(this.value)">
					<c:forEach var="in" items="${paylist }">
						<option value="${in.id }">${in.id }</option>
					</c:forEach>
			</select>
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="4"><input type="hidden" name="reqfg" value="addinpay">
				<input type="hidden" name="inmentid"></td>
		</tr>
		<tr>
			<td>应付款；</td>
			<td><input type="text" name="inmoney" value="${param.inmoney }"
				readonly="readonly"></td>
			<td>本次付款:</td>
			<td><input type="text" name="paymoney"
				value="${param.paymoney }" onblur="setpaymoney(this.value)">
			</td>
		</tr>

		<tr>
			<td>供应商:</td>
			<td><input type="text" name="supplername"
				readonly="readonly"></td>
			<td>剩余款:</td>
			<td><input type="text" name="balance" value="${param.balance }"
				readonly="readonly"></td>
		</tr>
		<tr>
			<td>操作员；</td>
			<td><input type="text" name="operator" value="${user.username }"
				readonly="readonly"></td>
			<td>批准人:</td>
			<td><input type="text" name="allwebpersion"
				value="${param.allwebpersion }"></td>
		</tr>

		<tr>
			<td>备注:</td>
			<td><textarea rows="" cols="" name="memo"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><input type="submit" value="提交">
				<input type="reset" value="重置"></td>
		</tr>
	</table>

</form>
</body>
</html>