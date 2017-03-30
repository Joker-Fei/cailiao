package com.hlg.entity;

import java.util.Date;

public class SubjectDetail {

	public SubjectDetail() {
		super();
	}

	public SubjectDetail(String subName, String content, String author) {
		super();
		this.subName = subName;
		this.content = content;
		this.author = author;
		// this.typeId = typeId;
	}

	public SubjectDetail(String subName, String content, int userId,
			String web, Date publishTime) {
		super();
		this.subName = subName;
		this.content = content;
		this.userId = userId;
		// this.typeId = typeId;
		this.web = web;
		this.publishTime = publishTime;
	}

	public SubjectDetail(int id, String subName, String content, int userId,
			String web, Date publishTime) {
		super();
		this.id = id;
		this.subName = subName;
		this.content = content;
		this.userId = userId;
		// this.typeId = typeId;
		this.web = web;
		this.publishTime = publishTime;
	}

	public SubjectDetail(int id, String subName, String content, int userId,
			String author, String web, Date publishTime) {
		super();
		this.id = id;
		this.subName = subName;
		this.content = content;
		this.userId = userId;
		this.author = author;
		/*
		 * this.typeId = typeId; this.typeName = typeName;
		 */
		this.web = web;
		this.publishTime = publishTime;
	}

	public SubjectDetail(String subName, String content, int userId,
			Date publishTime, String web) {
		super();
		this.subName = subName;
		this.content = content;
		this.userId = userId;
		// this.typeId = typeId;
		this.publishTime = publishTime;
		this.web = web;
	}

	public SubjectDetail(int id, String subName, String content, int userId,
			String author, Date publishTime, String web) {
		super();
		this.id = id;
		this.subName = subName;
		this.content = content;
		this.userId = userId;
		this.author = author;
		// this.typeId = typeId;
		this.typeName = typeName;
		this.publishTime = publishTime;
		this.web = web;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/*
	 * public int getTypeId() { return typeId; }
	 * 
	 * public void setTypeId(int typeId) { this.typeId = typeId; }
	 */

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	private int id;
	private String subName;
	private String content;
	private int userId;
	// private int typeId;
	private String web;
	private Date publishTime;
	// 发布者名字
	private String author;
	// 新闻类型名称
	private String typeName;
}
