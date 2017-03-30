package com.hlg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlg.entity.CoorperationType;
import com.hlg.service.CoorperationTypeService;

/**
 * Servlet implementation class CoorperationTypeServlet
 */
@WebServlet("/CoorperationTypeServlet")
public class CoorperationTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoorperationTypeServlet() {
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
			addCoorperationType(request, response);
		} else if ("list".equals(op)) {
			listCoorperationType(request, response);
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
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		coorperationTypeService.delete(id);
		// 删除数据后，返回列表
		listCoorperationType(request, response);
	}

	private void listCoorperationType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);
		request.getRequestDispatcher("listCoorperationType.jsp").forward(
				request, response);

	}

	private void addCoorperationType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		CoorperationType coorperationType = new CoorperationType(typeName);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		coorperationTypeService.save(coorperationType);
		response.sendRedirect("listCoorperationType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).

	}

}
