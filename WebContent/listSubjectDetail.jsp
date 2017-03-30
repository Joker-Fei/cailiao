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
<title>类型列表</title>
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
<script type="text/javascript">
function checkSelected(){
	var flag=false;
	var ids=document.getElementsByName("ids");
	for(var i=0;i<ids.length;i++){
		if(ids[i].checked){
			flag=true;
			break;
		}
	}
	if(!flag){
		alert("请选择需要删除的数据！");
	}else{
		if(confirm("确定要删除选中的数据吗？")){
			document.myform.submit();
		}
	}
}
function clearForm(){
	document.getElementById("title").value="";
	document.getElementById("content").value="";
	/* document.getElementById("typeId").value="-1"; */
	document.getElementById("topper").value="-1";
	document.getElementById("bold").value="-1";
	document.getElementById("color").value="-1";
	document.searchForm.submit();
}
</script>
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
.div3{
Margin-top:;
Margin-right:;
Margin-bottom:;
Margin-left:;
}
</style> 
</head>
 <div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：学科介绍　&gt;&gt;　信息列表　</a> 
<body>
<div class="div3">
<div class="div1">
<%-- <form name="searchForm" action="subjectdetailservlet?op=search" method="post">
	<tbody>
	<table class="right-table" width="120%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th colspan="2">查询条件</th>
		</tr>
		<tr>
			<td>标题</td>
			<td><input type="text" id="title" name="subName" value="${requestScope.subjectDetail.title }"</td>
		</tr>
		<tr>
			<td>内容关键字</td>
			<td><input type="text" id="content" name="content" value="${requestScope.subjectDetail.content }"</td>
		</tr>
		<tr>
			<td>信息类型</td>
			<td>
				<select name="typeId" id="typeId">
					<option value="-1">--请选择--</option>
					<c:forEach items="${requestScope.subjectTypeList }" var="coorperationType">
						<option value="${coorperationType.id }" ${coorperationType.id==requestScope.subjectDetail.typeId?"selected='selected'":"" }>${coorperationType.typeName }</option>	
					</c:forEach>
				</select>
			</td>
		</tr>

		<tr>
			<td>发布者</td>
			<td><input type="text" name="userName"  value="${sessionScope.loginUser.userName }"</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="查询"/>
				<input type="button" value="清空条件" onclick="clearForm()"/>
			</td>
		</tr>
	</table>
	</tbody>
</form> --%>
</div>
<div class="div2">
<form name="myform" method="post" action="coorperationdetailservlet?op=batchDelete">
	<tbody>
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>标题</th>
			<!-- <th>发布者</th> -->
			<!-- <th>类型</th> -->
			<th>发布时间</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.subjectDetailList }"  var="newsDetail" varStatus="status">
				<tr style="background-color: ${status.index%2==0?'':'#4F4F4F' } ">
				<td>
					<%-- <input type="checkbox" name="ids" value="${newsDetail.id }"/> --%>
					${newsDetail.id }
				</td>
				<td> ${newsDetail.subName } </td>
			 <%--    <td nowrap>${newsDetail.author }</td> --%>
			<%-- 	<td nowrap>${newsDetail.typeName }</td>  --%>
				<td nowrap>${newsDetail.publishTime }</td>
				<td nowrap><a href="subjectdetailservlet?op=toEdit&id=${newsDetail.id }">编辑</a></td>
				<td nowrap><a href="subjectdetailservlet?op=delete&id=${newsDetail.id }">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" >
				<!-- <input type="button" value="批量删除" onclick="checkSelected()"/> -->
				<div id="page">
            <ul>
            <li class="first"><a href="subjectdetailservlet?op=list&pageNo=1">&nbsp;首页&nbsp;</a></li>
            <li class="upPage"><a href="subjectdetailservlet?op=list&pageNo=${sessionScope.pageBean.prePage }">&nbsp;上一页&nbsp;</a></li>
            <li class="nextPage"><a href="subjectdetailservlet?op=list&pageNo=${sessionScope.pageBean.nextPage }">&nbsp;下一页&nbsp;</a></li>
            <li class="lastPage"><a href="subjectdetailservlet?op=list&pageNo=${sessionScope.pageBean.pageCount }">&nbsp;末页&nbsp;</a></li>
            </ul>
        </div>
			</td>
		</tr>
	</table>
	</tbody>
	</form>
	</div>
	</div>
</body>
</html>