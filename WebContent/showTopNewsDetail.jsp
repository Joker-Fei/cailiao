<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/xheditor-1.2.2.min.js"></script>
<script type="text/javascript" src="js/xheditor_lang/zh-cn.js"></script>


<style type="text/css">
	body{
		background-image: url("images/bg_newsDetailList1.jpg");
		background-position:-100px -300px;
	}
	.enableStyle{
		background-color: ;
		color:black;
	}
	.disableStyle{
		background-color: red;
		color: white;
	}
</style>
<style type ="text/css"> 
 
a {font-size:14px;
text-decoration:none;
color:white;
/* font-weight:bold; */
} 
</style>
<style type="text/css">
.div1{
/* float:left; */
margin-left:200px;
Margin-bottom:0px;
}
table td
{
word-break: keep-all;
white-space:nowrap;
}</style>
</head>
<body>
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：新闻管理　&gt;&gt;　头条详情　</a>
<form name="myform" method="post" >
	<div class="div1">
				<table width="100%"  border="0px" cellpadding="0" align="center" cellspacing="0">

		<%-- <c:forEach items="${requestScope.topNewsDetail }"  var="topNews" varStatus="status"> --%>

				<td>
				</td>
				<td><img src="./${requestScope.topNewsDetail.imgUrl}"  width="400" height="200" border="0"></td>
			</tr>
			<tr>
				<td><a>标题</a></td>

				<td>${requestScope.topNewsDetail.title }</td>
				
			</tr>
			<tr>
				<td><a>发布者</a></td>
				<td>${requestScope.topNewsDetail.author }</td>
			</tr>
			
			<tr>
				<td><a>内容</a></td>
				<td><textarea class="xheditor" rows="10" cols="70" name="content">${requestScope.topNewsDetail.content }</textarea></td>
			</tr>

			<tr>
				<td><a>发布时间</a></td>
				<td>${requestScope.topNewsDetail.publishTime }</td>
			</tr>
	
		<tr>
			<td colspan="4" >
			<td><a href="topnewsdetailservlet?op=delete&id=${requestScope.topNewsDetail.id }">删除</a></td>
			</td>
		</tr>
	</table>
	</div>
</form>
</body>
</html>