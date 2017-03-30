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

import com.hlg.entity.PhotoType;
import com.hlg.entity.SamplePhoto;
import com.hlg.entity.UserTestCenter;
import com.hlg.service.PhotoTypeService;
import com.hlg.service.SamplePhotoService;
import com.hlg.util.DateUtil;
import com.hlg.util.PageBean;
import com.hlg.util.SelectTestType;

/**
 * Servlet implementation class SamplePhotoServlet
 */
@WebServlet("/SamplePhotoServlet")
public class SamplePhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SamplePhotoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		PhotoTypeService photoTypeService = new PhotoTypeService();
		List<PhotoType> photoTypeList = photoTypeService.findAll();
		request.setAttribute("photoTypeList", photoTypeList);
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
			addSamplePhoto(request, response);
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
		} else if ("toSamplePhoto".equals(op)) {
			toSamplePhoto(request, response);
		}
		// 前台显示
		else if ("toSamplePhotoType".equals(op)) {
			toSamplePhotoType(request, response);
		}
	}

	// 类型概况
	private void toSamplePhotoType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		SamplePhotoService samplePhotoService = new SamplePhotoService();
		// 前台中心概况动态显示
		List<SamplePhoto> samplePhotoList = samplePhotoService
				.findByTypeId(typeId);
		if (typeId == 1) {
			if (samplePhotoList.size() != 0) {
				SamplePhoto samplePhotoDetail0 = samplePhotoList.get(0);
				List<SamplePhoto> samplePhotoDetail = new ArrayList<SamplePhoto>();
				samplePhotoDetail.add(samplePhotoDetail0);
				request.setAttribute("samplePhotoDetail", samplePhotoDetail);
				request.getRequestDispatcher("samplePhotoShow.jsp").forward(
						request, response);
			} else {
				System.out.println(0 + "success");
				request.getRequestDispatcher("samplePhotoShow.jsp").forward(
						request, response);
			}

		} else {
			/*
			 * // 中心概况 TestCenterTypeService testCenterTypeService = new
			 * TestCenterTypeService(); List<TestCenterType> testCenterTypeList
			 * = testCenterTypeService .findAll(); TestCenterType type = new
			 * TestCenterType(); // 为前台 类型信息列表 右侧设置标题 for (TestCenterType a :
			 * testCenterTypeList) { if (typeId == a.getId()) { type = a; } }
			 * 
			 * request.setAttribute("type", type);
			 * request.setAttribute("testCenterInfoList", testCenterInfoList);
			 * 
			 * request.getRequestDispatcher("testCenterSurvey.jsp").forward(
			 * request, response);
			 */
		}

	}

	private void toSamplePhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		// System.out.println("进入toSamplePhoto");
		SamplePhotoService samplePhotoService = new SamplePhotoService();

		List<SamplePhoto> samplePhotoList = samplePhotoService.findAll();
		request.setAttribute("samplePhotoList", samplePhotoList);
		PhotoTypeService photoTypeService = new PhotoTypeService();
		List<PhotoType> photoTypeList = photoTypeService.findAll();
		request.setAttribute("photoTypeList", photoTypeList);

		// 前台学院动态显示
		List<SamplePhoto> xueyuandongtai = samplePhotoService.findByTypeId(4);
		request.setAttribute("xueyuandongtai", xueyuandongtai);

		request.getRequestDispatcher("SamplePhoto.jsp").forward(request,
				response);

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
		SamplePhoto samplePhoto = new SamplePhoto(title, content, author,
				typeId);
		SamplePhotoService samplePhotoService = new SamplePhotoService();
		List<SamplePhoto> samplePhotoList = samplePhotoService
				.findByCondition(samplePhoto);
		request.setAttribute("samplePhotoList", samplePhotoList);
		request.setAttribute("samplePhoto", samplePhoto);

		request.getRequestDispatcher("web/sample/listSamplePhoto.jsp").forward(
				request, response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		SamplePhotoService samplePhotoService = new SamplePhotoService();
		SamplePhoto samplePhoto = samplePhotoService.findById(id);
		request.setAttribute("samplePhoto", samplePhoto);
		request.getRequestDispatcher("web/sample/editSamplePhoto.jsp").forward(
				request, response);

	}

	// 新闻更新
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserTestCenter loginUser_testCenter = (UserTestCenter) request
				.getSession().getAttribute("loginUser_testCenter");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String publishTimeStr = request.getParameter("publishTime");
		String passStr = request.getParameter("pass");
		int pass = 0;
		System.out.println("~~~~" + passStr + "~~~");
		if (passStr != "" && passStr != null) {
			pass = Integer.parseInt(passStr);
		}
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		SamplePhoto samplePhoto = new SamplePhoto(id, title, content,
				loginUser_testCenter.getId(), typeId, publishTime, pass);
		SamplePhotoService samplePhotoService = new SamplePhotoService();
		int result = samplePhotoService.update(samplePhoto);
		request.getRequestDispatcher("samplePhotoServlet?op=list").forward(
				request, response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		SamplePhotoService samplePhotoService = new SamplePhotoService();
		samplePhotoService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		SamplePhotoService samplePhotoService = new SamplePhotoService();
		// List<SamplePhoto> samplePhotoList = samplePhotoService.findAll();
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
			int count = samplePhotoService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<SamplePhoto> samplePhotoList = samplePhotoService.findByPage(
				pageNo, PageBean.pageSize);
		request.setAttribute("samplePhotoList", samplePhotoList);
		request.getRequestDispatcher("web/sample/listSamplePhoto.jsp").forward(
				request, response);

	}

	// 添加新闻
	private void addSamplePhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserTestCenter loginUser_testCenter = (UserTestCenter) request
				.getSession().getAttribute("loginUser_testCenter");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String publishTimeStr = request.getParameter("publishTime");
		String passStr = request.getParameter("pass");
		int pass = Integer.parseInt(passStr);
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		SamplePhoto samplePhoto = new SamplePhoto(title, content,
				loginUser_testCenter.getId(), typeId, publishTime, pass);
		SamplePhotoService samplePhotoService = new SamplePhotoService();
		int result = samplePhotoService.save(samplePhoto);
		request.getRequestDispatcher("samplePhotoServlet?op=list").forward(
				request, response);
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("web/sample/addSamplePhoto.jsp").forward(
				request, response);

	}

}
