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
<title>新闻类型列表</title>
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/listNewsDetail.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
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
 <style type="text/css">
.div1{
float:left;
margin-left:30px;
}
.div2{
/* float:right; */
margin-right:10px;
margin-top:30px;
}
</style> 
</head>
<body>
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：新闻管理　&gt;&gt;　头条管理　</a>
<div class="div2">
<form name="myform" method="post">
	<tbody>
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>标题</th>
			<th>发布者</th>
				<th>时间</th>
				<th>详情</th>
				<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.topNewsDetailList }"  var="topNews" varStatus="status">
			<tr style="background-color: ${status.index%2==0?'':'#4F4F4F' } ">
				<td>
					${topNews.id }
				</td>
				<td>${topNews.title }</td>
<%-- 				<td><img src="http://localhost:8080/travelnews/${hotelDetail.imgUrl}"  width="104" height="118" border="0""></td> --%>
			
				<td nowrap>${topNews.author }</td>
				<td>${topNews.publishTime }</td>
				<td><a href="topnewsdetailservlet?op=toTopNewsDetail&id=${topNews.id }">详情</a></td>
				<td><a href="topnewsdetailservlet?op=delete&id=${topNews.id }">删除</a></td>
			</tr>
		</c:forEach>
	
	</table>
	</tbody>
	</form>
	</div>
</body>
</html>