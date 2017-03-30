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
		
LIDayong.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
lidayong.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
LI Dayong</strong></td>
				<td width="150px"><strong>[Doctoral Supervisor]</strong></td>
				<td><strong>[Metal Material Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
				<p class="STYLE1">
		    Male,  born in May 1958, Ph.D., Professor, Ph.D. Supervisor, President<br>	
		  <strong>Educational Background</strong><br>
		    Sep. 1978  - July 1982,Harbin University of Science and Technology, majoring in the Craft and Equipment of Foundry,  Bachelor.<br>
		    Sep. 1984  - July 1987, Harbin University of Science and Technology, majoring in Foundry, Master.<br>
		    Mar. 1997  - Dec. 1999, Harbin Institute of Technology,  majoring in Material Processing Engineering, Ph.D.<br>
		    Dec. 2004  - Dec. 2005, University of Sheffield, U. K., Visiting Scholar.</p>
				</td>
			</tr>
		</table>
		</a><br>
				<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/
		
JIZesheng.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
jizesheng.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
JI Zesheng</strong></td>
				<td width="150px"><strong>[Doctoral Supervisor]</strong></td>
				<td><strong>[Metal Material Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
				<p>Male, born in Mar.1962, ?PH.D., Professor, Ph.D. Supervisor
		  <strong>Educational Background</strong><br>
		    Sept. 1979 - Jul. 1983, Harbin University of Science and  Technology, majoring in Metal Materials and Heat Treatment, Bachelor.<br>
		    Sept. 1986 - Sept. 1989,Harbin University of Science and Technology , majoring in Metal Materials and Heat Treatmen, Master. <br>
		   </p>
		  </td>
			</tr>
		</table>
		</a><br>
				<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/
		
GuoErjun.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
guoerjun.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
Guo Erjun</strong></td>
				<td width="150px"><strong>[Doctoral Supervisor]</strong></td>
				<td><strong>[Metal Material Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
				<p> <span class="STYLE1">
		  Male, born in Nov. 1963, Professor, Ph.D. Supervisor, Vice President </span>
		  <strong>Education Background</strong> <br>
		    Sept. 1980 - July 1984, Harbin University of Science and Technology, majoring  in Casting, Bachelor.<br>
		    Sept. 1996 - Apr. 1999, Harbin University of Science and Technology,, majoring in Material Processing Engineering, Master.<br>
		    Jan. 2002 - Mar. 2006, Harbin Engineering University, Mechanical Design  and Theory, Ph.D.</p>
		</td>
			</tr>
		</table>
		</a><br>
				<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/
		
WUYubin.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
WuYubin.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
WU Yubin</strong></td>
				<td width="150px"><strong>[Supervisor]</strong></td>
				<td><strong>[Metal Material Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
				<p class="STYLE1">
              Male, bron in May 1953, Professor, Master Supervisor
		  <strong>Educational Background</strong><br>
		    Sept. 1975 - Sept. 1978, Metallurgic Mechanics of Chongqing University, Bachelor.
		  <strong>Working Experiences</strong><br>
		    Sept. 1978 - Jul. 1992, Institute  of Metallurgy Technology Research of Heilongjiang, Head of the  Research Section.<br>
		    July 1992 - Aug. 1994, Metallurgy Technology Development Co. of Heilongjiang,  Senior Engineer, Vice-general Manager.<br>
		    Aug. 1994 - Aug. 1995, Harbin University  of Science and Technology, Associate Professor.<br></p>
		  	</td>
			</tr>
		</table>
		</a>
		
	</div>
</body>
</html>
