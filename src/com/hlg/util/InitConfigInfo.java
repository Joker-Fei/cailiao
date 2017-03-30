package com.hlg.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitConfigInfo
 */
@WebServlet("/InitConfigInfo")
public class InitConfigInfo extends HttpServlet {
	/*
	 * private static final long serialVersionUID = 1L;
	 *//**
	 * @see HttpServlet#HttpServlet()
	 */
	/*
	 * public InitConfigInfo() { super(); // TODO Auto-generated constructor
	 * stub }
	 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub }
	 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub }
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here

		ServletConfig config = this.getServletConfig();
		String driver = config.getInitParameter("driver");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		String url = config.getInitParameter("url");

		DBUtil.init(driver, url, username, password);

		System.out.println("设置成功!");
	}
}
