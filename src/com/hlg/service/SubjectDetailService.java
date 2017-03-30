package com.hlg.service;

import java.util.List;

import com.hlg.dao.SubjectDetailDao;
import com.hlg.entity.SubjectDetail;

public class SubjectDetailService {
	public int save(SubjectDetail subjectDetail) {
		return new SubjectDetailDao().save(subjectDetail);
	}

	public List<SubjectDetail> findAll() {
		return new SubjectDetailDao().findAll();
	}

	public SubjectDetail findById(String id) {
		return new SubjectDetailDao().findById(id);
	}

	public int delete(String id) {
		return new SubjectDetailDao().delete(id);
	}

	public int update(SubjectDetail subjectDetail) {
		return new SubjectDetailDao().update(subjectDetail);
	}

	/*
	 * public List<SubjectDetail> findByCondition(SubjectDetail subjectDetail) {
	 * return new SubjectDetailDao().findByCondition(subjectDetail); }
	 */

	/*
	 * public List<SubjectDetail> findByTypeId(int typeId) { return new
	 * SubjectDetailDao().findByTypeId(typeId); }
	 */

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 *            当前第几页
	 * @param pageSize
	 *            每页大小
	 * @return
	 */
	public List<SubjectDetail> findByPage(int pageNo, int pageSize) {
		return new SubjectDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new SubjectDetailDao().count();
	}

	/*
	 * public List<SubjectDetail> findByTypeIdAndPage(int typeId, int pageNo,
	 * int pageSize) { // TODO Auto-generated method stub return new
	 * SubjectDetailDao().findByTypeIdAndPage(typeId, pageNo, pageSize); }
	 */
}
