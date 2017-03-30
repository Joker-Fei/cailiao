package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.UserDetail;
import com.hlg.util.DBUtil;

public class UserDetailDao {
	DBUtil dbUtil = new DBUtil();

	public UserDetail findByNameAndPwd(String userName, String userPwd) {
		String sql = "select * from userdetail where userName=? and userPwd=?";
		Object[] params = { userName, userPwd }; // Object类型的的数组定义构建并赋值（
													// Object是所有类的父类）
		return this.findSingleBySQL(sql, params);
	}

	// 查找的通用方法（返回一个集合）
	public List<UserDetail> findBySQL(String sql, Object[] params) {
		List<UserDetail> list = new ArrayList<UserDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				UserDetail user = new UserDetail(rs.getInt("id"),
						rs.getString("userName"), rs.getString("userPwd"),
						rs.getString("phone"), rs.getInt("status"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	// 根据条件进行查询，返回一个对象
	public UserDetail findSingleBySQL(String sql, Object[] params) {
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				UserDetail user = new UserDetail(rs.getInt("id"),
						rs.getString("userName"), rs.getString("userPwd"),
						rs.getString("phone"), rs.getInt("status"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return null;
	}

	// 根据条件统计数据
	public int count(String sql, Object[] params) {
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				// 使用下标访问列，从1开始
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return 0;
	}

	// 根据用户Id查找用户
	public UserDetail findById(int id) {
		String sql = "select * from userDetail where id=?";
		Object[] params = { id };
		return this.findSingleBySQL(sql, params);
	}

	// 用户添加
	public int save(UserDetail userDetail) {
		String sql = "insert into userDetail "
				+ "(userName,userPwd,phone,status)" + "values(?,?,?,?)";
		Object[] params = { userDetail.getUserName(), userDetail.getUserPwd(),
				userDetail.getPhone(), userDetail.getStatus() };
		return dbUtil.executeUpdate(sql, params);
	}

	// 更新用户数据到数据库
	public int update(UserDetail userDetail) {
		String sql = "update userDetail set userName=?,userPwd=?,phone=?,status=?,"
				+ "where id=?";
		Object[] params = { userDetail.getUserName(), userDetail.getUserPwd(),
				userDetail.getPhone(), userDetail.getStatus(),
				userDetail.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	// 用户的删除
	public int delete(int id) {
		String sql = "delete from userDetail where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	// 用户列表
	public List<UserDetail> findAll() {
		String sql = "select * from userDetail";
		Object[] params = {};
		return findBySQL(sql, params);
	}

	// 批量删除用户
	// 分页显示
	public List<UserDetail> findByPage(int pageNo, int pageSize) {
		String sql = "select * from userDetail limit ?,?";
		Object[] params = { (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);
	}

	// 统计表中的记录数
	public int count() {
		String sql = "select count(*) from userDetail";
		return count(sql, null);
	}

	// 多条件查询
	public List<UserDetail> search(UserDetail userDetail) {
		StringBuffer buffer = new StringBuffer(
				"select * from userDetail where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (userDetail.getUserName() != null
				&& !"".equals(userDetail.getUserName())) {
			buffer.append(" and userName like ?");
			params.add("%" + userDetail.getUserName() + "%");
		}
		if (userDetail.getPhone() != null && !"".equals(userDetail.getPhone())) {
			buffer.append(" and phone like ?");
			params.add("%" + userDetail.getPhone() + "%");
		}
		if (userDetail.getStatus() != -1) {
			buffer.append(" and status=?");
			params.add(userDetail.getStatus());
		}

		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据用户Id来查找用户的信息
	public List<UserDetail> findAllByUserId(String id) {
		String sql = "select * from userdetail where id=?";
		Object[] params = { id };
		return findBySQL(sql, params);
	}

	// 阿贾克斯验证用户名方法
	public int findByUserName(String username) {
		String sql = "select * from userDetail where userName=?";
		Object[] params = { username };
		if (this.findSingleBySQL(sql, params) != null) {
			return 0;
		} else {
			return 1;
		}
	}

	public int checkPwd(String id, String pwd) {
		String sql = "select * from userDetail where id=? and userPwd=?";
		Object[] params = { id, pwd };
		if (this.findSingleBySQL(sql, params) != null) {
			return 1;
		} else {
			return 0;
		}

	}

	public int changePwd(String id, String pwd) {
		String sql = "update userDetail set userPwd=? where id=?";
		Object[] params = { pwd, id };
		int i = dbUtil.executeUpdate(sql, params);
		if (i > 0) {
			return 1;
		} else {
			return 0;
		}

	}
}
