<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 这个语句是用来拼装当前网页的相对路径的。 -->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加信息</title>
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
<script type="text/javascript">
function display_alert()
  {
  alert("添加成功！")
  }
</script>
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
   alert("请填写标题！");   
   document.form1.title.focus();   
   return false;}  
    
   /*  if(document.form1.content.value==''){   
   alert("内容不允许为空！");   
   document.form1.content.focus();  */
   if(editor.document.getBody().getText()==''){
       alert("请输入内容！");
   return false;}  
    
    }   
    
</script>
</head>
<body>

<div class="position">　<a style="font-size:14px;text-decoration:none;color:#FFAA33;" >当前位置：仪器管理　&gt;&gt;　添加仪器　</a>
<div class="div3">
<div class="tableMain">
<div class="div1"> 
<form action="instrumentServlet?op=add" method="post" name="form1" onsubmit="return formCheck33();" id="form1">
	
	<table class="right-table" width="70%" height="90%" border="0px" cellpadding="0" align="center" cellspacing="0" >
		<tr>
			<td><a>仪器类型</a></td>
			<td>
				<select name="typeId">				
					<c:forEach items="${requestScope.instrumentTypeList }" var="instrumentType">
						<option value="${instrumentType.id }">${instrumentType.typeName }</option>	
					</c:forEach>
				</select>
			</td>		
			<td><a>发布者</a></td>
			<td><a>${sessionScope.loginUser_testCenter.userName }</a><%-- <input style="width:300px;height:25px" type="text" name="userName" readonly="readonly" value="${sessionScope.loginUser_testCenter.userName }"/> --%>
			
			</td>
		</tr>
		<tr >
			<td><a>生产厂家</a></td>
			
			<td><textarea   rows="1" cols="30" name="factory"></textarea></td>
			<td><a>主要附件</a></td>
			<td><textarea   rows="1" cols="30" name="mainAccessories"></textarea></td>
		</tr>
		<tr >
			<td><a>技术参数</a></td>
			<td><textarea   rows="2" cols="30" name="tecParame"></textarea></td>
		
			<td><a>技术特点</a></td>
			<td><textarea   rows="2" cols="30" name="tecFeatures"></textarea></td>
		</tr>
		<tr >
			<td><a>应用范围</a></td>
			<td><textarea   rows="3" cols="30" name="appliRange"></textarea></td>
			
		</tr>
		<tr>
			<td><a>发布时间</a></td>
			<td><input type="text" name="publishTime" onClick="WdatePicker()" class="Wdate"/></td>
		</tr>
		<%-- <tr>
			<td>状态</td>
			<td>
				<input type="radio" name="pass" value="1" checked="checked" />未通过
				
			</td>
			<td></td>
		</tr> --%>
	
		<tr>
			<!-- <td></td> -->
			<td colspan="4" align="center">
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