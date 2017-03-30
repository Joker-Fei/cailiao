<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'EN_Home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
	<!--
		.STYLE {/*普通文字 */
			font-size: 16px;		/* 字体大小 */
		}
		.STYLE4 {/*底部声明 */
			font-size: 13px;		/* 字体大小 */
			font-family:"Times New Roman";	/* 字体 */
		}
		.STYLE1 {/*主标题 */
			letter-spacing: -1px;	/* 字间距 */
			word-spacing: 1px;		/* 词间距 */
			line-height:10px;		/* 行高 */
			font-family:"Agency FB";	/* 字体 */
			font-weight: 900;		/* 字体粗细 */
			font-size: 40px;		/* 字体大小 */
			text-transform: uppercase;/*转大写 */
			color:#11264f;
		}
		.STYLE2 {/*副标题 */
			letter-spacing: -1px;	/* 字间距 */
			word-spacing: 1px;		/* 词间距 */
			line-height:10px;		/* 行高 */
			font-family:"Birch Std";	/* 字体 */
			font-weight: 900;		/* 字体粗细 */
			font-size: 45px;		/* 字体大小 */
			text-transform: uppercase;/*转大写 */
			color:#694d9f;
		}
		.STYLE3 {/*一级菜单 */
			letter-spacing: -1px;	/* 字间距 */
			word-spacing: 2px;		/* 词间距 */
			line-height: 1px;		/* 行高 */
			font-family: "Times New Roman";	/* 字体 */
			font-weight: bold;		/* 字体粗细 */
			font-size: 20px;		/* 字体大小 */
			text-transform: uppercase;/*转大写 */
			text-decoration: none; /*修饰：无修饰 */
			color:#694d9f;
		}
	-->
	</style>
  </head>
  
<body bgcolor="#ffffff" style = "background-image:url(images/background.png); background-repeat: repeat-x">
	<table align="center" border="0" cellpadding="0" cellspacing="0" >
	<tbody>
		<tr bgcolor="" style = "background-image:url(images/biaoti-1.png);background-size: contain; background-repeat: no-repeat; background-position: center left;">
	  		<!-- <td colspan="3" id="navigation" class="navText" nowrap="nowrap" height="36"><img src="images/biaoti.gif" height="200" width="1200"></td> -->
	  		<td colspan="6" align="right" height="180" width="1202">
	  			<p class = "STYLE1">Harbin University</p><p class = "STYLE1">of Science and Technology<br></p>
	  			<p class = "STYLE2"> School of Material SCience &amp; Engineering</p>
	  		</td>
	  	
  		</tr>
  		
		<tr bgcolor="#f36c21">
			<td nowrap="nowrap" width="7">&nbsp;</td>
			<td colspan="3" width="" id="navigation" class="STYLE3" nowrap="nowrap" height="36">
				<a style="text-decoration:none" href="EN_Home.jsp" target="">HOME</a>&nbsp;&nbsp;&nbsp;
      			<a style="text-decoration:none" href="servlet/intrFindServlet?web_type=web" target="mainFrame">INTRODUCTION</a>&nbsp;&nbsp;&nbsp; 
      			<a style="text-decoration:none" href="jsp/en_MEMBERS.jsp" target="mainFrame">MEMBERS</a>&nbsp;&nbsp;&nbsp;
      			<a style="text-decoration:none" href="servlet/dmFindAllServlet?web_type=web" target="mainFrame">DEPARTMENTS</a>&nbsp;&nbsp;&nbsp;
      			<a style="text-decoration:none" href="servlet/addResearch?web_type=web" target="mainFrame">RESEARCH</a>&nbsp;&nbsp;&nbsp;
      			<a style="text-decoration:none" href="servlet/modifEducation?web_type=web" target="mainFrame">EDUCATION</a>&nbsp;&nbsp;&nbsp;
      			<a style="text-decoration:none" href="servlet/modifCuntactus?web_type=web" target="mainFrame">CONTACT&nbsp;&nbsp;US</a>
      			
      			
      		</td>
      		<td width="7"><a style="text-decoration:none" href="javascript:history.go(-1)" target="">[back]</a>&nbsp;&nbsp;</td>
	  		<td width="7"><a style="text-decoration:none" href="servlet/LoginUIServlet" target="_blank">[login]</a>&nbsp;&nbsp;</td>
			
		</tr>
		
	 	<tr bgcolor="#375830">
			<td colspan="6"><img src="" alt="" border="0" height="3" width="1"></td>
		</tr>
		
		
		<tr bgcolor="">
			<td colspan="6">
				<iframe src="jsp/en_HOME.jsp" scrolling="no" name="mainFrame" frameborder="0" marginheight="0" marginwidth="0" height="590" width="100%"></iframe>
			</td>
		</tr>
	
	
	<tr bgcolor="">
		<td colspan="6"><br></td>
	</tr>
	
	<tr bgcolor="#11264f">
		<td colspan="6"><img src="images/mm_spacer.png" alt="" border="0" height="2" width="1"></td>
	</tr>
	<tr>
		<td colspan="6" height=""><p class="STYLE4" align="center">Harbin University of Science &amp; Technology School of Material SCience &amp; Engineering <br>All Rignts Reserved  &nbsp;&nbsp;&nbsp;&nbsp; COPYRIGHT&nbsp;2016</p>	  
	  	</td>
	</tr>
	<tr bgcolor="#11264f">
		<td colspan="6"><img src="images/mm_spacer.png" alt="" border="0" height="2" width="1"></td>
	</tr>
	<!-- <tr>
		<td width="7">&nbsp;</td>
		<td width="493">&nbsp;</td>
		<td width="50">&nbsp;</td>
		<td width="659">&nbsp;</td>
		<td width="7">&nbsp;</td>
		<td width="7">&nbsp;</td>
	</tr> -->
	</tbody>
</table>
</body>
</html>
