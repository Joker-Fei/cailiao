package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.SubjectDetail;
import com.hlg.util.DBUtil;

public class SubjectDetailDao {
	DBUtil dbUtil = new DBUtil();

	public int save(SubjectDetail subjectDetail) {
		String sql = "insert into sub (subName,content,userId,web,publishTime) values(?,?,?,?,?)";
		Object[] params = { subjectDetail.getSubName(),
				subjectDetail.getContent(), subjectDetail.getUserId(),
				subjectDetail.getWeb(), subjectDetail.getPublishTime() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<SubjectDetail> findAll() {
		/*
		 * String sql = " select n.id,n.subName,n.content,n.userId," +
		 * "u.userName author,n.web,n.publishTime" + "from sub n,userdetail u" +
		 * " where n.userId=u.id " + "order by n.publishTime desc";
		 */

		String sql = "select n.id,n.subName,n.content,n.userId,u.userName author,n.web,n.publishTime from sub n,userdetail u where n.userId=u.id order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public SubjectDetail findById(String id) {
		String sql = " select s.id,s.subName,s.content,s.userId, u.userName author,s.web,s.publishTime from sub s,userdetail u where s.userId=u.id and s.id=? order by s.publishTime desc";
		Object[] params = { id };
		List<SubjectDetail> subjectDetailList = findBySQL(sql, params);
		if (subjectDetailList != null && subjectDetailList.size() > 0) {
			return subjectDetailList.get(0);
		}
		return null;
	}// 查找的通用方法（返回一个集合）

	public List<SubjectDetail> findBySQL(String sql, Object[] params) {
		List<SubjectDetail> list = new ArrayList<SubjectDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				SubjectDetail subjectDetail = new SubjectDetail(
						rs.getInt("id"), rs.getString("subName"),
						rs.getString("content"), rs.getInt("userId"),
						rs.getString("author"), rs.getString("web"),
						rs.getDate("publishTime"));
				list.add(subjectDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from sub where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(SubjectDetail subjectDetail) {
		String sql = "update sub set subName=?,content=?,userId=?,"
				+ "web=?,publishTime=? where id=?";
		Object[] params = { subjectDetail.getSubName(),
				subjectDetail.getContent(), subjectDetail.getUserId(),
				subjectDetail.getWeb(), subjectDetail.getPublishTime(),
				subjectDetail.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	/*
	 * public List<SubjectDetail> findByCondition(SubjectDetail subjectDetail) {
	 * StringBuffer buffer = new StringBuffer(
	 * "select n.id,n.subName,n.content,n.userId,n.typeId," +
	 * " u.userName author,t.typeName,n.web,n.publishTime" +
	 * " from sub n,userdetail u,subType t" +
	 * " where n.userId=u.id and n.typeId=t.id "); List<Object> params = new
	 * ArrayList<Object>(); if (subjectDetail != null) { if
	 * (subjectDetail.getSubName() != null &&
	 * !"".equals(subjectDetail.getSubName())) {
	 * buffer.append(" and title like ?"); params.add("%" +
	 * subjectDetail.getSubName() + "%"); } if (subjectDetail.getContent() !=
	 * null && !"".equals(subjectDetail.getContent())) {
	 * buffer.append(" and content like ?"); params.add("%" +
	 * subjectDetail.getContent() + "%"); } if (subjectDetail.getTypeId() != -1)
	 * { buffer.append(" and typeId= ?"); params.add(subjectDetail.getTypeId());
	 * }
	 * 
	 * } return findBySQL(new String(buffer), params.toArray()); }
	 */

	/*
	 * // 根据类型查找新闻 public List<SubjectDetail> findByTypeId(int typeId) { String
	 * sql = " select n.id,n.subName,n.content,n.userId,n.typeId," +
	 * " u.userName author,t.typeName,n.web,n.publishTime" +
	 * " from sub n,userdetail u,subType t" +
	 * " where n.userId=u.id and n.typeId=t.id  and n.typeId=?" +
	 * " order by n.publishTime desc"; Object[] params = { typeId }; return
	 * findBySQL(sql, params); }
	 */

	/*
	 * public List<SubjectDetail> findByTypeIdAndPage(int typeId, int pageNo,
	 * int pageSize) {
	 * 
	 * String sql = " select n.id,n.subName,n.content,n.userId,n.typeId," +
	 * " u.userName author,t.typeName,n.web,n.publishTime" +
	 * " from sub n,userdetail u,subType t" +
	 * " where n.userId=u.id and n.typeId=t.id  and n.typeId=? order by n.publishTime desc limit ?,?"
	 * ;
	 * 
	 * Object[] params = { typeId, (pageNo - 1) * pageSize, pageSize }; return
	 * findBySQL(sql, params);
	 * 
	 * }
	 */
	// 分页显示
	public List<SubjectDetail> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = "select s.id,s.subName,s.content,s.userId,u.userName author,s.web,s.publishTime from sub s,userdetail u where s.userId=u.id order by s.publishTime desc limit ?,?";

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
		String sql = "select count(*) from sub";
		return count(sql, null);
	}
}
