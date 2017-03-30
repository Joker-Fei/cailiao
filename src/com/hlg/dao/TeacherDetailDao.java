package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.TeacherDetail;
import com.hlg.util.DBUtil;

public class TeacherDetailDao {
	DBUtil dbUtil = new DBUtil();

	public int save(TeacherDetail teacherDetail) {
		String sql = "insert into teacher (teacherName,content,userId,typeId,publishTime) values(?,?,?,?,?)";
		Object[] params = { teacherDetail.getTeacherName(),
				teacherDetail.getContent(), teacherDetail.getUserId(),
				teacherDetail.getTypeId(), teacherDetail.getPublishTime() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<TeacherDetail> findAll() {
		// String sql = "select * from news";
		String sql = " select n.id,n.teacherName,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime"
				+ " from teacher n,userdetail u,subType t"
				+ " where n.userId=u.id and n.typeId=t.id "
				+ " order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public TeacherDetail findById(String id) {
		String sql = " select n.id,n.teacherName,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime"
				+ " from teacher n,userdetail u,subType t"
				+ " where n.userId=u.id and n.typeId=t.id and n.id=?"
				+ " order by n.publishTime desc";
		Object[] params = { id };
		List<TeacherDetail> teacherDetailList = findBySQL(sql, params);
		if (teacherDetailList != null && teacherDetailList.size() > 0) {
			return teacherDetailList.get(0);
		}
		return null;
	}// 查找的通用方法（返回一个集合）

	public List<TeacherDetail> findBySQL(String sql, Object[] params) {
		List<TeacherDetail> list = new ArrayList<TeacherDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				TeacherDetail teacherDetail = new TeacherDetail(
						rs.getInt("id"), rs.getString("teacherName"),
						rs.getString("content"), rs.getInt("userId"),
						rs.getString("author"), rs.getInt("typeId"),
						rs.getString("typeName"), rs.getDate("publishTime"));
				list.add(teacherDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from teacher where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(TeacherDetail teacherDetail) {
		String sql = "update teacher set teacherName=?,content=?,userId=?,"
				+ "typeId=?,publishTime=? where id=?";
		Object[] params = { teacherDetail.getTeacherName(),
				teacherDetail.getContent(), teacherDetail.getUserId(),
				teacherDetail.getTypeId(), teacherDetail.getPublishTime(),
				teacherDetail.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<TeacherDetail> findByCondition(TeacherDetail teacherDetail) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.teacherName,n.content,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.publishTime"
						+ " from teacher n,userdetail u,subType t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (teacherDetail != null) {
			if (teacherDetail.getTeacherName() != null
					&& !"".equals(teacherDetail.getTeacherName())) {
				buffer.append(" and teacherName like ?");
				params.add("%" + teacherDetail.getTeacherName() + "%");
			}
			if (teacherDetail.getContent() != null
					&& !"".equals(teacherDetail.getContent())) {
				buffer.append(" and content like ?");
				params.add("%" + teacherDetail.getContent() + "%");
			}
			if (teacherDetail.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(teacherDetail.getTypeId());
			}

		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据类型查找新闻
	public List<TeacherDetail> findByTypeId(int typeId) {
		String sql = " select n.id,n.teacherName,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime"
				+ " from teacher n,userdetail u,subType t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=?"
				+ " order by n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	public List<TeacherDetail> findByTypeIdAndPage(int typeId, int pageNo,
			int pageSize) {

		String sql = " select n.id,n.teacherName,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime"
				+ " from teacher n,userdetail u,subType t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=? order by n.publishTime desc limit ?,?";

		Object[] params = { typeId, (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);

	}

	// 分页显示
	public List<TeacherDetail> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = " select n.id,n.teacherName,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime"
				+ " from teacher n,userdetail u,subType t "
				+ " where n.userId=u.id and n.typeId=t.id order by n.publishTime desc limit ?,?";

		/*
		 * + " where n.userId=u.id and n.typeId=t.id " +
		 * " order by topper desc,n.publishTime desc";
		 */

		Object[] params = { (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);
	}

	/*
	 * mysql支持limit select * from tablename limit 0,1 即取出第一条记录。
	 * 
	 * select * from tablename limit 1,1 第二条记录
	 * 
	 * select * from tablename limit 10,20 从第11条到31条（共计20条）
	 */

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

	// 统计表中的记录数
	public int count() {
		String sql = "select count(*) from teacher";
		return count(sql, null);
	}

}
