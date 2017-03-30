package com.hlg.service;

import java.util.List;

import com.hlg.dao.AccreditationTypeDao;
import com.hlg.entity.AccreditationType;

public class AccreditationTypeService {

	public int save(AccreditationType accreditationType) {

		return new AccreditationTypeDao().save(accreditationType);
	}

	public List<AccreditationType> findAll() {
		return new AccreditationTypeDao().findAll();
	}

	public int delete(int id) {
		return new AccreditationTypeDao().delete(id);
	}
}
