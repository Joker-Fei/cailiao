package com.hlg.entity;

public class CoorperationType {
	public CoorperationType() {
		super();
	}

	public CoorperationType(String typeName) {
		super();
		this.typeName = typeName;
	}

	public CoorperationType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	private String typeName;

}
