package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.Accreditation;
import com.hlg.util.DBUtil;

public class AccreditationDao {
	DBUtil dbUtil = new DBUtil();

	// 修改状态
	public void changeStatus(int id) {
		String sql = "update accreditation set pass=(pass+1)%2 where id=?";
		Object[] params = { id };
		dbUtil.executeUpdate(sql, params);
	}

	public int save(Accreditation accreditation) {
		String sql = "insert into accreditation (title,content,userId,typeId,publishTime,pass) values(?,?,?,?,?,?)";
		Object[] params = { accreditation.getTitle(),
				accreditation.getContent(), accreditation.getUserId(),
				accreditation.getTypeId(), accreditation.getPublishTime(),
				accreditation.getPass() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<Accreditation> findAll() {
		// String sql = "select * from news";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from accreditation n,userdetail u,accreditationType t"
				+ " where n.userId=u.id and n.typeId=t.id "
				+ " order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public Accreditation findById(String id) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from accreditation n,userdetail u,accreditationType t"
				+ " where n.userId=u.id and n.typeId=t.id and n.id=?"
				+ " order by n.publishTime desc";
		Object[] params = { id };
		List<Accreditation> accreditationList = findBySQL(sql, params);
		if (accreditationList != null && accreditationList.size() > 0) {
			return accreditationList.get(0);
		}
		return null;
	}// 查找的通用方法（返回一个集合）

	public List<Accreditation> findBySQL(String sql, Object[] params) {
		List<Accreditation> list = new ArrayList<Accreditation>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				Accreditation accreditation = new Accreditation(
						rs.getInt("id"), rs.getString("title"),
						rs.getString("content"), rs.getInt("userId"),
						rs.getString("author"), rs.getInt("typeId"),
						rs.getString("typeName"), rs.getDate("publishTime"),
						rs.getInt("pass"));
				list.add(accreditation);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from accreditation where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(Accreditation accreditation) {
		String sql = "update accreditation set title=?,content=?,userId=?,"
				+ "typeId=?,publishTime=?,pass=? where id=?";
		Object[] params = { accreditation.getTitle(),
				accreditation.getContent(), accreditation.getUserId(),
				accreditation.getTypeId(), accreditation.getPublishTime(),
				accreditation.getPass(), accreditation.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<Accreditation> findByCondition(Accreditation accreditation) {
		StringBuffer buffer = new StringBuffer(
				"select n.id,n.title,n.content,n.userId,n.typeId,"
						+ " u.userName author,t.typeName,n.publishTime,n.pass"
						+ " from accreditation n,userdetail u,accreditationType t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (accreditation != null) {
			if (accreditation.getTitle() != null
					&& !"".equals(accreditation.getTitle())) {
				buffer.append(" and title like ?");
				params.add("%" + accreditation.getTitle() + "%");
			}
			if (accreditation.getContent() != null
					&& !"".equals(accreditation.getContent())) {
				buffer.append(" and content like ?");
				params.add("%" + accreditation.getContent() + "%");
			}
			if (accreditation.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(accreditation.getTypeId());
			}

		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据类型查找新闻
	public List<Accreditation> findByTypeId(int typeId) {
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from accreditation n,userdetail u,accreditationType t"
				+ " where n.userId=u.id and n.typeId=t.id  and n.typeId=?"
				+ " order by n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	// 分页显示
	public List<Accreditation> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = " select n.id,n.title,n.content,n.userId,n.typeId,"
				+ " u.userName author,t.typeName,n.publishTime,n.pass"
				+ " from accreditation n,userdetail u,accreditationType t "
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
		String sql = "select count(*) from accreditation";
		return count(sql, null);
	}

}
