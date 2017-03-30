package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.SamplePhoto;
import com.hlg.util.DBUtil;

public class SamplePhotoDao {
	DBUtil dbUtil = new DBUtil();

	public int save(SamplePhoto samplePhoto) {
		String sql = "insert into samplePhoto (title,content,userId,typeId,publishTime,pass) values(?,?,?,?,?,?)";
		Object[] params = { samplePhoto.getTitle(), samplePhoto.getContent(),
				samplePhoto.getUserId(), samplePhoto.getTypeId(),
				samplePhoto.getPublishTime(), samplePhoto.getPass() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<SamplePhoto> findAll() {
		// String sql = "select * from news";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from samplePhoto n,userdetail u,photoType t"
				+ " where n.userId=u.id and n.typeId=t.id "
				+ " order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public SamplePhoto findById(String id) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from samplePhoto n,userdetail u,photoType t"
				+ " where n.userId=u.id and n.typeId=t.id and n.id=?"
				+ " order by n.publishTime desc";
		Object[] params = { id };
		List<SamplePhoto> samplePhotoList = findBySQL(sql, params);
		if (samplePhotoList != null && samplePhotoList.size() > 0) {
			return samplePhotoList.get(0);
		}
		return null;
	}// 查找的通用方法（返回一个集合）

	public List<SamplePhoto> findBySQL(String sql, Object[] params) {
		List<SamplePhoto> list = new ArrayList<SamplePhoto>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				SamplePhoto samplePhoto = new SamplePhoto(rs.getInt("id"),
						rs.getString("title"), rs.getString("content"),
						rs.getInt("userId"), rs.getString("author"),
						rs.getInt("typeId"), rs.getString("typeName"),
						rs.getDate("publishTime"), rs.getInt("pass"));
				list.add(samplePhoto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from samplePhoto where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(SamplePhoto samplePhoto) {
		String sql = "update samplePhoto set title=?,content=?,userId=?,"
				+ "typeId=?,publishTime=?,pass=? where id=?";
		Object[] params = { samplePhoto.getTitle(), samplePhoto.getContent(),
				samplePhoto.getUserId(), samplePhoto.getTypeId(),
				samplePhoto.getPublishTime(), samplePhoto.getPass(),
				samplePhoto.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<SamplePhoto> findByCondition(SamplePhoto samplePhoto) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.title,n.content,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.publishTime,n.pass"
						+ " from samplePhoto n,userdetail u,photoType t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (samplePhoto != null) {
			if (samplePhoto.getTitle() != null
					&& !"".equals(samplePhoto.getTitle())) {
				buffer.append(" and title like ?");
				params.add("%" + samplePhoto.getTitle() + "%");
			}
			if (samplePhoto.getContent() != null
					&& !"".equals(samplePhoto.getContent())) {
				buffer.append(" and content like ?");
				params.add("%" + samplePhoto.getContent() + "%");
			}
			if (samplePhoto.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(samplePhoto.getTypeId());
			}

		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据类型查找新闻
	public List<SamplePhoto> findByTypeId(int typeId) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from samplePhoto n,userdetail u,photoType t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=?"
				+ " order by n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	// 分页显示
	public List<SamplePhoto> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from samplePhoto n,userdetail u,photoType t "
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
		String sql = "select count(*) from samplePhoto";
		return count(sql, null);
	}

}
