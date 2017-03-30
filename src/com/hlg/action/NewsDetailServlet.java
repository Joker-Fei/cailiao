package com.hlg.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hlg.entity.CoorperationDetail;
import com.hlg.entity.CoorperationType;
import com.hlg.entity.NewsDetail;
import com.hlg.entity.NewsType;
import com.hlg.entity.SubjectType;
import com.hlg.entity.TopNewsDetail;
import com.hlg.entity.UserDetail;
import com.hlg.service.CoorperationDetailService;
import com.hlg.service.CoorperationTypeService;
import com.hlg.service.NewsDetailService;
import com.hlg.service.NewsTypeService;
import com.hlg.service.SubjectTypeService;
import com.hlg.service.TopNewsDetailService;
import com.hlg.util.DateUtil;
import com.hlg.util.ListInfoUtil;
import com.hlg.util.PageBean;

/**
 * Servlet implementation class NewsDetailServlet
 */
@WebServlet("/NewsDetailServlet")
public class NewsDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewsDetailServlet() {
		super();
	}

	ListInfoUtil l = new ListInfoUtil();

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
	}

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
		String op = request.getParameter("op");
		if ("toAdd".equals(op)) {
			toAdd(request, response);
		} else if ("add".equals(op)) {
			addNewsDetail(request, response);
		} else if ("list".equals(op)) {
			list(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("toEdit".equals(op)) {
			toEdit(request, response);
		} else if ("update".equals(op)) {
			update(request, response);
		} else if ("search".equals(op)) {
			search(request, response);
		} else if ("toFirstWeb".equals(op)) {
			toFirstWeb(request, response);
		} else if ("toNewsDetail".equals(op)) {
			toNewsDetail(request, response);
		} else if ("toNewsType".equals(op)) {
			toNewsType(request, response);// 前台新闻类型下的信息列表展示
		} else if ("toAcademyInfo".equals(op)) {
			toAcademyInfo(request, response);
		} else if ("changeStatus".equals(op)) {
			changeStatus(request, response);
		}
	}

	/**
	 * 改变状态（通过=0|未通过=1）
	 * 
	 * @param request
	 * @param response
	 */
	private void changeStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String idStr = request.getParameter("id");
		if (idStr == null || "".equals(idStr)) {
			return;
		}
		int id = Integer.parseInt(idStr);
		NewsDetailService newsDetailService = new NewsDetailService();
		newsDetailService.changeStatus(id);
	}

	private void toAcademyInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		NewsDetailService newsDetailService = new NewsDetailService();
		NewsDetail newsDetail = newsDetailService.findById(id);

		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		request.setAttribute("newsDetail", newsDetail);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("academyInfo/news_academyInfo.jsp")
				.forward(request, response);

	}

	// 前台新闻类型下的信息列表展示
	private void toNewsType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		l.newsInfo(request);
		l.coorperationInfo(request);
		l.subjectInfo(request);
		l.workInfo(request);
		int end;
		String typeIdStr = request.getParameter("id");
		int typeId = Integer.parseInt(typeIdStr);
		/* System.out.println("类型ID是：" + typeId); */
		NewsDetailService newsDetailService = new NewsDetailService();

		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();

		/*
		 * List<NewsDetail> newsDetailList = newsDetailService
		 * .findByTypeIdAndPage(typeId, pageNo, PageBean.pageSize);
		 */
		List<NewsDetail> newsDetailByTypeList = newsDetailService
				.findByTypeId(typeId);

		/*---------------------------------*/
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoStr != null && !"".equals(pageNoStr)) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		// 统计数量
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) request.getAttribute("pageBean");
		if (pageBean == null) {
			pageBean = new PageBean();
			int count = newsDetailByTypeList.size();
			pageBean.setRowCount(count);
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		request.setAttribute("pageBean", pageBean);
		// 分页显示的尾数

		if (pageBean.getRowCount() < pageNo * PageBean.pageSize) {
			end = pageBean.getRowCount();
		} else {
			end = pageNo * PageBean.pageSize;
		}
		// System.out.println("end" + end);
		// 未前台显示。使用的request对象赋值
		List<NewsDetail> newsDetailByType = new ArrayList<NewsDetail>();
		if (newsDetailByTypeList.size() != 0) {
			for (int i = ((pageNo - 1) * PageBean.pageSize); i < end; i++) {
				/* System.out.println("for循环i=" + i); */
				// System.out.println("22222222"+typeListAll.get(i).getTitle());
				NewsDetail newsDetail = newsDetailByTypeList.get(i);
				newsDetailByType.add(newsDetail);
			}
		}
		/*
		 * List<NewsDetail> newsDetailList =
		 * newsDetailService.findByPage(pageNo, PageBean.pageSize);
		 */
		/*---------------------------------*/
		request.setAttribute("newsDetailByType", newsDetailByType);
		request.setAttribute("newsTypeList", newsTypeList);
		NewsType type = new NewsType();
		for (NewsType a : newsTypeList) {
			if (typeId == a.getId()) {
				type = a;
			}
		}
		request.setAttribute("type", type);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("academyInfo/news_list_web.jsp").forward(
				request, response);
	}

	// 前台新闻详情展示
	private void toNewsDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		NewsDetailService newsDetailService = new NewsDetailService();
		NewsDetail newsDetail = newsDetailService.findById(id);

		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);
		request.setAttribute("newsDetail", newsDetail);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("academyInfo/news_detail_show.jsp")
				.forward(request, response);
	}

	private void toFirstWeb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		l.subjectInfo(request);
		l.workInfo(request);
		// System.out.println("进入toFirstWeb");
		NewsDetailService newsDetailService = new NewsDetailService();

		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);

		// 前台学院动态显示
		List<NewsDetail> xueyuandongtai = newsDetailService.findByTypeId(4);
		request.setAttribute("xueyuandongtai", xueyuandongtai);

		// 前台通知公告显示
		List<NewsDetail> tongzhigonggao = newsDetailService.findByTypeId(3);
		request.setAttribute("tongzhigonggao", tongzhigonggao);

		// 前台科研与合作（交流合作显示区）
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> hezuojiaoliu = coorperationDetailService
				.findByTypeId(1);
		request.setAttribute("hezuojiaoliu", hezuojiaoliu);
		// 前台合作与交流下拉框内容显示（类型名）
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		// 专业介绍显示（学科介绍）
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		request.setAttribute("subjectTypeList", subjectTypeList);

		// 热点资讯展示
		TopNewsDetailService topNewsDetailService = new TopNewsDetailService();
		List<TopNewsDetail> topNewsDetailList = topNewsDetailService.findAll();
		request.setAttribute("topNewsDetailList", topNewsDetailList);

		request.getRequestDispatcher("firstweb.jsp").forward(request, response);

	}

	// 查询
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String author = request.getParameter("userName");
		int typeId = Integer.parseInt(typeIdStr);
		NewsDetail newsDetail = new NewsDetail(title, content, author, typeId);
		NewsDetailService newsDetailService = new NewsDetailService();
		List<NewsDetail> newsDetailList = newsDetailService
				.findByCondition(newsDetail);
		request.setAttribute("newsDetailList", newsDetailList);
		request.setAttribute("newsDetail", newsDetail);

		request.getRequestDispatcher("listNewsDetail.jsp").forward(request,
				response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		NewsDetailService newsDetailService = new NewsDetailService();
		NewsDetail newsDetail = newsDetailService.findById(id);
		request.setAttribute("newsDetail", newsDetail);
		request.getRequestDispatcher("editNewsDetail.jsp").forward(request,
				response);

	}

	// 新闻更新
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String publishTimeStr = request.getParameter("publishTime");
		String passStr = request.getParameter("pass");
		int pass = Integer.parseInt(passStr);
		/*
		 * String topper = request.getParameter("topper"); String bold =
		 * request.getParameter("bold"); String color =
		 * request.getParameter("color");
		 */
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		NewsDetail newsDetail = new NewsDetail(id, title, content,
				loginUser.getId(), typeId, publishTime, pass);
		NewsDetailService newsDetailService = new NewsDetailService();
		int result = newsDetailService.update(newsDetail);
		request.getRequestDispatcher("newsdetailservlet?op=list").forward(
				request, response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		NewsDetailService newsDetailService = new NewsDetailService();
		newsDetailService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		NewsDetailService newsDetailService = new NewsDetailService();
		// 查询所有的
		// List<UserDetail> userList = userDetailService.findAll();
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoStr != null && !"".equals(pageNoStr)) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		// 统计数量
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute("pageBean");
		if (pageBean == null) {
			pageBean = new PageBean();
			int count = newsDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<NewsDetail> newsDetailList = newsDetailService.findByPage(pageNo,
				PageBean.pageSize);
		request.setAttribute("newsDetailList", newsDetailList);
		request.getRequestDispatcher("listNewsDetail.jsp").forward(request,
				response);

	}

	// 添加新闻
	private void addNewsDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String publishTimeStr = request.getParameter("publishTime");
		String passStr = request.getParameter("pass");
		int pass = Integer.parseInt(passStr);
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		NewsDetail newsDetail = new NewsDetail(title, content,
				loginUser.getId(), typeId, publishTime, pass);
		NewsDetailService newsDetailService = new NewsDetailService();
		int result = newsDetailService.save(newsDetail);
		request.getRequestDispatcher("newsdetailservlet?op=list").forward(
				request, response);
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("addNewsDetail.jsp").forward(request,
				response);

	}

}
