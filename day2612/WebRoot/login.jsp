<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	//当当前页面和浏览器父页面不相同时转到当前页window.parent和window都代表浏览器
	//alert(window.parent!=window);
	if (window.parent != window) {
		window.parent.location.href = "${pageContext.request.contextPath}/login.jsp";
	}                	
</script>
</head>
<body>
	<h1>登录</h1>
	${tip }
	<form action="${pageContext.request.contextPath }/Userservlet"
		method="post">
		<table>
			<tr>
				<td><input type="hidden" name="reqfg" value="userlogin">
				</td>
			</tr>
			
			<tr>
				<td>用户名:<input type="text" name="username">
				</td>
			</tr>
			<tr>
				<td>密码:<input type="password" name="userpass">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" >&nbsp;&nbsp; <input
					type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>