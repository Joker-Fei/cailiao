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
<title>学生工作类型列表</title>

<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/listNewsType.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>

<style type="text/css">
	body{
		background-image: url("images/bg_workDetailList1.jpg");
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
	b {font-size:12px;
text-decoration:none;
color:yellow;
} 
</style>
<script>
function formCheck33()
   {   
     
     if(document.form1.typeName.value==''){   
   alert("请填写类型！");   
   document.form1.typeName.focus();   
   return false;}    
    }   
</script>
<style type="text/css">
.div1{

margin-top:30px;
}
</style>
</head>
<body>
 <div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：学院概况　&gt;&gt;　类型管理　</a>

<div class="div1">
<form action="worktypeservlet?op=add" method="post" name="form1" onsubmit="return formCheck33();">

	<tbody>

            <div class="search" align="center">
            <span>类型名称：<input maxlength="6" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px" type="text" name="typeName"/><b>请控制在6个字以内</b></span>
        
            <span><input type="submit" id="search-btn" value="添加"/> </span>
            <a href="worktypeservlet?op=list">刷新列表</a>
            </div>
		</table>
	</tbody>

</form>
</div>

<div class="div2">
<form name="myform" method="post" action="worktypeservlet?op=batchDelete">
	<tbody>
	<table class="right-table" width="50%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>类型名</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.workTypeList }"  var="workType" varStatus="status">
		  	<tr style="background-color: ${status.index%2==0?'':'#4F4F4F' } ">
				<td>
					<%-- <input type="checkbox" name="ids" value="${workType.id }"/> --%>
					${workType.id }
				</td>
				<td>${workType.typeName }</td>	
				<td><a href="worktypeservlet?op=delete&id=${workType.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	</tbody>
	</form>
</div>
	  
</body>
</html>