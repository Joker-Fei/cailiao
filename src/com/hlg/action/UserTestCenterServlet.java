package com.hlg.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hlg.entity.UserTestCenter;
import com.hlg.service.UserTestCenterService;
import com.hlg.util.PageBean;

/**
 * Servlet implementation class UserTestCenterServlet
 */
@WebServlet("/UserTestCenterServlet")
public class UserTestCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see 构造方法
	 */
	public UserTestCenterServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	// 初始化方法
	// 获取服务指南类型
	public void init(HttpServletRequest request) {
		UserTestCenterService userTestCenterService = new UserTestCenterService();
		// List<ServiceType> serviceTypeList = userTestCenterService.findAll();
		// request.setAttribute("serviceTypeList", serviceTypeList);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see 处理post请求#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");
		if ("toAdd".equals(op)) {
			toAdd(request, response);
		} else if ("login".equals(op)) {
			// 完成登录功能
			login(request, response);
		} else if ("list".equals(op)) {
			// 显示所有的用户
			list(request, response);
		} else if ("addUser".equals(op)) {
			// 管理员添加用户对象
			addUser(request, response);
		} else if ("search".equals(op)) {
			search(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("123".equals(op)) {
			ajaxRegister(request, response);// ajax验证注册用户名是否存在
		} else if ("checkPwd".equals(op)) {
			checkPwd(request, response);
		} else if ("changePwd".equals(op)) {
			changePwd(request, response);
		}
	}

	private void changePwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("userPwd");
		String userRePwd = request.getParameter("userRePwd");
		if (pwd == null) {
			// 第一种方式
			// request.setAttribute("userPwdMsg", "密码不能为空");
			// request.getRequestDispatcher("addUser.jsp").forward(request,response);
			// 第二种方式
			out.write("<script>alert('密码不能为空');history.back();</script>");
			return;
		} else if (!pwd.equals(userRePwd)) {
			// request.setAttribute("userPwdMsg", "密码和确认密码不一致");
			// request.getRequestDispatcher("addUser.jsp").forward(request,response);
			out.write("<script>alert('密码和确认密码不一致');history.back();</script>");
			return;
		}
		UserTestCenterService userTestCenterService = new UserTestCenterService();
		int a = userTestCenterService.changePwd(id, pwd);
		// 0密码错误，1密码正确

		if (a == 1) {

			out.write("<script>alert('密码修改成功');this.location.href='log.jsp';</script>");

		} else {
			out.write("<script>alert('密码修改失败');history.back();</script>");
		}

	}

	private void checkPwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		UserTestCenterService userTestCenterService = new UserTestCenterService();
		int a = userTestCenterService.checkPwd(id, pwd);
		// 0密码错误，1密码正确
		if (a == 0) {

			response.getWriter().print(0);// 把这一int值发送给ajax中的result

		} else {
			response.getWriter().print(1);// 把这一个int值发送给ajax中的result
		}
	}

	private String ajaxRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("开始进行ajax校验");
		UserTestCenter userTestCenter = null;
		String username = request.getParameter("userName");
		// 从界面获取数据
		// String passPwd = request.getParameter("passPwd");
		UserTestCenterService userTestCenterService = new UserTestCenterService();
		int a = userTestCenterService.findByUserName(username);
		// System.out.println("a===" + a);
		// 根据用户名到数据库进行查询返回的值，进行判断，如果没用查到数据返回值为null，
		// 说明用户名不存在，那么返回1，不为空说明用户名已经存在，返回0
		if (a == 0) {

			response.getWriter().print(0);// 把这一int值发送给ajax中的result

		} else {
			response.getWriter().print(1);// 把这一个int值发送给ajax中的result
		}
		return null;
	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null && "".equals(idStr)) {
			return;
		}
		int id = Integer.parseInt(idStr);
		UserTestCenterService userTestCenterService = new UserTestCenterService();
		userTestCenterService.delete(id);
		// 先删除数据，再更新页码
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute("pageBean");
		if (pageBean != null) {
			int count = userTestCenterService.count();
			pageBean.setPageCount(count);
			session.setAttribute("pageBean", pageBean);
		}

		list(request, response);

	}

	/**
	 * 多条件查询
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String status = request.getParameter("status");

		UserTestCenterService userTestCenterService = new UserTestCenterService();
		UserTestCenter userTestCenter = new UserTestCenter(userName, phone,
				Integer.parseInt(status));
		List<UserTestCenter> userTestCenterList = userTestCenterService
				.search(userTestCenter);
		request.setAttribute("userTestCenter", userTestCenter);
		request.setAttribute("userTestCenterList", userTestCenterList);
		request.getRequestDispatcher("web/testUser/listUserTestCenter.jsp")
				.forward(request, response);
	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从界面获取数据
		UserTestCenter userTestCenter = getUserTestCenter(request, response);
		if (userTestCenter == null) {
			return;
		}
		UserTestCenterService userTestCenterService = new UserTestCenterService();
		userTestCenterService.register(userTestCenter);

		// 先添加数据，再更新页码
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute("pageBean");
		if (pageBean != null) {
			int count = userTestCenterService.count();
			pageBean.setPageCount(count);
			session.setAttribute("pageBean", pageBean);
		}

		// 添加后，跳转到用户列表页面
		list(request, response);
	}

	/**
	 * 列表显示
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserTestCenterService userTestCenterService = new UserTestCenterService();
		// 查询所有的
		// List<UserTestCenter> userList = userTestCenterService.findAll();
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
			int count = userTestCenterService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		// 分页查询
		List<UserTestCenter> userTestCenterList = userTestCenterService
				.findByPage(pageNo, PageBean.pageSize);
		request.setAttribute("userTestCenterList", userTestCenterList);
		request.getRequestDispatcher("web/testUser/listUserTestCenter.jsp")
				.forward(request, response);

	}

	/**
	 * 从界面获取数据,方便用户获得数据（保存用户和修改用户时使用）
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public UserTestCenter getUserTestCenter(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserTestCenter userTestCenter = null;
		// 从界面获取数据
		// String idStr = request.getParameter("id");
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userRePwd = request.getParameter("userRePwd");
		String statusStr = request.getParameter("status");
		if (userPwd == null) {
			// 第一种方式
			// request.setAttribute("userPwdMsg", "密码不能为空");
			// request.getRequestDispatcher("addUser.jsp").forward(request,response);
			// 第二种方式
			out.write("<script>alert('密码不能为空');history.back();</script>");
			return null;
		} else if (!userPwd.equals(userRePwd)) {
			// request.setAttribute("userPwdMsg", "密码和确认密码不一致");
			// request.getRequestDispatcher("addUser.jsp").forward(request,response);
			out.write("<script>alert('密码和确认密码不一致');history.back();</script>");
			return null;
		}
		String phone = request.getParameter("phone");
		// int id = Integer.parseInt(idStr);
		int status = Integer.parseInt(statusStr);
		userTestCenter = new UserTestCenter(userName, userPwd, phone, status);

		return userTestCenter;
	}

	// 用户登录
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("iptNickName");
		String userPwd = request.getParameter("t_UserPass");
		UserTestCenterService userTestCenterService = new UserTestCenterService();
		UserTestCenter loginUser = userTestCenterService.login(userName,
				userPwd);
		if (loginUser == null) {
			// 用户名为空，登录失败
			request.setAttribute("errorMsg", "用户名或密码错误！");
			request.getRequestDispatcher("log_testCenter.jsp").forward(request,
					response);
		} else {
			// 登录成功
			HttpSession session = request.getSession();
			// 保存登录用户的信息到session中
			session.setAttribute("loginUser_testCenter", loginUser);
			session.setAttribute("userFXName", loginUser.getUserName());
			// 如果权限是1，即该用户是超级会员，则跳转到后台管理页面（root页面）
			if (loginUser.getStatus() == 1) {
				request.getRequestDispatcher(
						"backStageWeb/backstageweb_TestCenter.jsp").forward(// 此处跳转页面待定
						request, response);
				return;
			}
			request.getRequestDispatcher(
					"backStageWeb/backstageweb_TestCenter.jsp").forward(
					request, response);
		}
	}

	// 跳转到添加页面
	private void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		init(request);
		request.getRequestDispatcher("web/testUser/addUserTest.jsp").forward(
				request, response);

	}
}
