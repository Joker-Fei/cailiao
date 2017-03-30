<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 这个语句是用来拼装当前网页的相对路径的。 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- <base href="...">是用来表明当前页面的相对路径所使用的根路径的。 -->
<base href="<%=basePath %>" />
