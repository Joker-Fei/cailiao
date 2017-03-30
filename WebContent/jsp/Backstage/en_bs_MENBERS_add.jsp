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
<title>添加教师</title>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/ckfinder/ckfinder.js"></script>
<script type="text/javascript">

function formCheck33()
   {   
     
     if(document.form1.mbName.value==''){   
   		alert("请填写姓名");   
   		document.form1.mbName.focus();   
   		return false;
   	}  
 	else if(document.form1.mbIntroduce.value==null){   
   		alert("内容不允许为空！");   
   		document.form1.mbIntroduce.focus();   
   		return false;
   	}  
    else{
   	 	alert("添加成功！");
    } 
    }
    
</script>
</head>
<body>

	<form action="${pageContext.request.contextPath}/servlet/mbAddServlet" method="post" enctype="multipart/form-data" onsubmit="return formCheck33();" name="form1">
	<table class="right-table" width="70%" height="90%" border="0px" cellpadding="0" align="center" cellspacing="0" >
		
		<tr >
			<td><a>教师姓名</a></td>
			<td><input type="text" name="mbName"></td>
		</tr>
		<tr>
			<td><a>导师类型</a></td>
			<td>
				<select name="mbClass">
						<option value="Doctoral Supervisor">Doctoral Supervisor</option>
						<option value="Supervisor">Supervisor</option>	
				</select>
			</td>
		</tr>
		<tr>
			<td><a>所属院系</a></td>
			<td>
				<select name="mbDepartment">		
						<option value="Material Forming and Control Engineering">Material Forming and Control Engineering</option>
						<option value="Polymer Materials and Engineering">Polymer Materials and Engineering</option>
						<option value="Metal Material Engineering">Metal Material Engineering</option>
						<option value="Inorganic Non-metal Materials Engineering">Inorganic Non-metal Materials Engineering</option>		
				</select>
			</td>
		</tr>
		<tr>
			<td><a>教师照片</a></td>
			<td colspan="2">
	        	<input type="file" name="file">
			</td>
		</tr>
		<tr>
		 <td colspan="2">
				<textarea   rows="8" cols="15" name="mbIntroduce"></textarea>
				<script type="text/javascript">
			    	var editor =CKEDITOR.replace('mbIntroduce', {
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
				<input type="submit" value="添加教师" />
			</td>
		</tr>
	</table>
</form>
 
</body>
</html>