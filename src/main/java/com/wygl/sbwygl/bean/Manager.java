package com.wygl.sbwygl.bean;

import java.sql.Date;


public class Manager {

	// property constants
	private int id;
	private String name;
	private String persionNo;
	private String sex;
	private String jig;
	private String telephone;
	private String address;
	private Date date;
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getPersionNo() {
		return persionNo;
	}

	public void setPersionNo(String persionNo) {
		this.persionNo = persionNo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJig() {
		return jig;
	}

	public void setJig(String jig) {
		this.jig = jig;
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

}