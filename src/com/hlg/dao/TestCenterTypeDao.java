package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.TestCenterType;
import com.hlg.util.ArrayUtil;
import com.hlg.util.DBUtil;

public class TestCenterTypeDao {

	DBUtil dbUtil = new DBUtil();

	// 保存测试中心概况类型
	public int save(TestCenterType testCenterType) {
		String sql = "insert into testcenterinfotype(typeName) values (?)";
		Object[] params = { testCenterType.getTypeName() };
		return dbUtil.executeUpdate(sql, params);
		// executeUpdate的返回值是一个整数，指示受影响的行数（即更新计数）
	}

	public List<TestCenterType> findAll() {
		List<TestCenterType> testCenterTypeList = new ArrayList<TestCenterType>();

		String sql = "select * from testcenterinfotype";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				TestCenterType testCenterType = new TestCenterType(
						rs.getInt("id"), rs.getString("typeName"));
				testCenterTypeList.add(testCenterType);// 将对象放入到集合

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return testCenterTypeList;
		} finally {
			dbUtil.closeAll();
		}
		return testCenterTypeList;
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 *            指定的ID集合
	 * @return
	 */
	public int batchDelete(String[] ids) {

		String sql = "delete from testcenterinfotype where id in(?)";
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
		String sql = "delete from testcenterinfotype where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

}
