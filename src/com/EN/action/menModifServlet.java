package com.EN.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EN.entity.menbers;
import com.EN.service.menbersService;
import com.EN.util.WebUtils;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class menModifServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public menModifServlet() {
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

    	menbers mb = new menbers();
		menbersService mbService = new menbersService();
		mb = mbService.fundsing(request.getParameter("id"));
		request.setAttribute("MbName", mb.getMbName());
		request.setAttribute("id", mb.getId());
		request.setAttribute("MbClass", mb.getMbClass());
		request.setAttribute("MbDepartment", mb.getMbDepartment());
		request.setAttribute("MbIntroduce", mb.getMbIntroduce());
		request.setAttribute("MbPhoto", mb.getMbPhoto());
		
		request.getRequestDispatcher("/jsp/Backstage/en_bs_MENBERS_modif.jsp").forward(request, response);
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

		menbers mb = new menbers();
    	mb.setMbName(request.getParameter("mbName"));
		mb.setMbClass(request.getParameter("mbClass"));
		mb.setMbDepartment(request.getParameter("mbDepartment"));
		mb.setMbIntroduce(request.getParameter("mbIntroduce"));
		mb.setId(request.getParameter("id"));
		mb.setMbPhoto(request.getParameter("MbPhoto"));
		menbersService mbService = new menbersService();
		mbService.modif(mb);
	
		String message =String.format(
				"修改成功！<meta http-equiv='refresh' content='1;url=%s'", 
				request.getContextPath()+"/servlet/menFindAllServlet?web_type=back");
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
