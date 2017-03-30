<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导师信息添加</title>
<script src="ckeditor/ckeditor.js"></script>
<script src="ckfinder/ckfinder.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link href="share/images/favicon.ico" rel="shortcut icon"/>
<link rel="stylesheet" type="text/css" href="share/css/share.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/addNewsail.css"/>
<link rel="stylesheet" type="text/css" href="admin/css/default/share.css"/>
<script src="share/js/jquery-1.11.0.min.js" type="application/javascript"></script>
<script type="text/javascript" src="share/js/jsUtil.js"></script>
<script src="admin/js/index.js" type="application/javascript"></script>
<script src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript">
    	var editor =CKEDITOR.replace('content', {
			uiColor: '#14B8C4'
		});
    	CKFinder.setupCKEditor( editor, 'ckfinder/' ) ;
    </script>
    <script src="ckfinder/ckfinder.js"></script>
<!-- <script type="text/javascript">
function display_alert()
  {
  alert("添加成功！")
  }
</script> -->
<style type="text/css">
	body{
		background-image: url("images/bg_newsDetailList1.jpg");
		background-position:-100px -300px;
	}
	.enableStyle{
		background-color: ;
		color:black;
	}
	.disableStyle{
		background-color: red;
		color: white;
	}
</style>
<style type ="text/css"> 
 
a {font-size:14px;
text-decoration:none;
color:white;
/* font-weight:bold; */
} 
b {font-size:12px;
text-decoration:none;
color:yellow;
/* font-weight:bold; */
} 
</style>
<style type="text/css">
.div1{
/* float:left; */
margin-left:200px;
Margin-bottom:10px;
}
.div3{}
table td
{
word-break: keep-all;
white-space:nowrap;
}</style>
<script>
function formCheck33()
   {   
     
     if(document.form1.title.value==''){   
   alert("请填写导师姓名！");   
   document.form1.title.focus();   
   return false;}  
    
  /*   if(document.form1.content.value==''){   
   alert("内容不允许为空！");   
   document.form1.content.focus();   
   return false;}   */
     if(editor.document.getBody().getText()==''){
         alert("请输入导师简介！");
         return false;
         
     }
    
     
    }   
    
</script>
</head>
<body>

<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：导师队伍　&gt;&gt;　添加信息　</a>
<div class="div3">
<div class="tableMain">
<div class="div1"> 
<form action="teacherdetailservlet?op=add" method="post" name="form1" onsubmit="return formCheck33();" id="form1">
	
	<table class="right-table" width="70%" height="90%" border="0px" cellpadding="0" align="center" cellspacing="0" >
		
		<tr >
			<td><a>导师名</a></td>
			<td><input maxlength="15"  onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999;width:300px;height:25px" type="text" name="title"/></td>
		</tr>
		<tr>
			<td><a>发布者</a></td>
			<td><a>${sessionScope.loginUser.userName }</a>
			
			</td>
		</tr>
		<tr>
			<td><a>所在专业</a></td>
			<td>
				<select name="typeId">
					<c:forEach items="${requestScope.subjectTypeList }" var="newsType">
						<option value="${newsType.id }">${newsType.typeName }</option>	
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><a>发布时间</a></td>
			<td><input type="text" name="publishTime" onClick="WdatePicker()" class="Wdate"/></td>
		</tr>
		
	
		<tr>
			<!-- <td></td> -->
			<td colspan="2">
				<textarea   rows="8" cols="15" name="content"></textarea>
				<script type="text/javascript">
			    	var editor =CKEDITOR.replace('content', {
						uiColor: '#14B8C4'
					});
			    	CKFinder.setupCKEditor( editor, 'ckfinder/' ) ;
			    </script>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="添加信息" /><!-- onclick="display_alert()" -->
			</td>
		</tr>
	</table>
</form>
 
 </div></div>
</body>
</html>