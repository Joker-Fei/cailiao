<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'en_MENBERS_show.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
    	function doadd(){
    		window.location.href="${pageContext.request.contextPath }/jsp/Backstage/en_bs_MENBERS_add.jsp";
    	}
    </script>
</head>

<body bgcolor="#afb4db">
	<div  style="visibility: visible; width:100%; height:580px; overflow-y:scroll;">
		<%@ page import= "com.EN.entity.*"%>
		<%@ page import= "java.util.List" %>
		<%
		List<menbers> lsmen = (List<menbers>)request.getAttribute("lsmen");
		if(lsmen!=null){
		for(menbers i:lsmen){%>
		<a style="text-decoration:none" href="${pageContext.request.contextPath}/servlet/menShowServlet?id=<%=i.getId()%>" target="mainFrame">
			<table border="1" width="100%">
				<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/<%=i.getMbPhoto()%>"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong><%=i.getMbName() %></strong></td>
				<td width="150px"><strong>[<%=i.getMbClass() %>]</strong></td>
				<td width="500px"><strong>[<%=i.getMbDepartment() %>]</strong></td>
				</tr>
				<tr>
				<td colspan="3" >
					<div style="width:100%; height:130px; overflow:hidden;">
						<%=i.getMbIntroduce() %>
					</div>
				</td>
				
				</tr>
				</table>
			</a>
	<% }} %>
	</div>
</body>
</html>
