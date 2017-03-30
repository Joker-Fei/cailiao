<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	pageContext.setAttribute("path",path);
%>
<%@ page import= "com.EN.entity.*"%>
<%@ page import= "java.util.List" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'en_DEPARTMENTS.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.STYLE {/*左侧链接 */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			line-height:25px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			font-weight: 100;		/* 字体粗细 */
			font-size: 15px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			color:#009ad6;
		}
		.STYLE1 {/*一级标题 */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			line-height:1px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			font-weight: 900;		/* 字体粗细 */
			font-size: 30px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			color:#c88400;
		}
		.STYLE2 {/*普通文字 */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			line-height:1px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			font-weight: 700;		/* 字体粗细 */
			font-size: 20px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			//text-indent: 2em;		/* 缩进 */
			text-align: justify;		/* 对齐方式 */
			color:#0c212b;
		}
		.STYLE2-2 {/*普通文字 */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			line-height:1px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			font-weight: 700;		/* 字体粗细 */
			font-size: 15px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			//text-indent: 2em;		/* 缩进 */
			text-align: justify;		/* 对齐方式 */
			color:#0c212b;
		}
		.STYLE3 {/*普通文字 */
			//letter-spacing: -5px;	/* 字间距 */
			//word-spacing: 1px;		/* 词间距 */
			line-height:1px;		/* 行高 */
			//font-family:"Agency FB";	/* 字体 */
			font-weight: 500;		/* 字体粗细 */
			font-size: 15px;		/* 字体大小 */
			//text-transform: uppercase;/*转大写 */
			//text-indent: 2em;		/* 缩进 */
			text-align: justify;		/* 对齐方式 */
			color:#0c212b;
		}
		.STYLE4 {/*普通文字 */
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
  
  	<table>
  		<tr>
  			<td valign="top" width="50px" height="100%">
				<table width="100%" height="100%" frame="rhs" rules="none" border="2" bordercolor="#585eaa">
					<tr>
						<td colspan="" class="STYLE" nowrap="nowrap" width="" height="">
							<%
							List<departments> lsdm = (List<departments>)request.getAttribute("lsdm");
							for(departments i:lsdm){%>
							<a style="text-decoration:none" href="${pageContext.request.contextPath }/servlet/dmShowServlet?id=<%= i.getId()%>" target="departmentsFrame">
								<%=i.getDmName() %><br>
							</a>
							<% } %>
						</td>
					</tr>
					<tr height="1000px">
					</tr>
				</table>
			</td>
			
			<td valign="top" width="80%" height="100%">
				<iframe src="${pageContext.request.contextPath}/jsp/en_DEPARTMENTS_show.jsp" scrolling="no" name="departmentsFrame" frameborder="0" marginheight="0" marginwidth="0" height="590" width="100%"></iframe>
			</td>
			<td width="8">&nbsp;</td>
		</tr>

		<tr>
			<td colspan="3" height="20px">&nbsp;</td>
		</tr>
	</table>
  </body>
  <div id="div1" style=" width:100%; height:600px; overflow-y:scroll;">
					<table align="center" border="0" width="100%" height="800px" cellpadding="0" cellspacing="0" >
    				<tr>
    					<td colspan="3" height="20px">&nbsp;</td>
    				</tr>
    				
    				<tr>
    					<td width="8">&nbsp;</td>
    					<td valign="top">
							<p style="text-align:center" class = "STYLE1">DEPARTMENTS</p>
							<p class = "STYLE2">Material Forming and Control Engineering</p>
							<p class = "STYLE3">(Science and engineering, Undergraduate Education, Educational System: FourYears )</p> 
							<p class = "STYLE2-2">Specialty introduction:</p>
							<p class = "STYLE4">This major is provincial key
								professional Speciality. The subject has the right to grant
									master's degree and doctor's degree and can receive
									post-doctoral research work. Senior engineering and technical
									talents are trained with the material forming and control
									science and engineering knowledge of the theoretical
									foundation, basic experimental skills and methods of scientific
									innovation, able to take welding, molding, micro-electronics
									packaging and other technical work; through professional
									learning. They can also master professional-related mechanical,
									electrical and electronic technology, computer applications and
									other basic knowledge and skills. After finishing their
									studies, students will be able to do scientific research;
									technology development, process and equipment design,
									production management, etc. in the fields of precision welding
									technology, microelectronic assembly technology, robot welding
									technology intelligence, welding testing, metal forming process
									and die design, plastic and die-casting mold design, CNC
									machining technology, the mold CAD/CAE/CAM/CAPP and its
									integration technology, modern design, molding technology and
									optimization, etc. Computer technology is stressed in Material
									Forming and manufacturing applications. The students have broad
									knowledge, strong adaptability and employability. There are two
									main directions in welding and die. </p>
									<p class = "STYLE2-2">Main Course:</p>
									 <p class = "STYLE4">The basis of
									material forming, Engineering materials, Material forming
									detection technology, Materials analysis and testing, Material
									forming equipment and control, Mechanical Properties, Mold CAD,
									The numerical simulation of material forming, welding
									metallurgy and metal welding, Welding structure, Welding
									method, Welding inspection, Welding new material and new
									technology, Welding robots, Principles of plastic forming,
									Metal plastic forming process and die design, Plastic mold
									process and design, CNC machining technology, Mold
									manufacturing processes, Rapid prototyping, Die casting mold
									design, Mold design software, Electronic packaging materials
									and technology, the reliability of electronic packaging and
									testing. </p>
									<p class = "STYLE2-2">Employment orientation:</p>
									<p class = "STYLE4">Graduates can be engaged in
									materials forming research, design and management work of
									machinery, automotive, instrumentation, aerospace and other
									industries；engaged in design and development of new products,
									new processes, new equipment, product quality testing and
									analysis of material forming in the research Institute or the
									design Institute and inspection departments; Engaged in
									teaching and scientific research in universities. In addition，a
									part of the graduates can obtain postgraduate.</p>
						</td>
						<td width="8">&nbsp;</td>
					</tr>
					
					<tr>
    					<td colspan="3" height="20px">&nbsp;</td>
    				</tr>
					</table>
				</div>
  				<div id="div2" style=" width:100%; height:600px; overflow-y:scroll; visibility: hidden;" >
					<table align="center" border="0" width="100%" height="1000px" cellpadding="0" cellspacing="0" >
    				<tr>
    					<td colspan="3" height="20px">&nbsp;</td>
    				</tr>
    				
    				<tr>
    					<td width="8">&nbsp;</td>
    					<td valign="top">
							<p style="text-align:center" class = "STYLE1">DEPARTMENTS</p>
							<p class = "STYLE2">Polymer Materials and Engineering </p>
							<p class = "STYLE3">(Electrical Insulating Materials, Undergraduate Education, Educational System: Four Years )</p> 
							<p class = "STYLE2-2">Brief Introduction:</p>
							<p class="STYLE4">Polymer Materials and Engineering is the
					National Key Characteristic Specialty and Key Specialty of
					Heilongjiang Province. It has the right to grand Ph.D in Materials
					Science and Engineering and postdoctorial research station. It also
					has the right to grand Master’s degree in Polymer Chemistry and
					Physics (Master of Science), Materials Science (Polymer Science),
					High Voltage and Insulation Technology (Master of Engineering). The
					students graduate from this specialty will work on several fields
					including the research and development of insulating materials,
					polymer moulding and processing, plastic products’ design,
					synthesis and modification of polymer materials, high-tech research
					and development of new materials and functional polymers, modern
					testing technology of polymers, computer application and production
					and operation management, etc. The specialty is now engaged in a
					number of subjects in the frontier areas of scientific research,
					and the research work in insulating materials is in the domestic
					advanced level. </p>
					<p class = "STYLE2-2">Main Courses: </p>
					<p class="STYLE4">The main courses of this specialty
					are including the Inorganic chemistry, Organic chemistry, Physical
					chemistry, Polymer chemistry, Polymer physics, Polymer rheology,
					Dielectric physics, Computer in chemistry and chemical industry,
					Principles of polymer processing, Functional polymers, Composite
					Materials, Polymer research method, Plastic molding process used
					for electrical insulation, Polymer Synthesis, Plastic mould design,
					Process principles of insulating material, Electrical insulation
					testing, Cable materials. Moreover, there are also some practice
					courses including the Awareness training, Production practice,
					Course design, Innovative experiment and Graduate design.
					<p class = "STYLE2-2">Employment orientation:</p>
					 <p class="STYLE4">Graduates rate is nearly 25%, students
					employed mainly in the fields including the insulation materials,
					fiber optic cable, polymer materials, polymer composites, plastic
					mould and polymer synthesis, etc. Moreover, students are available
					in universities, research institutions engaged in teaching and
					research, or also can go to the appropriate government departments
					engaged in administration, quality supervision, etc.</p></td>
						<td width="8">&nbsp;</td>
					</tr>
					
					<tr>
    					<td colspan="3" height="20px">&nbsp;</td>
    				</tr>
					</table>
				</div>
				
				<div id="div3" style=" width:100%; height:600px; overflow-y:scroll; visibility: hidden;" >
					<table align="center" border="0" width="100%" height="1000px" cellpadding="0" cellspacing="0" >
    				<tr>
    					<td colspan="3" height="20px">&nbsp;</td>
    				</tr>
    				
    				<tr>
    					<td width="8">&nbsp;</td>
				<td valign="top">
				<p style="text-align:center" class="STYLE1">DEPARTMENTS</p>
				<p class="STYLE2">Metal Material Engineering</p>
				<p class="STYLE3">(Science and Engineering, Undergraduate
					Education, Educational System: Four Years)</p>
				<p class="STYLE2-2">Introduction:</p>
				<p class="STYLE4">it is the professional major of the state and
					key major of Heilongjiang Province. It has the master and doctor
					authorized right and a post-doctoral research station. It mainly
					cultivates the technical personnel in the metal material design,
					preparation, analysis of microstructure and properties, materials
					science of formation and process of liquid, engineering technology,
					development and management of production, Students can grasp the
					knowledge of metal materials science and engineering and the basic
					skills through the professional learning. The students will possess
					the ability of design and selection of metal materials, and the
					capacity of correct choice of production equipment. The students
					will have the necessary expertise to grasp the basic knowledge and
					skills of mechanics, electrical and electronic technology, computer
					applications. The students will have the ability to explore new
					materials, new process and equipment.</p>
				<p class="STYLE2-2">Main Courses:</p>
				<p class="STYLE4">In addition to the basic public classes, the
					main courses are as follows: metallurgy and heat treatment,
					transport theory, metallurgy principle, metal materials, metal
					mechanical properties, material analysis, thermal processing
					control technology, form a theory of casting, mold design CAD ,
					alloys and melting, the liquid molding process, material forming
					mechanical and electrical integration, composite materials,
					functional materials, nondestructive testing, heat treatment
					technology and equipment, mechanical drawing, engineering
					mechanics, physical chemistry, mechanical principles, electrical
					technology, Elementary Technology measurement, machinery
					manufacturing base, electronics, computer theory and application,
					mechanical design. </p>
					<p class="STYLE2-2">Employment orientation:</p>
					<p class="STYLE4"> A part of the graduates
					enter the well-known institutions, the others go to the state-owned
					enterprises, joint ventures, research institutes, universities and
					government agencies. They mainly do the work of engineering and
					technology, teaching and management of metal materials and thermal
					processing of metal materials.</p>
				</td>
					<td width="8">&nbsp;</td>
					</tr>
					
					<tr>
    					<td colspan="3" height="20px">&nbsp;</td>
    				</tr>
					</table>
				</div>
				<div id="div4" style=" width:100%; height:600px; overflow-y:scroll; visibility: hidden;" >
					<table align="center" border="0" width="100%" height="1000px" cellpadding="0" cellspacing="0" >
    				<tr>
    					<td colspan="3" height="20px">&nbsp;</td>
    				</tr>
    				
    				<tr>
    					<td width="8">&nbsp;</td>
				<td valign="top">
				<p style="text-align:center" class="STYLE1">DEPARTMENTS</p>
				<p class="STYLE2">Inorganic Non-metal Materials Engineering</p>
				<p class="STYLE3">(Science and Engineering, Undergraduate Education, Educational System: Four Years) </p>
				<p class="STYLE2-2">Introduction:</p>
				<p class="STYLE4">The major is based on the academic discipline of
					master degree, doctor degree and postdoctor workstation, aiming to
					cultivate the high-quality engineers to meet the demands of
					inorganic materials, optical fiber and optical cable industries.
					The students are comprehensively educated to master the principal
					theories, professional knowledge and basic skills of inorganic
					non-metallic materials, be capable of designing and choosing the
					equipments to manufacture the inorganic non-metal materials, have
					the basic knowledge of mechanics, electrical and electronics,
					computer technology, have the abilities of developing new
					materials, designing new processing technology and devising
					equipments. The graduates can be engaged in scientific research,
					technology developing, process design, equipment devising, and
					production management.</p>
				<p class="STYLE2-2">Main Courses:</p>
				<p class="STYLE4">The main courses, in addition to the public
					elementary courses, include inorganic chemistry, physical
					chemistry, organic chemistry, analytical chemistry, solid state
					physics, basics of inorganic materials science, technics of
					inorganic materials, testing and characterization of inorganic
					materials, pyrological process and equipment, powder engineering,
					composite materials, nano materials, electrical and electronic
					materials, manufacturing technology of optical fiber and cable,
					optical communication, functional materials, environmental
					materials, etc. Practical teachings are also set up, such as metal
					working, know-how training, production training, curriculum design,
					open and comprehensive experiment, graduating design.</p>
					<p class="STYLE2-2">Employment orientation:</p>
					<p class="STYLE4">25% of graduates are admitted into some
					well-known universities as postgraduates. The others are mainly
					employed by large and medium state-owned enterprises, foreign
					funded enterprises, research institutes, etc, working on production
					management, new product development, quality monitoring, technical
					supervision, administration and scientific research in the fields
					of inorganic non-metallic materials, composite materials, optical
					fiber and optical cable.</p>
				</td>
					<td width="8">&nbsp;</td>
					</tr>
					
					<tr>
    					<td colspan="3" height="20px">&nbsp;</td>
    				</tr>
					</table>
				</div>
</html>
