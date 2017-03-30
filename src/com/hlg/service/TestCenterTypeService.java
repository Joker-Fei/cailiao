package com.hlg.service;

import java.util.List;

import com.hlg.dao.TestCenterTypeDao;
import com.hlg.entity.TestCenterType;

public class TestCenterTypeService {

	public int save(TestCenterType testCenterType) {

		return new TestCenterTypeDao().save(testCenterType);
	}

	public List<TestCenterType> findAll() {
		return new TestCenterTypeDao().findAll();
	}

	public int delete(int id) {
		return new TestCenterTypeDao().delete(id);
	}
}
