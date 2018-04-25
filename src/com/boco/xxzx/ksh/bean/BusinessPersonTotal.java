package com.boco.xxzx.ksh.bean;

public class BusinessPersonTotal {
	private String code;
	private String name;
	private Integer total_person;
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
	public Integer getTotal_person() {
		return total_person;
	}
	public void setTotal_person(Integer total_person) {
		this.total_person = total_person;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public BusinessPersonTotal() {
		super();
	}
	public BusinessPersonTotal(String code, String name, Integer total_person, Integer month) {
		super();
		this.code = code;
		this.name = name;
		this.total_person = total_person;
		this.month = month;
	}
	
}
