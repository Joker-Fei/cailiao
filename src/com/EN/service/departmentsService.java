package com.EN.service;

import java.util.List;

import com.EN.dao.departmentsDao;
import com.EN.entity.departments;

public class departmentsService {
	private departmentsDao dmDao = new departmentsDao();
	
	public void addDM(departments dm){	
		dmDao.add(dm);
	}
	
	public void delDM(String id){
		dmDao.delete(id);
	}
	
	public departments findDM(String type, String dmName){
		return dmDao.find(type,dmName);
	}
	
	public List<departments> findAll(){
		
		return dmDao.findAll();
	}
	
	public void modifDM(departments dm){
		dmDao.modif(dm);
	}
	
}
