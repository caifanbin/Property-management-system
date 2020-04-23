package com.wygl.sbwygl.bean;

import java.util.Date;


public class Resident {

	// property constants
	private int id;
	private String username;
	private String password;
	private String persionNo;
	private String sex;
	private String jig;
	private String telephone;
	private String address;
	private String date;
	private String type;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Resident{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", persionNo='" + persionNo + '\'' +
				", sex='" + sex + '\'' +
				", jig='" + jig + '\'' +
				", telephone='" + telephone + '\'' +
				", address='" + address + '\'' +
				", date='" + date + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}