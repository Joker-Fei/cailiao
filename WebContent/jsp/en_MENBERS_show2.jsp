<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'en_MENBERS_show.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<div  style="visibility: visible; width:100%; height:580px; overflow-y:scroll;">
		<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/
		
FANYong.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
fanyong.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
FAN Yong</strong></td>
				<td width="150px"><strong>[Doctoral Supervisor]</strong></td>
				<td><strong>[Polymer Materials and Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
					<p class="STYLE1">
Male, born  in March 1953, Ph.D., Professor, Ph.D. Supervisor. <br>
		  <strong>Educational Background</strong><br>
		    Sept. 1975 - Sep. 1978, Harbin Institute of Electrical Technology,  majoring in Insulation  Materials, Bachelor.<br>
		    Sept. 1979 - Dec. 1981, Harbin Institute of Electrical Technology,  majoring in Insulation Materials,  Master. <br>
		    Sept. 1999 - Nov. 2004, Harbin University of Science and Technology, majoring in High Voltage and Insulation Technology,Ph.D.
				</td>
			</tr>
		</table>
		</a><br>
		<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/
		
LIULiZhu.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
liulizhu.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
LIU LiZhu</strong></td>
				<td width="150px"><strong>[Doctoral Supervisor]</strong></td>
				<td><strong>[Polymer Materials and Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
					
		  Male, born in May  1964, Ph.D., Professor, Ph.D. Supervisor, Associate Dean.<br>
		 <strong>Educational  Background</strong><strong> </strong><br>
		    Sept.1982-July 1986,Harbin Institute of Electrical Technology,majoring in Electrical Insulating Materials, Bachelor.<br>
		    Sept.1986-July 1989,Harbin Institute of Electrical Technology,majoring in Electrical Materials and Insulation Technology, Master. <br>
		    Sept.2000-July 2006,Harbin University of Science and Technology,majoring in High Voltage and Insulation Technology,Ph.D. 	  
				</td>
			</tr>
		</table>
		</a><br>
				<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/
		
ZhouHaoran.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
Zhouhaoran.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
Zhou Haoran</strong></td>
				<td width="150px"><strong>[Supervisor]</strong></td>
				<td><strong>[Polymer Materials and Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
				 <strong>Education  Background:</strong> <br>
		  Ph.D of  Engineering, Material Engineering，July.  2011 Harbin University of Science &amp; Technology<br>
		  Master  of Engineering, Refine Chemical Engineering, September. 1988 ?Dalian  University of Science and Technology, Dalian, China.<br>
		    Bachelor of Science, Polymer Chemistry and  Physics, July. 1985 Heilongjiang University, Harbin,   China.	  
				</td>
			</tr>
		</table>
		</a><br>
				<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/
		
ZhangMingyan.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
ZhangMingyan.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
Zhang Mingyan</strong></td>
				<td width="150px"><strong>[Supervisor]</strong></td>
				<td><strong>[Polymer Materials and Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
				<strong>Education Background</strong><br>
		      Sep. 1982 - Sep.1986 Harbin Electrican Institue Electrical insulating materials?? Undergraduate<br>
		    Sep. 1986 - Sep.1988 Harbin Electrican Institue Electrical insulation materials and  technology? Postgraduate<br>
		    Sep. 2001 - until now Harbin University of Science and Technology High voltage and insulation technology Ph.D. candidate				</td>
			</tr>
		</table>
		</a>
		
	</div>
</body>
</html>
