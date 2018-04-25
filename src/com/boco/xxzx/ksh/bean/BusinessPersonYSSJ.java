package com.boco.xxzx.ksh.bean;

public class BusinessPersonYSSJ {
	private String code;
	private String name;
	private Integer ys_Person;
	private Integer sj_Person;
	private String year;
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
	
	public Integer getYs_Person() {
		return ys_Person;
	}
	public void setYs_Person(Integer ys_Person) {
		this.ys_Person = ys_Person;
	}
	public Integer getSj_Person() {
		return sj_Person;
	}
	public void setSj_Person(Integer sj_Person) {
		this.sj_Person = sj_Person;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public BusinessPersonYSSJ() {
		super();
	}
	public BusinessPersonYSSJ(String code, String name, Integer ys_Person, Integer sj_Person, String year) {
		super();
		this.code = code;
		this.name = name;
		this.ys_Person = ys_Person;
		this.sj_Person = sj_Person;
		this.year = year;
	}
	
}
