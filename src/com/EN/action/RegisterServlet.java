package com.EN.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;


import com.EN.entity.User;
import com.EN.exception.UserExistException;

import com.EN.service.UserService;
import com.EN.util.WebUtils;
import com.EN.web.formbean.RegisterFormBean;

/**
 * 处理用户注册的Servlet
 * @author gacl
 *
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//将客户端提交的表单数据封装到RegisterFormBean对象中
		RegisterFormBean formbean = WebUtils.request2Bean(request,RegisterFormBean.class);
		//校验用户注册填写的表单数据
		if (formbean.validate() == false) {//如果校验失败
			//将封装了用户填写的表单数据的formbean对象发送回register.jsp页面的form表单中进行显示
			request.setAttribute("formbean", formbean);
			//校验失败就说明是用户填写的表单数据有问题，那么就跳转回register.jsp
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		try {
			// 注册字符串到日期的转换器
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean);//把表单的数据填充到javabean中
			user.setId(WebUtils.makeId());//设置用户的Id属性
			UserService service = new UserService();
			//调用service层提供的注册用户服务实现用户注册
			service.registerUser(user);
			String message = String.format(
					"注册成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request,response);

		} catch (UserExistException e) {
			formbean.getErrors().put("userName", "注册用户已存在！！");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // 在后台记录异常
			request.setAttribute("message", "对不起，注册失败！！");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
