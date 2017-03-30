package com.hlg.entity;

import java.util.Date;

public class TeacherDetail {
	public TeacherDetail() {
		super();
	}

	public TeacherDetail(String teacherName, String content, int userId,
			int typeId, Date publishTime) {
		super();
		this.teacherName = teacherName;
		this.content = content;
		this.userId = userId;
		this.typeId = typeId;
		this.publishTime = publishTime;
	}

	public TeacherDetail(int id, String teacherName, String content,
			int userId, int typeId, Date publishTime) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.content = content;
		this.userId = userId;
		this.typeId = typeId;
		this.publishTime = publishTime;
	}

	public TeacherDetail(String teacherName, String content, String author,
			int typeId) {
		super();
		this.teacherName = teacherName;
		this.content = content;
		this.author = author;
		this.typeId = typeId;
	}

	public TeacherDetail(int id, String teacherName, String content,
			int userId, String author, int typeId, String typeName,
			Date publishTime) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.content = content;
		this.author = author;
		this.typeId = typeId;
		this.typeName = typeName;
		this.publishTime = publishTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	private int id;
	private String teacherName;
	private String content;
	private int userId;
	private int typeId;
	private Date publishTime;

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

	private String author;
	private String typeName;
}
