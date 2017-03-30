<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'en_home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
.STYLE1 { /* */
	letter-spacing: 0px; /* 字间距 */
	word-spacing: 1px; /* 词间距 */
	line-height: 1px; /* 行高 */
	font-family: "Forte"; /* 字体 */
	font-weight: 900; /* 字体粗细 */
	font-size: 90px; /* 字体大小 */
	text-transform: uppercase; /*转大写 */
	color: #d71345;
}

.STYLE2 { /* */
	letter-spacing: -0px; /* 字间距 */
	word-spacing: 2px; /* 词间距 */
	line-height: 1px; /* 行高 */
	font-family: "Birch Std"; /* 字体 */
	font-weight: 900; /* 字体粗细 */
	font-size: 50px; /* 字体大小 */
	text-transform: uppercase; /*转大写 */
	color: #694d9f;
}

.STYLE3 { /* */
	letter-spacing: -0px; /* 字间距 */
	word-spacing: 2px; /* 词间距 */
	line-height: 1px; /* 行高 */
	font-family: "Birch Std"; /* 字体 */
	font-weight: 900; /* 字体粗细 */
	font-size: 30px; /* 字体大小 */
	text-transform: uppercase; /*转大写 */
	color: #181d4b;
}


div img{
	width: 180px;
	height: 180px;
	
	transition: 0.7s;
	-moz-transition:  0.7s; /* Firefox 4 */
	-webkit-transition:  0.7s; /* Safari and Chrome */
	-o-transition:  0.7s; /* Opera */
}
div img:hover
{
	width:220px;
	height: 220px;
	
}
</style>
  </head>
  
  <body>
  <table align="center" border="0" cellpadding="0" cellspacing="0" >
  	<tr>
    	<td colspan="4" align="center" height="180" width="1202">
	  		<p class = "STYLE1">Welcome<br></p>
	  	</td>
	</tr>
	<tr height="290" width="1202">
    	<td class="" align="center">
    		<div>
				<a style="text-decoration:none" href="http://202.118.192.149/hrb-lgdx-en/" target="_blank">
				<img src="${pageContext.request.contextPath}/images/xiaohui.png" ><br>
				<p class = "STYLE3">SCHOOL HOME</p>
				</a>
			</div>
		</td >
		<td class="" align="center">
			<div>
			<a style="text-decoration:none" href="${pageContext.request.contextPath }/servlet/intrFindServlet?web_type=web">
				<img src="${pageContext.request.contextPath}/images/cailiao_yuanhui.png" ><br>
				<p class = "STYLE3">INTRODUCTION</p>
			</a>
			<div>
		</td>
		<td class="" align="center">
			<div>
			<a style="text-decoration:none" href="./jsp/en_MEMBERS.jsp">
				<img src="${pageContext.request.contextPath}/images/MEMBERS.png"><br>
				<p class = "STYLE3">MEMBERS</p>
			</a>
			<div>
		</td>
		<td class="" align="center"> 
			<div>
			<a style="text-decoration:none" href="${pageContext.request.contextPath }/servlet/dmFindAllServlet?web_type=web" target="mainFrame">
				<img src="${pageContext.request.contextPath}/images/zhulou_2.png"><br>
				<p class = "STYLE3">DEPARTMENTS</p>
			</a>
			<div>
		</td>
	</tr>
	<tr>
    	<td colspan="4" align="center" height="" width="">
	  		<p class = "STYLE2">Shortcut<img src="${pageContext.request.contextPath}/images/jiantou_1.png" height="61.8" width="48.4"><br></p>
	  	</td>
	</tr>
	</table>
	
  </body>
</html>
