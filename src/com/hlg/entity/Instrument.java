package com.hlg.entity;

import java.util.Date;

public class Instrument {

	private int id;
	private int typeId; // 产品型号
	private String content; // 仪器介绍
	private String factory; // 生产厂家
	private String mainAccessories; // 主要附件
	private String tecParame; // 技术参数
	private String tecFeatures; // 技术特点
	private String appliRange; // 应用范围
	private Date publishTime; // 编辑时间
	private int userId;
	// 发布者名字
	private String author;
	private String typeName;// 仪器型号名称

	public Instrument(int id, int typeId, String content, String factory,
			String mainAccessories, String tecParame, String tecFeatures,
			String appliRange, java.sql.Date publishTime, String typeName,
			int userId, String author) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.typeId = typeId;
		this.content = content;
		this.factory = factory;
		this.mainAccessories = mainAccessories;
		this.tecParame = tecParame;
		this.tecFeatures = tecFeatures;
		this.appliRange = appliRange;
		this.publishTime = publishTime;
		this.typeName = typeName;
		this.userId = userId;
		this.author = author;

	}

	public Instrument(String content, int typeId, String author) {
		// TODO Auto-generated constructor stub
		super();

		this.typeId = typeId;
		this.content = content;
		this.author = author;
	}

	public Instrument(int id, int typeId, String content, String factory,
			String mainAccessories, String tecParame, String tecFeatures,
			String appliRange, Date publishTime, int userId) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.typeId = typeId;
		this.content = content;
		this.factory = factory;
		this.mainAccessories = mainAccessories;
		this.tecParame = tecParame;
		this.tecFeatures = tecFeatures;
		this.appliRange = appliRange;
		this.publishTime = publishTime;
		this.userId = userId;
	}

	public Instrument(int typeId, String content, String factory,
			String mainAccessories, String tecParame, String tecFeatures,
			String appliRange, Date publishTime, int userId) {
		// TODO Auto-generated constructor stub
		super();

		this.typeId = typeId;
		this.content = content;
		this.factory = factory;
		this.mainAccessories = mainAccessories;
		this.tecParame = tecParame;
		this.tecFeatures = tecFeatures;
		this.appliRange = appliRange;
		this.publishTime = publishTime;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getMainAccessories() {
		return mainAccessories;
	}

	public void setMainAccessories(String mainAccessories) {
		this.mainAccessories = mainAccessories;
	}

	public String getTecParame() {
		return tecParame;
	}

	public void setTecParame(String tecParame) {
		this.tecParame = tecParame;
	}

	public String getTecFeatures() {
		return tecFeatures;
	}

	public void setTecFeatures(String tecFeatures) {
		this.tecFeatures = tecFeatures;
	}

	public String getAppliRange() {
		return appliRange;
	}

	public void setAppliRange(String appliRange) {
		this.appliRange = appliRange;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
