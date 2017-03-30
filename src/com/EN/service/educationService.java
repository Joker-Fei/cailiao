package com.EN.service;

import com.EN.dao.educationDao;
import com.EN.entity.education;

public class educationService {
	private educationDao eduDao = new educationDao();
	public void modifEducation(education edu){
		if(eduDao.find("id", edu.getId())!=null){
			eduDao.modif(edu);
		}else{
			eduDao.add(edu);
		}
	}
	public education fundEducation(String type, String id){
		return eduDao.find(type, id);
	}
}
