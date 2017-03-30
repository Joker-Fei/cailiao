package com.hlg.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBUtil {
	// String className = "com.mysql.jdbc.Driver";
	// String url =
	// "jdbc:mysql://localhost:3306/materialdb?characterEncoding=utf-8";
	// String userName = "root";
	// String userPwd = "123123";

	/* ===================================== */
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	public static void init(String driver1, String url1, String username1,
			String password1) {
		driver = driver1;
		url = url1;
		username = username1;
		password = password1;

	}

	public Connection getConnection() throws SQLException, Exception {

		try {
			Class.forName(driver);

			conn = (Connection) DriverManager.getConnection(url, username,
					password);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;

	}

	/* ===================================== */

	ResultSet rs = null;
	java.sql.PreparedStatement pst = null;
	Connection conn = null;

	/*
	 * public Connection getConnection() {
	 * 
	 * try {
	 * 
	 * // 1、加载驱动 Class.forName(className); // 2.获取连接 conn = (Connection)
	 * DriverManager.getConnection(url, userName, userPwd);
	 * 
	 * } catch (ClassNotFoundException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } catch (SQLException e) {
	 * 
	 * e.printStackTrace(); } return conn;
	 * 
	 * }
	 */

	// 执行查询
	public ResultSet executeQuery(String sql, Object[] params) {
		try {
			getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// 3.准备SQL语句
			pst = conn.prepareStatement(sql);
			// 占位符 赋值
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject((i + 1), params[i]);
				}
			}
			// 4.执行SQL语句
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 执行更新
	public int executeUpdate(String sql, Object[] params) {
		int result = 0;
		try {
			getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			// 3.准备SQL语句
			pst = conn.prepareStatement(sql);
			// 占位符 赋值
			if (params != null && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject((i + 1), params[i]);
				}
			}
			// 4.执行SQL语句
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;
	}

	// 释放资源
	public void closeAll() {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if (pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
