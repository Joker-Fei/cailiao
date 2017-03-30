<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

<head>
<title>我的空间</title>
<style type="text/css">
body,h1,h2,h3,h4,h5,h6,hr,p,blockquote,dl,dt,dd,ul,ol,li,pre,form,fieldset,legend,button,input,textarea,th,td{margin:0;padding:0}
body,button,input,select,textarea{font:12px/1.5 tahoma,arial,\5b8b\4f53,sans-serif;text-align:justify;text-justify:inter-ideograph;word-break:break-all;word-wrap:break-word}
h1,h2,h3,h4,h5,h6{font-size:100%}
address,cite,dfn,em,var,i,u{font-style:normal}
code,kbd,pre,samp{font-family:courier new,courier,monospace}
small{font-size:12px}ul,ol{list-style:none}
sup{vertical-align:text-top}sub{vertical-align:text-bottom}
legend{color:#000}fieldset,img{border:0}button,input,select,textarea{font-size:100%;padding:0;margin:0}
table{border-collapse:collapse;border-spacing:0}caption,th{ text-align:left }
.ovh{overflow:hidden}.l{float:left}.r{float:right}.cur{cursor:pointer}
.c_b{content:".";display:block;height:0;clear:both;visibility:hidden;zoom:1;font-size:0px;overflow:hidden;visibility:hidden}.c_b2{clear:both}.dn{display:none}.dis{display:block}.b{font-weight:bold}
body{behavior:url("css/hover_htc.htc");font-family:"Microsoft YaHei",宋体; color:#333;}/*hover*/

/*会员注册*/
.login ul{/*background:url(../images/line.png) repeat-x;*/ padding-top:10px; border-top:1px solid #fff}
.login ul a{ color:#005cb1}
.login .id input,.login .pw input,.in_id,.in_mo,.reg_input,.reg_input_pic{background-color:#FFF; border:1px solid #d5cfc2;  font-size:14px; font-weight:bold; vertical-align:middle}
.login .id input,.login .pw input{width:170px; height:30px;margin:0 5px 5px 0; line-height:30px; padding:0 5px;}
.login .id input:hover,.login .pw input:hover,.in_id:hover,.in_mo:hover,.reg_input:hover,.reg_input_pic:hover{border:1px solid #005cb1;background-color:#F2FAFF;}
.l_button,.r_button{background:url(images/login_button.png) no-repeat; width:118px; height:39px; border:none; cursor:pointer; display:block; float:left; text-indent:-9000px}
.l_button{background-position:0 -60px;}
.r_button{background-position:-138px -60px; margin-right:4px}
.l_button:hover{background-position:0 0;}
.r_button:hover{background-position:-138px 0;}
.f_reg_but{margin:10px 0 0 115px}

.reg{width:500px; font-size:14px;line-height:40px;overflow:hidden;margin:0 auto;}
.reg dl{padding-left:10px; font-size:14px;}
.reg dl dt{ margin-top:20px;}
.reg dl dd{padding:3px 0}
.reg .title{width:100px; display:inline-block; text-align:right; padding-right:10px}
.reg_input_pic{width:80px;}
.in_pic_s{margin-left:83px}
.reg .img{position:absolute}
.onShow,.onFocus,.onError,.onCorrect,.onLoad{background:url(images/reg_bg.png) no-repeat 3000px 3000px;padding-left:30px; font-size: 12px; height:25px; width:124px; display:inline-block; line-height:25px; vertical-align:middle; overflow:hidden; margin-left:6px}
.onShow{color:#999; padding-left:0px}
.onFocus{background-position:0px -30px; color:#333}
.onError{background-position:0px -60px; color:#333}
.onCorrect{background-position:0px 0; text-indent:-9000px}
.onLoad{background-position:0px 0}
.reg_m{margin-left:90px}
.clew_txt{display:inline-block; padding:7px  0 0 15px; font-size:12px;}

.id input,.pw input,.in_id,.in_mo,.reg_input,.reg_input_pic{_behavior:url(js/Round_htc.htc);-moz-border-radius:4px;-webkit-border-radius:4px;border-radius:4px; height:25px;}
.user_button a,.pay_but{_behavior:url(js/Round_htc.htc);-moz-border-radius:100px;-webkit-border-radius:100px;border-radius:100px;}

#one1,#one2{display:block; background-color:#e9eed8; padding:5px 0; text-align:center; clear:both; cursor:pointer}
#one2{margin-top:15px}
#one1:hover,#one2:hover{background-color:#d4dfb0}
#one1 span,#one2 span{color:#F00}
</style>
<meta name="keywords" content="" />
<meta name="description" content="" />

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width" />

<!--[if lt IE 9]>
<script type="text/javascript" src="layout/plugins/html5.js"></script>
<![endif]-->

<link rel="stylesheet" href="layout/style.css" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=PT+Sans:400,700" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Droid+Serif:400,400italic" rel="stylesheet" type="text/css" />


<script type="text/javascript">
	jQuery(function () {
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<script type="text/javascript" src="layout/js/main.js"></script>
<script src="js/jquery-1.4.2.js"></script>
<script type="text/javascript">
$(function() {
	

	/*
	 *  当输入框失去焦点时进行校验
	 */
	$("#pwd").blur(function() {
		
		validateLoginname();
	});

});
/*
 * 动态验证登录名的方法
 */
function validateLoginname() {
	var value = $("#pwd").val();//获取输入框内容
	var checkPwd="checkPwd";
	var id=$("#id").val();
	if (value == "") {
		$("#pwd").text("");
	}
	if (value == "请输入用户名" || value == "") {
		return false;
	}

	/*
	 * 3. 是否注册校验
	 */
	$.ajax( {
		url : "userdetailservlet",//第一步 ，要请求的servlet
		data : {
			pwd : value,
			op : checkPwd,
			id : id
		},//第二步，默认调用的是servlet中的dopost方法，给服务器的参数,op只是一个传送的参数而已，用来在dopost方法中调用ajax校验的方法。
		type : "POST",
		dataType : "json",
		async : false,//第三步，是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache : false,
		success : function(result) {
			var iptNickNameTip = document.getElementById("msg");
			if (result == 0) {//第四步，校验
				iptNickNameTip.style.color = "red";
			$("#msg").text("密码错误！");
			return false;
		}
		if (result == 1) {
			iptNickNameTip.style.color = "green";
			$("#msg").text("密码正确！");
		}

	}
	});
	return true;
}
</script>
<style>
 .main{
width: 100%;
height: 100%;
/* background: url(images/back1.jpg) no-repeat center top; */

} 
.main2{
width: 100%;
height: 190px;

} 
.main3{
	/* position: relative; /* 相对定位 */
	/* left:250px;/*在原来的位置向右移动*/
	/* top:0px;/*  在原来的位置向下移动  */  
	width: 100%;
height: 100%;

} 
</style> 
<style type="text/css">
 
body {
 background-image: url(images/back1.jpg);
}
 
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body  style="overflow:hidden">
<div class="main2">
	<div style="width:500px;height:400px;border:0px solid red;position:relative;">
  		<img src="images/xiaohui.png" style="width:100px;height:100px;position:absolute;left:180px;top:20px;"/>
 	 </div>
</div>
<div  class="main">
<!--登录开始-->
	<div class="main3">
    <div class="reg login">
           
<form name="myform" action="userdetailservlet?op=changePwd" method="post" >
<input type="hidden" name="id" value="${sessionScope.loginUser.id} " id="id">
	<!-- <table class="right-table" width="50%"  border="0px" cellpadding="0" align="center" cellspacing="0"> -->
		
		<dl>
			
			<dd><span class="title"><a style="font-size:17px;color:#842b00;text-decoration:none;font-weight:bold;">旧密码：</a></span>
			<input class="reg_input" type="text" name="userName" id="pwd" />
			<div id="msg">
			 
			</div> 
			</dd>
		
		</dl>
		<dl>
			<dd><span class="title"><a style="font-size:17px;color:#842b00;text-decoration:none;font-weight:bold;">新密码：</a></span>
		<input class="reg_input" type="password" name="userPwd" id="Pwd1" /></dd>
			 <div id="userPwdMsg"></div> 
		 
		</dl>
		<dl>
			<dd><span class="title"><a style="font-size:17px;color:#842b00;text-decoration:none;font-weight:bold;">确&nbsp&nbsp&nbsp&nbsp认：</a></span>
			 <input class="reg_input" type="password" name="userRePwd" id="Pwd2"/></td>
			<td><div id="userRePwdMsg"></div></td>
		</dd>
		<div class="f_reg_but">
		<input type="submit" style="margin-left:80px; margin-top:20px" class="general_button standart type_1" value="修改密码"/></td>
		</div>
	</table>
</form>
  
</div></div></div>
</body>

</html>