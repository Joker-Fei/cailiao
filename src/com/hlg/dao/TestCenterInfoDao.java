package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.TestCenterInfo;
import com.hlg.util.DBUtil;

public class TestCenterInfoDao {
	DBUtil dbUtil = new DBUtil();

	// 修改状态
	public void changeStatus(int id) {
		System.out.println("TestCenterInfoDao.changeStatus()" + id);
		String sql = "update testcenterinfo set pass=(pass+1)%2 where id=?";
		Object[] params = { id };
		dbUtil.executeUpdate(sql, params);
	}

	public int save(TestCenterInfo testCenterInfo) {
		String sql = "insert into testcenterinfo (title,content,userId,typeId,publishTime,pass) values(?,?,?,?,?,?)";
		Object[] params = { testCenterInfo.getTitle(),
				testCenterInfo.getContent(), testCenterInfo.getUserId(),
				testCenterInfo.getTypeId(), testCenterInfo.getPublishTime(),
				testCenterInfo.getPass() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<TestCenterInfo> findAll() {
		// String sql = "select * from news";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from testcenterinfo n,userdetail u,testcenterinfoType t"
				+ " where n.userId=u.id and n.typeId=t.id "
				+ " order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public TestCenterInfo findById(String id) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from testcenterinfo n,userdetail u,testcenterinfoType t"
				+ " where n.userId=u.id and n.typeId=t.id and n.id=?"
				+ " order by n.publishTime desc";
		Object[] params = { id };
		List<TestCenterInfo> testCenterInfoList = findBySQL(sql, params);
		if (testCenterInfoList != null && testCenterInfoList.size() > 0) {
			return testCenterInfoList.get(0);
		}
		return null;
	}// 查找的通用方法（返回一个集合）

	public List<TestCenterInfo> findBySQL(String sql, Object[] params) {
		List<TestCenterInfo> list = new ArrayList<TestCenterInfo>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				TestCenterInfo testCenterInfo = new TestCenterInfo(
						rs.getInt("id"), rs.getString("title"),
						rs.getString("content"), rs.getInt("userId"),
						rs.getString("author"), rs.getInt("typeId"),
						rs.getString("typeName"), rs.getDate("publishTime"),
						rs.getInt("pass"));
				list.add(testCenterInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from testcenterinfo where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(TestCenterInfo testCenterInfo) {
		String sql = "update testcenterinfo set title=?,content=?,userId=?,"
				+ "typeId=?,publishTime=?,pass=? where id=?";
		Object[] params = { testCenterInfo.getTitle(),
				testCenterInfo.getContent(), testCenterInfo.getUserId(),
				testCenterInfo.getTypeId(), testCenterInfo.getPublishTime(),
				testCenterInfo.getPass(), testCenterInfo.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<TestCenterInfo> findByCondition(TestCenterInfo testCenterInfo) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.title,n.content,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.publishTime,n.pass"
						+ " from testcenterinfo n,userdetail u,testcenterinfoType t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (testCenterInfo != null) {
			if (testCenterInfo.getTitle() != null
					&& !"".equals(testCenterInfo.getTitle())) {
				buffer.append(" and title like ?");
				params.add("%" + testCenterInfo.getTitle() + "%");
			}
			if (testCenterInfo.getContent() != null
					&& !"".equals(testCenterInfo.getContent())) {
				buffer.append(" and content like ?");
				params.add("%" + testCenterInfo.getContent() + "%");
			}
			if (testCenterInfo.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(testCenterInfo.getTypeId());
			}

		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据类型查找新闻
	public List<TestCenterInfo> findByTypeId(int typeId) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from testcenterinfo n,userdetail u,testcenterinfoType t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=?"
				+ " order by n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	// 分页显示
	public List<TestCenterInfo> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from testcenterinfo n,userdetail u,testcenterinfoType t "
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
		String sql = "select count(*) from testcenterinfo";
		return count(sql, null);
		// 前台
		// String sql = "select count(*) ";
		// from testcenterinfo n where n.typeId=?
		// Object[] params = { typeId };
		// return findBySQL(sql, params);
		//

	}

}
