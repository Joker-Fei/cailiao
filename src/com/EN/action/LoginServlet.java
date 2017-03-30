package com.EN.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EN.entity.User;
import com.EN.service.UserService;

/**
 * 处理用户登录的servlet
 * @author gacl
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取用户填写的登录用户名
		String username = request.getParameter("username");
		//获取用户填写的登录密码
		String password = request.getParameter("password");
		
		UserService service = new UserService();
		//用户登录
		User user = service.loginUser(username, password);
		if(user==null){
			String message = String.format(
					"对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//登录成功后，就将用户存储到session中
		request.getSession().setAttribute("user", user);
		String message = String.format(
				"管理员：%s,登陆成功！！<meta http-equiv='refresh' content='1;url=%s'", 
				user.getUserName(),
				request.getContextPath()+"/jsp/en_BACKSTAGE.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
