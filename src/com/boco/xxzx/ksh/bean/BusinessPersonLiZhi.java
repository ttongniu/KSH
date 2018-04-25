package com.boco.xxzx.ksh.bean;

public class BusinessPersonLiZhi {
	private String code;
	private String name;
	private Integer lz_person;
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
	public Integer getLz_person() {
		return lz_person;
	}
	public void setLz_person(Integer lz_person) {
		this.lz_person = lz_person;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public BusinessPersonLiZhi() {
		super();
	}
	public BusinessPersonLiZhi(String code, String name, Integer lz_person, Integer month) {
		super();
		this.code = code;
		this.name = name;
		this.lz_person = lz_person;
		this.month = month;
	}
	
}
