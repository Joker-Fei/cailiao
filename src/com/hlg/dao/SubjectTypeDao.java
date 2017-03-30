package com.hlg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hlg.entity.SubjectType;
import com.hlg.util.DBUtil;

public class SubjectTypeDao {
	DBUtil dbUtil = new DBUtil();

	// 保存类型
	public int save(SubjectType subjectType) {
		String sql = "insert into subType(typeName) values (?)";
		Object[] params = { subjectType.getTypeName() };
		return dbUtil.executeUpdate(sql, params);
		// executeUpdate的返回值是一个整数，指示受影响的行数（即更新计数）
	}

	public List<SubjectType> findAll() {
		List<SubjectType> subjectTypeList = new ArrayList<SubjectType>();

		String sql = "select * from subType";
		ResultSet rs = dbUtil.executeQuery(sql, null);
		try {
			while (rs.next()) {
				SubjectType subjectType = new SubjectType(rs.getInt("id"),
						rs.getString("typeName"));
				subjectTypeList.add(subjectType);// 将对象放入到集合

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return subjectTypeList;
		} finally {
			dbUtil.closeAll();
		}
		return subjectTypeList;
	}

	/**
	 * 根据Id进行删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		String sql = "delete from subType where id=?";
		Object[] params = { id };
		return dbUtil.executeUpdate(sql, params);
	}

}