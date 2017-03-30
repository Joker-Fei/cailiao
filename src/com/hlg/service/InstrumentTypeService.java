package com.hlg.service;

import java.util.List;

import com.hlg.dao.InstrumentTypeDao;
import com.hlg.entity.InstrumentType;

public class InstrumentTypeService {

	public int save(InstrumentType instrumentType) {

		return new InstrumentTypeDao().save(instrumentType);
	}

	public List<InstrumentType> findAll() {
		return new InstrumentTypeDao().findAll();
	}

	public int delete(int id) {
		return new InstrumentTypeDao().delete(id);
	}
}
