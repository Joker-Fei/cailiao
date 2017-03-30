package com.hlg.service;

import java.util.List;

import com.hlg.dao.ServiceGuideDao;
import com.hlg.entity.ServiceGuide;

public class ServiceGuideService {
	public int save(ServiceGuide serviceGuide) {
		return new ServiceGuideDao().save(serviceGuide);
	}

	// 修改状态
	public void changeStatus(int id) {
		new ServiceGuideDao().changeStatus(id);
	}

	public List<ServiceGuide> findAll() {
		return new ServiceGuideDao().findAll();
	}

	public ServiceGuide findById(String id) {
		return new ServiceGuideDao().findById(id);
	}

	public int delete(String id) {
		return new ServiceGuideDao().delete(id);
	}

	public int update(ServiceGuide serviceGuide) {
		return new ServiceGuideDao().update(serviceGuide);
	}

	public List<ServiceGuide> findByCondition(ServiceGuide serviceGuide) {
		return new ServiceGuideDao().findByCondition(serviceGuide);
	}

	public List<ServiceGuide> findByTypeId(int typeId) {
		return new ServiceGuideDao().findByTypeId(typeId);
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
	public List<ServiceGuide> findByPage(int pageNo, int pageSize) {
		return new ServiceGuideDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new ServiceGuideDao().count();
	}

}
