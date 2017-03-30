<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户登陆</title>
    <script type="text/javascript">
    	function doRegister(){
    		window.location.href="${pageContext.request.contextPath }/servlet/RegisterUIServlet";
    	}
    </script>
    <style> 
* { 
margin: 0; 
padding: 0; 
font-size: 12px; 
} 
html, body { 
height: 100%; 
width: 100%; 
} 
#content { 
background: #FFFFFF; 
padding: 30px; 
height: 100%; 
} 
#content a { 
font-size: 30px; 
color: #369; 
font-weight: 700; 
} 
#alert { z-index:2; 
border: 1px solid #369; 
width: 300px; 
height: 150px; 
background: #e2ecf5; 
z-index: 1000; 
position: absolute; 
display: none; 
} 
#alert h4 { 
height: 20px; 
background: #369; 
color: #fff; 
padding: 5px 0 0 5px; 
} 
#alert h4 span { 
float: left; 
} 
#alert h4 span#close { 
margin-left: 210px; 
font-weight: 500; 
cursor: pointer; 
} 
#alert p { 
padding: 12px 0 0 30px; 
} 
#alert p input { 
width: 120px; 
margin-left: 20px; 
} 
#alert p input.myinp { 
border: 1px solid #ccc; 
height: 16px; 
} 
#alert p input.sub { 
width: 60px; 
margin-left: 30px; 
} 
#mask{ position:absolute; top:0; left:0; height:100%; width:100%; background:#000; opacity:0.3; display:none; z-index:1;} 
</style> 
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
    	
    	<div id="alert"> 
<h4><span>请登录</span><span id="close">主页</span></h4> 
<p> 
<label> 用户名</label> 
<input type="text" name="username" class="myinp" onmouseover="this.style.border='1px solid #f60'" onfoucs="this.style.border='1px solid #f60'" onblur="this.style.border='1px solid #ccc'" /> 
</p> 
<p> 
<label> 密　码</label> 
<input type="password" name="password" class="myinp" onmouseover="this.style.border='1px solid #f60'" onfoucs="this.style.border='1px solid #f60'" onblur="this.style.border='1px solid #ccc'" /> 
</p> 
<p> 
<input type="submit" value="登陆" class="sub" /> 
<input type="reset" value="重置" class="sub" /> 
</p> 
</div> 
<div id="mask"></div><!-- 遮罩层div--> 
 
<script type="text/javascript"> 

var myAlert = document.getElementById("alert"); 
var myMask=document.getElementById('mask'); 
var mClose = document.getElementById("close"); 

myMask.style.display="block"; 
myAlert.style.display = "block"; 
myAlert.style.position = "absolute"; 
myAlert.style.top = "50%"; 
myAlert.style.left = "50%"; 
myAlert.style.marginTop = "-75px"; 
myAlert.style.marginLeft = "-150px"; 
document.body.style.overflow = "hidden"; 

mClose.onclick = function() 
{ 
	/* javascript:history.go(-1); */
	window.location.href="${pageContext.request.contextPath }/EN_Home.jsp";
} 
</script> 
    </form>
  </body>
</html>