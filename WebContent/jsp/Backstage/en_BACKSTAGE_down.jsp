<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'en_BACKSTAGE_down.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <frameset name="frame1" rows="*" cols="200,*" border="" bordercolor="" framespacing="0">
  		<frame src="${pageContext.request.contextPath }/jsp/Backstage/en_BACKSTAGE_right.jsp" name="houtai_liftFrame" scrolling="no" noresize>
  		<frame src="" name="houtai_rightFrame" scrolling="no" noresize>
  	</frameset> 
</html>
