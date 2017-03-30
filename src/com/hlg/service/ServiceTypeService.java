package com.hlg.service;

import java.util.List;

import com.hlg.dao.ServiceTypeDao;
import com.hlg.entity.ServiceType;

public class ServiceTypeService {

	public int save(ServiceType serviceType) {

		return new ServiceTypeDao().save(serviceType);
	}

	public List<ServiceType> findAll() {
		return new ServiceTypeDao().findAll();
	}

	public int delete(int id) {
		return new ServiceTypeDao().delete(id);
	}
}
