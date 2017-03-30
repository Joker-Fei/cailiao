package com.hlg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlg.entity.WorkType;
import com.hlg.service.WorkTypeService;

/**
 * Servlet implementation class WorkTypeServlet
 */
@WebServlet("/WorkTypeServlet")
public class WorkTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WorkTypeServlet() {
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
			addWorkType(request, response);
		} else if ("list".equals(op)) {
			listWorkType(request, response);
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
		WorkTypeService workTypeService = new WorkTypeService();
		workTypeService.delete(id);
		// 删除数据后，返回列表
		listWorkType(request, response);
	}

	private void listWorkType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WorkTypeService workTypeService = new WorkTypeService();
		List<WorkType> workTypeList = workTypeService.findAll();
		request.setAttribute("workTypeList", workTypeList);
		request.getRequestDispatcher("listWorkType.jsp").forward(request,
				response);

	}

	private void addWorkType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		WorkType workType = new WorkType(typeName);
		WorkTypeService workTypeService = new WorkTypeService();
		workTypeService.save(workType);
		response.sendRedirect("listWorkType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).

	}

}
