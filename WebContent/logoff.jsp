 <!--    注销页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注销页面</title>
</head>
<body>
<%
if(session.getAttribute("loginUser")!=null)//判断用户名是不是为空
{
session.removeAttribute("loginUser");//注销
}

out.println("<script>alert('您已成功注销登录！');this.location.href='toFirstWeb.jsp';</script>");//回到首页
%> 
</body>
</html>