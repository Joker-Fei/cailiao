<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<link rel=stylesheet type=text/css href="css/zzsc.css">
<script type=text/javascript src="js/jquery.min.js"></script>
</head>
<body topMargin="1px" leftMargin="0px" bgcolor="#afb4db">
<!-- 代码 开始 -->
 <div id="firstpane" class="menu_list">
    <p class="menu_head">
    	<a style="text-decoration:none" target="rightFrame" href="${pageContext.request.contextPath }/servlet/menFindAllServlet?web_type=1">&nbsp;&nbsp;Doctoral Supervisor&nbsp;&nbsp;</a>
    </p>
    	<div style="display:none" class=menu_body ></div>
    <p class="menu_head"><a style="text-decoration:none" href="#">&nbsp;&nbsp;Supervisor&nbsp;&nbsp;</a>
    </p>
    	<div style="display:block" class=menu_body >
	      <a href="${pageContext.request.contextPath }/servlet/menFindAllServlet?web_type=2&type=1" target="rightFrame">Material Forming and Control Engineering</a>
	      <a href="${pageContext.request.contextPath }/servlet/menFindAllServlet?web_type=2&type=2" target="rightFrame">Polymer Materials and Engineering</a>
	      <a href="${pageContext.request.contextPath }/servlet/menFindAllServlet?web_type=2&type=3" target="rightFrame">Metal Material Engineering</a>
	      <a href="${pageContext.request.contextPath }/servlet/menFindAllServlet?web_type=2&type=4" target="rightFrame">Inorganic Non-metal Materials Engineering</a>
    	</div>
	</div>
<script type=text/javascript>
$(document).ready(function(){
	$("#firstpane .menu_body:eq(0)").show();
	$("#firstpane p.menu_head").click(function(){
		$(this).addClass("current").next("div.menu_body").slideToggle(300).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	$("#secondpane .menu_body:eq(0)").show();
	$("#secondpane p.menu_head").mouseover(function(){
		$(this).addClass("current").next("div.menu_body").slideDown(500).siblings("div.menu_body").slideUp("slow");
		$(this).siblings().removeClass("current");
	});
	
});
</script>

<!-- 代码 结束 -->

</body>
</html>