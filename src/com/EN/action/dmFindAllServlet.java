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

import com.EN.entity.departments;
import com.EN.entity.menbers;
import com.EN.service.departmentsService;

public class dmFindAllServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public dmFindAllServlet() {
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
		departmentsService dmService = new departmentsService();
		List<departments> lsdm = dmService.findAll();
		request.setAttribute("lsdm", lsdm);
		if(request.getParameter("web_type").equals("back")){
			request.getRequestDispatcher("/jsp/Backstage/en_bs_DEPARTMENTS_to_modif.jsp").forward(request, response);
		}else{
			HttpSession dmInSession = request.getSession();
			dmInSession.setAttribute("dmIntroduce", dmService.findDM("id", "1").getDmIntroduce());
			request.getRequestDispatcher("/jsp/en_DEPARTMENTS.jsp").forward(request, response);
		}
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
		
		departmentsService dmService = new departmentsService();
		String name = request.getParameter("dmName");
		List <departments> lsdm=new ArrayList<departments>(); 
		
		if(dmService.findDM("dmName", name)!=null){
			lsdm.add(dmService.findDM("dmName", name));
		}else{
			request.getSession().setAttribute("Msg","查无此项！请输入准备信息！");
			lsdm=dmService.findAll();
		}
		request.setAttribute("lsdm", lsdm);
		request.getRequestDispatcher("/jsp/Backstage/en_bs_DEPARTMENTS_to_modif.jsp").forward(request, response);	
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
