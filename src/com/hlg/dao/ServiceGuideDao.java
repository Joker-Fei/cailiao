package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.ServiceGuide;
import com.hlg.util.DBUtil;

public class ServiceGuideDao {
	DBUtil dbUtil = new DBUtil();

	// 修改状态
	public void changeStatus(int id) {
		String sql = "update serviceguide set pass=(pass+1)%2 where id=?";
		Object[] params = { id };
		dbUtil.executeUpdate(sql, params);
	}

	public int save(ServiceGuide serviceGuide) {
		String sql = "insert into serviceguide (title,content,userId,typeId,publishTime,pass) values(?,?,?,?,?,?)";
		Object[] params = { serviceGuide.getTitle(), serviceGuide.getContent(),
				serviceGuide.getUserId(), serviceGuide.getTypeId(),
				serviceGuide.getPublishTime(), serviceGuide.getPass() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<ServiceGuide> findAll() {

		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from serviceguide n,userdetail u,serviceType t"
				+ " where n.userId=u.id and n.typeId=t.id "
				+ " order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public ServiceGuide findById(String id) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from serviceguide n,userdetail u,serviceType t"
				+ " where n.userId=u.id and n.typeId=t.id and n.id=?"
				+ " order by n.publishTime desc";
		Object[] params = { id };
		List<ServiceGuide> serviceGuideList = findBySQL(sql, params);
		if (serviceGuideList != null && serviceGuideList.size() > 0) {
			return serviceGuideList.get(0);
		}
		return null;
	}// 查找的通用方法（返回一个集合）

	public List<ServiceGuide> findBySQL(String sql, Object[] params) {
		List<ServiceGuide> list = new ArrayList<ServiceGuide>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				ServiceGuide serviceGuide = new ServiceGuide(rs.getInt("id"),
						rs.getString("title"), rs.getString("content"),
						rs.getInt("userId"), rs.getString("author"),
						rs.getInt("typeId"), rs.getString("typeName"),
						rs.getDate("publishTime"), rs.getInt("pass"));
				list.add(serviceGuide);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from serviceguide where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(ServiceGuide serviceGuide) {
		String sql = "update serviceguide set title=?,content=?,userId=?,"
				+ "typeId=?,publishTime=?,pass=? where id=?";
		Object[] params = { serviceGuide.getTitle(), serviceGuide.getContent(),
				serviceGuide.getUserId(), serviceGuide.getTypeId(),
				serviceGuide.getPublishTime(), serviceGuide.getPass(),
				serviceGuide.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<ServiceGuide> findByCondition(ServiceGuide serviceGuide) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.title,n.content,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.publishTime,n.pass"
						+ " from serviceguide n,userdetail u,serviceType t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (serviceGuide != null) {
			if (serviceGuide.getTitle() != null
					&& !"".equals(serviceGuide.getTitle())) {
				buffer.append(" and title like ?");
				params.add("%" + serviceGuide.getTitle() + "%");
			}
			if (serviceGuide.getContent() != null
					&& !"".equals(serviceGuide.getContent())) {
				buffer.append(" and content like ?");
				params.add("%" + serviceGuide.getContent() + "%");
			}
			if (serviceGuide.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(serviceGuide.getTypeId());
			}

		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据类型查找新闻
	public List<ServiceGuide> findByTypeId(int typeId) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from serviceguide n,userdetail u,serviceType t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=?"
				+ " order by n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	// 分页显示
	public List<ServiceGuide> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from serviceguide n,userdetail u,serviceType t "
				+ " where n.userId=u.id and n.typeId=t.id order by n.publishTime desc limit ?,?";

		/*
		 * + " where n.userId=u.id and n.typeId=t.id " +
		 * " order by topper desc,n.publishTime desc";
		 */

		Object[] params = { (pageNo - 1) * pageSize, pageSize };
		return findBySQL(sql, params);
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

	// 统计表中的记录数
	public int count() {
		String sql = "select count(*) from serviceguide";
		return count(sql, null);
	}

}
