package com.hlg.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hlg.entity.SubjectDetail;
import com.hlg.entity.SubjectType;
import com.hlg.entity.UserDetail;
import com.hlg.service.SubjectDetailService;
import com.hlg.service.SubjectTypeService;
import com.hlg.util.DateUtil;
import com.hlg.util.ListInfoUtil;
import com.hlg.util.PageBean;

@WebServlet("/SubjectDetailServlet")
public class SubjectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubjectDetailServlet() {
		super();
	}

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		request.setAttribute("subjectTypeList", subjectTypeList);
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
		if ("toAdd".equals(op)) {
			toAdd(request, response);
		} else if ("add".equals(op)) {
			addSubjectDetail(request, response);
		} else if ("list".equals(op)) {
			list(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("toEdit".equals(op)) {
			toEdit(request, response);
		} else if ("update".equals(op)) {
			update(request, response);
		} /*
		 * else if ("search".equals(op)) { search(request, response); }
		 *//*
			 * else if ("toSubjectType".equals(op)) { toSubjectType(request,
			 * response);// 前台新闻类型下的信息列表展示 }
			 */else if ("toSubjectDetail".equals(op)) {
			toSubjectDetail(request, response);
		} else if ("listAll".equals(op)) {
			listAll(request, response);
		}
	}

	private void listAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SubjectDetailService subjectDetailService = new SubjectDetailService();
		List<SubjectDetail> subjectDetailList = subjectDetailService.findAll();
		request.setAttribute("subjectDetailList", subjectDetailList);
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		request.getRequestDispatcher("subject/subject_list_web.jsp").forward(
				request, response);
	}

	// 前台新闻详情展示
	private void toSubjectDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		String id = request.getParameter("id");
		SubjectDetailService subjectDetailService = new SubjectDetailService();
		SubjectDetail subjectDetail = subjectDetailService.findById(id);

		List<SubjectDetail> subjectDetailList = subjectDetailService.findAll();
		request.setAttribute("subjectDetailList", subjectDetailList);
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		request.setAttribute("subjectTypeList", subjectTypeList);

		request.setAttribute("subjectDetail", subjectDetail);
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		request.getRequestDispatcher("subject/subject_detail_show.jsp")
				.forward(request, response);
	}

	/*
	 * // 前台新闻类型下的信息列表展示 private void toSubjectType(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * listInfoUtil.newsInfo(request); listInfoUtil.coorperationInfo(request);
	 * listInfoUtil.subjectInfo(request); listInfoUtil.workInfo(request); String
	 * typeIdStr = request.getParameter("id"); int typeId =
	 * Integer.parseInt(typeIdStr); SubjectDetailService subjectDetailService =
	 * new SubjectDetailService();
	 * 
	 * SubjectTypeService subjectTypeService = new SubjectTypeService();
	 * List<SubjectType> subjectTypeList = subjectTypeService.findAll();
	 * 
	 * List<SubjectDetail> subjectDetailList = subjectDetailService.findAll();
	 * 
	 * request.setAttribute("subjectTypeList", subjectTypeList);
	 * request.setAttribute("subjectDetailList", subjectDetailList);
	 * 
	 * listInfoUtil.newsInfo(request); listInfoUtil.coorperationInfo(request);
	 * listInfoUtil.subjectInfo(request);
	 * request.getRequestDispatcher("subject/subject_list_web.jsp").forward(
	 * request, response); }
	 */

	/*
	 * // 查询 private void search(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * listInfoUtil.newsInfo(request); listInfoUtil.coorperationInfo(request);
	 * listInfoUtil.subjectInfo(request); String subName =
	 * request.getParameter("subName"); String content =
	 * request.getParameter("content"); String typeIdStr =
	 * request.getParameter("typeId"); String author =
	 * request.getParameter("userName"); int typeId =
	 * Integer.parseInt(typeIdStr); SubjectDetail subjectDetail = new
	 * SubjectDetail(subName, content, author, typeId); SubjectDetailService
	 * subjectDetailService = new SubjectDetailService(); List<SubjectDetail>
	 * subjectDetailList = subjectDetailService .findByCondition(subjectDetail);
	 * request.setAttribute("subjectDetailList", subjectDetailList);
	 * request.setAttribute("subjectDetail", subjectDetail);
	 * 
	 * request.getRequestDispatcher("listSubjectDetail.jsp").forward(request,
	 * response);
	 * 
	 * }
	 */

	// 更新
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String subName = request.getParameter("subName");
		String content = request.getParameter("content");
		// String typeIdStr = request.getParameter("typeId");
		String web = request.getParameter("web");
		String publishTimeStr = request.getParameter("publishTime");
		// String passStr = request.getParameter("pass");
		// int pass = Integer.parseInt(passStr);
		/*
		 * String topper = request.getParameter("topper"); String bold =
		 * request.getParameter("bold"); String color =
		 * request.getParameter("color");
		 */
		// int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		SubjectDetail subjectDetail = new SubjectDetail(id, subName, content,
				loginUser.getId(), web, publishTime);
		SubjectDetailService subjectDetailService = new SubjectDetailService();
		int result = subjectDetailService.update(subjectDetail);
		request.getRequestDispatcher("subjectdetailservlet?op=list").forward(
				request, response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);

		String id = request.getParameter("id");
		SubjectDetailService subjectDetailService = new SubjectDetailService();
		SubjectDetail subjectDetail = subjectDetailService.findById(id);
		request.setAttribute("subjectDetail", subjectDetail);
		request.getRequestDispatcher("editSubjectDetail.jsp").forward(request,
				response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		SubjectDetailService subjectDetailService = new SubjectDetailService();
		subjectDetailService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);

		SubjectDetailService subjectDetailService = new SubjectDetailService();
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
			int count = subjectDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<SubjectDetail> subjectDetailList = subjectDetailService
				.findByPage(pageNo, PageBean.pageSize);
		request.setAttribute("subjectDetailList", subjectDetailList);
		request.getRequestDispatcher("listSubjectDetail.jsp").forward(request,
				response);

	}

	private void addSubjectDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String subName = request.getParameter("subName");
		String content = request.getParameter("content");
		// String typeIdStr = request.getParameter("typeId");

		String web = request.getParameter("web");
		String publishTimeStr = request.getParameter("publishTime");
		// int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		SubjectDetail subjectDetail = new SubjectDetail(subName, content,
				loginUser.getId(), web, publishTime);
		SubjectDetailService subjectDetailService = new SubjectDetailService();
		int result = subjectDetailService.save(subjectDetail);

		/*
		 * SubjectTypeService subjectTypeService = new SubjectTypeService();
		 * List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		 * request.setAttribute("subjectTypeList", subjectTypeList);
		 */

		request.getRequestDispatcher("subjectdetailservlet?op=list").forward(
				request, response);

	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);// 此处一定要向该跳转页面传类型名的值，不然添加页面无法显示类型
		request.getRequestDispatcher("addSubjectDetail.jsp").forward(request,
				response);

	}

}
