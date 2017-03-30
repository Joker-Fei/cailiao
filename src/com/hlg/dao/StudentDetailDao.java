package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.StudentDetail;
import com.hlg.util.DBUtil;

public class StudentDetailDao {

	DBUtil dbUtil = new DBUtil();

	/*
	 * public StudentDetail findByNameAndPwd(String stuname, String studentPwd)
	 * { String sql =
	 * "select * from studentdetail where stuname=? and studentPwd=?"; Object[]
	 * params = { stuname, studentPwd }; // Object类型的的数组定义构建并赋值（ //
	 * Object是所有类的父类） return this.findSingleBySQL(sql, params); }
	 */

	// 查找的通用方法（返回一个集合）
	public List<StudentDetail> findBySQL(String sql, Object[] params) {
		List<StudentDetail> list = new ArrayList<StudentDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				StudentDetail student = new StudentDetail(rs.getInt("id"),
						rs.getString("num"), rs.getString("stuname"),
						rs.getString("address"), rs.getString("phone"),
						rs.getString("qq"), rs.getString("weixin"));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	// 根据条件进行查询，返回一个对象
	public StudentDetail findSingleBySQL(String sql, Object[] params) {
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				StudentDetail student = new StudentDetail(rs.getInt("id"),
						rs.getString("num"), rs.getString("stuname"),
						rs.getString("address"), rs.getString("phone"),
						rs.getString("qq"), rs.getString("weixin"));
				return student;
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
	public StudentDetail findById(int id) {
		String sql = "select * from studentDetail where id=?";
		Object[] params = { id };
		return this.findSingleBySQL(sql, params);
	}

	// 用户添加
	public int save(StudentDetail studentDetail) {
		String sql = "insert into studentDetail "
				+ "(num,stuname,address,phone,qq,weixin)"
				+ "values(?,?,?,?,?,?)";
		Object[] params = { studentDetail.getNum(), studentDetail.getSutname(),
				studentDetail.getAddress(), studentDetail.getPhone(),
				studentDetail.getQq(), studentDetail.getWeixin() };
		return dbUtil.executeUpdate(sql, params);
	}

	// 用户的删除
	public int delete(int id) {
		String sql = "delete from studentdetail where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	// 用户列表
	public List<StudentDetail> findAll() {
		String sql = "select * from studentdetail";
		Object[] params = {};
		return findBySQL(sql, params);
	}

	// 批量删除用户
	// 分页显示
	public List<StudentDetail> findByPage(int pageNo, int pageSize) {
		String sql = "select * from studentdetail limit ?,?";
		Object[] params = { (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);
	}

	// 统计表中的记录数
	public int count() {
		String sql = "select count(*) from studentdetail";
		return count(sql, null);
	}

	// 多条件查询
	public List<StudentDetail> search(StudentDetail studentDetail) {
		StringBuffer buffer = new StringBuffer(
				"select * from studentdetail where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (studentDetail.getNum() != null
				&& !"".equals(studentDetail.getNum())) {
			buffer.append(" and num like ?");
			params.add("%" + studentDetail.getNum() + "%");
		}

		if (studentDetail.getSutname() != null
				&& !"".equals(studentDetail.getSutname())) {
			buffer.append(" and stuname like ?");
			params.add("%" + studentDetail.getSutname() + "%");
		}

		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据用户Id来查找用户的信息
	public List<StudentDetail> findAllByUserId(String id) {
		String sql = "select * from studentdetail where id=?";
		Object[] params = { id };
		return findBySQL(sql, params);
	}

	// 阿贾克斯验证用户名方法
	public int findByNum(String num) {
		String sql = "select * from studentdetail where num=?";
		Object[] params = { num };
		if (this.findSingleBySQL(sql, params) != null) {
			return 0;
		} else {
			return 1;
		}
	}

	/*
	 * public int checkPwd(String id, String pwd) { String sql =
	 * "select * from studentdetail where id=? and studentPwd=?"; Object[]
	 * params = { id, pwd }; if (this.findSingleBySQL(sql, params) != null) {
	 * return 1; } else { return 0; }
	 * 
	 * }
	 */

	/*
	 * public int changePwd(String id, String pwd) { String sql =
	 * "update studentDetail set studentPwd=? where id=?"; Object[] params = {
	 * pwd, id }; int i = dbUtil.executeUpdate(sql, params); if (i > 0) { return
	 * 1; } else { return 0; }
	 * 
	 * }
	 */
}
