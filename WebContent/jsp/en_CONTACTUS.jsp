<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>My JSP 'en_CONTACTUS.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div style=" width:100%; height:600px; overflow-y:scroll; visibility: visible;">
		<table align="center" border="0" width="60%" height="1000px" cellpadding="0" cellspacing="0" >
    		<tr>
    			<td colspan="2" height="40px">&nbsp;</td>
    		</tr>
    		<tr>
    			<td valign="top">${Contactus}</td>
   		</table>
   	</div>
    
  </body>
</html>
