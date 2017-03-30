package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.TopNewsDetail;
import com.hlg.util.DBUtil;

public class TopNewsDetailDao {

	DBUtil dbUtil = new DBUtil();

	public int save(TopNewsDetail topNewsDetail) {
		String sql = "insert into topNews (title,imgUrl,content,userId,publishTime) values(?,?,?,?,?)";
		Object[] params = { topNewsDetail.getTitle(),
				topNewsDetail.getImgUrl(), topNewsDetail.getContent(),
				topNewsDetail.getUserId(), topNewsDetail.getPublishTime() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<TopNewsDetail> findAll() {
		// String sql = "select * from news";
		String sql = " select n.id,n.title,n.imgUrl,n.content,n.userId,"
				+ " u.userName author,n.publishTime"
				+ " from topNews n,userdetail u " + " where n.userId=u.id"
				+ " order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public TopNewsDetail findById(String id) {
		String sql = " select n.id,n.title,n.imgUrl,n.content,n.userId,"
				+ " u.userName author,n.publishTime"
				+ " from topNews n,userdetail u"
				+ " where n.userId=u.id and n.id=?"
				+ " order by n.publishTime desc";
		Object[] params = { id };
		List<TopNewsDetail> topNewsDetailList = findBySQL(sql, params);
		if (topNewsDetailList != null && topNewsDetailList.size() > 0) {
			return topNewsDetailList.get(0);
		}
		return null;
	}

	// 查找的通用方法（返回一个集合）
	public List<TopNewsDetail> findBySQL(String sql, Object[] params) {
		List<TopNewsDetail> list = new ArrayList<TopNewsDetail>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				TopNewsDetail topNewsDetail = new TopNewsDetail(
						rs.getInt("id"), rs.getString("title"),
						rs.getString("imgUrl"), rs.getString("content"),
						rs.getInt("userId"), rs.getString("author"),
						rs.getDate("publishTime"));
				list.add(topNewsDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from topNews where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

}
