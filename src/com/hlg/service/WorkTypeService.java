package com.hlg.service;

import java.util.List;

import com.hlg.dao.WorkTypeDao;
import com.hlg.entity.WorkType;

public class WorkTypeService {

	public int save(WorkType newsType) {

		return new WorkTypeDao().save(newsType);
	}

	public List<WorkType> findAll() {
		return new WorkTypeDao().findAll();
	}

	public int delete(int id) {
		return new WorkTypeDao().delete(id);
	}
}
