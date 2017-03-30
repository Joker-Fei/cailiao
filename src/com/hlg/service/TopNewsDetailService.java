package com.hlg.service;

import java.util.List;

import com.hlg.dao.TopNewsDetailDao;
import com.hlg.entity.TopNewsDetail;

public class TopNewsDetailService {

	public int save(TopNewsDetail topNsewsDetail) {
		return new TopNewsDetailDao().save(topNsewsDetail);
	}

	public List<TopNewsDetail> findAll() {
		return new TopNewsDetailDao().findAll();
	}

	public TopNewsDetail findById(String id) {
		return new TopNewsDetailDao().findById(id);
	}

	public int delete(String id) {
		return new TopNewsDetailDao().delete(id);
	}

}
