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
}
window.onload=function(){
    	var userType='${MbClass}';
    	var userType2='${MbDepartment}';
    	var selectCode=document.getElementById("class");
    	var selectCode2=document.getElementById("mbDepartment");
    	if(selectCode.length>0){  
                for(var i=0;i<selectCode.options.length;i++){  
                    if(selectCode.options[i].value==userType){  
                        selectCode.options[i].selected=true; 
                        break;  
                    }  
                }  
    	}
    	if(selectCode2.length>0){  
                for(var i=0;i<selectCode2.options.length;i++){  
                    if(selectCode2.options[i].value==userType2){  
                        selectCode2.options[i].selected=true;  
                     
                        break;  
                    }  
                }  
    	}
    	
    }
</script>
</head>
<body>

	<form action="${pageContext.request.contextPath}/servlet/menModifServlet?id=${id}&MbPhoto=${MbPhoto}" method="post" onsubmit="return formCheck33();" name="form1">
	<table class="right-table" width="70%" height="90%" border="0px" cellpadding="0" align="center" cellspacing="0" >
		
		<tr >
			<td><a>教师姓名</a></td>
			<td><input type="text" name="mbName" value="${MbName}"></td>
		</tr>
		<tr>
			<td><a>导师类型</a></td>
			<td>
				<select id="class" name="mbClass">
						<option value="Doctoral Supervisor">Doctoral Supervisor</option>
						<option value="Supervisor">Supervisor</option>	
				</select>
			</td>
		</tr>
		<tr>
			<td><a>所属院系</a></td>
			<td>
				<select id="mbDepartment" name="mbDepartment" >		
						<option value="Material Forming and Control Engineering" >Material Forming and Control Engineering</option>
						<option value="Polymer Materials and Engineering">Polymer Materials and Engineering</option>
						<option value="Metal Material Engineering">Metal Material Engineering</option>
						<option value="Inorganic Non-metal Materials Engineering">Inorganic Non-metal Materials Engineering</option>		
				</select>
			</td>
		</tr>
		<tr>
			<td><a>教师照片</a></td>
			<td colspan="2">
	        	不可修改！
			</td>
		</tr>
		<tr>
		 <td colspan="2">
				<textarea   rows="8" cols="15" name="mbIntroduce">${MbIntroduce}</textarea>
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
				<input type="submit" value="修改信息" />
			</td>
		</tr>
	</table>
</form>
 
</body>
</html>