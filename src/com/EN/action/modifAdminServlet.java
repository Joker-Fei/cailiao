package com.EN.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EN.entity.User;
import com.EN.service.UserService;
import com.EN.util.WebUtils;
import com.EN.web.formbean.RegisterFormBean;

public class modifAdminServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public modifAdminServlet() {
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
			UserService uSeriver = new UserService();
			User u = uSeriver.fund(request.getParameter("id"));
			request.setAttribute("user", u);
			request.getRequestDispatcher("/jsp/Backstage/en_bs_Admin.jsp").forward(request, response);
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
		RegisterFormBean formbean = WebUtils.request2Bean(request,RegisterFormBean.class);
		//校验用户注册填写的表单数据
		if (formbean.validate() == false) {//如果校验失败
			//将封装了用户填写的表单数据的formbean对象发送回register.jsp页面的form表单中进行显示
			request.setAttribute("formbean", formbean);
			//校验失败就说明是用户填写的表单数据有问题，那么就跳转回register.jsp
			request.getRequestDispatcher("/jsp/Backstage/en_bs_Admin.jsp").forward(request, response);
			return;
		}
		UserService uSeriver = new UserService();
		User u = new User();
		u.setId(request.getParameter("id"));
		u.setUserName(request.getParameter("userName"));
		u.setEmail(request.getParameter("email"));
		
		u.setUserPwd(request.getParameter("confirmPwd"));
		u.setBirthday(request.getParameter("birthday"));
		
		uSeriver.modifUser(u); 
		String message =String.format(
				"修改成功！<meta http-equiv='refresh' content='1;url=%s'", 
				request.getContextPath()+"/servlet/LogoutServlet" );
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
