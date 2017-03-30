package com.EN.service;

import com.EN.dao.contactusDao;
import com.EN.entity.contactus;

public class contactusService {
	private contactusDao conDao = new contactusDao();
	public void modifContactus(contactus con){
		if(conDao.find("id", con.getId())!=null){
			conDao.modif(con);
		}else{
			conDao.add(con);
		}
	}
	public contactus fundContactus(String type, String id){
		return conDao.find(type, id);
	}
}
