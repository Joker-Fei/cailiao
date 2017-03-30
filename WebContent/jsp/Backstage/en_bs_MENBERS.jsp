<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>
<%-- <%@ include file="./base.jsp"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专业查询</title>
<script src="../../ckeditor/ckeditor.js"></script>
<script src="../../ckfinder/ckfinder.js"></script>
<script type="text/javascript">

function formCheck33()
   {   
     
     if(document.form1.dmName.value==''){   
   		alert("请填写搜索信息");   
   		document.form1.dmName.focus();   
   		return false;
   	}  
 }
    
</script>
<style type="text/css">
		.STYLE {/* */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			line-height:20px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			font-weight: 700;		/* 字体粗细 */
			font-size: 15px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			//text-indent: 2em;		/* 缩进 */
			text-align: justify;		/* 对齐方式 */
			color:#0c212b;
		}
		.STYLE1 {/* */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			//line-height:10px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			//font-weight: 700;		/* 字体粗细 */
			font-size: 12px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			//text-indent: 2em;		/* 缩进 */
			//text-align: justify;		/* 对齐方式 */
			//color:#0c212b;
		}
	</style>
	<script type="text/javascript">
    	function doadd(){
    		window.location.href="${pageContext.request.contextPath }/jsp/Backstage/en_bs_DEPARTMENTS.jsp";
    	}
    </script>
</head>
<body style=" width:1024; height:100%; overflow: auto;">
<form action="" method="post" name="form1" onsubmit="return formCheck33();" id="form1">
	<table  width="800" height="100%" border="0px" cellpadding="0" align="center" cellspacing="0" >
		<tr >
			<td width="110" height="10">
				<a>教师名称</a>
			</td>
			<td width="" height="10">
				<input type="text" size="80" name="dmName">
			</td>
			<td width="" height="10">
				<input type="submit" value="查找" />
				<input type="button" value="添加" onClick="doadd();"/>
			</td>
		</tr>
	</table>
		
</form>
	<div  style="visibility: visible; width:100%; height:580px; overflow-y:scroll;">
		<%@ page import= "com.EN.entity.*"%>
		<%@ page import= "java.util.List" %>
		<%
			List<menbers> lsmen = (List<menbers>)request.getAttribute("lsmen");
			for(menbers i:lsmen){
		%>
		<a style="text-decoration:none" href="${pageContext.request.contextPath}/menShowServlet?id=<%= i.getId()%>" target="mainFrame">
		<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/sunfenglian.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>Fenglian Sun</strong></td>
				<td width="150px"><strong>[Doctoral Supervisor]</strong></td>
				<td><strong>[Material Forming and Control Engineering]</strong></td>

			</tr>
			<tr >
				<td colspan="3" height="130px">
					<p>Female,  born in Oct. 1957, Ph.D., Professor, Ph.D. Supervisor, Dean.<br>
		  			<strong>Educational  Background</strong><br/>
		    Mar. 1978  - Jan. 1982, Harbin Institute of Technology, majoring in Welding, Bachelor.<br />
		    Sept.  1985 - Apr. 1988, Harbin University of Science and Technology, majoring in Material  Science and Engineering, Master.<br />
		    Mar. 1999  - Apr. 2002, Harbin Institute of Technology, majoring in Materials Engineering,  Ph.D. <br />
		    June 2007  - Dec. 2007, The Dutch NXP Semiconductor Co., TUDelft University, Senior  Visiting Scholar.
		  	</p>
				</td>
			</tr>
		</table>
		</a><br>
			<% 
			}
		%>
		
	</div>

</body>
</html>