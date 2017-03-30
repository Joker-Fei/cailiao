package com.hlg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlg.entity.AccreditationType;
import com.hlg.service.AccreditationTypeService;

/**
 * Servlet implementation class AccreditationTypeServlet
 */
@WebServlet("/AccreditationTypeServlet")
public class AccreditationTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccreditationTypeServlet() {
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
			addAccreditationType(request, response);
		} else if ("list".equals(op)) {
			listAccreditationType(request, response);
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
		AccreditationTypeService accreditationTypeService = new AccreditationTypeService();
		accreditationTypeService.delete(id);
		// 删除数据后，返回列表
		listAccreditationType(request, response);
	}

	private void listAccreditationType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		AccreditationTypeService accreditationTypeService = new AccreditationTypeService();
		List<AccreditationType> accreditationTypeList = accreditationTypeService
				.findAll();
		request.setAttribute("accreditationTypeList", accreditationTypeList);
		request.getRequestDispatcher("web/acc/listAccreditationType.jsp")
				.forward(request, response);

	}

	private void addAccreditationType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		AccreditationType accreditationType = new AccreditationType(typeName);
		AccreditationTypeService accreditationTypeService = new AccreditationTypeService();
		accreditationTypeService.save(accreditationType);
		response.sendRedirect("web/acc/listAccreditationType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).

	}

}
