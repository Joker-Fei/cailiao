package com.hlg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hlg.entity.NewsType;
import com.hlg.service.NewsTypeService;

/**
 * Servlet implementation class NewsTypeServlet
 */
@WebServlet("/NewsTypeServlet")
public class NewsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsTypeServlet() {
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
			addNewsType(request, response);
		} else if ("list".equals(op)) {
			listNewsType(request, response);
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
		NewsTypeService newsTypeService = new NewsTypeService();
		newsTypeService.delete(id);
		// 删除数据后，返回列表
		listNewsType(request, response);
	}

	private void listNewsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		request.getRequestDispatcher("listNewsType.jsp").forward(request,
				response);

	}

	private void addNewsType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("typeName");
		NewsType newsType = new NewsType(typeName);
		NewsTypeService newsTypeService = new NewsTypeService();
		newsTypeService.save(newsType);
		response.sendRedirect("listNewsType.jsp");// response.sendRedirect的功能是地址重定向(页面跳转).

	}

}
