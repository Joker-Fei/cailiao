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

import com.hlg.entity.CoorperationDetail;
import com.hlg.entity.CoorperationType;
import com.hlg.entity.SubjectDetail;
import com.hlg.entity.SubjectType;
import com.hlg.entity.UserDetail;
import com.hlg.entity.WorkDetail;
import com.hlg.entity.WorkType;
import com.hlg.service.CoorperationDetailService;
import com.hlg.service.CoorperationTypeService;
import com.hlg.service.SubjectDetailService;
import com.hlg.service.SubjectTypeService;
import com.hlg.service.WorkDetailService;
import com.hlg.service.WorkTypeService;
import com.hlg.util.DateUtil;
import com.hlg.util.ListInfoUtil;
import com.hlg.util.PageBean;

/**
 * Servlet implementation class WorkDetailServlet
 */
@WebServlet("/WorkDetailServlet")
public class WorkDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WorkDetailServlet() {
		super();
	}

	ListInfoUtil listInfoUtil = new ListInfoUtil();

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		WorkTypeService workTypeService = new WorkTypeService();
		List<WorkType> workTypeList = workTypeService.findAll();
		request.setAttribute("workTypeList", workTypeList);
	}

	// 学院学科介绍方法
	public void subjectInfo(HttpServletRequest request) {

		SubjectDetailService subjectDetailService = new SubjectDetailService();

		List<SubjectDetail> subjectDetailList = subjectDetailService.findAll();
		request.setAttribute("subjectDetailList", subjectDetailList);
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		request.setAttribute("subjectTypeList", subjectTypeList);
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
			addWorkDetail(request, response);
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
		} else if ("toWorkDetail".equals(op)) {
			toWorkDetail(request, response);
		} else if ("toWorkDetail2".equals(op)) {
			toWorkDetail2(request, response);
		} else if ("toWorkType".equals(op)) {
			toWorkType(request, response);// 前台新闻类型下的信息列表展示
		} else if ("toAcademyInfo".equals(op)) {
			toAcademyInfo(request, response);
		}
	}

	private void toAcademyInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);

		String id = request.getParameter("id");
		WorkDetailService workDetailService = new WorkDetailService();
		WorkDetail workDetail = workDetailService.findById(id);

		List<WorkDetail> workDetailList = workDetailService.findAll();
		request.setAttribute("workDetailList", workDetailList);
		WorkTypeService workTypeService = new WorkTypeService();
		List<WorkType> workTypeList = workTypeService.findAll();
		request.setAttribute("workTypeList", workTypeList);
		request.setAttribute("workDetail", workDetail);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("workInfo/work_workInfo.jsp").forward(
				request, response);

	}

	// 前台新闻类型下的信息列表展示
	private void toWorkType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		String typeIdStr = request.getParameter("id");
		int typeId = Integer.parseInt(typeIdStr);
		System.out.println("类型ID是：" + typeId);
		WorkDetailService workDetailService = new WorkDetailService();

		/*---------------------------------*/
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
			int count = workDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		/*
		 * List<WorkDetail> workDetailList =
		 * workDetailService.findByPage(pageNo, PageBean.pageSize);
		 */
		/*---------------------------------*/

		/*
		 * List<WorkDetail> workDetailList = workDetailService
		 * .findByTypeId(typeId);
		 */
		/*
		 * System.out.println(pageNo); System.out.println(PageBean.pageSize);
		 */
		WorkTypeService workTypeService = new WorkTypeService();
		List<WorkType> workTypeList = workTypeService.findAll();

		List<WorkDetail> workDetailList = workDetailService
				.findByTypeIdAndPage(typeId, pageNo, PageBean.pageSize);

		request.setAttribute("workTypeList", workTypeList);
		request.setAttribute("workDetailList", workDetailList);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("workInfo/work_list_web.jsp").forward(
				request, response);
	}

	// 前台新闻详情展示
	private void toWorkDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);

		String id = request.getParameter("id");
		WorkDetailService workDetailService = new WorkDetailService();
		WorkDetail workDetail = workDetailService.findById(id);

		List<WorkDetail> workDetailList = workDetailService.findAll();
		request.setAttribute("workDetailList", workDetailList);
		WorkTypeService workTypeService = new WorkTypeService();
		List<WorkType> workTypeList = workTypeService.findAll();
		request.setAttribute("workTypeList", workTypeList);
		request.setAttribute("workDetail", workDetail);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("workInfo/work_detail_show.jsp").forward(
				request, response);
	}

	// 后台新闻详情展示
	private void toWorkDetail2(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);

		String id = request.getParameter("id");
		WorkDetailService workDetailService = new WorkDetailService();
		WorkDetail workDetail = workDetailService.findById(id);

		List<WorkDetail> workDetailList = workDetailService.findAll();
		request.setAttribute("workDetailList", workDetailList);
		WorkTypeService workTypeService = new WorkTypeService();
		List<WorkType> workTypeList = workTypeService.findAll();
		request.setAttribute("workTypeList", workTypeList);
		request.setAttribute("workDetail", workDetail);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("workInfo/back_work_detail_show.jsp")
				.forward(request, response);
	}

	private void toFirstWeb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		WorkDetailService workDetailService = new WorkDetailService();

		List<WorkDetail> workDetailList = workDetailService.findAll();
		request.setAttribute("workDetailList", workDetailList);
		WorkTypeService workTypeService = new WorkTypeService();
		List<WorkType> workTypeList = workTypeService.findAll();
		request.setAttribute("workTypeList", workTypeList);

		// 前台学院动态显示
		List<WorkDetail> xueyuandongtai = workDetailService.findByTypeId(4);
		request.setAttribute("xueyuandongtai", xueyuandongtai);

		// 前台通知公告显示
		List<WorkDetail> tongzhigonggao = workDetailService.findByTypeId(3);
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

		/*
		 * // 热点资讯展示 TopWorkDetailService topWorkDetailService = new
		 * TopWorkDetailService(); List<TopWorkDetail> topWorkDetailList =
		 * topWorkDetailService.findAll();
		 * request.setAttribute("topWorkDetailList", topWorkDetailList);
		 */

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
		WorkDetail workDetail = new WorkDetail(title, content, author, typeId);
		WorkDetailService workDetailService = new WorkDetailService();
		List<WorkDetail> workDetailList = workDetailService
				.findByCondition(workDetail);
		request.setAttribute("workDetailList", workDetailList);
		request.setAttribute("workDetail", workDetail);

		request.getRequestDispatcher("listWorkDetail.jsp").forward(request,
				response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		WorkDetailService workDetailService = new WorkDetailService();
		WorkDetail workDetail = workDetailService.findById(id);
		request.setAttribute("workDetail", workDetail);
		request.getRequestDispatcher("editWorkDetail.jsp").forward(request,
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
		WorkDetail workDetail = new WorkDetail(id, title, content,
				loginUser.getId(), typeId, publishTime, pass);
		WorkDetailService workDetailService = new WorkDetailService();
		int result = workDetailService.update(workDetail);
		request.getRequestDispatcher("workdetailservlet?op=list").forward(
				request, response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		WorkDetailService workDetailService = new WorkDetailService();
		workDetailService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		WorkDetailService workDetailService = new WorkDetailService();
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
			int count = workDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<WorkDetail> workDetailList = workDetailService.findByPage(pageNo,
				PageBean.pageSize);
		request.setAttribute("workDetailList", workDetailList);
		request.getRequestDispatcher("listWorkDetail.jsp").forward(request,
				response);

	}

	// 添加新闻
	private void addWorkDetail(HttpServletRequest request,
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
		WorkDetail workDetail = new WorkDetail(title, content,
				loginUser.getId(), typeId, publishTime, pass);
		WorkDetailService workDetailService = new WorkDetailService();
		int result = workDetailService.save(workDetail);
		request.getRequestDispatcher("workdetailservlet?op=list").forward(
				request, response);
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("addWorkDetail.jsp").forward(request,
				response);

	}

}
