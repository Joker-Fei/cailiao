package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.WorkType;
import com.hlg.util.ArrayUtil;
import com.hlg.util.DBUtil;

public class WorkTypeDao {

	DBUtil dbUtil = new DBUtil();

	// 保存学院概况类型
	public int save(WorkType newsType) {
		String sql = "insert into workType(typeName) values (?)";
		Object[] params = { newsType.getTypeName() };
		return dbUtil.executeUpdate(sql, params);
		// executeUpdate的返回值是一个整数，指示受影响的行数（即更新计数）
	}

	public List<WorkType> findAll() {
		List<WorkType> newsTypeList = new ArrayList<WorkType>();

		String sql = "select * from workType";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				WorkType newsType = new WorkType(rs.getInt("id"),
						rs.getString("typeName"));
				newsTypeList.add(newsType);// 将对象放入到集合

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return newsTypeList;
		} finally {
			dbUtil.closeAll();
		}
		return newsTypeList;
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 *            指定的ID集合
	 * @return
	 */
	public int batchDelete(String[] ids) {

		String sql = "delete from workType where id in(?)";
		Object[] params = { ArrayUtil.array2String(ids, ",") };

		/*
		 * 打印id值的集合，其中含有“,”
		 * 
		 * for (int i = 0; i < params.length; i++) {
		 * System.out.println(params[i]); }
		 */

		return dbUtil.executeUpdate(sql, params);

	}

	/**
	 * 根据Id进行删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		String sql = "delete from workType where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

}
