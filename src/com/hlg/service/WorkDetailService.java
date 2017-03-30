package com.hlg.service;

import java.util.List;

import com.hlg.dao.WorkDetailDao;
import com.hlg.entity.WorkDetail;

public class WorkDetailService {
	public int save(WorkDetail newsDetail) {
		return new WorkDetailDao().save(newsDetail);
	}

	public List<WorkDetail> findAll() {
		return new WorkDetailDao().findAll();
	}

	public WorkDetail findById(String id) {
		return new WorkDetailDao().findById(id);
	}

	public int delete(String id) {
		return new WorkDetailDao().delete(id);
	}

	public int update(WorkDetail newsDetail) {
		return new WorkDetailDao().update(newsDetail);
	}

	public List<WorkDetail> findByCondition(WorkDetail newsDetail) {
		return new WorkDetailDao().findByCondition(newsDetail);
	}

	public List<WorkDetail> findByTypeId(int typeId) {
		return new WorkDetailDao().findByTypeId(typeId);
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
	public List<WorkDetail> findByPage(int pageNo, int pageSize) {
		return new WorkDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new WorkDetailDao().count();
	}

	public List<WorkDetail> findByTypeIdAndPage(int typeId, int pageNo,
			int pageSize) {

		return new WorkDetailDao()
				.findByTypeIdAndPage(typeId, pageNo, pageSize);
	}

}
