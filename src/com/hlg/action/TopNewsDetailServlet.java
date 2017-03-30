package com.hlg.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.hlg.entity.NewsDetail;
import com.hlg.entity.NewsType;
import com.hlg.entity.TopNewsDetail;
import com.hlg.entity.UserDetail;
import com.hlg.service.NewsDetailService;
import com.hlg.service.NewsTypeService;
import com.hlg.service.TopNewsDetailService;
import com.hlg.util.DateUtil;
import com.hlg.util.ListInfoUtil;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


/**
 * Servlet implementation class TopNewsDetailServlet
 */
@WebServlet("/TopNewsDetailServlet")
public class TopNewsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TopNewsDetailServlet() {
		super();
	}

	ListInfoUtil listInfoUtil = new ListInfoUtil();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("toAddTopNews".equals(op)) {
			toAddTopNews(request, response);
		} else if ("addTopNews".equals(op)) {
			try {
				addTopNews(request, response);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("list".equals(op)) {
			list(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("toTopNewsDetail".equals(op)) {
			toTopNewsDetail(request, response);
		} else if ("toTopNewsDetailWeb".equals(op)) {
			toTopNewsDetailWeb(request, response);
		} else if ("topNewsEveryday".equals(op)) {
			topNewsEveryday(request, response);
		}
	}

	// 根据新闻类型进行查询
	private void topNewsEveryday(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// init(request);
		NewsDetailService newsDetailService = new NewsDetailService();

		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);

		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		// TopNewsDetail topNewsDetail = topNewsDetailService.findById(id);
		// request.setAttribute("topNewsDetail", topNewsDetail);
		List<TopNewsDetail> topNewsDetailList = topNewsDetailService.findAll();
		request.setAttribute("topNewsDetailList", topNewsDetailList);

		request.getRequestDispatcher("TOP.jsp").forward(request, response);
	}

	// 详情显示
	private void toTopNewsDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();

		TopNewsDetail topNewsDetail = topNewsDetailService.findById(id);

		request.setAttribute("topNewsDetail", topNewsDetail);

		request.getRequestDispatcher("showTopNewsDetail.jsp").forward(request,
				response);
	}

	// 前台 详情显示
	private void toTopNewsDetailWeb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		String id = request.getParameter("id");
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();

		TopNewsDetail topNewsDetail = topNewsDetailService.findById(id);

		request.setAttribute("topNewsDetail", topNewsDetail);

		List<TopNewsDetail> topNewsDetailList = topNewsDetailService.findAll();
		request.setAttribute("topNewsDetailList", topNewsDetailList);

		request.getRequestDispatcher("topnews/topnews_detail_show.jsp")
				.forward(request, response);
	}

	// 删除
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		topNewsDetailService.delete(id);
		list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		List<TopNewsDetail> topNewsDetailList = topNewsDetailService.findAll();
		request.setAttribute("topNewsDetailList", topNewsDetailList);
		request.getRequestDispatcher("listTopNews.jsp").forward(request,
				response);
	}

	// 添加头条新闻
	private void addTopNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SmartUploadException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");

		SmartUpload su = new SmartUpload("utf-8");
		JspFactory _jspxFactory = null;
		PageContext pageContext = null;
		_jspxFactory = JspFactory.getDefaultFactory();
		pageContext = _jspxFactory.getPageContext(this, request, response, "",
				true, 8192, true);
		su.initialize(pageContext);
		su.service(request, response);
		su.setTotalMaxFileSize(100000000);
		su.setAllowedFilesList("gif,jpg,bmp,txt,doc,xls,htm,html,JPG,zip,rar,png,PNG");
		// su.setDeniedFilesList("exe,bat,jsp,htm,html,,");

		su.upload();

		com.jspsmart.upload.SmartFile file = su.getFiles().getFile(0);
		Date date = new Date();
		String newName = date.getTime()
				+ file.getFileName().substring(
						file.getFileName().lastIndexOf("."));
		file.saveAs("/upload/" + newName);

		String title = su.getRequest().getParameter("title");
		String imgUrl = "upload/" + newName;
		String content = su.getRequest().getParameter("content");
		String publishTimeStr = su.getRequest().getParameter("publishTime");

		Date publishTime = DateUtil.string2Date(publishTimeStr);
		TopNewsDetail topNsewsDetail = new TopNewsDetail(title, imgUrl,
				content, loginUser.getId(), publishTime);
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		int result = topNewsDetailService.save(topNsewsDetail);
		request.getRequestDispatcher("topnewsdetailservlet?op=list").forward(
				request, response);

	}

	// 跳转到添加头条新闻页面
	private void toAddTopNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("addTopNews.jsp").forward(request,
				response);

	}
}