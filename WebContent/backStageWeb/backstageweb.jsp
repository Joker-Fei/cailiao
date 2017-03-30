<!-- 后台管理页面 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>材料学院官网管理平台-首页</title>
<link href="share/images/favicon.ico" rel="shortcut icon" />
<link rel="stylesheet" type="text/css" href="share/css/share.css" />
<link rel="stylesheet" type="text/css"
	href="admin/css/default/index.css" />
<link rel="stylesheet" type="text/css"
	href="admin/css/default/share.css" />
<script src="share/js/jquery-1.11.0.min.js"
	type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>

</head>

<body>
	<div class="bezel" id="bezel-id">
		<div class="head">
			<div class="hleft">
				<span class="head-icon">材料学院后台管理</span>
			</div>

		<div class="hcenter">
 
        </div>
		
			<div class="hright">
				用户：${sessionScope.loginUser.userName } 您好，欢迎使用使用后台管理！
				<!-- <a class="outLogin" href="#">修改密码</a> -->
				<!-- <a class="outLogin" href="userdetailservlet?op=revisepwd" target="rightFrame">修改密码</a> -->
				<a class="outLogin" href="logoff.jsp">注销</a></span><a class="outLogin" href="alter_pwd.jsp">修改密码</a></span>
			</div>
		</div>
		<div class="center">

			<div class="cleft" id="cleft-id">
			<h4>图片新闻</h4>
				<ul>
					<li class="on"><a href="topnewsdetailservlet?op=toAddTopNews" target="rightFrame">信息添加</a></li>
				 
					<li><a href="topnewsdetailservlet?op=list" target="rightFrame">信息列表</a></li>
					<!-- <li><a href="topnewsdetailservlet?op=toAddTopNews" target="rightFrame">添加头条</a></li>
					<li><a href="topnewsdetailservlet?op=list" target="rightFrame">头条管理</a></li> -->
				</ul>
				<h4>学院概况</h4>
				<ul>
					<li class="on"><a href="newstypeservlet?op=list" target="rightFrame">类型管理</a></li>
					<!-- <li><a href="newstypeservlet?op=list" target="rightFrame">类型列表</a></li> -->

					<li ><a href="newsdetailservlet?op=toAdd" target="rightFrame">添加信息</a></li>
					<li><a href="newsdetailservlet?op=list" target="rightFrame">信息列表</a></li>
					<!-- <li><a href="topnewsdetailservlet?op=toAddTopNews" target="rightFrame">添加头条</a></li>
					<li><a href="topnewsdetailservlet?op=list" target="rightFrame">头条管理</a></li> -->
				</ul>

				<h4>科研与合作</h4>
				<ul>
					<li class="on"><a href="coorperationtypeservlet?op=list" target="rightFrame">类型管理</a></li>
					<li><a href="coorperationdetailservlet?op=toAdd" target="rightFrame">添加信息</a></li>
					<li><a href="coorperationdetailservlet?op=list" target="rightFrame">信息列表</a></li>
					
				</ul>
				<h4>学科介绍</h4>
				<ul>
					<!-- <li class="on"><a href="subjecttypeservlet?op=list" target="rightFrame">添加学科</a></li> -->
					<li><a href="subjectdetailservlet?op=toAdd" target="rightFrame">添加学科</a></li>
					<li><a href="subjectdetailservlet?op=list" target="rightFrame">学科列表</a></li>
				</ul>
				
				<h4>导师管理</h4>
				<ul>
					<!-- <li class="on"><a href="roadtypeservlet?op=list" target="rightFrame">类型管理</a></li> -->
					<li><a href="teacherdetailservlet?op=toAdd" target="rightFrame">添加导师</a></li>
					<li><a href="teacherdetailservlet?op=list" target="rightFrame">导师列表</a></li>
				</ul>
				<c:if test="${sessionScope.loginUser.status le 2}"><!-- 当权限小于等于2（即权限为1或者2的用户） -->
				<h4>用户管理</h4>
				<ul>
					<li class="on"><a href="addUser.jsp" target="rightFrame">添加管理员</a></li>
					<li><a href="userdetailservlet?op=list" target="rightFrame">管理员列表</a></li>
					<!-- <li><a href="roaddetailservlet?op=list" target="rightFrame">导师列表</a></li> -->
				</ul>
				</c:if>
				<!-- <h4>学生工作</h4>
				<ul>
					<li class="on"><a href="worktypeservlet?op=list" target="rightFrame">类型管理</a></li>
					<li><a href="workdetailservlet?op=toAdd" target="rightFrame">添加信息</a></li>
					<li><a href="workdetailservlet?op=list" target="rightFrame">信息列表</a></li>
					<li><a href="studentdetailservlet?op=list" target="rightFrame">学生信息</a></li>
					<li><a href="#" target="rightFrame">学生信息（正在建设中）</a></li>
				</ul> -->
			</div>
		 <div id="showHideMenu"></div> 
			<div class="rleft">


				<!--   <div class="topMenu">
            	  <ul>
            	   	  <li><a href="javascript:add()">　新增　</a></li>
           	  		  <li><a href="#">　发布　</a></li>
         		      <li><a href="#">　删除　</a></li>
         		      <li><a href="#">　置顶　</a></li>
				  </ul>
            </div> -->

				 


				<iframe name="rightFrame" src="" width="100%" height="100%"
					frameborder="0">
					
					
					</iframe>
				




			</div>
		</div>
		<div class="floot">环球旅游资讯网版权所有</div>
	</div>
</body>
</html>