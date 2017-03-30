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

import com.hlg.entity.TestCenterInfo;
import com.hlg.entity.TestCenterType;
import com.hlg.entity.UserTestCenter;
import com.hlg.service.TestCenterInfoService;
import com.hlg.util.DateUtil;
import com.hlg.util.PageBean;
import com.hlg.util.SelectTestType;

/**
 * Servlet implementation class TestCenterInfoServlet
 */
@WebServlet("/TestCenterInfoServlet")
public class TestCenterInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestCenterInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
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

		// 后台
		if ("toAdd".equals(op)) {
			toAdd(request, response);
		} else if ("add".equals(op)) {
			addTestCenterInfo(request, response);
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
		} else if ("changeStatus".equals(op)) {
			changeStatus(request, response);
		}

		// 前台
		else if ("toTestCenterWeb".equals(op)) {
			toTestCenterWeb(request, response);
		} else if ("toCenterSurveyDetail".equals(op)) {
			toCenterSurveyDetail(request, response);
		} else if ("toCenterSurveyType".equals(op)) {
			toCenterSurveyType(request, response);
		}
	}

	private void setType(HttpServletRequest request) {

		// 获取类型
		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		List<TestCenterType> testCenterTypeList = (List) request
				.getAttribute("testCenterTypeList");
		TestCenterType type = new TestCenterType();
		// 为前台 类型信息列表 右侧设置标题
		for (TestCenterType a : testCenterTypeList) {
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
		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		testCenterInfoService.changeStatus(id);
	}

	// 中心概况详细信息
	private void toCenterSurveyDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 主菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		String idStr = request.getParameter("id");

		// 前台中心概况动态显示
		TestCenterInfo testCenterInfoDetail1 = testCenterInfoService
				.findById(idStr);
		List<TestCenterInfo> testCenterInfoDetail = new ArrayList<TestCenterInfo>();
		testCenterInfoDetail.add(testCenterInfoDetail1);
		setType(request);
		request.setAttribute("testCenterInfoDetail", testCenterInfoDetail);
		request.getRequestDispatcher("testCenterSurveyShow.jsp").forward(
				request, response);

	}

	// 类型概况
	private void toCenterSurveyType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		// 前台中心概况动态显示
		// 根据类型 typeId 查询 对象。 获得LIST
		List<TestCenterInfo> testCenterInfoListAll = testCenterInfoService
				.findByTypeId(typeId);
		List<TestCenterInfo> testListAll = new ArrayList<TestCenterInfo>();
		int pass = 0;
		for (TestCenterInfo ti : testCenterInfoListAll) {
			if (ti.getPass() == 0) {
				testListAll.add(ti);
				pass++;
				System.out.println(testListAll.size() + "~~~~~~~~~" + pass + 1);
			}
		}

		if (typeId == 1) {

			if (testListAll.size() != 0) {
				TestCenterInfo testSurveyDetail0 = testListAll.get(0);
				List<TestCenterInfo> testCenterInfoDetail = new ArrayList<TestCenterInfo>();
				testCenterInfoDetail.add(testSurveyDetail0);
				System.out.println(testSurveyDetail0.getTitle());
				setType(request);
				request.setAttribute("testCenterInfoDetail",
						testCenterInfoDetail);
				request.getRequestDispatcher("testCenterSurveyShow.jsp")
						.forward(request, response);
			} else {
				System.out.println(0 + "success");
				setType(request);
				request.getRequestDispatcher("testCenterSurveyShow.jsp")
						.forward(request, response);
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
				int countShow = testListAll.size();

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
			List<TestCenterInfo> testCenterInfoList = new ArrayList<TestCenterInfo>();
			if (testListAll.size() != 0) {
				for (int i = ((pageNo - 1) * PageBean.pageSize); i < end; i++) {
					System.out.println("for循环i=" + i);
					// System.out.println("22222222"+typeListAll.get(i).getTitle());

					TestCenterInfo testCenterInfo = testListAll.get(i);
					testCenterInfoList.add(testCenterInfo);
				}
			}
			// 中心概况
			setType(request);
			request.setAttribute("testCenterInfoList", testCenterInfoList);
			request.getRequestDispatcher("testCenterSurvey.jsp").forward(
					request, response);
		}

	}

	// 根据主界面显示内容进行相关信息查询 前台

	private void toTestCenterWeb(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 主菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);
		// System.out.println("进入toFirstWeb");
		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		// HttpSession testCenterInfoSesion = request.getSession();

		// 前台新闻快递动态显示
		List<TestCenterInfo> xinwenkuaidi = testCenterInfoService
				.findByTypeId(5);
		request.setAttribute("xinwenkuaidi", xinwenkuaidi);
		request.setAttribute("xinwenkuaidiTypeId", 5);
		// 前台重要通知动态显示
		List<TestCenterInfo> zhongyaotz = testCenterInfoService.findByTypeId(7);
		request.setAttribute("zhongyaotz", zhongyaotz);
		request.setAttribute("zhongyaotzTypeId", 7);
		System.out.println(zhongyaotz.get(0).getTitle());
		// 前台本站公告动态显示
		List<TestCenterInfo> benzhangg = testCenterInfoService.findByTypeId(8);
		request.setAttribute("benzhangg", benzhangg);
		request.setAttribute("benzhanggTypeId", 8);
		// 前台测试安排动态显示
		List<TestCenterInfo> ceshiap = testCenterInfoService.findByTypeId(9);
		request.setAttribute("ceshiap", ceshiap);
		request.setAttribute("ceshiapTypeId", 9);
		// 前台欢迎词动态显示
		List<TestCenterInfo> welcome = testCenterInfoService.findByTypeId(10);
		String wel = welcome.get(0).getContent();
		request.setAttribute("wel", wel);

		/*
		 * testCenterInfoSesion.setAttribute("xinwenkuaidi", xinwenkuaidi);
		 * testCenterInfoSesion.setAttribute("zhongyaotz", zhongyaotz);
		 * testCenterInfoSesion.setAttribute("benzhangg", benzhangg);
		 * testCenterInfoSesion.setAttribute("ceshiap", ceshiap);
		 * testCenterInfoSesion.setAttribute("wel", wel);
		 */

		// 返回的主界面

		request.getRequestDispatcher("testCenter.jsp").forward(request,
				response);

	}

	// 查询
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 主菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String author = request.getParameter("userName");
		int typeId = Integer.parseInt(typeIdStr);
		TestCenterInfo testCenterInfo = new TestCenterInfo(title, content,
				author, typeId);
		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		List<TestCenterInfo> testCenterInfoList = testCenterInfoService
				.findByCondition(testCenterInfo);
		request.setAttribute("testCenterInfoList", testCenterInfoList);
		request.setAttribute("testCenterInfo", testCenterInfo);

		request.getRequestDispatcher("web/teC/listTestCenterInfo.jsp").forward(
				request, response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 主菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		String id = request.getParameter("id");
		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		TestCenterInfo testCenterInfo = testCenterInfoService.findById(id);
		request.setAttribute("testCenterInfo", testCenterInfo);
		request.getRequestDispatcher("web/teC/editTestCenterInfo.jsp").forward(
				request, response);

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

		/*
		 * String topper = request.getParameter("topper"); String bold =
		 * request.getParameter("bold"); String color =
		 * request.getParameter("color");
		 */
		int pass = 0;
		System.out.println("~~~~" + passStr + "~~~");
		if (passStr != "" && passStr != null) {
			pass = Integer.parseInt(passStr);
		}
		int typeId = Integer.parseInt(typeIdStr);
		Date publishTime = DateUtil.string2Date(publishTimeStr);
		TestCenterInfo testCenterInfo = new TestCenterInfo(id, title, content,
				loginUser_testCenter.getId(), typeId, publishTime, pass);
		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		int result = testCenterInfoService.update(testCenterInfo);
		request.getRequestDispatcher("testCenterInfoServlet?op=list").forward(
				request, response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		testCenterInfoService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 菜单查询
		// 主菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		// List<TestCenterInfo> testCenterInfoList = testCenterInfoService
		// .findAll();
		System.out.printf("查询执行成功");
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
			int count = testCenterInfoService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<TestCenterInfo> testCenterInfoList = testCenterInfoService
				.findByPage(pageNo, PageBean.pageSize);
		request.setAttribute("testCenterInfoList", testCenterInfoList);
		// System.out.printf(testCenterInfoList.get(0).getTitle());
		request.getRequestDispatcher("web/teC/listTestCenterInfo.jsp").forward(
				request, response);

	}

	// 添加新闻
	private void addTestCenterInfo(HttpServletRequest request,
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
		TestCenterInfo testCenterInfo = new TestCenterInfo(title, content,
				loginUser_testCenter.getId(), typeId, publishTime, pass);
		TestCenterInfoService testCenterInfoService = new TestCenterInfoService();
		int result = testCenterInfoService.save(testCenterInfo);
		request.getRequestDispatcher("testCenterInfoServlet?op=list").forward(
				request, response);
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 主菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);
		request.getRequestDispatcher("web/teC/addTestCenterInfo.jsp").forward(
				request, response);

	}

}
