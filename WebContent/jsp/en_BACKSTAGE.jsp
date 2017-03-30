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
    <title>首页</title>
     <script type="text/javascript">
    	function doLogout(){
    		//访问LogoutServlet注销当前登录的用户
    		window.location.href="${pageContext.request.contextPath}/servlet/LogoutServlet";
    	}
    </script>
    <style>
    .STYLE {/* */
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
		.STYLE1 {/*user*/
			letter-spacing: -1px;	/* 字间距 */
			word-spacing: 2px;		/* 词间距 */
			line-height: 1px;		/* 行高 */
			font-family: "Times New Roman";	/* 字体 */
			font-weight: bold;		/* 字体粗细 */
			font-size: 20px;		/* 字体大小 */
			text-transform: uppercase;/*转大写 */
			text-decoration: none; /*修饰：无修饰 */
			color:#ef5b9c;
		}
	</style>
  </head>
  
  <body>
	<h1>哈尔滨理工大学材料学院</h1>
	
		
	<hr/>
	<c:if test="${user==null}">
	
				<a href="${pageContext.request.contextPath}/servlet/LoginUIServlet">登陆</a>

	</c:if>
	<c:if test="${user!=null}">
	<table width="100%">
		<tr bgcolor="">
			<td align="left" nowrap="nowrap" width="200" class="STYLE1">欢迎您：${user.userName}</td>
			
			<td align="left" colspan="" width="" id="navigation" class="STYLE" nowrap="nowrap" height="36">
			<a style="text-decoration:none" href="${pageContext.request.contextPath}/servlet/modifAdminServlet?name=${user.id}" target="">[修改密码]</a></td>
      		<td align="right" width="" class="STYLE"></td>
      		<td align="right" width="" class="STYLE"><a style="text-decoration:none" href="javascript:history.go(-1)" target="">[后退]</a>&nbsp;&nbsp;<a style="text-decoration:none" href="${pageContext.request.contextPath}/servlet/LogoutServlet" target="">[退出登陆]</a></td>
      		<!-- <td><input type="button" value="退出登陆" onclick="doLogout()"></td> -->
	  	</tr>
	</table>
	<iframe src="${pageContext.request.contextPath }/jsp/Backstage/en_BACKSTAGE_down.jsp" scrolling="no" name="houtai_mainFrame" frameborder="0" marginheight="0" marginwidth="0" height="700" width="100%">
	</iframe>
	</c:if>
	<hr/>
	
	
</body>
</html>
