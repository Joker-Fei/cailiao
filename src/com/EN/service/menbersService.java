package com.EN.service;

import java.util.List;

import com.EN.dao.menbersDao;
import com.EN.entity.menbers;

public class menbersService {

	private menbersDao mbDao = new menbersDao();
	public void addmb(menbers mb){
		mbDao.add(mb);
	}
	public List<menbers> fundAll(){
		return mbDao.findAll();
	}
	public menbers fundsing(String id){
		return mbDao.find("id", id);
	}
	public void delete(String id){
		mbDao.delete(id);
	}
	public void modif(menbers mb){
		mbDao.modif(mb);
	}
	public menbers fundname(String name){
		menbers men = new menbers();
		List<menbers> lsmen=mbDao.findAll();
		for(menbers i:lsmen){
			if(i.getMbName().equals(name)){
				return i;
			}
		}
		return null;
	}
}
