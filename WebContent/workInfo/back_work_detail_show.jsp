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
<link href="./images/yuanhui.png" rel="shortcut icon"/>
<title>详情</title>
<script src="ckeditor/ckeditor.js"></script>
<script src="ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
margin-left:100px;
Margin-bottom:0px;
}
table td
{
word-break: keep-all;
white-space:nowrap;
}</style>
</head>
<body>
<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：信息管理　&gt;&gt;　信息详情　</a>
<div class="div1">
<form action="newsdetailservlet?op=update" method="post">
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<td><a>标题</a></td>
			<td>
				<%-- <input type="hidden" name="id" value="${requestScope.workDetail.id }"/> --%>
				
				<%-- <input style="width:300px;height:25px" type="text" name="title" value="${requestScope.workDetail.title }"/> --%>
				<a>${requestScope.workDetail.title }</a>
			</td>
		</tr>
		<tr>
			<td><a>作者</a></td>
			<td><a>${sessionScope.loginUser.userName }</a></td>
		</tr>
		<tr>
			<td><a>类型</a></td>
			<td>
				<select name="typeId">
					<c:forEach items="${requestScope.workTypeList }" var="newsType">
						<option value="${newsType.id }" ${newsType.id==requestScope.newsDetail.typeId?"selected='selected'":"" }>${newsType.typeName }</option>	
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><a>时间</a></td>
			<td><input type="text" name="publishTime" onClick="WdatePicker()" class="Wdate" value="${requestScope.newsDetail.publishTime }"/></td>
		</tr>
		 <%-- <tr>
			<td>状态</td>
			<td>
				<input type="radio" name="pass" value="${requestScope.workDetail.pass  }" checked="checked"/>未通过
				<input type="radio" name="pass" value="${requestScope.newsDetail.pass }"/>通过
			</td>
			<td></td>
		</tr>  --%>
		<tr>
			 
			<td colspan="2">
				<textarea rows="10" cols="20" name="content">${requestScope.workDetail.content }</textarea>
				<script type="text/javascript">
			    	var editor =CKEDITOR.replace('content', {
						uiColor: '#14B8C4'
					});
			    	CKFinder.setupCKEditor( editor, 'ckfinder/' ) ;
			    </script>
			</td>
		</tr>
		<!-- <tr>
			<td colspan="2">
				<input type="submit" value="修改新闻"/>
			</td>
		</tr> -->
	</table>
</form>
</div>
</body>
</html>