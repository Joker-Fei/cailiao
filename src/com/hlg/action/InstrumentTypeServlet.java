package com.hlg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlg.entity.InstrumentType;
import com.hlg.service.InstrumentTypeService;

/**
 * Servlet implementation class InstrumentTypeServlet
 */
@WebServlet("/InstrumentTypeServlet")
public class InstrumentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstrumentTypeServlet() {
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
			addInstrumentType(request, response);
		} else if ("list".equals(op)) {
			listInstrumentType(request, response);
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
		InstrumentTypeService instrumentTypeService = new InstrumentTypeService();
		instrumentTypeService.delete(id);
		// 删除数据后，返回列表
		listInstrumentType(request, response);
	}

	private void listInstrumentType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		InstrumentTypeService instrumentTypeService = new InstrumentTypeService();
		List<InstrumentType> instrumentTypeList = instrumentTypeService
				.findAll();
		request.setAttribute("instrumentTypeList", instrumentTypeList);
		request.getRequestDispatcher("web/instru/listInstrumentType.jsp")
				.forward(request, response);

	}

	private void addInstrumentType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		InstrumentType instrumentType = new InstrumentType(typeName);
		InstrumentTypeService instrumentTypeService = new InstrumentTypeService();
		instrumentTypeService.save(instrumentType);
		response.sendRedirect("web/instru/listInstrumentType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).

	}

}
