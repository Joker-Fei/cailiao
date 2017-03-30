package com.hlg.service;

import java.util.List;

import com.hlg.dao.CoorperationDetailDao;
import com.hlg.entity.CoorperationDetail;

public class CoorperationDetailService {
	public int save(CoorperationDetail coorperationDetail) {
		return new CoorperationDetailDao().save(coorperationDetail);
	}

	// 修改状态
	public void changeStatus(int id) {
		new CoorperationDetailDao().changeStatus(id);
	}

	public List<CoorperationDetail> findAll() {
		return new CoorperationDetailDao().findAll();
	}

	public CoorperationDetail findById(String id) {
		return new CoorperationDetailDao().findById(id);
	}

	public int delete(String id) {
		return new CoorperationDetailDao().delete(id);
	}

	public int update(CoorperationDetail coorperationDetail) {
		return new CoorperationDetailDao().update(coorperationDetail);
	}

	public List<CoorperationDetail> findByCondition(
			CoorperationDetail coorperationDetail) {
		return new CoorperationDetailDao().findByCondition(coorperationDetail);
	}

	public List<CoorperationDetail> findByTypeId(int typeId) {
		return new CoorperationDetailDao().findByTypeId(typeId);
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
	public List<CoorperationDetail> findByPage(int pageNo, int pageSize) {
		return new CoorperationDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new CoorperationDetailDao().count();
	}

	public List<CoorperationDetail> findByTypeIdAndPage(int typeId, int pageNo,
			int pageSize) {
		// TODO Auto-generated method stub
		return new CoorperationDetailDao().findByTypeIdAndPage(typeId, pageNo,
				pageSize);
	}

}
