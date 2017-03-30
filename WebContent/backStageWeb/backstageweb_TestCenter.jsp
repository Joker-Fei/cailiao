<!-- 后台管理页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>材料学院分析测试中心管理平台-首页</title>
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
				<span class="head-icon">分析测试中心</span>
			</div>

			<div class="hcenter"></div>

			<div class="hright">
				用户：${sessionScope.loginUser_testCenter.userName } 您好，欢迎使用使用后台管理！
				<!-- <a class="outLogin" href="#">修改密码</a> -->
				<!-- <a class="outLogin" href="userdetailservlet?op=revisepwd" target="rightFrame">修改密码</a> -->
				<a class="outLogin" href="logoff2.jsp">注销</a>
				<a class="outLogin" href="testCenterChangepwd.jsp" target="_blank">修改密码</a>
				</span>
			</div>
		</div>
		<div class="center">

			<div class="cleft" id="cleft-id">
				<!-- 	<h4>学院概况</h4>
				<ul>
					<li class="on"><a href="newstypeservlet?op=list" target="rightFrame">类型管理</a></li>
					<!-- <li><a href="newstypeservlet?op=list" target="rightFrame">类型列表</a></li>

					<li ><a href="newsdetailservlet?op=toAdd" target="rightFrame">添加信息</a></li>
					<li><a href="newsdetailservlet?op=list" target="rightFrame">信息列表</a></li>
					<!-- <li><a href="topnewsdetailservlet?op=toAddTopNews" target="rightFrame">添加头条</a></li>
					<li><a href="topnewsdetailservlet?op=list" target="rightFrame">头条管理</a></li>
				</ul>
				
				<!-- 测试中心 -->
				<h4>中心概况</h4>
				<ul>
					<li class="on"><a href="testCenterTypeServlet?op=list"
						target="rightFrame">类型管理</a></li>
					<li><a href="testCenterInfoServlet?op=toAdd"
						target="rightFrame">添加信息</a></li>
					<li><a href="testCenterInfoServlet?op=list"
						target="rightFrame">信息列表</a></li>
				</ul>
				<h4>仪器管理</h4>
				<ul>
					<li class="on"><a href="instrumentTypeServlet?op=list"
						target="rightFrame">类型管理</a></li>
					<li><a href="instrumentServlet?op=toAdd" target="rightFrame">添加仪器</a></li>
					<li><a href="instrumentServlet?op=list" target="rightFrame">仪器列表</a></li>
				</ul>
				<h4>服务指南管理</h4>
				<ul>
					<li class="on"><a href="serviceTypeServlet?op=list"
						target="rightFrame">类型管理</a></li>
					<li><a href="serviceGuideServlet?op=toAdd" target="rightFrame">添加服务指南</a></li>
					<li><a href="serviceGuideServlet?op=list" target="rightFrame">服务指南列表</a></li>
				</ul>
				<h4>计量认证管理</h4>
				<ul>
					<li class="on"><a href="accreditationTypeServlet?op=list"
						target="rightFrame">类型管理</a></li>
					<li><a href="accreditationServlet?op=toAdd"
						target="rightFrame">添加计量认证</a></li>
					<li><a href="accreditationServlet?op=list" target="rightFrame">计量认证列表</a></li>
				</ul>
				<h4>示例照片管理</h4>
				<ul>
					<%-- <li class="on"><a href="roadtypeservlet?op=list" target="rightFrame">类型管理</a></li>
					<li><a href="samplePhotoServlet?op=toAdd" target="rightFrame">添加照片</a></li> --%>
					<li><a href="samplePhotoServlet?op=list" target="rightFrame">照片列表</a>
					</li>
				</ul>

							
				<c:if test="${sessionScope.loginUser_testCenter.status eq 1}">

					<h4>用户管理</h4>
					<ul>
						<li class="on"><a href="userTestCenterServlet?op=toAdd" target="rightFrame">添加管理员</a>
						</li>
						<li><a href="userTestCenterServlet?op=list"
							target="rightFrame">管理员列表</a></li>
					</ul>
				</c:if>


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
					frameborder="0"> </iframe>





			</div>
		</div>
		<div class="floot">哈尔滨理工大学材料学院版权所有</div>
	</div>
</body>
</html>