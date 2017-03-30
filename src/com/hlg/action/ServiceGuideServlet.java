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

import com.hlg.entity.ServiceGuide;
import com.hlg.entity.ServiceType;
import com.hlg.entity.UserTestCenter;
import com.hlg.service.ServiceGuideService;
import com.hlg.service.ServiceTypeService;
import com.hlg.util.DateUtil;
import com.hlg.util.PageBean;
import com.hlg.util.SelectTestType;

/**
 * Servlet implementation class ServiceGuideServlet
 */
@WebServlet("/ServiceGuideServlet")
public class ServiceGuideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServiceGuideServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 初始化方法
	// 获取服务指南类型
	public void init(HttpServletRequest request) {
		ServiceTypeService serviceTypeService = new ServiceTypeService();
		List<ServiceType> serviceTypeList = serviceTypeService.findAll();
		request.setAttribute("serviceTypeList", serviceTypeList);
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
			addServiceGuide(request, response);
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
		} else if ("toServiceGuide".equals(op)) {
			toServiceGuide(request, response);
		} else if ("changeStatus".equals(op)) {
			changeStatus(request, response);
		}
		// 前台
		else if ("toServiceGuideDetail".equals(op)) {
			toServiceGuideDetail(request, response);
		} else if ("toServiceGuideType".equals(op)) {
			toServiceGuideType(request, response);
		}
	}

	private void setType(HttpServletRequest request) {

		// 服务指南介绍
		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		ServiceTypeService serviceTypeService = new ServiceTypeService();
		List<ServiceType> serviceTypeList = serviceTypeService.findAll();
		ServiceType type = new ServiceType();
		// 为前台 类型信息列表 右侧设置标题
		for (ServiceType a : serviceTypeList) {
			if (typeId == a.getId()) {
				type = a;
			}
		}

		request.setAttribute("type", type);
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
		ServiceGuideService serviceGuideService = new ServiceGuideService();
		serviceGuideService.changeStatus(id);
	}

	// 中心概况详细信息
	private void toServiceGuideDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 主菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		ServiceGuideService serviceGuideService = new ServiceGuideService();
		String idStr = request.getParameter("id");

		// 前台中心概况动态显示
		ServiceGuide ServiceGuideDetail1 = serviceGuideService.findById(idStr);
		List<ServiceGuide> serviceGuideDetail = new ArrayList<ServiceGuide>();
		serviceGuideDetail.add(ServiceGuideDetail1);
		setType(request);
		request.setAttribute("serviceGuideDetail", serviceGuideDetail);
		request.getRequestDispatcher("serviceGuideShow.jsp").forward(request,
				response);

	}

	// 类型概况
	private void toServiceGuideType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		ServiceGuideService serviceGuideService = new ServiceGuideService();
		// 前台服务指南动态显示
		List<ServiceGuide> serviceGuideListAll = serviceGuideService
				.findByTypeId(typeId);
		List<ServiceGuide> serviceListAll = new ArrayList<ServiceGuide>();
		int pass = 0;
		for (ServiceGuide sg : serviceGuideListAll) {
			if (sg.getPass() == 0) {
				serviceListAll.add(sg);
				pass++;
				System.out.println(serviceListAll.size() + "~~~~~~~~~" + pass
						+ 1);
			}
		}

		if (typeId == 1) {

			if (serviceListAll.size() != 0) {
				ServiceGuide serviceGuideDetail0 = serviceListAll.get(0);
				List<ServiceGuide> serviceGuideDetail = new ArrayList<ServiceGuide>();
				serviceGuideDetail.add(serviceGuideDetail0);
				setType(request);
				request.setAttribute("serviceGuideDetail", serviceGuideDetail);
				request.getRequestDispatcher("serviceGuideShow.jsp").forward(
						request, response);
			} else {
				System.out.println(0 + "success");
				setType(request);
				request.getRequestDispatcher("serviceGuideShow.jsp").forward(
						request, response);
			}

		} else {

			System.out.println("查询执行成功");
			// 分页，显示的最后位置
			int end;
			String pageNoStr = request.getParameter("pageNo");
			int pageNo = 1;
			if (pageNoStr != null && !"".equals(pageNoStr)) {
				pageNo = Integer.parseInt(pageNoStr);
			}
			System.out.println("pageNo=" + pageNo);
			PageBean pageBean = (PageBean) request.getAttribute("pageBean");
			if (pageBean == null) {
				pageBean = new PageBean();
				// 计算新闻数量
				int countShow = serviceListAll.size();
				System.out.println("countShow=" + countShow);
				pageBean.setPageCount(countShow);
				pageBean.setRowCount(countShow);
			}
			pageBean.setPageNo(pageNo);
			// session.setAttribute("pageBean" + typeIdStr, pageBean);
			request.setAttribute("pageBean", pageBean);
			System.out.println("pageBean.getRowCount()="
					+ pageBean.getRowCount() + "~~~~~~"
					+ "pageBean.getPageNo()=" + pageBean.getPageNo());
			// 分页显示的尾数

			if (pageBean.getRowCount() < pageNo * PageBean.pageSize) {
				end = pageBean.getRowCount();
			} else {
				end = pageNo * PageBean.pageSize;
			}
			System.out.println("end" + end);
			// 未前台显示。使用的request对象赋值
			List<ServiceGuide> serviceGuideList = new ArrayList<ServiceGuide>();
			if (serviceListAll.size() != 0) {
				for (int i = ((pageNo - 1) * PageBean.pageSize); i < end; i++) {
					System.out.println("for循环i=" + i);
					// System.out.println("22222222"+typeListAll.get(i).getTitle());

					ServiceGuide serviceGuide = serviceListAll.get(i);
					serviceGuideList.add(serviceGuide);
				}
			}
			setType(request);
			request.setAttribute("serviceGuideList", serviceGuideList);

			request.getRequestDispatcher("serviceGuide.jsp").forward(request,
					response);
		}

	}

	private void toServiceGuide(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		// System.out.println("进入toFirstWeb");
		ServiceGuideService serviceGuideService = new ServiceGuideService();

		/*
		 * List<ServiceGuide> serviceGuideList = serviceGuideService.findAll();
		 * request.setAttribute("serviceGuideList", serviceGuideList);
		 */
		ServiceTypeService serviceTypeService = new ServiceTypeService();
		List<ServiceType> serviceTypeList = serviceTypeService.findAll();
		request.setAttribute("serviceTypeList", serviceTypeList);

		// 显示服务指南内容动 服务指南id=1
		List<ServiceGuide> serGuiShow = serviceGuideService.findByTypeId(1);
		request.setAttribute("serGuiShow", serGuiShow);

		request.getRequestDispatcher("ServiceGuide.jsp").forward(request,
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
		ServiceGuide serviceGuide = new ServiceGuide(title, content, author,
				typeId);
		ServiceGuideService serviceGuideService = new ServiceGuideService();
		List<ServiceGuide> serviceGuideList = serviceGuideService
				.findByCondition(serviceGuide);
		request.setAttribute("serviceGuideList", serviceGuideList);
		request.setAttribute("serviceGuide", serviceGuide);

		request.getRequestDispatcher("web/service/listServiceGuide.jsp")
				.forward(request, response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		ServiceGuideService serviceGuideService = new ServiceGuideService();
		ServiceGuide serviceGuide = serviceGuideService.findById(id);
		request.setAttribute("serviceGuide", serviceGuide);
		request.getRequestDispatcher("web/service/editServiceGuide.jsp")
				.forward(request, response);

	}

	// 更新
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
		ServiceGuide serviceGuide = new ServiceGuide(id, title, content,
				loginUser_testCenter.getId(), typeId, publishTime, pass);
		ServiceGuideService serviceGuideService = new ServiceGuideService();
		int result = serviceGuideService.update(serviceGuide);
		request.getRequestDispatcher("serviceGuideServlet?op=list").forward(
				request, response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		ServiceGuideService serviceGuideService = new ServiceGuideService();
		serviceGuideService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		ServiceGuideService serviceGuideService = new ServiceGuideService();
		// List<ServiceGuide> serviceGuideList = serviceGuideService.findAll();
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
			int count = serviceGuideService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<ServiceGuide> serviceGuideList = serviceGuideService.findByPage(
				pageNo, PageBean.pageSize);
		request.setAttribute("serviceGuideList", serviceGuideList);
		System.out.printf(serviceGuideList.get(0).getTitle());
		request.getRequestDispatcher("web/service/listServiceGuide.jsp")
				.forward(request, response);

	}

	// 添加新闻
	private void addServiceGuide(HttpServletRequest request,
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
		ServiceGuide serviceGuide = new ServiceGuide(title, content,
				loginUser_testCenter.getId(), typeId, publishTime, pass);
		ServiceGuideService serviceGuideService = new ServiceGuideService();
		int result = serviceGuideService.save(serviceGuide);
		request.getRequestDispatcher("serviceGuideServlet?op=list").forward(
				request, response);
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("web/service/addServiceGuide.jsp")
				.forward(request, response);

	}

}
