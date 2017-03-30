package com.hlg.entity;

public class InstrumentType {

	public InstrumentType() {
		super();
	}

	public InstrumentType(String typeName) {
		super();
		this.typeName = typeName;
	}

	public InstrumentType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

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

	private int id;
	private String typeName;
}
