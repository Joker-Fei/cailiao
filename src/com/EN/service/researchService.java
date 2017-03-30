package com.EN.service;

import com.EN.dao.researchDao;
import com.EN.entity.research;

public class researchService {
	private researchDao resDao= new researchDao();
	public void modifResearch(research res){
		if(resDao.find("id", res.getId())!=null){
			resDao.modif(res);
		}else{
			resDao.add(res);
		}
	}
	public research fundResearch(String type, String id){
		return resDao.find(type, id);
	}
}
