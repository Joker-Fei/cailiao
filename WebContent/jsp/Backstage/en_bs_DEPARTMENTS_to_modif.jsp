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
<div>
<form action="${pageContext.request.contextPath}/servlet/dmFindAllServlet" method="post" name="form1" onsubmit="return formCheck33()" id="form1">
	<table  width="800" height="100%" border="0px" cellpadding="0" align="center" cellspacing="0" >
		<tr >
			<td width="110" height="10">
				<a>院系/专业名称</a>
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
		<table width="800" height="100%" border="0px" cellpadding="0" align="center" cellspacing="0" >
			<tr>
				<td>
				<div style="width:100%; height:650px; overflow-y:scroll;">
		
		<table width="100%" height="" border="1px" cellpadding="0" align="center" cellspacing="0" >
		<%@ page import= "com.EN.entity.*"%>
		<%@ page import= "java.util.List" %>
		<%
			List<departments> lsdm = (List<departments>)request.getAttribute("lsdm");
			for(departments i:lsdm){
				%>
			<tr>
				<td class="STYLE">
					<a style="text-decoration:none" href="${pageContext.request.contextPath}/servlet/dmFindServlet?dmName=<%=i.getDmName()%>"><%=i.getDmName() %></a>
				</td>
				<td width="50" align="right">
					<a style="text-decoration:none" href="${pageContext.request.contextPath}/servlet/dmDelServlet?id=<%=i.getId()%>">[删除]</a>
				</td>
			</tr>
			
			<tr>	
				<td colspan="2" class="STYLE1">
				<div id="div0" style="width:100%; height:150px; overflow-y:scroll;">
					<%=i.getDmIntroduce() %>
				</div>
				</td>
			</tr>
			<% 
			}
		%>
		</table>
		</div>
				</td>
			</tr>
		</table>
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
</div>
</body>
</html>