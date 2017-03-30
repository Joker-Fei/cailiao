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
		
		
		<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/SUNFenglian.jsp" target="mainFrame">
		<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/sunfenglian.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>Fenglian Sun</strong></td>
				<td width="150px"><strong>[Doctoral Supervisor]</strong></td>
				<td><strong>[Material Forming and Control Engineering]</strong></td>

			</tr>
			<tr >
				<td colspan="3" height="130px">
					<p>Female,  born in Oct. 1957, Ph.D., Professor, Ph.D. Supervisor, Dean.<br>
		  			<strong>Educational  Background</strong><br/>
		    Mar. 1978  - Jan. 1982, Harbin Institute of Technology, majoring in Welding, Bachelor.<br />
		    Sept.  1985 - Apr. 1988, Harbin University of Science and Technology, majoring in Material  Science and Engineering, Master.<br />
		    Mar. 1999  - Apr. 2002, Harbin Institute of Technology, majoring in Materials Engineering,  Ph.D. <br />
		    June 2007  - Dec. 2007, The Dutch NXP Semiconductor Co., TUDelft University, Senior  Visiting Scholar.
		  	</p>
				</td>
			</tr>
		</table>
		</a><br>
		
		<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/YuYandong.jsp" target="mainFrame">
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/YuYandong.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>YuYandong</strong></td>
				<td width="150px"><strong>[Doctoral Supervisor]</strong></td>
				<td><strong>[Material Forming and Control Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
					<p>Female, born in Dec. 1964, Ph.D., Professor, Ph.D.Supervisor.<br>
						<strong>Educational Background</strong><br>
						July 1983 - July 1987, Jiamusi Polytechnic Institute,majoring in Welding, Bachelor.<br> 
						Sept.1989 - Mar. 1992,Harbin University of Science and Technology, majoring in Casting,Master.<br> 
						Mar. 2000 - Apr. 2003,Harbin Institute of Technology, majoring in Press Working, Ph.D.<br>
						Mar. 2004 - Apr. 2006, Shanghai Jiaotong University,Post-doctor.<br>
					</p>
				</td>
			</tr>
		</table>
		</a><br>
		
		<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/MengGongge.jsp" target="mainFrame">
		<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/Menggongge.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>Meng Gongge</strong></td>
				<td width="150px"><strong>[Supervisor]</strong></td>
				<td><strong>[Material Forming and Control Engineering]</strong></td>

			</tr>
			<tr >
				<td colspan="3" height="130px">
				<p class="STYLE1">Born: 1956.4. Master, Professor
		  	<strong>Academic Background</strong><br />
		    1978.3.-1982.1., Harbin University  of Science and Technology, <br />
		    Metal materials and heat treatment, Bachelor<br />
		    1985.9.-1988.9., Harbin Research Institute of Welding,  Welding, <br />
		    Machinery  and Electronic Industry Ministry, Master<br />
		    2005.10.-2006.3., Joining and Welding Research Institute,  Osaka  University, Japan, <br />
		    Guest researcher.
			</p>	
				</td>
			</tr>
		</table>
		</a><br>
		<a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/
		
LiuXiaojing.jsp" target="mainFrame">
		
			<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/
Liuxiaojing.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>
Liu Xiaojing</strong></td>
				<td width="150px"><strong>[Supervisor]</strong></td>
				<td><strong>[Polymer Materials and Engineering]</strong></td>
			</tr>
			<tr >
				<td colspan="3" height="130px">
					<p class="STYLE1">Han, born in May 1966, Ph.D., professor,Master student supervisor,   director of material formation and control engineering faculty
		  <strong>Learning  Experiences </strong><br>
		    1985.9 -1989.6, Harbin Institute of  Technology, Pressure Processing Engineering, undergraduate. <br>
		    1999.9 -2003.4, Harbin University  of Science and Technology, Materials Processing Engineering, Master. <br>
		    2004.3 -2008.6, Harbin  Institute of Technology, Materials Processing  Engineering, PhD. </p>
		 		</td>
			</tr>
		</table>
		</a><br>
		<%-- <a style="text-decoration:none" href="${pageContext.request.contextPath}/jsp/daoshi/SUNFenglian.jsp" target="mainFrame">
		<table border="1" width="100%">
			<tr>
				<td width="140" rowspan="2"><img
					src="${pageContext.request.contextPath}/images/jiaoshi/.jpg"
					height="150" width="140">
				</td>
				<td width="150px" height="8px"><strong>Liansheng Shi</strong></td>
				<td width="150px"><strong>[Supervisor]</strong></td>
				<td><strong>[Material Forming and Control Engineering]</strong></td>

			</tr>
			<tr >
				<td colspan="3" height="130px">
					
				</td>
			</tr>
		</table>
		</a><br> --%>
	</div>
</body>
</html>
