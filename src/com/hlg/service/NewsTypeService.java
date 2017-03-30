package com.hlg.service;

import java.util.List;

import com.hlg.dao.NewsTypeDao;
import com.hlg.entity.NewsType;

public class NewsTypeService {

	public int save(NewsType newsType) {

		return new NewsTypeDao().save(newsType);
	}

	public List<NewsType> findAll() {
		return new NewsTypeDao().findAll();
	}

	public int delete(int id) {
		return new NewsTypeDao().delete(id);
	}
}
