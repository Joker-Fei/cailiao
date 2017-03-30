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

import com.hlg.entity.Accreditation;
import com.hlg.entity.AccreditationType;
import com.hlg.entity.UserTestCenter;
import com.hlg.service.AccreditationService;
import com.hlg.service.AccreditationTypeService;
import com.hlg.util.DateUtil;
import com.hlg.util.PageBean;
import com.hlg.util.SelectTestType;

/**
 * Servlet implementation class AccreditationServlet
 */
@WebServlet("/AccreditationServlet")
public class AccreditationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccreditationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		AccreditationTypeService accreditationTypeService = new AccreditationTypeService();
		List<AccreditationType> accreditationTypeList = accreditationTypeService
				.findAll();
		request.setAttribute("accreditationTypeList", accreditationTypeList);
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
			addAccreditation(request, response);
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
		} else if ("toAccreditation".equals(op)) {
			toAccreditation(request, response);
		} else if ("changeStatus".equals(op)) {
			changeStatus(request, response);
		}
		// 前台
		else if ("toAccreditationDetail".equals(op)) {
			toAccreditationDetail(request, response);
		} else if ("toAccreditationType".equals(op)) {
			toAccreditationType(request, response);
		}
	}

	private void setType(HttpServletRequest request) {

		// 获取类型
		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		List<AccreditationType> accreditationTypeList = (List) request
				.getAttribute("accreditationTypeList");
		AccreditationType type = new AccreditationType();
		// 为前台 类型信息列表 右侧设置标题
		for (AccreditationType a : accreditationTypeList) {
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
		System.out.println("TestCenterInfoServlet.changeStatus()" + idStr);
		if (idStr == null || "".equals(idStr)) {
			return;
		}
		int id = Integer.parseInt(idStr);
		AccreditationService accreditationService = new AccreditationService();
		accreditationService.changeStatus(id);
	}

	// 中心概况详细信息
	private void toAccreditationDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 主菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		AccreditationService accreditationService = new AccreditationService();
		String idStr = request.getParameter("id");

		// 前台中心概况动态显示
		Accreditation accreditationDetail1 = accreditationService
				.findById(idStr);
		List<Accreditation> accreditationDetail = new ArrayList<Accreditation>();
		accreditationDetail.add(accreditationDetail1);
		setType(request);
		request.setAttribute("accreditationDetail", accreditationDetail);
		request.getRequestDispatcher("accreditationShow.jsp").forward(request,
				response);

	}

	// 类型概况
	private void toAccreditationType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		AccreditationService accreditationService = new AccreditationService();
		// 前台中心概况动态显示
		List<Accreditation> accreditationListAll = accreditationService
				.findByTypeId(typeId);
		List<Accreditation> accListAll = new ArrayList<Accreditation>();
		int pass = 0;
		for (Accreditation ac : accreditationListAll) {
			if (ac.getPass() == 0) {
				accListAll.add(ac);
				pass++;
				System.out.println(accListAll.size() + "~~~~~~~~~" + pass + 1);
			}
		}
		if (typeId == 1) {
			if (accListAll.size() != 0) {
				Accreditation accreditationDetail0 = accListAll.get(0);
				List<Accreditation> accreditationDetail = new ArrayList<Accreditation>();
				accreditationDetail.add(accreditationDetail0);
				setType(request);
				request.setAttribute("accreditationDetail", accreditationDetail);
				request.getRequestDispatcher("accreditationShow.jsp").forward(
						request, response);

			} else {
				System.out.println(0 + "success");
				setType(request);
				request.getRequestDispatcher("accreditationShow.jsp").forward(
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
			// 统计数量
			HttpSession session = request.getSession();
			// PageBean pageBean = (PageBean) session.getAttribute("pageBean"
			// + typeIdStr);
			PageBean pageBean = (PageBean) request.getAttribute("pageBean");
			if (pageBean == null) {
				pageBean = new PageBean();
				// 计算新闻数量
				int countShow = accListAll.size();
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
			List<Accreditation> accreditationList = new ArrayList<Accreditation>();
			if (accListAll.size() != 0) {
				for (int i = ((pageNo - 1) * PageBean.pageSize); i < end; i++) {
					System.out.println("for循环i=" + i);
					// System.out.println("22222222"+typeListAll.get(i).getTitle());

					Accreditation accreditation = accListAll.get(i);
					accreditationList.add(accreditation);
				}
			}
			setType(request);
			request.setAttribute("accreditationList", accreditationList);
			request.getRequestDispatcher("accreditation.jsp").forward(request,
					response);
		}

	}

	/*
	 * 根据前台 显示 重新修改
	 */
	private void toAccreditation(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		// System.out.println("进入toFirstWeb");
		AccreditationService accreditationService = new AccreditationService();

		List<Accreditation> accreditationList = accreditationService.findAll();
		request.setAttribute("accreditationList", accreditationList);
		AccreditationTypeService accreditationTypeService = new AccreditationTypeService();
		List<AccreditationType> accreditationTypeList = accreditationTypeService
				.findAll();
		request.setAttribute("accreditationTypeList", accreditationTypeList);

		// 前台学院动态显示
		List<Accreditation> xueyuandongtai = accreditationService
				.findByTypeId(4);
		request.setAttribute("xueyuandongtai", xueyuandongtai);

		request.getRequestDispatcher("accreditation.jsp").forward(request,
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
		Accreditation accreditation = new Accreditation(title, content, author,
				typeId);
		AccreditationService accreditationService = new AccreditationService();
		List<Accreditation> accreditationList = accreditationService
				.findByCondition(accreditation);
		request.setAttribute("accreditationList", accreditationList);
		request.setAttribute("accreditation", accreditation);

		request.getRequestDispatcher("web/acc/listAccreditation.jsp").forward(
				request, response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		AccreditationService accreditationService = new AccreditationService();
		Accreditation accreditation = accreditationService.findById(id);
		request.setAttribute("accreditation", accreditation);
		request.getRequestDispatcher("web/acc/editAccreditation.jsp").forward(
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
		Accreditation accreditation = new Accreditation(id, title, content,
				loginUser_testCenter.getId(), typeId, publishTime, pass);
		AccreditationService accreditationService = new AccreditationService();
		int result = accreditationService.update(accreditation);
		request.getRequestDispatcher("AccreditationServlet?op=list").forward(
				request, response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AccreditationService accreditationService = new AccreditationService();
		accreditationService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		AccreditationService accreditationService = new AccreditationService();
		// List<Accreditation> accreditationList =
		// accreditationService.findAll();
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
			int count = accreditationService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<Accreditation> accreditationList = accreditationService
				.findByPage(pageNo, PageBean.pageSize);
		request.setAttribute("accreditationList", accreditationList);
		request.getRequestDispatcher("web/acc/listAccreditation.jsp").forward(
				request, response);

	}

	// 添加新闻
	private void addAccreditation(HttpServletRequest request,
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
		Accreditation accreditation = new Accreditation(title, content,
				loginUser_testCenter.getId(), typeId, publishTime, pass);
		AccreditationService accreditationService = new AccreditationService();
		int result = accreditationService.save(accreditation);
		request.getRequestDispatcher("AccreditationServlet?op=list").forward(
				request, response);
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("web/acc/addAccreditation.jsp").forward(
				request, response);

	}

}
