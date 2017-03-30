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
import com.hlg.entity.SubjectType;
import com.hlg.entity.TeacherDetail;
import com.hlg.entity.UserDetail;
import com.hlg.service.CoorperationDetailService;
import com.hlg.service.CoorperationTypeService;
import com.hlg.service.SubjectTypeService;
import com.hlg.service.TeacherDetailService;
import com.hlg.util.DateUtil;
import com.hlg.util.ListInfoUtil;
import com.hlg.util.PageBean;

/**
 * Servlet implementation class TeacherDetailServlet
 */
@WebServlet("/TeacherDetailServlet")
public class TeacherDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeacherDetailServlet() {
		super();
	}

	ListInfoUtil listInfoUtil = new ListInfoUtil();

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		request.setAttribute("subjectTypeList", subjectTypeList);
	}

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
			addTeacherDetail(request, response);
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
		} else if ("toTeacherDetail".equals(op)) {
			toTeacherDetail(request, response);
		} else if ("toTeacherType".equals(op)) {
			toTeacherType(request, response);// 前台新闻类型下的信息列表展示
		}
	}

	private void toTeacherType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		String typeIdStr = request.getParameter("id");
		int typeId = Integer.parseInt(typeIdStr);
		// System.out.println("类型ID是：" + typeId);
		TeacherDetailService teacherDetailService = new TeacherDetailService();
		List<TeacherDetail> teacherDetailList = teacherDetailService
				.findByTypeId(typeId);
		request.setAttribute("teacherDetailList", teacherDetailList);

		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();

		/*
		 * List<NewsDetail> newsDetailList = newsDetailService
		 * .findByTypeIdAndPage(typeId, pageNo, PageBean.pageSize);
		 */

		request.setAttribute("subjectTypeList", subjectTypeList);
		/* request.setAttribute("newsDetailList", newsDetailList); */

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("teacher/teacher_list_web.jsp").forward(
				request, response);

	}

	// 前台新闻详情展示
	private void toTeacherDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		String id = request.getParameter("id");
		TeacherDetailService teacherDetailService = new TeacherDetailService();
		TeacherDetail teacherDetail = teacherDetailService.findById(id);

		List<TeacherDetail> teacherDetailList = teacherDetailService.findAll();
		request.setAttribute("teacherDetailList", teacherDetailList);
		SubjectTypeService subjectTypeService = new SubjectTypeService();
		List<SubjectType> subjectTypeList = subjectTypeService.findAll();
		request.setAttribute("subjectTypeList", subjectTypeList);
		request.setAttribute("teacherDetail", teacherDetail);

		CoorperationDetailService coorperationDetailService = new CoorperationDetailService();
		List<CoorperationDetail> coorperationDetailList = coorperationDetailService
				.findAll();
		request.setAttribute("coorperationDetailList", coorperationDetailList);
		CoorperationTypeService coorperationTypeService = new CoorperationTypeService();
		List<CoorperationType> coorperationTypeList = coorperationTypeService
				.findAll();
		request.setAttribute("coorperationTypeList", coorperationTypeList);

		request.getRequestDispatcher("teacher/teacher_detail_show.jsp")
				.forward(request, response);
	}

	// 查询
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String teacherName = request.getParameter("teacherName");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String author = request.getParameter("userName");
		int typeId = Integer.parseInt(typeIdStr);
		TeacherDetail teacherDetail = new TeacherDetail(teacherName, content,
				author, typeId);
		TeacherDetailService teacherDetailService = new TeacherDetailService();
		List<TeacherDetail> teacherDetailList = teacherDetailService
				.findByCondition(teacherDetail);
		request.setAttribute("teacherDetailList", teacherDetailList);
		request.setAttribute("teacherDetail", teacherDetail);

		request.getRequestDispatcher("listTeacherDetail.jsp").forward(request,
				response);

	}

	// 新闻更新
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listInfoUtil.subjectInfo(request);
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String teacherName = request.getParameter("teacherName");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String publishTimeStr = request.getParameter("publishTime");

		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		TeacherDetail teacherDetail = new TeacherDetail(id, teacherName,
				content, loginUser.getId(), typeId, publishTime);
		TeacherDetailService teacherDetailService = new TeacherDetailService();
		int result = teacherDetailService.update(teacherDetail);
		request.getRequestDispatcher("teacherdetailservlet?op=list").forward(
				request, response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		listInfoUtil.newsInfo(request);
		listInfoUtil.coorperationInfo(request);
		listInfoUtil.subjectInfo(request);
		listInfoUtil.workInfo(request);
		String id = request.getParameter("id");
		TeacherDetailService teacherDetailService = new TeacherDetailService();
		TeacherDetail teacherDetail = teacherDetailService.findById(id);
		request.setAttribute("teacherDetail", teacherDetail);
		request.getRequestDispatcher("editTeacherDetail.jsp").forward(request,
				response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		TeacherDetailService teacherDetailService = new TeacherDetailService();
		teacherDetailService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listInfoUtil.subjectInfo(request);
		TeacherDetailService teacherDetailService = new TeacherDetailService();
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
			int count = teacherDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<TeacherDetail> teacherDetailList = teacherDetailService
				.findByPage(pageNo, PageBean.pageSize);
		request.setAttribute("teacherDetailList", teacherDetailList);
		request.getRequestDispatcher("listTeacherDetail.jsp").forward(request,
				response);

	}

	// 添加
	private void addTeacherDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		listInfoUtil.subjectInfo(request);
		UserDetail loginUser = (UserDetail) request.getSession().getAttribute(
				"loginUser");
		String teacherName = request.getParameter("teacherName");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String publishTimeStr = request.getParameter("publishTime");
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		TeacherDetail teacherDetail = new TeacherDetail(teacherName, content,
				loginUser.getId(), typeId, publishTime);
		TeacherDetailService teacherDetailService = new TeacherDetailService();
		int result = teacherDetailService.save(teacherDetail);
		request.getRequestDispatcher("teacherdetailservlet?op=list").forward(
				request, response);
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("addTeacherDetail.jsp").forward(request,
				response);

	}

}
