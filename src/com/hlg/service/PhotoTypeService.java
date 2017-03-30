package com.hlg.service;

import java.util.List;

import com.hlg.dao.PhotoTypeDao;
import com.hlg.entity.PhotoType;

public class PhotoTypeService {

	public int save(PhotoType photoType) {

		return new PhotoTypeDao().save(photoType);
	}

	public List<PhotoType> findAll() {
		return new PhotoTypeDao().findAll();
	}

	public int delete(int id) {
		return new PhotoTypeDao().delete(id);
	}
}
