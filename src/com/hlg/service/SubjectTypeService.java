package com.hlg.service;

import java.util.List;

import com.hlg.dao.SubjectTypeDao;
import com.hlg.entity.SubjectType;

public class SubjectTypeService {
	public int save(SubjectType coorperationType) {

		return new SubjectTypeDao().save(coorperationType);
	}

	public List<SubjectType> findAll() {
		return new SubjectTypeDao().findAll();
	}

	public int delete(int id) {
		return new SubjectTypeDao().delete(id);
	}
}
