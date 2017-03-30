package com.hlg.service;

import java.util.List;

import com.hlg.dao.AccreditationDao;
import com.hlg.entity.Accreditation;

public class AccreditationService {
	public int save(Accreditation accreditation) {
		return new AccreditationDao().save(accreditation);
	}

	// 修改状态
	public void changeStatus(int id) {
		new AccreditationDao().changeStatus(id);
	}

	public List<Accreditation> findAll() {
		return new AccreditationDao().findAll();
	}

	public Accreditation findById(String id) {
		return new AccreditationDao().findById(id);
	}

	public int delete(String id) {
		return new AccreditationDao().delete(id);
	}

	public int update(Accreditation accreditation) {
		return new AccreditationDao().update(accreditation);
	}

	public List<Accreditation> findByCondition(Accreditation accreditation) {
		return new AccreditationDao().findByCondition(accreditation);
	}

	public List<Accreditation> findByTypeId(int typeId) {
		return new AccreditationDao().findByTypeId(typeId);
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
	public List<Accreditation> findByPage(int pageNo, int pageSize) {
		return new AccreditationDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new AccreditationDao().count();
	}

}
