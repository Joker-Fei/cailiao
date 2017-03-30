<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>材料科学与工程学院</title>
<meta name="description" content="">
<meta name="keywords" content="">
<link href="./images/yuanhui.png" rel="shortcut icon"/>
<link href="./css/dedecms.css" rel="stylesheet" media="screen" type="text/css">
<link href="./css/page.css" rel="stylesheet" media="screen" type="text/css">
<link href="./css/layout.css" rel="stylesheet" media="screen" type="text/css">
<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/view.php?aid=">
<script type="text/javascript">if(window.location.toString().indexOf('pref=padindex') != -1){}else{if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){if(window.location.href.indexOf("?mobile")<0){try{if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){window.location.href="/m/view.php?aid=";}else if(/iPad/i.test(navigator.userAgent)){}else{}}catch(e){}}}}</script>
<script language="javascript" type="text/javascript" src="./js/dedeajax2.js"></script>
<script language="javascript" type="text/javascript" src="./js/j.js"></script>
<script language="javascript" type="text/javascript" src="./js/pic_scroll.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<script language="javascript" type="text/javascript">
	$(function(){
		$("a[_for]").mouseover(function(){
			$(this).parents().children("a[_for]").removeClass("thisclass").parents().children("dd").hide();
			$(this).addClass("thisclass").blur();
			$("#"+$(this).attr("_for")).show();
		});
		$("a[_for=uc_member]").mouseover();
		$("a[_for=flink_1]").mouseover();
	});
	
	function CheckLogin(){
	  var taget_obj = document.getElementById('_userlogin');
	  myajax = new DedeAjax(taget_obj,false,false,'','','');
	  myajax.SendGet2("/member/ajax_loginsta.php");
	  DedeXHTTP = null;
	}
</script>
</head>
<body class="index">
<div class="header_top">  
    <div class="w960 center">  
     <span class="time">欢迎访问</span><span class="time">哈尔滨理工大学-材料科学与工程学院！</span>
     <div class="toplinks">
	 <span id="time">2015/11/21 下午8:11:29 星期六</span> 
<!-- <a href="http://jixie.hrbust.edu.cn/plus/heightsearch.php" target="_blank">搜索</a>| -->
	 <!--<a href="/Data/sitemap.html" target="_blank">网站地图</a>|
	 <a href="/tags.php">TAG标签</a>
	 <a href="/data/rssmap.html" class="rss">RSS订阅</a>-->
</div> 
</div>
<div class="header">
	<div class="top w960 center">
      <div class="title">
        <a href="#"><img src="./images/logo.gif" alt="材料科学与工程学院" height="150" width="960"></a>
      </div>
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
      	
      	<li><a href="http://jixie.hrbust.edu.cn/Html/Teacher/" rel="dropmenu29"><span>学生工作</span></a></li>
      	
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
	<div class="place"><strong>当前位置:</strong> <a href="./toFirstWeb.jsp">主页</a> &gt; <a>学院概况</a></div>
<!-- /place -->
	<div class="viewbox">
		<div class="title"><h2><a style="color:#227700;text-decoration:none;">学院概况</a></h2></div>
<!-- /title -->
  <div class="info">  <small>来源:</small>材料科学与工程学院<small>作者:</small><!-- --><%--  ${requestScope.newsDetail.author } --%> 管理员<script src="introduce_files/count.htm" type="text/javascript" language="javascript"></script></div>
  <!-- /info -->
<!--  -->
		<div class="content">
		<table width="100%">
		<tbody><tr>
		<td>
		<style type="text/css">
p{text-indent: 2em;}</style>
<!-- <h3>  1111111111</h3> -->
<p class="MsoNormal" style="text-align: justify">
材料科学与工程学院于一九九八年由原电工材料系和材料科学与工程系的部分专业合并组建而成。学院设有高分子材料系、金属材料系、材料成型及控制工程系、无机非金属材料系、材料分析测试中心以及近二十个研究所、研究室。我院现有教职工89人，新世纪百千万人才工程国家级人选1人，龙江学者2人，博士生导师11人，硕士生导师57人，师资队伍中已获博士学位54人，45岁以下的青年教师中有博士学位和在读博士占87.7％，学院目前在校本科生1604人，博士、硕士研究生366人。
    学院现有材料科学与工程一级学科博士学位授予权及博士后研究流动站。材料学、材料加工工程、高分子化学与物理（理学）、材料物理与化学、高电压与绝缘技术（新型绝缘材料方向）5个学科具有硕士学位授予权，同时具有材料工程领域工程硕士授予权和材料学高校教师硕士授予权。学院拥有材料学和材料物理与化学省重点学科、装备制造省重点学科群、校企共建铝镁合金材料省重点实验室、材料研究与应用省高校重点实验室。 
    学院现有高分子材料与工程（国家特色专业）、金属材料工程（国家特色专业）、材料成型及控制工程（省重点专业）、无机非金属材料工程（省重点专业）四个本科专业。学院拥有良好的教学、科研、产品中试条件，大型仪器设备有扫描电镜、X射线衍射仪、FT-IR光谱仪、数码金相显微镜、直读光谱仪、凝胶渗透色谱仪、热重及差示扫描量热仪等，为科学研究与人才培养提供了有利条件。
    学院重视与国内外的学术交流与合作。同日、英、荷、德、意、澳大利亚等国的大学和研究机构建立了密切的学术交流与长期的合作关系，聘请了国际著名专家为我院的客座教授，并派出多名教师出国访问与合作研究。为服务地方经济与黑龙江省部分企业如：中国第一重型、东轻公司、哈飞集团、东安集团、黑化、哈轴等单位建立了良好的合作关系，在东轻和原哈航集团建立了研究生培养创新基地。
    科研方面在金属材料质量快速检测与优化控制、厚大断面球墨铸铁、轻合金材料及制造工艺、精密焊接新材料及新工艺、高分子电介质材料及其表征技术、聚合物基复合材料、陶瓷材料、光纤与光缆材料、模具CAD及数值模拟技术等研究领域取得了较突出的成绩。2010年以来共承担国家自然科学基金、国际合作、省市科技攻关及企业项目270余项，发表学术论文610余篇，其中高影响因子的学术论文360余篇，专利66项。
材料学院办学理念科学、办学思路清晰，正在朝着国内知名材料学院的目标发展。

</p>

		</td>
		</tr>
		</tbody></table>
		</div>
  <div class="dede_pages">
   <ul class="pagelist">
    
   </ul>
  </div>
  <!-- /pages -->
  
  <!-- //分享代码结束 -->
  <div class="boxoff"> <strong>------分隔线----------------------------</strong> </div>
  <div class="handle">
   <div class="context">
    <ul>
     <li></li>
     <li></li>
    </ul>
   </div>
   <!-- /context -->
   <div class="actbox">
    <ul>
     <li id="act-fav"><a href="http://jixie.hrbust.edu.cn/plus/stow.php?aid=11" target="_blank">收藏</a></li>
     <!--li id="act-err"><a href="/plus/erraddsave.php?aid=11&title=学院概况" target="_blank">挑错</a></li>
     <li id="act-pus"><a href="/plus/recommend.php?aid=11" target="_blank">推荐</a></li-->
     <li id="act-pnt"><a href="#" onclick="window.print();">打印</a></li>
    </ul>
   </div>
   <!-- /actbox -->
  </div>
  <!-- /handle -->
 </div>
 <!-- /viewbox -->
 <!-- //AJAX评论区 -->
</div>
<!-- //右边内容结束 -->
<!-- //左边内容开始 -->
 <div class="pleft">
<!--纵向导航-->
  <div>
   <dl class=" tboxmenu">
    <dt><strong>栏目列表</strong></dt>
    <dd>
     <ul class="tboxd6">
	
	<c:forEach items="${requestScope.newsTypeList }" var="nn">  
                              	
			<li>	
				<a href="newsdetailservlet?op=toNewsType&id=${nn.id }"> ${nn.typeName} </a>
        	 </li>
     </c:forEach> 
	
     </ul>
    </dd>
   </dl>
  </div>
<!--纵向导航-->
  <!-- <div class="commend">
   <dl class="tbox light">
    <dt class='light'><strong>推荐内容</strong></dt>
    <dd class='light'>
     <ul class="d4">
      <li><a href="/Html/Organization/news/2015/0320/335.html">机械动力工程学院2012级硕士研究生进行学位论</a>
       <p>机械动力工程学院 2012 级硕士研究生学位论文答辩于 2015 年 3 月 16 日开始。本次答...</p>
      </li>

     </ul>
    </dd>
   </dl>
  </div>-->
  <!-- /commend -->
 <!--  <div class="hot mt1 light">
   <dl class="tbox">
    <dt class="light"><strong>热点内容</strong></dt>
    <dd class="light">
     <ul class="c1 ico2">
      <li><a href="http://jixie.hrbust.edu.cn/Html/Organization/tzgg/2014/1127/289.html">机械动力工程学院2015年硕博连读</a></li>
<li><a href="http://jixie.hrbust.edu.cn/Html/Organization/tzgg/2015/0525/344.html">机械动力工程学院2015年博士研究</a></li>
<li><a href="http://jixie.hrbust.edu.cn/Html/Organization/tzgg/2015/0414/338.html">机械学院2014-2015年度第一学期</a></li>
<li><a href="http://jixie.hrbust.edu.cn/Html/Organization/tzgg/2015/0424/342.html">学院2015届优秀本科毕业生公示名</a></li>
<li><a href="http://jixie.hrbust.edu.cn/Html/Organization/tzgg/2015/0111/327.html">关于做好2015届硕士研究生学位授</a></li>

     </ul>
    </dd>
   </dl>
  </div> -->
 </div>
 <!-- /pleft -->
</div>
<!-- //二级子类下拉菜单 ，考虑SEO原因放置于底部-->
 
 
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
	<font face="Times New Roman">
COPYRIGHT2016 , 哈尔滨理工大学材料科学与工程学院<!--版权所有: 哈尔滨理工大学-机械动力工程学院</br>Copyright&copy: 2014 All Rights Reserved</br>Power by Arthur--></font>
<!-- /powered -->
   </div>
   <!--<div class="footer_right"></div>-->
</div>
<!-- /footer -->


</div></body></html>