package com.hlg.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hlg.entity.StudentDetail;
import com.hlg.service.StudentDetailService;
import com.hlg.util.PageBean;

/**
 * Servlet implementation class StudentRegister
 */
@WebServlet("/StudentRegister")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentDetailServlet() {
		super();

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
		if ("register".equals(op)) {
			// 完成注册功能
			register(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("123".equals(op)) {
			ajaxRegister(request, response);// ajax验证注册用户名是否存在
		} else if ("list".equals(op)) {
			// 显示所有的用户
			list(request, response);
		}
	}

	private String ajaxRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// System.out.println("开始进行ajax校验");
		StudentDetail studentDetail = null;
		String num = request.getParameter("num");
		// 从界面获取数据
		// String passPwd = request.getParameter("passPwd");
		StudentDetailService studentDetailService = new StudentDetailService();
		int a = studentDetailService.findByNum(num);
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
		StudentDetailService studentDetailService = new StudentDetailService();
		studentDetailService.delete(id);
		// 先删除数据，再更新页码
		HttpSession session = request.getSession();
		PageBean pageBean = (PageBean) session.getAttribute("pageBean");
		if (pageBean != null) {
			int count = studentDetailService.count();
			pageBean.setPageCount(count);
			session.setAttribute("pageBean", pageBean);
		}

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
		StudentDetailService studentDetailService = new StudentDetailService();
		// 查询所有的
		// List<StudentDetail> studentList = studentDetailService.findAll();
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
			int count = studentDetailService.count();
			pageBean.setPageCount(count);
		}
		pageBean.setPageNo(pageNo);
		session.setAttribute("pageBean", pageBean);
		// 分页查询
		List<StudentDetail> studentList = studentDetailService.findByPage(
				pageNo, PageBean.pageSize);
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("listStudent.jsp").forward(request,
				response);

	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取数据
		String num = request.getParameter("iptNickName");
		String stuName = request.getParameter("stuname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String weixin = request.getParameter("weixin");

		// 生成用户对象

		StudentDetail studentDetail = new StudentDetail(num, stuName, address,
				phone, qq, weixin);

		StudentDetailService studentDetailService = new StudentDetailService();
		int result = studentDetailService.register(studentDetail);
		if (result == 0) {
			// 用户注册失败，跳回原来页面，并提示信息
			request.setAttribute("errorMsg", "用户注册失败，请重试！");
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		} else {
			// 用户注册成功，进入欢迎页面
			request.getRequestDispatcher("toFirstWeb.jsp").forward(request,
					response);
		}
	}
}
