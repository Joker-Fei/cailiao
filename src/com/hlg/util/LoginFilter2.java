package com.hlg.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter2 implements Filter {

	public LoginFilter2() {

	}

	@Override
	public void destroy() {
		// System.out.println("OnlineFilter destroy>>>>>>>>>>>>>>>>>>");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		/* String path = req.getContextPath(); */
		String path = req.getContextPath();
		String basePath = req.getScheme() + "://" + req.getServerName() + ":"
				+ req.getServerPort() + path;
		HttpSession session = req.getSession(true);
		String username = (String) session.getAttribute("userFXName");
		if (username == null || "".equals(username)) {

			resp.setHeader("Cache-Control", "no-store");
			resp.setDateHeader("Expires", 0);
			resp.setHeader("Prama", "no-cache");
			resp.sendRedirect(basePath + "/tolog2.jsp");// 若不是会员，则登录到跳转页面（tolog.jsp），然后经过5秒跳到登录页面
		} else {

			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	/*
	 * @Override public void init(FilterConfig fConfig) throws ServletException
	 * { // System.out.println("OnlineFilter init>>>>>>>>>>>>>>>>>"); }
	 */

}
