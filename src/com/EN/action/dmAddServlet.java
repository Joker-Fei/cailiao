package com.EN.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EN.entity.departments;
import com.EN.service.departmentsService;
import com.EN.util.WebUtils;

public class dmAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public dmAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			departments dm = new departments();
			departmentsService dmService = new departmentsService();
			dm = WebUtils.request2Bean(request, departments.class);
			if(dmService.findDM("dmName",dm.getDmName())==null){
				dm.setId(WebUtils.makeId());
				dmService.addDM(dm);
				String message =String.format(
						"添加成功！<meta http-equiv='refresh' content='1;url=%s'", 
						request.getContextPath()+"/servlet/dmFindAllServlet?web_type=back");
				request.setAttribute("message",message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;	
			}
			else{
				String message =String.format(
						"已有此项！<meta http-equiv='refresh' content='1;url=%s'", 
						request.getContextPath()+"/jsp/Backstage/en_bs_DEPARTMENTS.jsp");
				request.setAttribute("message",message);
				request.getRequestDispatcher("/message.jsp").forward(request, response);
				return;	
			}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
