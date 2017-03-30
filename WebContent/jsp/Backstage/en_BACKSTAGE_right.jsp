<%@ page language="java"  pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>
<%--为了避免在jsp页面中出现java代码，这里引入jstl标签库，利用jstl标签库提供的标签来做一些逻辑判断处理 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
<title></title>
<link rel=stylesheet type=text/css href="css/zzsc.css">
<script type=text/javascript src="../js/jquery.min.js"></script>
</head>
<body topMargin="1px" leftMargin="0px" bgcolor="">
<!-- 代码 开始 -->
 <div id="firstpane" class="menu_list">
    <p class="menu_head"><a style="text-decoration:none" href="${pageContext.request.contextPath }/servlet/intrFindServlet?web_type=back" target="houtai_rightFrame">学院介绍</a></p>
   <%--  <div style="display:none" class=menu_body >
    	<a href="${pageContext.request.contextPath }/servlet/intrFindServlet?web_type=back" target="houtai_rightFrame">修改</a>
    </div> --%>
    <p class="menu_head"><a style="text-decoration:none" href="${pageContext.request.contextPath }/servlet/dmFindAllServlet?web_type=back" target="houtai_rightFrame">院系管理</a></p>
    <%-- <div style="display:none" class=menu_body >
    	<a href="${pageContext.request.contextPath }/jsp/Backstage/en_bs_DEPARTMENTS.jsp" target="houtai_rightFrame">增加</a>
    	<a href="${pageContext.request.contextPath }/servlet/dmFindAllServlet?web_type=back" target="houtai_rightFrame">查询</a>
    </div> --%>
    <p class="menu_head"><a style="text-decoration:none" href="${pageContext.request.contextPath }/servlet/menFindAllServlet?web_type=back" target="houtai_rightFrame">人员管理</a></p>
     <%-- <div  class=menu_body >
    	<a href="${pageContext.request.contextPath }/jsp/Backstage/en_bs_MENBERS_add.jsp" target="houtai_rightFrame">增加</a>
    	<a href="">修改</a>
    	<a href="">删除</a>
    </div>  --%>
   <p class="menu_head"><a style="text-decoration:none" href="${pageContext.request.contextPath}/servlet/addResearch?web_type=back" target="houtai_rightFrame">科研管理</a></p>
    <!--  <div style="display:none" class=menu_body >
    	<a href="">增加</a>
    	<a href="">修改</a>
    	<a href="">删除</a>
    </div>-->
    <p class="menu_head"><a style="text-decoration:none" href="${pageContext.request.contextPath}/servlet/modifEducation?web_type=back" target="houtai_rightFrame">教育信息</a></p>
    <!-- <div style="display:none" class=menu_body >
    	<a href="">增加</a>
    	<a href="">修改</a>
    	<a href="">删除</a>
    </div> -->
    <p class="menu_head"><a style="text-decoration:none" href="${pageContext.request.contextPath}/servlet/modifCuntactus?web_type=back" target="houtai_rightFrame">其他管理</a></p>
    <!-- <div style="display:none" class=menu_body >
    	<a href="">增加</a>
    	<a href="">修改</a>
    	<a href="">删除</a>
    </div> -->
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