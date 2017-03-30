<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 这个语句是用来拼装当前网页的相对路径的。 -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加页面</title>
<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/addUser.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery-1.2.6.min.js" type=text/javascript></script>
<script src="js/formValidator_min.js" type="text/javascript" charset="UTF-8"></script>
<script src="js/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.formValidator.initConfig({formid:"myform",debug:false,submitonce:true,
		onerror:function(msg,obj,errorlist){
			//$.map(errorlist,function(msg1){alert(msg1)});
			alert(msg);
		}
	});
	$("#iptNickName").formValidator({onshow:"至少4个字符",onfocus:"至少4个字符",oncorrect:"通过"}).inputValidator({min:4,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"});
	$("#t_UserPass").formValidator({onshow:"至少6个字符",onfocus:"至少6个字符",oncorrect:"密码合法"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"});
	$("#t_RePass").formValidator({onshow:"请再次输入密码",onfocus:"请再次输入密码",oncorrect:"密码一致"}).inputValidator({min:6,empty:{leftempty:false,rightempty:false,emptyerror:"输入有误"},onerror:"输入有误"}).compareValidator({desid:"t_UserPass",operateor:"=",onerror:"密码不一致"});	
});
function test1(obj)
{
	if(obj.value=="全角字符当做1个长度")
	{
		$.formValidator.getInitConfig("1").wideword = false;
		obj.value = "全角字符当做2个长度";
	}
	else
	{
		$.formValidator.getInitConfig("1").wideword = true;
		obj.value = "全角字符当做1个长度";
	}
	
}

</script>
<script type="text/javascript">
	var userPwdMsg="${requestScope.userPwdMsg}";
	if(userPwdMsg!=""){
		alert(userPwdMsg);
	}
</script>
<style type="text/css">
body{
	margin: 0px;
	background-image : url('images/register_bg.jpg');
}
#container{
	margin:0px auto;
	width:500px;
	height:600px;
	margin-top:30px;
}
</style>

</head>
<body>
 <div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：用户管理　&gt;&gt;　用户添加　</a> 
<!-- <div id="container"> -->
<form name="myform" action="userTestCenterServlet?op=addUser" method="post" onsubmit="return checkForm()">
<tbody>
	<table class="right-table" width="50%"  border="0px" cellpadding="0" align="center" cellspacing="0">
		<tr>
			<th colspan="3">添加用户页面</th>
		</tr>
		<tr>
			<td>用户名</td>
			<td><input value="用户名" onFocus="if(value==defaultValue){value='';this.style.color='#000'}"  onblur="checkNickName(this.value) style="color:#999999;width:300px;height:25px" type="text" name="userName" id="userName" /><span id="iptNickNameTip" class="onshow"></span></td>
			<td><div id="userNameMsg"></div></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input value="请记住密码" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px"  name="userPwd" id="userPwd"/></td>
			<td><div id="userPwdMsg"></div></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input value="请重新输入密码" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px"  name="userRePwd" id="userRePwd"/></td>
			<td><div id="userRePwdMsg"></div></td>
		</tr>
		<tr>
			<td>联系方式</td>
			<td><input value="请输入正确的联系方式" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px" type="text" name="phone" id="phone"/></td>
			<td></td>
		</tr>
		<tr>
			<td>权限</td>
			<td>
				<select name="status">
					<option value="3">信息发布员</option>
			     	<option value="2">管理员</option> 
					<option value="1">超级管理员</option>
				</select>
			</td>
			<td></td>
		</tr>
		<!-- <tr>
			<td>状态</td>
			<td>
				<input type="radio" name="status" value="1" checked="checked"/>可用
				<input type="radio" name="status" value="0"/>禁用
			</td>
			<td></td>
		</tr> -->
		
	
		<tr>
			<td colspan="3">
				<input type="submit" value="添加"/>
				<input type="reset" value="重填"/>
			</td>
		</tr>
	</table>
	</tbody>
</form>
</div>
</body>
</html>