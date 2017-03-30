package com.hlg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlg.entity.SubjectType;
import com.hlg.service.SubjectTypeService;

/**
 * Servlet implementation class SubjectTypeServlet
 */
@WebServlet("/SubjectTypeServlet")
public class SubjectTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubjectTypeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");// 注意：此处的JSP页面不放在根目录下，Servlet就无法接收到页面传来的数据，因为web.xml配置信息无法覆盖
		if ("add".equals(op)) {
			addSubjectType(request, response);
		} else if ("list".equals(op)) {
			listSubjectType(request, response);
		} else if ("delete".equals(op)) {
			deleteById(request, response);
		}
	}

	// 根据Id删除数据
	private void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String idStr = request.getParameter("id");

		int id = Integer.parseInt(idStr);
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		subjectTypeService.delete(id);
		// 删除数据后，返回列表
		listSubjectType(request, response);
	}

	private void listSubjectType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		request.setAttribute("subjectTypeList", subjectTypeList);
		request.getRequestDispatcher("listSubjectType.jsp").forward(request,
				response);

	}

	private void addSubjectType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		SubjectType subjectType = new SubjectType(typeName);
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		subjectTypeService.save(subjectType);
		response.sendRedirect("listSubjectType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).

	}

}
