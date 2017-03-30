package com.hlg.service;

import java.util.List;

import com.hlg.dao.TeacherDetailDao;
import com.hlg.entity.TeacherDetail;

public class TeacherDetailService {
	public int save(TeacherDetail teacherDetail) {
		return new TeacherDetailDao().save(teacherDetail);
	}

	public List<TeacherDetail> findAll() {
		return new TeacherDetailDao().findAll();
	}

	public TeacherDetail findById(String id) {
		return new TeacherDetailDao().findById(id);
	}

	public int delete(String id) {
		return new TeacherDetailDao().delete(id);
	}

	public int update(TeacherDetail teacherDetail) {
		return new TeacherDetailDao().update(teacherDetail);
	}

	public List<TeacherDetail> findByCondition(TeacherDetail teacherDetail) {
		return new TeacherDetailDao().findByCondition(teacherDetail);
	}

	public List<TeacherDetail> findByTypeId(int typeId) {
		return new TeacherDetailDao().findByTypeId(typeId);
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
	public List<TeacherDetail> findByPage(int pageNo, int pageSize) {
		return new TeacherDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new TeacherDetailDao().count();
	}
	/*
	 * public List<TeacherDetail> findByTypeIdAndPage(int typeId, int pageNo,
	 * int pageSize) {
	 * 
	 * // TODO Auto-generated method stub return new
	 * TeacherDetailDao().findByTypeIdAndPage(typeId, pageNo, pageSize);
	 * 
	 * }
	 */

}
