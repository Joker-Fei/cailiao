package com.hlg.service;

import java.util.List;

import com.hlg.dao.UserDetailDao;
import com.hlg.entity.UserDetail;

public class UserDetailService {

	/**
	 * 用户注册功能
	 * 
	 * @param userDetail
	 *            用户对象
	 * @return 0：注册失败，1：注册成功
	 */
	public int register(UserDetail userDetail) {
		UserDetailDao userDetailDao = new UserDetailDao();
		int result = userDetailDao.save(userDetail);
		return result;
	}

	/**
	 * 根据Id删除用户对象
	 * 
	 * @param id
	 * @return
	 */
	public int delete(int id) {
		return new UserDetailDao().delete(id);
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
	public UserDetail login(String userName, String userPwd) {
		return new UserDetailDao().findByNameAndPwd(userName, userPwd);
	}

	/**
	 * 查询所有的用户
	 * 
	 * @return
	 */
	public List<UserDetail> findAll() {
		return new UserDetailDao().findAll();
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
	public List<UserDetail> findByPage(int pageNo, int pageSize) {
		return new UserDetailDao().findByPage(pageNo, pageSize);
	}

	// 统计表中的记录数
	public int count() {
		return new UserDetailDao().count();
	}

	/**
	 * 多条件查询
	 * 
	 * @param userDetail
	 * @return
	 */
	public List<UserDetail> search(UserDetail userDetail) {
		return new UserDetailDao().search(userDetail);
	}

	// 根据用户Id查找用户
	public UserDetail findById(int id) {
		return new UserDetailDao().findById(id);
	}

	public List<UserDetail> findAllByUserId(String id) {
		return new UserDetailDao().findAllByUserId(id);
	}

	public int findByUserName(String username) {
		return new UserDetailDao().findByUserName(username);
	}

	public int checkPwd(String id, String pwd) {
		// TODO Auto-generated method stub
		return new UserDetailDao().checkPwd(id, pwd);
	}

	public int changePwd(String id, String pwd) {
		// TODO Auto-generated method stub
		return new UserDetailDao().changePwd(id, pwd);
	}
}