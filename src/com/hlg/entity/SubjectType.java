package com.hlg.entity;

public class SubjectType {
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;

	public SubjectType() {
		super();
	}

	public SubjectType(String typeName) {
		super();
		this.typeName = typeName;
	}

	public SubjectType(int id, String typeName) {
		super();
		this.typeName = typeName;
		this.id = id;
	}
}
