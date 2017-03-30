package com.hlg.entity;

public class StudentDetail {

	public StudentDetail() {
		super();
	}

	public StudentDetail(String num, String stuname, String address,
			String phone, String qq, String weixin) {
		super();
		this.num = num;
		this.stuname = stuname;
		this.address = address;
		this.phone = phone;
		this.qq = qq;
		this.weixin = weixin;

	}

	public StudentDetail(int id, String num, String stuname, String address,
			String phone, String qq, String weixin) {
		super();
		this.id = id;
		this.num = num;
		this.stuname = stuname;
		this.address = address;
		this.phone = phone;
		this.qq = qq;
		this.weixin = weixin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSutname() {
		return stuname;
	}

	public void setSutname(String stuname) {
		this.stuname = stuname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	private int id;
	private String num;
	private String stuname;
	private String address;
	private String phone;
	private String qq;
	private String weixin;
}
