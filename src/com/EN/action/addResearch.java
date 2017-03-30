package com.EN.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EN.entity.introduction;
import com.EN.entity.research;
import com.EN.service.introductionService;
import com.EN.service.researchService;

public class addResearch extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addResearch() {
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

		/*response.setContentType("text/html");
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
		out.close();*/
		research res = new research();
		researchService resService = new researchService();	
		
		if((res=resService.fundResearch("id", "001"))!=null){
			String Research = res.getResearch();
			request.setAttribute("Research",Research);
		}else{
			/*String message =String.format(
					"请先添加！<meta http-equiv='refresh' content='1;url=%s'", 
					request.getContextPath()+"/servlet/intrAddServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;*/
			request.setAttribute("Research","nothing");
		}
		if(request.getParameter("web_type").equals("back")){
			request.getRequestDispatcher("/jsp/Backstage/en_bs_RESEARCH.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/en_RESEARCH.jsp").forward(request, response);
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

		/*response.setContentType("text/html");
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
		out.close();*/
		research res = new research();
		researchService resService = new researchService();
		res.setId(request.getParameter("id"));
		res.setResearch(request.getParameter("Research"));
		resService.modifResearch(res);
		
		String message =String.format(
				"修改成功！<meta http-equiv='refresh' content='1;url=%s'", 
				request.getContextPath()+"/servlet/addResearch?web_type=back");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;	
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
