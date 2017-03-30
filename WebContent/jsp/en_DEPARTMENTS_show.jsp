<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'en_DEPARTMENTS_show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.STYLE1 {/*一级标题 */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			line-height:1px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			font-weight: 900;		/* 字体粗细 */
			font-size: 30px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			color:#c88400;
		}
	</style>
  </head>
  
  <body>
	<div id="div1" style=" width:100%; height:600px; overflow-y:scroll;">
		<table align="center" border="0" width="100%" height="800px"
			cellpadding="0" cellspacing="0">
			<tr>
				<td colspan="3" height="20px">&nbsp;</td>
			</tr>
			<tr>
				<td align="center" class="STYLE1" colspan="3" height="20px">DEPARTMENTS</td>
			</tr>
			<tr>
				<td width="8">&nbsp;</td>
				<td valign="top">
					${dmIntroduce}
				</td>

				<td width="8">&nbsp;</td>
			</tr>

			<tr>
				<td colspan="3" height="20px">&nbsp;</td>
			</tr>
		</table>
	</div>
</body>
</html>
