package com.boco.xxzx.ksh.bean;

public class PersonNianLing {
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

	public PersonNianLing() {
		super();
	}

	public PersonNianLing(String name, Integer value) {
		super();
		this.value = value;
		this.name = name;
	}

}
