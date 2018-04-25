package com.boco.xxzx.ksh.bean;

public class DepartmentPersonYSSJ {
	private String code;
	private String name;
	private Integer ys_person;
	private Integer sj_person;
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
	public Integer getYs_person() {
		return ys_person;
	}
	public void setYs_person(Integer ys_person) {
		this.ys_person = ys_person;
	}
	public Integer getSj_person() {
		return sj_person;
	}
	public void setSj_person(Integer sj_person) {
		this.sj_person = sj_person;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public DepartmentPersonYSSJ() {
		super();
	}
	public DepartmentPersonYSSJ(String code, String name, Integer ys_person, Integer sj_person, String year) {
		super();
		this.code = code;
		this.name = name;
		this.ys_person = ys_person;
		this.sj_person = sj_person;
		this.year = year;
	}
	
}
