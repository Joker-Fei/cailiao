package com.hlg.service;

import java.util.List;

import com.hlg.dao.InstrumentDao;
import com.hlg.entity.Instrument;

public class InstrumentService {
	public int save(Instrument instrument) {
		return new InstrumentDao().save(instrument);
	}

	public List<Instrument> findAll() {
		return new InstrumentDao().findAll();
	}

	public Instrument findById(String id) {
		return new InstrumentDao().findById(id);
	}

	public int delete(String id) {
		return new InstrumentDao().delete(id);
	}

	public int update(Instrument instrument) {
		return new InstrumentDao().update(instrument);
	}

	public List<Instrument> findByCondition(Instrument instrument) {
		return new InstrumentDao().findByCondition(instrument);
	}

	public List<Instrument> findByTypeId(int typeId) {
		return new InstrumentDao().findByTypeId(typeId);
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
	public List<Instrument> findByPage(int pageNo, int pageSize) {
		return new InstrumentDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new InstrumentDao().count();
	}

}
