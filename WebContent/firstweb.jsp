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

 

<link href="css/jquery.slideBox.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.1min.js" type="text/javascript"></script>
<script src="js/jquery.slideBox.js" type="text/javascript"></script>
<script>
jQuery(function($){
	$('#demo1').slideBox();
	$('#demo2').slideBox({
		direction : 'top',//left,top#方向
		duration : 0.3,//滚动持续时间，单位：秒
		easing : 'linear',//swing,linear//滚动特效
		delay : 5,//滚动延迟时间，单位：秒
		startIndex : 1//初始焦点顺序
	});
	$('#demo3').slideBox({
		duration : 0.3,//滚动持续时间，单位：秒
		easing : 'linear',//swing,linear//滚动特效
		delay : 6,//滚动延迟时间，单位：秒
		hideClickBar : false,//不自动隐藏点选按键
		clickBarRadius : 10
	});
	$('#demo4').slideBox({
		hideBottomBar : true//隐藏底栏
	});
});
</script>

<style type="text/css">
p1 {text-indent: 2em
}
</style>
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
	 <a href="" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('./toFirstWeb.jsp');">设为首页</a>|<a href="javascript:window.external.AddFavorite('http://jixie.hrbust.edu.cn/','%E6%9C%BA%E6%A2%B0%E5%8A%A8%E5%8A%9B%E5%B7%A5%E7%A8%8B%E5%AD%A6%E9%99%A2')">收藏</a></div>
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
   <div class="flashnews">

  <div id="demo1" class="slideBox">
  <ul class="items">
  
    <!-- <li><a href="http://www.jq22.com/" title="材料学院"><img src="images/1.jpg"></a></li> -->
    <!-- 
    <li><a href="http://www.jq22.com/" title=""><img src="images/2.jpg"></a></li> -->
    <c:forEach items="${requestScope.topNewsDetailList }" begin="0" end="4" var="topNews">
    <li>
    <a href="topnewsdetailservlet?op=toTopNewsDetailWeb&id=${topNews.id }" title="${topNews.title }">  <img src="../cailiao/${topNews.imgUrl}"  style=" width:454px;height:290px;"></a>
    </li> 
  	</c:forEach> 
  

  </ul>
<%--   
  <c:forEach items="${requestScope.topNewsDetailList }" begin="0" end="4" var="topNews">
    <li><a href="topnewsdetailservlet?op=toTopNewsDetailWeb&id=${topNews.id }" title="${topNews.title }">  <img src="./${topNews.imgUrl}" height="300" width="300"></a></li> 
  	</c:forEach> --%>
  
</div>
  
  
  
  <!--
   size: 712px * 235px
   <script language="javascript">
linkarr = new Array();
picarr = new Array();
textarr = new Array();
var swf_width=456;
var swf_height=280;
//文字颜色|文字位置|文字背景颜色|文字背景透明度|按键文字颜色|按键默认颜色|按键当前颜色|自动播放时间|图片过渡效果|是否显示按钮|打开方式
var configtg='0xffffff|2|0x3FA61F|5|0xffffff|0xC5DDBC|0x000033|4|3|1|_blank';
var files = "";
var links = "";
var texts = "";
//这里设置调用标记
linkarr[1] = "/Html/Teacher/jixiezhizaojizidonghua/2014/0729/119.html";
picarr[1]  = "/uploads/allimg/140722/1-140H2221I1201.jpg";
textarr[1] = "李振加 教授[博导]";
linkarr[2] = "/Html/Teacher/jixieshejijizidonghua/2014/0801/128.html";
picarr[2]  = "/uploads/allimg/140817/1-140QGJ222a2.jpg";
textarr[2] = "张嘉振 教授[博导]";
linkarr[3] = "/Html/Research/keyanjigou/2014/0812/173.html";
picarr[3]  = "/uploads/allimg/140812/1-140Q2152044D9.jpg";
textarr[3] = "机电液一体化技术与产品开发研究";

for(i=1;i<picarr.length;i++){
if(files=="") files = picarr[i].replace("-lp","");
else files += "|"+picarr[i].replace("-lp","");
}
for(i=1;i<linkarr.length;i++){
if(links=="") links = linkarr[i];
else links += "|"+linkarr[i];
}
for(i=1;i<textarr.length;i++){
if(texts=="") texts = textarr[i];
else texts += "|"+textarr[i];
}
document.write('<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="'+ swf_width +'" height="'+ swf_height +'">');
document.write('<param name="movie" value="/templets/JixieTemplets/images/bcastr3.swf"><param name="quality" value="high">');
document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
document.write('<param name="FlashVars" value="bcastr_file='+files+'&bcastr_link='+links+'&bcastr_title='+texts+'&bcastr_config='+configtg+'">');
document.write('<embed src="/templets/JixieTemplets/images/bcastr3.swf" wmode="opaque" FlashVars="bcastr_file='+files+'&bcastr_link='+links+'&bcastr_title='+texts+'&bcastr_config='+configtg+'&menu="false" quality="high" width="'+ swf_width +'" height="'+ swf_height +'" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />'); document.write('</object>');
</script><object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" height="280" width="456"><param name="movie" value="./images/bcastr3.swf"><param name="quality" value="high"><param name="menu" value="false"><param name="wmode" value="opaque"><param name="FlashVars" value="bcastr_file=/uploads/allimg/140722/1-140H2221I1201.jpg|/uploads/allimg/140817/1-140QGJ222a2.jpg|/uploads/allimg/140812/1-140Q2152044D9.jpg&amp;bcastr_link=/Html/Teacher/jixiezhizaojizidonghua/2014/0729/119.html|/Html/Teacher/jixieshejijizidonghua/2014/0801/128.html|/Html/Research/keyanjigou/2014/0812/173.html&amp;bcastr_title=李振加 教授[博导]|张嘉振 教授[博导]|机电液一体化技术与产品开发研究&amp;bcastr_config=0xffffff|2|0x3FA61F|5|0xffffff|0xC5DDBC|0x000033|4|3|1|_blank"><embed src="./index_files/bcastr3.swf" wmode="opaque" flashvars="bcastr_file=/uploads/allimg/140722/1-140H2221I1201.jpg|/uploads/allimg/140817/1-140QGJ222a2.jpg|/uploads/allimg/140812/1-140Q2152044D9.jpg&amp;bcastr_link=/Html/Teacher/jixiezhizaojizidonghua/2014/0729/119.html|/Html/Teacher/jixieshejijizidonghua/2014/0801/128.html|/Html/Research/keyanjigou/2014/0812/173.html&amp;bcastr_title=李振加 教授[博导]|张嘉振 教授[博导]|机电液一体化技术与产品开发研究&amp;bcastr_config=0xffffff|2|0x3FA61F|5|0xffffff|0xC5DDBC|0x000033|4|3|1|_blank&amp;menu=" false"="" quality="high" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" height="280" width="456"></object>
  </div> --></div>
<!-- /flashnews -->  
	   <div class="listboxtop">
<dl class="tbox light">
	<dt><!--<div class="news_title index_news_bg">-->
	<strong><a href="./subjectdetailservlet?op=listAll">学科介绍</a></strong>
	<span class="more"><a href="./subjectdetailservlet?op=listAll">更多…</a></span><!--</div> --> </dt>
		<dd>
		<ul class="d1 ico3">
		<!-- <li><a href="http://jixie.hrbust.edu.cn/Html/Teaching/zhuanyejieshao/2014/1231/309.html">机械设计制造及其自动化</a></li> -->
<c:forEach items="${requestScope.subjectDetailList }" var="nn">                             	
			<li>	
				<a href="subjectdetailservlet?op=toSubjectDetail&id=${nn.id }"> ${nn.subName} </a>
        	 </li>
     </c:forEach> 

	 </ul>
	</dd>
	 </dl>
	 </div>
	 <!--顶部内容结束-->

	   <div class="listboxright">
<dl class="tbox light">
	<dt><!--<div class="news_title index_news_bg">-->
	<strong><a href="./coorperationdetailservlet?op=toCoorperationType&id=1">科研合作与交流</a></strong>
	<span class="more"><a href="./coorperationdetailservlet?op=toCoorperationType&id=1">更多…</a></span><!--</div> --> </dt>
		<dd>
		<ul class="d1 ico3">

<c:forEach items="${requestScope.hezuojiaoliu }" var="hezuojiaoliu" begin="0" end="9">
 <c:if test="${hezuojiaoliu.pass eq 0}"><!-- 判断审核是否通过 --> 
<li><a href="coorperationdetailservlet?op=toCoorperationDetail&id=${hezuojiaoliu.id }">${hezuojiaoliu.title }</a></li>
  </c:if>  
</c:forEach>


	 </ul>
	</dd>
	 </dl>
	 </div>

	 
   <div class="listboxleft">
<dl class="tbox light">
	<dt><!--<div class="news_title index_news_bg">-->
	<strong><a href="./newsdetailservlet?op=toNewsType&id=3">通知公告</a></strong>
	<span class="more"><a href="./newsdetailservlet?op=toNewsType&id=3">更多…</a></span><!--/div --> </dt>
		<dd>
		<ul class="d1 ico3">
    
    

<c:forEach items="${requestScope.tongzhigonggao }" var="xueyuandongtai"><!-- begin="0" end="7" -->
<c:if test="${xueyuandongtai.pass eq 0}"><!-- 判断审核是否通过 -->
<li>
<table class="MsoTableClassic1" border="0" cellpadding="0" cellspacing="0" width="100%"><tbody>
 <tr>
  <td style="width:80.0%;" width="80%">
  <p><a href="newsdetailservlet?op=toNewsDetail&id=${xueyuandongtai.id }">${xueyuandongtai.title }</a></p>
  </td>
  <td style="width:20.0%;" width="20%">
  <p style="text-align:right;padding:0 5.4px 0 0" align="right">${xueyuandongtai.publishTime }</p>
  </td>
 </tr>
</tbody></table>
</li>
</c:if>
</c:forEach> 


	 </ul>
	</dd>
	 </dl>
	 </div>


<!--右侧内容--> </div>
 	<!-- /listbox -->
 	<!-- /pleft -->
<div class="pleft">
<div class="commend mt2">
	<dl class="tbox light">
	<dt class="light"><strong>学院动态</strong></dt>
	<dd class="light">
	<ul class="d4">
	<p style="line-height: 150%">
	<marquee behavior="scroll" align="absbottom" direction="up" scrollamount="2" scrolldelay="0" onmouseover="this.stop()" onmouseout="this.start()" height="240" width="235">
<c:forEach items="${requestScope.xueyuandongtai }" var="xueyuandongtai"><!-- begin="0" end="7" -->
<c:if test="${xueyuandongtai.pass eq 0}"><!-- 判断审核是否通过 -->
<li><a href="newsdetailservlet?op=toNewsDetail&id=${xueyuandongtai.id }" target="_blank" class="pix12h1_line24">${xueyuandongtai.title }<span>${xueyuandongtai.publishTime }</span></a>

<p1>${xueyuandongtai.content }</p1>

</li>
</c:if>
</c:forEach>

</marquee>
	</p>
	</ul>
	</dd>
	</dl>
	</div>
<!--<div class="smallimage"><a href="http://peapea1780.244b.net222-3.net/Html/Organization/phone/"><img src="/templets/JixieTemplets/image/phones.png" width="240" height="120" alt="机械动力工程学院"/></a></div>-->
<!--友情链接开始-->
<dl class="smallimage"><img src="./images/yuanxun.png" height="80" width="240"></dl>

	   <dl class="tbox light">
<dt><strong>友情链接</strong></dt>
<!---->
<dd id="flink_9" style="text-indent:1em;"><ul class="f5"><li><a href="http://www.hrbust.edu.cn/" target="_blank">哈尔滨理工大学</a> </li><li><a href="http://www.hit.edu.cn/" target="_blank">哈尔滨工业大学</a></li>
<li><a href="http://www.hlje.net"  target="_blank">黑龙江省教育厅</a></li></ul></dd>
<!---->
</dl>

	 <!-- /flink -->
 <!-- /pleft --></div>
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
<!-- 
<li><a href="./reg.jsp">学生信息采集</a></li> -->
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
	background:url(./images/top.gif) center no-repeat;
	<img src="./images/top.gif" height="25" width="65" alt="返回顶部"/></div>-->
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
<p><a href="./log.jsp">后台入口</a></p>
<!-- /footer -->

</div></div></body></html>