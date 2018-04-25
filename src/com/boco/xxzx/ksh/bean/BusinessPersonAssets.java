package com.boco.xxzx.ksh.bean;

public class BusinessPersonAssets {
	private String name;
	private Integer num;
	private Integer asset;
	
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
	public Integer getAsset() {
		return asset;
	}
	public void setAsset(Integer asset) {
		this.asset = asset;
	}
	
	public BusinessPersonAssets() {
		super();
	}
	public BusinessPersonAssets(String name, Integer num, Integer asset) {
		super();
		this.name = name;
		this.num = num;
		this.asset = asset;
	}
	
}
