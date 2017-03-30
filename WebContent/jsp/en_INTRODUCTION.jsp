<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'en_home.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.STYLE {/*一级标题 */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			line-height:1px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			font-weight: 900;		/* 字体粗细 */
			font-size: 30px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			color:#c88400;
		}
		.STYLE1 {/*普通文字 */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			//line-height:1px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			//font-weight: 900;		/* 字体粗细 */
			font-size: 20px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			text-indent: 2em;		/* 缩进 */
			text-align: justify;		/* 对齐方式 */
			color:#0c212b;
		}
	</style>
  </head>
  
  <body>
  <table align="center" border="0" cellpadding="0" cellspacing="0" >
  	<tr bgcolor="">
    	<td bgcolor="" width="40%" valign="top">
    	<table align="center" border="0" cellpadding="0" cellspacing="0" >
    		<tr>
    			<td colspan="2" height="30px">&nbsp;</td>
    		</tr>
    		<tr>
    			<td>
					<img src="${pageContext.request.contextPath}/images/xiaohui.png" height="200" width="200">
				</td>
				<td>
					<img src="${pageContext.request.contextPath}/images/cailiao_yuanhui.png" height="200" width="200">
				</td>
			</tr>
			<tr>
    			<td colspan="2" height="30px">&nbsp;</td>
    		</tr>
			<tr>
				<td colspan="2">
					<img src="${pageContext.request.contextPath}/images/zhulou.png" height="293" width="500">
				</td>
			</tr>
		</table>	
	  	</td>
	  	
		<td valign="top" width="2%">
			<img src="${pageContext.request.contextPath}/images/mm_spacer-1.png" alt="" border="0" height="1" width="50">
		</td>
		
		<td valign="top" width="58%" height="500px" bgcolor="">
			<div style=" width:100%; height:600px; overflow-y:scroll; visibility: visible;">
				<table align="center" border="0" width="100%" height="1000px" cellpadding="0" cellspacing="0" >
    				<tr>
    					<td colspan="2" height="40px">&nbsp;</td>
    				</tr>
    				<tr>
    					<td valign="top">
    						${intdIntroduce}
							<!-- <p style="text-align:center" class = "STYLE">School of Material Science &amp; Engineering</p>
							<p id="text" style="" class = "STYLE1">
									The School of Material Science &amp; Engineering in HUST has
									four departments, namely the Department of Metal Materials
									Engineering, Department of Polymer Materials Engineering, the
									Department of Inorganic Non-metallic Materials Engineering, and
									the Department of Materials Formation and Control Engineering.
									It also includes analysis and testing center, experimental
									centers, engineering practice centers and more than 20 research
									groups. There are more than 90 staffs, including 33 professors,
									36 associate professors and senior engineers, 8 doctoral
									supervisors, 48 master supervisors. So, the main rational
									structure with doctoral supervisors, professors, associate
									professors and PhD as is formed and it is an innovative
									teaching staff full of vigor and vitality. Currently, there are
									more than 1,600 undergraduates and 300 graduate students.<br>
									There are doctoral degree students and postdoctoral scientific
									research students of materials science and engineering. It has
									the right to grant master's degree for 5 subjects, that are,
									materials science, material processing engineering, materials
									physics and chemistry, polymer chemistry and physics (Science),
									high voltage and insulation technology (new insulation
									materials). At the same time, it includes an authorized master
									degree of engineering in the field of materials engineering and
									an authorized master degree for teachers in-service. There is a
									provincial key disciplines-Materials Science and
									Engineering, provincial key discipline groups-"Equipment
									Manufacturing Technology (covering materials processing
									engineering disciplines)", provincial key laboratory of
									universities-"Materials Research and Application", provincial
									key co-construction and sharing laboratory for school and
									enterprises-"Magnesium Alloy Materials. In many large
									enterprises, the graduate innovation base, and research and
									development centers have been established. "Metal Materials
									Engineering" and "Polymer Science and Engineering" are the
									national key disciplines, "Material Forming and Control
									Engineering" and âInorganic Non-metallic Materials
									Engineering are provincial key disciplines.<br> 
									There are
									good conditions for teaching, scientific research and
									engineering training in this school The main analytical
									instruments including transmission and scanning electron
									microscopy, X-ray diffraction, FT-IR spectrometer, a digital
									optical microscopy, nanoindenter, direct-reading spectrometer,
									gel permeation chromatography, thermogravimetry and
									differential scanning calorimetry are imported from the United
									States, Japan, the Netherlands and other countries. The total
									value of the equipments is worth about 0.3 billion yuan and it
									provides a favorable protection for scientific research and
									personnel training.
									<br>
								</p> -->
						</td>
						<td width="10">&nbsp;</td>
					</tr>
					<tr>
    					<td colspan="2">&nbsp;</td>
    				</tr>
				</table>
			</div>
		</td>
	</tr>
	</table>
	
  </body>
</html>
