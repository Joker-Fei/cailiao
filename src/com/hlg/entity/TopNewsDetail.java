package com.hlg.entity;

import java.util.Date;

public class TopNewsDetail {
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	private int id;
	private String title;
	private String imgUrl;
	private String content;
	private int userId;
	private Date publishTime;
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public TopNewsDetail(int id, String title, String imgUrl, String content,
			int userId, Date publishTime) {
		super();
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.userId = userId;
		this.publishTime = publishTime;
	}

	public TopNewsDetail(String title, String imgUrl, String content,
			int userId, Date publishTime) {
		super();

		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.userId = userId;
		this.publishTime = publishTime;
	}

	public TopNewsDetail(int id, String title, String imgUrl, String content,
			int userId, String author, Date publishTime) {
		super();

		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.userId = userId;
		this.author = author;
		this.publishTime = publishTime;
	}

	public TopNewsDetail(int id, String title, String imgUrl, String content,
			String author, Date publishTime) {
		super();

		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.content = content;
		this.author = author;
		this.publishTime = publishTime;
	}
}
