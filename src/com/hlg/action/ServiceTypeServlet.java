package com.hlg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlg.entity.ServiceType;
import com.hlg.service.ServiceTypeService;

/**
 * Servlet implementation class ServiceTypeServlet
 */
@WebServlet("/ServiceTypeServlet")
public class ServiceTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServiceTypeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see 处理Post请求#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");// 注意：此处的JSP页面不放在根目录下，Servlet就无法接收到页面传来的数据，因为web.xml配置信息无法覆盖
		if ("add".equals(op)) {
			addServiceType(request, response);
		} else if ("list".equals(op)) {
			listServiceType(request, response);
		} else if ("delete".equals(op)) {
			deleteById(request, response);
		}
		/*
		 * else if ("delete".equals(op)) { deleteById(request, response); }
		 */

	}

	// 根据Id删除数据
	private void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String idStr = request.getParameter("id");
		/*
		 * if (idStr == null || "".equals(idStr)) {
		 * out.write("<script>alert('密码不能为空');history.back();</script>");
		 * return; }
		 */
		int id = Integer.parseInt(idStr);
		ServiceTypeService serviceTypeService = new ServiceTypeService();
		serviceTypeService.delete(id);
		// 删除数据后，返回列表
		listServiceType(request, response);
	}

	private void listServiceType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServiceTypeService serviceTypeService = new ServiceTypeService();
		List<ServiceType> serviceTypeList = serviceTypeService.findAll();
		request.setAttribute("serviceTypeList", serviceTypeList);
		request.getRequestDispatcher("web/service/listServiceType.jsp")
				.forward(request, response);

	}

	private void addServiceType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		ServiceType serviceType = new ServiceType(typeName);
		ServiceTypeService serviceTypeService = new ServiceTypeService();
		serviceTypeService.save(serviceType);
		response.sendRedirect("web/service/listServiceType.jsp");

		// response.sendRedirect的功能是地址重定向(页面跳转).

	}

}
