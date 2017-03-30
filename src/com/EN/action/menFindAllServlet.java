package com.EN.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EN.entity.menbers;
import com.EN.service.menbersService;

public class menFindAllServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public menFindAllServlet() {
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
		
		menbersService menService = new menbersService();
		List<menbers> lsmen = menService.fundAll();
		List<menbers> lsmen1 = new ArrayList<menbers>();
		List<menbers> lsmen2 = new ArrayList<menbers>();
		if(request.getParameter("web_type").equals("back")){
			request.setAttribute("lsmen", lsmen);
		}else if(request.getParameter("web_type").equals("1")){
			for(menbers i:lsmen){
				if(i.getMbClass().equals("Doctoral Supervisor")){
					lsmen1.add(i);
				}
			}
			request.setAttribute("lsmen", lsmen1);
		}else if(request.getParameter("web_type").equals("2")){
			for(menbers i:lsmen){
				if(i.getMbClass().equals("Supervisor")){
					lsmen1.add(i);
				}
			}
			if(request.getParameter("type").equals("1")){
				for(menbers j:lsmen1){
					if(j.getMbDepartment().equals("Material Forming and Control Engineering")){
						lsmen2.add(j);
					}
				}
				request.setAttribute("lsmen", lsmen2);
			}else if(request.getParameter("type").equals("2")){
				for(menbers j:lsmen1){
					if(j.getMbDepartment().equals("Polymer Materials and Engineering")){
						lsmen2.add(j);
					}
				}
				request.setAttribute("lsmen", lsmen2);
			}else if(request.getParameter("type").equals("3")){
				for(menbers j:lsmen1){
					if(j.getMbDepartment().equals("Metal Material Engineering")){
						lsmen2.add(j);
					}
				}
				request.setAttribute("lsmen", lsmen2);
			}else if(request.getParameter("type").equals("4")){
				for(menbers j:lsmen1){
					if(j.getMbDepartment().equals("Inorganic Non-metal Materials Engineering")){
						lsmen2.add(j);
					}
				}
				request.setAttribute("lsmen", lsmen2);
			}
		}
		if(request.getParameter("web_type").equals("back")){		
			request.getRequestDispatcher("/jsp/Backstage/en_bs_MENBERS_showAll.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/en_MENBERS_showAll.jsp").forward(request, response);
		}
		
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
