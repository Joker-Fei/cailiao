<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'en_MENBERS_show.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
    	function doadd(){
    		window.location.href="${pageContext.request.contextPath }/jsp/Backstage/en_bs_MENBERS_add.jsp";
    	}

function formCheck33()
   {   
     
     if(document.form1.menName.value==''){   
   		alert("请填写姓名");   
   		document.form1.menName.focus();   
   		return false;
    	}
    }
    </script>
</head>

<body>
	<form action="${pageContext.request.contextPath}/servlet/menFundServlet" onsubmit="return formCheck33()" name="form1">
	<table  width="800" height="20px" border="0px" cellpadding="0" align="center" cellspacing="0" >
		<tr >
			<td width="110" height="10">
				<a>教师姓名</a>
			</td>
			<td width="" height="10">
				<input type="text" size="80" name="menName">
			</td>
			<td width="" height="10">
				<input type="submit" value="查找" />
				<input type="button" value="添加" onClick="doadd();"/>
		</tr>
	</table>
	
	<div  style="visibility: visible; width:100%; height:580px; overflow-y:scroll;">
		<%@ page import= "com.EN.entity.*"%>
		<%@ page import= "java.util.List" %>
		<%
		List<menbers> lsmen = (List<menbers>)request.getAttribute("lsmen");
		if(lsmen!=null){
		for(menbers i:lsmen){%>
			
	
				<table border="1" width="100%">
				<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/<%=i.getMbPhoto()%>"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong><%=i.getMbName() %></strong></td>
				<td width="150px"><strong>[<%=i.getMbClass() %>]</strong></td>
				<td width="500px"><strong>[<%=i.getMbDepartment() %>]</strong></td>
				<td width="50px">
					<a style="text-decoration:none" href="${pageContext.request.contextPath }/servlet/menModifServlet?id=<%= i.getId()%>">
					[修改]</a>
				</td>
				<td width="50px">
					<a style="text-decoration:none" href="${pageContext.request.contextPath }/servlet/menDeleteServlet?id=<%= i.getId()%>">
					[删除]</a>
				</td>
				</tr>
				<tr>
				<td colspan="5" >
					<div style="width:100%; height:130px; overflow:hidden;">
						<%=i.getMbIntroduce() %>
					</div>
				</td>
				
				</tr>
				</table>
			
	<% }} %>
	</div>
	<%  
        HttpSession sess = request.getSession();  
        String message = (String)sess.getAttribute("Msg");  
    	if(message == null||message == ""){  
    %>  
    <%  
    	}else{  
    %>  
             <script type="text/javascript">  
                    alert("<%=message%>");  
            </script>  
    <%  
        	sess.setAttribute("Msg", "");  
    	}  
 	%>
 	</form>
</body>
</html>
