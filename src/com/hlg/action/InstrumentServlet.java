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

import com.hlg.entity.Instrument;
import com.hlg.entity.InstrumentType;
import com.hlg.entity.UserTestCenter;
import com.hlg.service.InstrumentService;
import com.hlg.service.InstrumentTypeService;
import com.hlg.util.DateUtil;
import com.hlg.util.PageBean;
import com.hlg.util.SelectTestType;

/**
 * Servlet implementation class InstrumentServlet
 */
@WebServlet("/InstrumentServlet")
public class InstrumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InstrumentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 初始化方法
	// 获取新闻类型
	public void init(HttpServletRequest request) {
		InstrumentTypeService instrumentTypeService = new InstrumentTypeService();
		List<InstrumentType> instrumentTypeList = instrumentTypeService
				.findAll();
		request.setAttribute("instrumentTypeList", instrumentTypeList);
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
			addInstrument(request, response);
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
		} else if ("toInstrument".equals(op)) {
			toInstrument(request, response);
		}
		// 前台
		/*
		 * else if ("toInstrumentDetail".equals(op)) {
		 * toInstrumentDetail(request, response); }
		 */else if ("toInstrumentType".equals(op)) {
			toInstrumentType(request, response);
		}
	}

	/*
	 * // 仪器一览详细信息 private void toInstrumentDetail(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { //
	 * 主菜单类型查找 SelectTestType selectTestType = new SelectTestType();
	 * selectTestType.selectType(request);
	 * 
	 * InstrumentService instrumentService = new InstrumentService(); String
	 * idStr = request.getParameter("id");
	 * 
	 * // 前台中心概况动态显示 Instrument instrumentDetail =
	 * instrumentService.findById(idStr);
	 * request.setAttribute("instrumentDetail", instrumentDetail);
	 * request.getRequestDispatcher("instrumentShow.jsp").forward(request,
	 * response);
	 * 
	 * }
	 */

	private void setType(HttpServletRequest request) {

		// 获取类型
		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		List<InstrumentType> instrumentTypeList = (List) request
				.getAttribute("instrumentTypeList");
		InstrumentType type = new InstrumentType();
		// 为前台 类型信息列表 右侧设置标题
		for (InstrumentType a : instrumentTypeList) {
			if (typeId == a.getId()) {
				type = a;
			}
		}

		request.setAttribute("type", type);
	}

	// 仪器一览详细类型信息
	private void toInstrumentType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 菜单类型查找
		SelectTestType selectTestType = new SelectTestType();
		selectTestType.selectType(request);

		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		InstrumentService instrumentService = new InstrumentService();
		// 前台中心概况动态显示
		List<Instrument> instrumentList = instrumentService
				.findByTypeId(typeId);

		if (instrumentList.size() != 0) {
			System.out.println("非零success");
			Instrument InstrumentDetail0 = instrumentList.get(0);
			List<Instrument> instrumentDetail = new ArrayList<Instrument>();
			instrumentDetail.add(InstrumentDetail0);
			setType(request);
			request.setAttribute("instrumentDetail", instrumentDetail);
			request.getRequestDispatcher("instrumentShow.jsp").forward(request,
					response);
		} else {
			System.out.println(0 + "success");
			setType(request);
			request.getRequestDispatcher("instrumentShow.jsp").forward(request,
					response);
		}

	}

	// 主页跳转 所用 action 。查询信息需要修改
	private void toInstrument(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		init(request);
		// System.out.println("进入toInstrument");
		InstrumentService instrumentService = new InstrumentService();

		List<Instrument> instrumentList = instrumentService.findAll();
		request.setAttribute("instrumentList", instrumentList);
		InstrumentTypeService instrumentTypeService = new InstrumentTypeService();
		List<InstrumentType> instrumentTypeList = instrumentTypeService
				.findAll();
		request.setAttribute("instrumentTypeList", instrumentTypeList);

		// 前台学院动态显示
		List<Instrument> xueyuandongtai = instrumentService.findByTypeId(4);
		request.setAttribute("xueyuandongtai", xueyuandongtai);

		request.getRequestDispatcher("Instrument.jsp").forward(request,
				response);

	}

	// 查询
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		// String title = request.getParameter("title");
		String content = request.getParameter("content");
		String typeIdStr = request.getParameter("typeId");
		String author = request.getParameter("userName");
		int typeId = Integer.parseInt(typeIdStr);
		Instrument instrument = new Instrument(content, typeId, author);
		InstrumentService instrumentService = new InstrumentService();
		List<Instrument> instrumentList = instrumentService
				.findByCondition(instrument);
		request.setAttribute("instrumentList", instrumentList);
		request.setAttribute("instrument", instrument);

		request.getRequestDispatcher("web/instru/listInstrument.jsp").forward(
				request, response);

	}

	// 新闻编辑
	private void toEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		String id = request.getParameter("id");
		InstrumentService instrumentService = new InstrumentService();
		Instrument instrument = instrumentService.findById(id);
		request.setAttribute("instrument", instrument);
		request.getRequestDispatcher("web/instru/editInstrument.jsp").forward(
				request, response);

	}

	// 新闻更新
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserTestCenter loginUser_testCenter = (UserTestCenter) request
				.getSession().getAttribute("loginUser_testCenter");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		String content = request.getParameter("content");
		String factory = request.getParameter("factory");
		String mainAccessories = request.getParameter("mainAccessories");
		String tecParame = request.getParameter("tecParame");
		String tecFeatures = request.getParameter("tecFeatures");
		String appliRange = request.getParameter("appliRange");
		String publishTimeStr = request.getParameter("publishTime");
		// String passStr = request.getParameter("pass");
		// int pass = Integer.parseInt(passStr);

		/*
		 * String topper = request.getParameter("topper"); String bold =
		 * request.getParameter("bold"); String color =
		 * request.getParameter("color");
		 */

		Date publishTime = DateUtil.string2Date(publishTimeStr);

		Instrument instrument = new Instrument(id, typeId, content, factory,
				mainAccessories, tecParame, tecFeatures, appliRange,
				publishTime, loginUser_testCenter.getId());
		InstrumentService instrumentService = new InstrumentService();
		int result = instrumentService.update(instrument);
		request.getRequestDispatcher("instrumentServlet?op=list").forward(
				request, response);

	}

	// 删除新闻
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		InstrumentService instrumentService = new InstrumentService();
		instrumentService.delete(id);
		list(request, response);

	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);

		InstrumentService instrumentService = new InstrumentService();
		// List<Instrument> instrumentList = instrumentService.findAll();
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
			int count = instrumentService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		List<Instrument> instrumentList = instrumentService.findByPage(pageNo,
				PageBean.pageSize);
		request.setAttribute("instrumentList", instrumentList);
		request.getRequestDispatcher("web/instru/listInstrument.jsp").forward(
				request, response);

	}

	// 添加新闻
	private void addInstrument(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserTestCenter loginUser_testCenter = (UserTestCenter) request
				.getSession().getAttribute("loginUser_testCenter");
		String typeIdStr = request.getParameter("typeId");
		int typeId = Integer.parseInt(typeIdStr);
		String content = request.getParameter("content");
		String factory = request.getParameter("factory");
		String mainAccessories = request.getParameter("mainAccessories");
		String tecParame = request.getParameter("tecParame");
		String tecFeatures = request.getParameter("tecFeatures");
		String appliRange = request.getParameter("appliRange");
		String publishTimeStr = request.getParameter("publishTime");
		Date publishTime = DateUtil.string2Date(publishTimeStr);

		Instrument instrument = new Instrument(typeId, content, factory,
				mainAccessories, tecParame, tecFeatures, appliRange,
				publishTime, loginUser_testCenter.getId());
		InstrumentService instrumentService = new InstrumentService();
		int result = instrumentService.save(instrument);
		request.getRequestDispatcher("instrumentServlet?op=list").forward(
				request, response);
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("web/instru/addInstrument.jsp").forward(
				request, response);

	}

}
