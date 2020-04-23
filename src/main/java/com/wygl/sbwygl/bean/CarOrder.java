package com.wygl.sbwygl.bean;

import java.util.Date;

public class CarOrder {
	private Integer id;
	private String state;
	private String telephone;
	private String address;
	private String changedate;
	private String userid;
	private String persionNo;
	private String carAddress;
	private String carimage;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCarimage() {
		return carimage;
	}

	public void setCarimage(String carimage) {
		this.carimage = carimage;
	}

	public String getCarAddress() {
		return carAddress;
	}
	public void setCarAddress(String carAddress) {
		this.carAddress = carAddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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

	public String getChangedate() {
		return changedate;
	}

	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPersionNo() {
		return persionNo;
	}
	public void setPersionNo(String persionNo) {
		this.persionNo = persionNo;
	}

}
