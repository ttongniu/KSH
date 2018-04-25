package com.boco.xxzx.ksh.bean;

public class IndustryProject {
	private String code;
	private String name;
	private Integer num;
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public IndustryProject() {
		super();
	}
	public IndustryProject(String code, String name, Integer num) {
		super();
		this.code = code;
		this.name = name;
		this.num = num;
	}
	
}
