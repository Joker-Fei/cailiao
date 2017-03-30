package com.EN.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EN.entity.departments;
import com.EN.entity.introduction;
import com.EN.service.introductionService;
import com.EN.util.WebUtils;

public class intrAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public intrAddServlet() {
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

		String message =String.format(
				"请添加！<meta http-equiv='refresh' content='1;url=%s'", 
				request.getContextPath()+"/jsp/Backstage/en_bs_INTRODUCTION.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		return;	
		
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

		introduction intr = new introduction();
		introductionService intrService = new introductionService();
		/*intr = WebUtils.request2Bean(request, introduction.class);*/
		if(intrService.findIntr("id", "001")==null){
			intr.setIntdIntroduce(request.getParameter("intdIntroduce"));
			intr.setId("001");
			intrService.addIntr(intr);
			String message =String.format(
					"添加成功！<meta http-equiv='refresh' content='1;url=%s'", 
					request.getContextPath()+"/servlet/intrFindServlet?web_type=back");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;	
		}else{
			String message =String.format(
					"此项已有不能重复添加！<meta http-equiv='refresh' content='1;url=%s'", 
					request.getContextPath()+"/servlet/intrFindServlet?web_type=back");
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
