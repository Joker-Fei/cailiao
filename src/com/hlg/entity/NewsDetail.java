package com.hlg.entity;

import java.util.Date;

public class NewsDetail {
	public NewsDetail() {
		super();
	}

	// servlet层
	public NewsDetail(int id, String title, String content, int userId,
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

	/*
	 * // 处理学院概况的信息添加
	 * 
	 * public NewsDetail(String title, String content, int userId, int typeId,
	 * Date publishTime, int pass) { super(); this.title = title; this.content =
	 * content; this.userId = userId; this.typeId = typeId; this.publishTime =
	 * publishTime; this.pass = pass; }
	 */

	// DAO层查找的通用方法
	public NewsDetail(int id, String title, String content, int userId,
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

	// servlet层
	public NewsDetail(String title, String content, int userId, int typeId,
			Date publishTime, int pass) {
		super();
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.typeId = typeId;
		this.publishTime = publishTime;
		this.pass = pass;
	}

	// 多条件信息查询
	public NewsDetail(String title, String content, String author, int typeId) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.typeId = typeId;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	private String title;
	private String content;
	private int userId;
	private int typeId;
	private Date publishTime;
	private int pass;
	// 发布者名字
	private String author;
	// 新闻类型名称
	private String typeName;

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

}
