package com.hlg.service;

import java.util.List;

import com.hlg.dao.CoorperationTypeDao;
import com.hlg.entity.CoorperationType;

public class CoorperationTypeService {
	public int save(CoorperationType coorperationType) {

		return new CoorperationTypeDao().save(coorperationType);
	}

	public List<CoorperationType> findAll() {
		return new CoorperationTypeDao().findAll();
	}

	public int delete(int id) {
		return new CoorperationTypeDao().delete(id);
	}
}
