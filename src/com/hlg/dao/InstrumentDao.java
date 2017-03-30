package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.Instrument;
import com.hlg.util.DBUtil;

public class InstrumentDao {
	DBUtil dbUtil = new DBUtil();

	public int save(Instrument instrument) {
		String sql = "insert into instrument (typeId,content,factory,mainAccessories,tecParame,tecFeatures,appliRange,publishTime,userId) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { instrument.getTypeId(), instrument.getContent(),
				instrument.getFactory(), instrument.getMainAccessories(),
				instrument.getTecParame(), instrument.getTecFeatures(),
				instrument.getAppliRange(), instrument.getPublishTime(),
				instrument.getUserId() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<Instrument> findAll() {
		// String sql = "select * from news";
		String sql = " select n.id,n.typeId,n.content,n.factory,n.mainAccessories,n.tecParame,"
				+ "n.tecFeatures,n.appliRange,n.publishTime,n.userId,"
				+ " t.typeName,u.userName author"
				+ " from instrument n,usertestcenter u,instrumenttype t"
				+ " where n.userId=u.id and n.typeId=t.id  order by n.publishTime desc";
		return findBySQL(sql, null);
	}

	public Instrument findById(String id) {
		String sql = " select n.id, n.typeId,n.content,n.factory,n.mainAccessories,n.tecParame,"
				+ "n.tecFeatures,n.appliRange,n.publishTime,n.userId,"
				+ " t.typeName,u.userName author"
				+ " from instrument n,usertestcenter u,instrumenttype t"
				+ " where n.userId=u.id and n.typeId=t.id and n.id=? order by n.publishTime desc";
		Object[] params = { id };
		List<Instrument> instrumentList = findBySQL(sql, params);
		if (instrumentList != null && instrumentList.size() > 0) {
			return instrumentList.get(0);
		}
		return null;
	}

	// 查找的通用方法（返回一个集合）

	public List<Instrument> findBySQL(String sql, Object[] params) {
		List<Instrument> list = new ArrayList<Instrument>();
		ResultSet rs = dbUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				Instrument instrument = new Instrument(rs.getInt("id"),
						rs.getInt("typeId"), rs.getString("content"),
						rs.getString("factory"),
						rs.getString("mainAccessories"),
						rs.getString("tecParame"), rs.getString("tecFeatures"),
						rs.getString("appliRange"), rs.getDate("publishTime"),
						rs.getString("typeName"), rs.getInt("userId"),
						rs.getString("author"));
				list.add(instrument);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.closeAll();
		}
		return list;
	}

	public int delete(String id) {
		String sql = "delete from instrument where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

	public int update(Instrument instrument) {
		String sql = "update instrument set typeId=?,content=?,factory=?,"
				+ "mainAccessories=?,tecParame=?,tecFeatures=?,"
				+ "appliRange=?,publishTime=?, userId=? where id=?";
		Object[] params = { instrument.getTypeId(), instrument.getContent(),
				instrument.getFactory(), instrument.getMainAccessories(),
				instrument.getTecParame(), instrument.getTecFeatures(),
				instrument.getAppliRange(), instrument.getPublishTime(),
				instrument.getUserId(), instrument.getId() };
		return dbUtil.executeUpdate(sql, params);
	}

	public List<Instrument> findByCondition(Instrument instrument) {
		StringBuffer buffer = new StringBuffer(
				" select n.id,n.typeId,n.content,n.factory,n.mainAccessories,n.tecParame,"
						+ "n.tecFeatures,n.appliRange,n.publishTime,n.userId,"
						+ " t.typeName,u.userName author"
						+ " from instrument n,usertestcenter u,instrumenttype t"
						+ " where n.userId=u.id and n.typeId=t.id ");
		List<Object> params = new ArrayList<Object>();
		if (instrument != null) {

			if (instrument.getFactory() != null
					&& !"".equals(instrument.getFactory())) {
				buffer.append(" and factory like ?");
				params.add("%" + instrument.getFactory() + "%");
			}

			if (instrument.getContent() != null
					&& !"".equals(instrument.getContent())) {
				buffer.append(" and content like ?");
				params.add("%" + instrument.getContent() + "%");
			}
			if (instrument.getTypeId() != -1) {
				buffer.append(" and typeId= ?");
				params.add(instrument.getTypeId());
			}

		}
		return findBySQL(new String(buffer), params.toArray());
	}

	// 根据类型查找新闻
	public List<Instrument> findByTypeId(int typeId) {
		String sql = " select n.id,n.typeId,n.content,n.factory,n.mainAccessories,n.tecParame,"
				+ "n.tecFeatures,n.appliRange,n.publishTime,n.userId,"
				+ " t.typeName,u.userName author"
				+ " from instrument n,usertestcenter u,instrumenttype t"
				+ " where  n.userId=u.id and n.typeId=t.id and n.typeId=?"
				+ " order by n.publishTime desc";
		Object[] params = { typeId };
		return findBySQL(sql, params);
	}

	// 分页显示
	public List<Instrument> findByPage(int pageNo, int pageSize) {
		// String sql = "select * from news limit ?,?";
		String sql = " select n.id ,n.typeId,n.content,n.factory,n.mainAccessories,n.tecParame,"
				+ "n.tecFeatures,n.appliRange,n.publishTime,n.userId,u.userName author,"
				+ " t.typeName"
				+ " from instrument n,usertestcenter u,instrumenttype t"
				+ " where  n.userId=u.id and n.typeId=t.id order by n.publishTime desc limit ?,?";

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
		String sql = "select count(*) from instrument";
		return count(sql, null);
	}

}
