package com.hlg.service;

import java.util.List;

import com.hlg.dao.TestCenterInfoDao;
import com.hlg.entity.TestCenterInfo;

public class TestCenterInfoService {
	public int save(TestCenterInfo testCenterInfo) {
		return new TestCenterInfoDao().save(testCenterInfo);
	}

	// 修改状态
	public void changeStatus(int id) {
		new TestCenterInfoDao().changeStatus(id);
	}

	public List<TestCenterInfo> findAll() {
		return new TestCenterInfoDao().findAll();
	}

	public TestCenterInfo findById(String id) {
		return new TestCenterInfoDao().findById(id);
	}

	public int delete(String id) {
		return new TestCenterInfoDao().delete(id);
	}

	public int update(TestCenterInfo testCenterInfo) {
		return new TestCenterInfoDao().update(testCenterInfo);
	}

	public List<TestCenterInfo> findByCondition(TestCenterInfo testCenterInfo) {
		return new TestCenterInfoDao().findByCondition(testCenterInfo);
	}

	public List<TestCenterInfo> findByTypeId(int typeId) {
		return new TestCenterInfoDao().findByTypeId(typeId);
	}

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 *            当前第几页
	 * @param pageSize
	 *            每页大小
	 * @return
	 */
	public List<TestCenterInfo> findByPage(int pageNo, int pageSize) {
		return new TestCenterInfoDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new TestCenterInfoDao().count();
	}

}
