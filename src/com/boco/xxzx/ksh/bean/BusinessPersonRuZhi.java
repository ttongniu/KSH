package com.boco.xxzx.ksh.bean;

public class BusinessPersonRuZhi {
	private String code;
	private String name;
	private Integer rz_person;
	private Integer month;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRz_person() {
		return rz_person;
	}
	public void setRz_person(Integer rz_person) {
		this.rz_person = rz_person;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public BusinessPersonRuZhi() {
		super();
	}
	public BusinessPersonRuZhi(String code, String name, Integer rz_person, Integer month) {
		super();
		this.code = code;
		this.name = name;
		this.rz_person = rz_person;
		this.month = month;
	}
	
}
