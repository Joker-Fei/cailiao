package com.EN.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EN.entity.departments;
import com.EN.service.departmentsService;

public class dmFindServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public dmFindServlet() {
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

		doPost(request, response);
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
		dm = dmService.findDM("dmName",request.getParameter("dmName"));
		if(dm==null){
			String message =String.format(
					"查无此项！<meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/jsp/Backstage/en_bs_DEPARTMENTS_to_modif.jsp");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;	
		}
		request.setAttribute("id",dm.getId());
		request.setAttribute("dmName",dm.getDmName());
		request.setAttribute("dmIntroduce",dm.getDmIntroduce());
		
		request.getRequestDispatcher("/jsp/Backstage/en_bs_DEPARTMENTS_modif.jsp").forward(request, response);
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
