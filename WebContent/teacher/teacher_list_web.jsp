<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>材料科学与工程学院</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link href="./images/yuanhui.png" rel="shortcut icon"/>
<link href="./css/dedecms.css" rel="stylesheet" media="screen" type="text/css">
<link href="./css/page.css" rel="stylesheet" media="screen" type="text/css">
<link href="./css/layout.css" rel="stylesheet" media="screen" type="text/css">
<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/list.php?tid=60">
<script type="text/javascript">if(window.location.toString().indexOf('pref=padindex') != -1){}else{if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){if(window.location.href.indexOf("?mobile")<0){try{if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){window.location.href="/m/list.php?tid=60";}else if(/iPad/i.test(navigator.userAgent)){}else{}}catch(e){}}}}</script>
 <style type="text/css"> 
#divcss5{
    width:100%;
	height:60px;
	line-height：20px; 
	line-right:10px;
	margin-left:5px;
	color:#776955;
	overflow:hidden;
	text-overflow:ellipsis;   
	word-wrap:break-word;

} 
</style>
</head>
<body class="channel">
<div class="header_top">  
    <div class="w960 center">  
     <span class="time">欢迎访问</span><span class="time">哈尔滨理工大学-材料科学与工程学院 ！</span>
     <div class="toplinks">
	 <span id="time">2015/11/22 上午7:30:19 星期日</span> 
<!-- <a href="http://jixie.hrbust.edu.cn/plus/heightsearch.php" target="_blank">搜索</a>| -->
	 <!--<a href="/Data/sitemap.html" target="_blank">网站地图</a>|
	 <a href="/tags.php">TAG标签</a>
	 <a href="/data/rssmap.html" class="rss">RSS订阅</a>-->
</div> 
</div>
<div class="header">
	<div class="top w960 center">
      
       </div><!-- //top -->
	<!-- //菜单 -->
	<div class="module blue mT10 wrapper w963">
  	<div class="top">
    	<!-- //如果不使用currentstyle，可以在channel标签加入 cacheid='channeltoplist' 属性提升性能 -->
      <div id="navMenu">
  	    	<ul>
      	<li><a href="./toFirstWeb.jsp"><span>主页</span></a></li>
      	
      	<li><a href="./newsdetailservlet?op=toAcademyInfo" rel="dropmenu11"><span>学院概况</span></a></li>
      	
      	<li><a href="./coorperationdetailservlet?op=toCoorperationType&id=1" rel="dropmenu40"><span>科研与合作</span></a></li>
      	
      	<li><a href="subjectdetailservlet?op=listAll" rel="dropmenu23"><span>学科介绍</span></a></li>
      	
      	<li><a href="./teacherdetailservlet?op=toTeacherType&id=1" ><span>导师队伍</span></a></li>
      	
      	<li><a href="./workdetailservlet?op=toWorkType&id=1" rel="dropmenu29"><span>学生工作</span></a></li>
      	
      	<li><a href="./toTestCenterWeb.jsp" rel="dropmenu56"><span>分析测试中心</span></a></li>
      	
      	  	<li><a href="http://www2.hrbust.edu.cn/cailiao/"><span>勤工助学</span></a></li>
      	  	
      	  	
      	<li><a href="http://www1.hrbust.edu.cn/xueyuan/cailiao/"><span>旧版网站入口</span></a></li>
      	  	  	<li><a href="./EN_Home.jsp"><span>English</span></a></li>
      	
      	
    	</ul>
    </div>
<!--导航结束-->
		</div>
	</div>
</div><!--end header-->
 
 


<!-- /header -->
<div class="w960 center clear mt1">
 <div class="pright">
  <div class="place"> <strong>当前位置:</strong> <a href="./toFirstWeb.jsp">主页</a> &gt; <a href="./teacherdetailservlet?op=toTeacherType&id=1">博/硕士导师</a> </div>
  
<!--   专业里的教师列表 -->
		<div class="listboxteacher">
	
	<%-- <c:forEach items="${requestScope.subjectTypeList }" var="nn">    --%> 
	
	<dl class="tbox">
         
        <dd>
          <ul class="e2T">
           <c:forEach items="${requestScope.teacherDetailList }" var="tt">
          <li><a href="teacherdetailservlet?op=toTeacherDetail&id=${tt.id }" class="preview"><img src="images/xiaohui.png"></a>
    <!--[<b><a href='/Html/Teacher/jixiezhizaojizidonghua/'>机械制造及自动化</a></b>]-->
<h3><a href="teacherdetailservlet?op=toTeacherDetail&id=${tt.id }" class="title">&nbsp;${tt.teacherName }</a><br></h3>
   <%-- <div id="divcss5"> <p class="intro" style="text-indent: 2em;margin-left:72.0pt;"> ${tt.content }</p></div> --%>
    </li>
    </c:forEach> 
         
 

          </ul>
        </dd>
      </dl>
     <%--  </c:forEach> --%>
  
		</div>
<!-- /listbox -->
  <div class="dede_pages">
   <ul class="pagelist">
    
   </ul>
  </div>
  <!-- /pages -->
 </div>
 <!-- /pright-->
 <div class="pleft">
<!--纵向导航-->
  <div>
   <dl class=" tboxmenu">
    <dt><strong>博/硕士导师</strong></dt>
    <dd>
     <ul class="tboxd6">
	  <c:forEach items="${requestScope.subjectTypeList }" var="nn">                             	
			<li>	
				<a href="teacherdetailservlet?op=toTeacherType&id=${nn.id }"> ${nn.typeName} </a>
        	 </li>
     </c:forEach> 
	
     </ul>
    </dd>
   </dl>
  </div>
<!--纵向导航-->
 
   
 </div>
 <!-- /pleft -->
</div>
<!-- //二级子类下拉菜单 ，考虑SEO原因放置于底部-->
<script type="text/javascript" src="./js/dropdown.js"></script>
<ul id="dropmenu11" class="dropMenu">
	<c:forEach items="${requestScope.newsTypeList }" var="nn">  
                              	
			<li>	
				<a href="newsdetailservlet?op=toNewsType&id=${nn.id }"> ${nn.typeName} </a>
        	 </li>
     </c:forEach> 

</ul><ul id="dropmenu40" class="dropMenu">

<c:forEach items="${requestScope.coorperationTypeList }" var="nn">  
                              	
			<li>	
				<a href="coorperationdetailservlet?op=toCoorperationType&id=${nn.id }"> ${nn.typeName} </a>
        	 </li>
     </c:forEach> 

</ul><ul id="dropmenu23" class="dropMenu">

<c:forEach items="${requestScope.subjectDetailList }" var="nn">                             	
			<li>	
				<a href="subjectdetailservlet?op=toSubjectDetail&id=${nn.id }"> ${nn.subName} </a>
        	 </li>
     </c:forEach> 

</ul><ul id="dropmenu60" class="dropMenu">

<!-- <li><a href="http://jixie.hrbust.edu.cn/Html/xueke/xuekejieshao/">学科介绍</a></li>

 
 -->
</ul><ul id="dropmenu29" class="dropMenu">

 
<c:forEach items="${requestScope.workTypeList }" var="nn">  
                              	
			<li>	
				<a href="workdetailservlet?op=toWorkType&id=${nn.id }"> ${nn.typeName} </a>
        	 </li>
     </c:forEach> 
 
</ul> 
<script type="text/javascript">cssdropdown.startchrome("navMenu")</script>
<!-- //底部模板 -->
<div class="footer w960 center mt1 clear">
	<!-- 
		为了支持织梦团队的发展,请您保留织梦内容管理系统的链接信息.
		我们对支持织梦团队发展的朋友表示真心的感谢!织梦因您更精彩!
	-->
    <!--<div class="footer_left">.gotop{
	display:block;
	height:25px;
	line-height:25px;
	align;center;
	text-align:center;
	background:url(../images/top.gif) center no-repeat;
	<img src="/images/top.gif" height="25" width="65" alt="返回顶部"/></div>-->
    	<div class="gotop">
		<a href="javascript:scroll(0,0)"><span>　<br>　<br>　<br>　<br></span></a>
		</div>
	<div class="footer_body">
	
	<div class="copyright">
	<font face="Times New Roman">COPYRIGHT2016 , 哈尔滨理工大学材料科学与工程学院<!--版权所有: 哈尔滨理工大学-机械动力工程学院</br>Copyright&copy: 2014 All Rights Reserved</br>Power by Arthur--></font>
<!-- /powered -->
   </div>
   <!--<div class="footer_right"></div>-->
</div>
<!-- /footer -->

</div></body></html>