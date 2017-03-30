package com.hlg.entity;

import java.util.Date;

public class CoorperationDetail {
	private String title;

	// DAO层的调用
	public CoorperationDetail(int id, String title, String content, int userId,
			String author, int typeId, String typeName, Date publishTime,
			int pass) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.author = author;
		this.typeId = typeId;
		this.typeName = typeName;
		this.publishTime = publishTime;
		this.pass = pass;
	}

	public CoorperationDetail(int id, String title, String content, int userId,
			int typeId, Date publishTime, int pass) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.typeId = typeId;
		this.publishTime = publishTime;
		this.pass = pass;
	}

	public CoorperationDetail(String title, String content, int userId,
			int typeId, Date publishTime, int pass) {
		super();
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.typeId = typeId;
		this.publishTime = publishTime;
		this.pass = pass;
	}

	public CoorperationDetail(String title, String content, String author,
			int typeId) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.typeId = typeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String content;
	private int userId;
	private int typeId;
	private Date publishTime;
	private int pass;
	// 发布者名字
	private String author;
	// 新闻类型名称
	private String typeName;
}
