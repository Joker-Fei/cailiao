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
import com.hlg.entity.UserDetail;
import com.hlg.service.CoorperationDetailService;
import com.hlg.service.CoorperationTypeService;
import com.hlg.service.NewsDetailService;
import com.hlg.service.NewsTypeService;
import com.hlg.util.DateUtil;
import com.hlg.util.ListInfoUtil;
import com.hlg.util.PageBean;

/**
 * Servlet implementation class CoorperationDetailServlet
 */
@WebServlet("/CoorperationDetailServlet")
public class CoorperationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CoorperationDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	ListInfoUtil listInfoUtil = new ListInfoUtil();

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);
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
			addCoorperationDetail(request, response);
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
		} else if ("toCoorperationType".equals(op)) {
			toCoorperationType(request, response);// 前台新闻类型下的信息列表展示
		} else if ("toCoorperationDetail".equals(op)) {
			toCoorperationDetail(request, response);
		} else if ("toCoorperationMain".equals(op)) {
			toCoorperationMain(request, response);
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
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		coorperationDetailService.changeStatus(id);
	}

	private void toCoorperationMain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		request.getRequestDispatcher("coorperation/main_info.jsp").forward(
				request, response);
	}

	// 前台新闻详情展示
	private void toCoorperationDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		String id = request.getParameter("id");
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		CoorperationDetail coorperationDetail = coorperationDetailService
				.findById(id);

		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.setAttribute("coorperationDetail", coorperationDetail);

		NewsDetailService newsDetailService = new NewsDetailService();

		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);

		request.getRequestDispatcher(
				"coorperation/coorperation_detail_show.jsp").forward(request,
				response);
	}

	private void toCoorperationType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		int end;
		String typeIdStr = request.getParameter("id");
		int typeId = Integer.parseInt(typeIdStr);
		/* System.out.println("类型ID是：" + typeId); */
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();

		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();

		/*
		 * List<CoorperationDetail> coorperationDetailList =
		 * coorperationDetailService .findByTypeIdAndPage(typeId, pageNo,
		 * PageBean.pageSize);
		 */
		List<CoorperationDetail> coorperationDetailByTypeList = coorperationDetailService
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
			int count = coorperationDetailByTypeList.size();
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
		List<CoorperationDetail> coorperationDetailByType = new ArrayList<CoorperationDetail>();
		if (coorperationDetailByTypeList.size() != 0) {
			for (int i = ((pageNo - 1) * PageBean.pageSize); i < end; i++) {
				/* System.out.println("for循环i=" + i); */
				// System.out.println("22222222"+typeListAll.get(i).getTitle());
				CoorperationDetail coorperationDetail = coorperationDetailByTypeList
						.get(i);
				coorperationDetailByType.add(coorperationDetail);
			}
		}
		/*
		 * List<CoorperationDetail> coorperationDetailList =
		 * coorperationDetailService.findByPage(pageNo, PageBean.pageSize);
		 */
		/*---------------------------------*/
		request.setAttribute("coorperationDetailByType",
				coorperationDetailByType);
		request.setAttribute("coorperationTypeList", coorperationTypeList);
		CoorperationType type = new CoorperationType();
		for (CoorperationType a : coorperationTypeList) {
			if (typeId == a.getId()) {
				type = a;
			}
		}
		request.setAttribute("type", type);

		NewsDetailService newsDetailService = new NewsDetailService();
		List<NewsDetail> newsDetailList = newsDetailService.findAll();
		request.setAttribute("newsDetailList", newsDetailList);
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> newsTypeList = newsTypeService.findAll();
		request.setAttribute("newsTypeList", newsTypeList);

		request.getRequestDispatcher("coorperation/coorperation_list_web.jsp")
				.forward(request, response);
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
		CoorperationDetail coorperationDetail = new CoorperationDetail(title,
				content, author, typeId);
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findByCondition(coorperationDetail);
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		request.setAttribute("coorperationDetail", coorperationDetail);

		request.getRequestDispatcher("listCoorperationDetail.jsp").forward(
				request, response);

	}

	// 更新
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
		CoorperationDetail coorperationDetail = new CoorperationDetail(id,
				title, content, loginUser.getId(), typeId, publishTime, pass);
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		int result = coorperationDetailService.update(coorperationDetail);
		request.getRequestDispatcher("coorperationdetailservlet?op=list")
				.forward(request, response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		CoorperationDetail coorperationDetail = coorperationDetailService
				.findById(id);
		request.setAttribute("coorperationDetail", coorperationDetail);
		request.getRequestDispatcher("editCoorperationDetail.jsp").forward(
				request, response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		coorperationDetailService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
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
			int count = coorperationDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findByPage(pageNo, PageBean.pageSize);
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		request.getRequestDispatcher("listCoorperationDetail.jsp").forward(
				request, response);

	}

	private void addCoorperationDetail(HttpServletRequest request,
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
		CoorperationDetail coorperationDetail = new CoorperationDetail(title,
				content, loginUser.getId(), typeId, publishTime, pass);
		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		int result = coorperationDetailService.save(coorperationDetail);
		request.getRequestDispatcher("coorperationdetailservlet?op=list")
				.forward(request, response);

	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("addCoorperationDetail.jsp").forward(
				request, response);

	}

}
