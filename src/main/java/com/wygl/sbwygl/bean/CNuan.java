package com.wygl.sbwygl.bean;

import java.util.Date;

public class CNuan{
	private Integer id;	
	private String cases;
	private String telephone;
	private String address;	
	private Date changedate;
	private String userid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getChangedate() {
		return changedate;
	}
	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}
	public String getCases() {
		return cases;
	}
	public void setCases(String cases) {
		this.cases = cases;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
