package com.EN.service;

import com.EN.dao.introductionDao;
import com.EN.entity.introduction;

public class introductionService {
	private introductionDao intrDao = new introductionDao();
	public void addIntr(introduction intr){
		intrDao.add(intr);
	}
	public void deleteIntr(String id){
		intrDao.delete(id);
	}
	public void modifIntr(introduction intr){
		intrDao.modif(intr);
	}
	public introduction findIntr(String type,String id){
		return intrDao.find(type, id);
	}
	
	
}
