package com.hlg.entity;

public class UserDetail {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private int id;
	private String userName;
	private String userPwd;
	private String phone;
	private int status;// 身份

	// 构造方法
	public UserDetail() {
		super();
	}

	public UserDetail(int id, String userName, String userPwd, String phone,
			int status) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
		this.status = status;
	}

	public UserDetail(String userName, String phone, int status) {
		super();
		this.userName = userName;
		this.phone = phone;
		this.status = status;
	}

	public UserDetail(String userName, String userPwd, String phone, int status) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
		this.status = status;
	}

}
