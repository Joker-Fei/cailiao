<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
      <body style="text-align: center;">
        <form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
            <table width="60%" border="1">
                <tr>
                    <td>用户名</td>
                    <td>
                        
                        <input type="text" name="userName" value="${formbean.userName}">${formbean.errors.userName}
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>
                        <input type="password" name="userPwd" value="${formbean.userPwd}">${formbean.errors.userPwd}
                    </td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td>
                        <input type="password" name="confirmPwd" value="${formbean.confirmPwd}">${frombean.errors.confirmPwd}
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td>
                         <input type="text" name="email" value="${formbean.email}">${formbean.errors.email}
                    </td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td>
                        <input type="text" name="birthday"value="${formbean.birthday}">${formbean.errors.birthday}
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" value="清空">
                    </td>
                    <td>
                        <input type="submit" value="注册">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
