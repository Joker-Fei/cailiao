package com.hlg.service;

import java.util.List;

import com.hlg.dao.StudentDetailDao;
import com.hlg.entity.StudentDetail;

public class StudentDetailService {

	/**
	 * 用户注册功能
	 * 
	 * @param studentDetail
	 *            用户对象
	 * @return 0：注册失败，1：注册成功
	 */
	public int register(StudentDetail studentDetail) {
		StudentDetailDao studentDetailDao = new StudentDetailDao();
		int result = studentDetailDao.save(studentDetail);
		return result;
	}

	/**
	 * 根据Id删除用户对象
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		return new StudentDetailDao().delete(id);
	}

	/**
	 * 查询所有的用户
	 * 
	 * @return
	 */
	public List<StudentDetail> findAll() {
		return new StudentDetailDao().findAll();
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
	public List<StudentDetail> findByPage(int pageNo, int pageSize) {
		return new StudentDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new StudentDetailDao().count();
	}

	/**
	 * 多条件查询
	 * 
	 * @param studentDetail
	 * @return
	 */
	public List<StudentDetail> search(StudentDetail studentDetail) {
		return new StudentDetailDao().search(studentDetail);
	}

	// 根据用户Id查找用户
	public StudentDetail findById(int id) {
		return new StudentDetailDao().findById(id);
	}

	public List<StudentDetail> findAllByUserId(String id) {
		return new StudentDetailDao().findAllByUserId(id);
	}

	public int findByNum(String num) {
		return new StudentDetailDao().findByNum(num);
	}

}