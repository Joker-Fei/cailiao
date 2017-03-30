package com.EN.service;

import com.EN.dao.UserDao;
import com.EN.entity.User;
import com.EN.exception.UserExistException;


public class UserService{

	private UserDao userDao = new UserDao();
	public void registerUser(User user) throws UserExistException {
		// TODO Auto-generated method stub
		if (userDao.find(user.getUserName())!=null) {
			//checked exception 
			//unchecked exception
			//这里抛编译时异常的原因：是我想上一层程序处理这个异常，以给用户一个友好提示
			throw new UserExistException("注册的用户名已存在！！！");
		}
		userDao.add(user);
	}

	
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		return userDao.find(userName, userPwd);
	}
	public void modifUser(User u){
		userDao.modif(u);		
	}
	public User fund(String id){
		return userDao.find(id);
	}

}
