package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.WorkDetail;
import com.hlg.util.DBUtil;

public class WorkDetailDao {
	DBUtil dbUtil = new DBUtil();

	public int save(WorkDetail newsDetail) {
		String sql = "insert into workInfo (title,content,userId,typeId,publishTime,pass) values(?,?,?,?,?,?)";
		Object[] params = { newsDetail.getTitle(), newsDetail.getContent(),
				newsDetail.getUserId(), newsDetail.getTypeId(),
				newsDetail.getPublishTime(), newsDetail.getPass() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<WorkDetail> findAll() {
		// String sql = "select * from news";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from workInfo n,userdetail u,workType t"
				+ " where n.userId=u.id and n.typeId=t.id "
				+ " order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public WorkDetail findById(String id) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from workInfo n,userdetail u,workType t"
				+ " where n.userId=u.id and n.typeId=t.id and n.id=?"
				+ " order by n.publishTime desc";
		Object[] params = { id };
		List<WorkDetail> newsDetailList = findBySQL(sql, params);
		if (newsDetailList != null && newsDetailList.size() > 0) {
			return newsDetailList.get(0);
		}
		return null;
	}// 查找的通用方法（返回一个集合）

	public List<WorkDetail> findBySQL(String sql, Object[] params) {
		List<WorkDetail> list = new ArrayList<WorkDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				WorkDetail newsDetail = new WorkDetail(rs.getInt("id"),
						rs.getString("title"), rs.getString("content"),
						rs.getInt("userId"), rs.getString("author"),
						rs.getInt("typeId"), rs.getString("typeName"),
						rs.getDate("publishTime"), rs.getInt("pass"));
				list.add(newsDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from workInfo where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(WorkDetail newsDetail) {
		String sql = "update workInfo set title=?,content=?,userId=?,"
				+ "typeId=?,publishTime=?,pass=? where id=?";
		Object[] params = { newsDetail.getTitle(), newsDetail.getContent(),
				newsDetail.getUserId(), newsDetail.getTypeId(),
				newsDetail.getPublishTime(), newsDetail.getPass(),
				newsDetail.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<WorkDetail> findByCondition(WorkDetail newsDetail) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.title,n.content,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.publishTime,n.pass"
						+ " from workInfo n,userdetail u,workType t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (newsDetail != null) {
			if (newsDetail.getTitle() != null
					&& !"".equals(newsDetail.getTitle())) {
				buffer.append(" and title like ?");
				params.add("%" + newsDetail.getTitle() + "%");
			}
			if (newsDetail.getContent() != null
					&& !"".equals(newsDetail.getContent())) {
				buffer.append(" and content like ?");
				params.add("%" + newsDetail.getContent() + "%");
			}
			if (newsDetail.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(newsDetail.getTypeId());
			}

		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据类型查找新闻
	public List<WorkDetail> findByTypeId(int typeId) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from workInfo n,userdetail u,workType t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=?"
				+ " order by n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	public List<WorkDetail> findByTypeIdAndPage(int typeId, int pageNo,
			int pageSize) {

		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from workInfo n,userdetail u,workType t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=? order by n.publishTime desc limit ?,?";

		Object[] params = { typeId, (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);

	}

	// 分页显示
	public List<WorkDetail> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from workInfo n,userdetail u,workType t "
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
		String sql = "select count(*) from workInfo";
		return count(sql, null);
	}

}
