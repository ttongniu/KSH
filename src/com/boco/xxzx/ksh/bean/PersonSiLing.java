package com.boco.xxzx.ksh.bean;

public class PersonSiLing {
	private Integer value;
	private String name;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonSiLing() {
		super();
	}

	public PersonSiLing(String name, Integer value) {
		super();
		this.value = value;
		this.name = name;
	}

}
