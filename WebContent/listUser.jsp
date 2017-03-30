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
<title>用户列表</title>
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/listUser.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function clearForm(){
		document.myform.userName.value="";
		document.myform.phone.value=""; 
		document.myform.status.value="-1"; 
		document.myform.action="userdetailservlet?op=list";
		document.myform.submit();
	}
	//定义一个变量用于存放XMLHttpRequest对象
	var xmlHttp;
	//定义一个按钮
	var myButton;
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
	//处理从服务器返回的信息
	function processor() {
		if (xmlHttp.readyState == 4) { //如果响应完成
			if (xmlHttp.status == 200) {//如果返回成功
				//修改按钮信息
				if(myButton.value=="禁用"){
					myButton.value="可用";
					myButton.className="enableStyle";
				}else{
					myButton.value="禁用";
					myButton.className="disableStyle";
				}
			}
		}
	}
	
	function changeStatus(clickedButton,id){
		myButton=clickedButton;
		createXMLHttpRequest();
		//将状态触发器绑定到一个函数
		xmlHttp.onreadystatechange = processor;
		//通过GET方法向指定的URL建立服务器的调用
		xmlHttp.open("GET", "userdetailservlet?op=changeStatus&id="+id );
		//发送请求
		xmlHttp.send(null);
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
 <div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：用户管理　&gt;&gt;　用户列表　</a>
<div class="div3">
<div class="div1">
<form name="myform" action="userdetailservlet?op=search" method="post">
	<tbody>
	<table class="right-table" width="100%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th colspan="2">查询条件</th>
		</tr>
		<tr>
			<td>用户名</td>
			<td><input style="width:200px;height:25px" type="text" name="userName" value="${requestScope.userDetail.userName }"/></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input style="width:200px;height:25px" type="text" name="phone" value="${requestScope.userDetail.phone }"/></td>
		</tr>
		<tr>
			<td>权限</td>
			<td>
				<select name="status">
					<option value="-1">-请选择-</option>
					<option value="1" ${requestScope.userDetail.status==1?"selected='selected'":"" }>超级管理员</option>
					<option value="2" ${requestScope.userDetail.status==2?"selected='selected'":"" }>管理员</option>
					<option value="3" ${requestScope.userDetail.status==3?"selected='selected'":"" }>信息发布员</option>
				</select>
			</td>
		</tr>
		<%-- <tr>
			<td>状态</td>
			<td>
				<select name="status">
					<option value="-1">-请选择-</option>
					<option value="1" ${requestScope.userDetail.status==1?"selected='selected'":"" }>可用</option>
					<option value="0" ${requestScope.userDetail.status==0?"selected='selected'":"" }>禁用</option>
				</select>
			</td>
		</tr> --%>
		 
		<tr>
			<td colspan="2">
				<input type="submit" value="查询"/>
				<input type="button" value="清空查询条件" onclick="clearForm()"/>
			</td>
		</tr>
	</table></tbody>
</form></div>
	<div class="div2">
	<tbody>
	<table class="right-table" width="60%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		 
			<th>编号</th>
			<th>用户名</th>
			<!-- <th>密码</th>
			<th>电话</th> -->
			<!--  <th>权限</th>  -->  
		 	<th>电话</th> 
			<th>删除</th>
		</tr>
		
		<c:forEach items="${requestScope.userList }"  var="user">
		 
		<c:if test="${ user.id ne 10000}">
			 	<tr style="background-color: ${status.index%2==0?'':'#4F4F4F' } ">
				<td>${user.id }</td>
				<td>${user.userName }</td>
				<%-- <td>${user.userPwd }</td>--%>
				<td>${user.phone }</td> 
				<%--  <td>${user.status }</td>  --%>
			<%-- 	<td>${user.status==1?'可用':'<font color=red>禁用</font>' }
					<c:if test="${user.status==1}">
						<input type="button" value="可用" class="enableStyle" onclick="changeStatus(this,${user.id })"/>
					</c:if>
					<c:if test="${user.status==0}">
						<input type="button" value="禁用" class="disableStyle" onclick="changeStatus(this,${user.id })"/>
					</c:if>
				</td> --%> 
			<%-- 
				<td><a href="userdetailservlet?op=toEdit&id=${user.id }">编辑</a></td> --%>
				<%-- <c:if test="${ user.id ne 3}"> --%>
				<td><a href="userdetailservlet?op=delete&id=${user.id }">删除</a></td>
			<%-- 	</c:if> --%>
			</tr>
	 </c:if>
			</c:forEach>
			<tr><td colspan="10">
			<div id="page">
            <ul>
            <li class="first"><a href="userdetailservlet?op=list&pageNo=1">&nbsp;首页&nbsp;</a></li>
            <li class="upPage"><a href="userdetailservlet?op=list&pageNo=${sessionScope.pageBean.prePage }">&nbsp;上一页&nbsp;</a></li>
            <li class="nextPage"><a href="userdetailservlet?op=list&pageNo=${sessionScope.pageBean.nextPage }">&nbsp;下一页&nbsp;</a></li>
            <li class="lastPage"><a href="userdetailservlet?op=list&pageNo=${sessionScope.pageBean.pageCount }">&nbsp;末页&nbsp;</a></li>
            </ul>
        </div>
        </td>
        </tr>
	</table></tbody></div></div>
</body>
</html>