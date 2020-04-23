package com.wygl.sbwygl.bean;



public class Equip {

	// property constants
	private int id;
	private String name;//保修事项名称
	private String inName;//报修人
	private String tel;
	private String address;
	private String revalue;//是否修好
	private String mark;//情况说明
	private String beDate;//保修时间
	private String recode;//登记人
	
	public String getRecode() {
		return recode;
	}
	public void setRecode(String recode) {
		this.recode = recode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getInName() {
		return inName;
	}
	public void setInName(String inName) {
		this.inName = inName;
	}
	public String getBeDate() {
		return beDate;
	}
	public void setBeDate(String beDate) {
		this.beDate = beDate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRevalue() {
		return revalue;
	}
	public void setRevalue(String revalue) {
		this.revalue = revalue;
	}

	

}