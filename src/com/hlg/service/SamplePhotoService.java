package com.hlg.service;

import java.util.List;

import com.hlg.dao.SamplePhotoDao;
import com.hlg.entity.SamplePhoto;

public class SamplePhotoService {
	public int save(SamplePhoto samplePhoto) {
		return new SamplePhotoDao().save(samplePhoto);
	}

	public List<SamplePhoto> findAll() {
		return new SamplePhotoDao().findAll();
	}

	public SamplePhoto findById(String id) {
		return new SamplePhotoDao().findById(id);
	}

	public int delete(String id) {
		return new SamplePhotoDao().delete(id);
	}

	public int update(SamplePhoto samplePhoto) {
		return new SamplePhotoDao().update(samplePhoto);
	}

	public List<SamplePhoto> findByCondition(SamplePhoto samplePhoto) {
		return new SamplePhotoDao().findByCondition(samplePhoto);
	}

	public List<SamplePhoto> findByTypeId(int typeId) {
		return new SamplePhotoDao().findByTypeId(typeId);
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
	public List<SamplePhoto> findByPage(int pageNo, int pageSize) {
		return new SamplePhotoDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new SamplePhotoDao().count();
	}

}
