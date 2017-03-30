package com.hlg.service;

import java.util.List;

import com.hlg.dao.UserTestCenterDao;
import com.hlg.entity.UserTestCenter;

public class UserTestCenterService {

	/**
	 * 用户注册功能
	 * 
	 * @param userTestCenter
	 *            用户对象
	 * @return 0：注册失败，1：注册成功
	 */
	public int register(UserTestCenter userTestCenter) {
		UserTestCenterDao userTestCenterDao = new UserTestCenterDao();
		int result = userTestCenterDao.save(userTestCenter);
		return result;
	}

	/**
	 * 根据Id删除用户对象
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		return new UserTestCenterDao().delete(id);
	}

	/**
	 * 用户登录
	 * 
	 * @param userName
	 *            用户名
	 * @param userPwd
	 *            密码
	 * @return 登陆成功，返回用户对象；登录失败，返回null
	 */
	public UserTestCenter login(String userName, String userPwd) {
		return new UserTestCenterDao().findByNameAndPwd(userName, userPwd);
	}

	/**
	 * 查询所有的用户
	 * 
	 * @return
	 */
	public List<UserTestCenter> findAll() {
		return new UserTestCenterDao().findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 *            当前第几页
	 * @param pageSize
	 *            每页大小
	 * @return
	 */
	public List<UserTestCenter> findByPage(int pageNo, int pageSize) {
		return new UserTestCenterDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new UserTestCenterDao().count();
	}

	/**
	 * 多条件查询
	 * 
	 * @param userTestCenter
	 * @return
	 */
	public List<UserTestCenter> search(UserTestCenter userTestCenter) {
		return new UserTestCenterDao().search(userTestCenter);
	}

	// 根据用户Id查找用户
	public UserTestCenter findById(int id) {
		return new UserTestCenterDao().findById(id);
	}

	public List<UserTestCenter> findAllByUserId(String id) {
		return new UserTestCenterDao().findAllByUserId(id);
	}

	public int findByUserName(String username) {
		return new UserTestCenterDao().findByUserName(username);
	}

	public int checkPwd(String id, String pwd) {
		// TODO Auto-generated method stub
		return new UserTestCenterDao().checkPwd(id, pwd);
	}

	public int changePwd(String id, String pwd) {
		// TODO Auto-generated method stub
		return new UserTestCenterDao().changePwd(id, pwd);
	}
}
