<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
<frameset rows="10%,*" framespacing="0">
	<frame name="top"
		src="${pageContext.request.contextPath }/index/top.jsp"
		frameborder="1">
	<frameset cols="13%,*" frameborder="yes" framespacing="0">
		<frame name="left"
			src="${pageContext.request.contextPath }/index/left.jsp"
			frameborder="1">
		<frame name="right" frameborder="1">
	</frameset>
</frameset>
<body>
  </body>
</html>
