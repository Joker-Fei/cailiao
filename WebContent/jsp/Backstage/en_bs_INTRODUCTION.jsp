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
<title>添加学院介绍</title>
<script src="../../ckeditor/ckeditor.js"></script>
<script src="../../ckfinder/ckfinder.js"></script>
<script type="text/javascript">

function formCheck33()
   {   
     
     if(document.form1.dmName.value==''){   
   		alert("请填写名称");   
   		document.form1.dmName.focus();   
   		return false;
   	}  
 	else if(document.form1.dmIntroduce.value==null){   
   		alert("内容不允许为空！");   
   		document.form1.dmIntroduce.focus();   
   		return false;
   	}  
 }
    
</script>
</head>
<body>

<div>
	<div> 
<form action="${pageContext.request.contextPath}/servlet/intrAddServlet" method="post" name="form1" onsubmit="return formCheck33();" id="form1">
	
	<table class="right-table" width="70%" height="90%" border="0px" cellpadding="0" align="center" cellspacing="0" >
		
		<tr >
			<td colspan="2"><a>学院介绍</a></td>
		</tr>
		<tr>
		 <td colspan="2">
				<textarea   rows="8" cols="15" name="intdIntroduce"></textarea>
				<script type="text/javascript">
			    	var editor =CKEDITOR.replace('intdIntroduce', {
						uiColor: '#FFFFFF',
						filebrowserUploadUrl : '${path}/ckeditor/uploader?Type=File',
						filebrowserImageUploadUrl : '${path}/ckeditor/uploader?Type=Image',
						filebrowserFlashUploadUrl : '${path}/ckeditor/uploader?Type=Flash'
					});
			    	CKFinder.setupCKEditor( editor, 'ckfinder/' );
			    </script>
			    
			</td> 
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="添加" />
			</td>
		</tr>
	</table>
</form>
 </div></div>
</body>
</html>