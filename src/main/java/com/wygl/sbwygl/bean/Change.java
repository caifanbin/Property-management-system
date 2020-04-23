package com.wygl.sbwygl.bean;

import java.util.Date;

public class Change{
	private Integer id;	
	private String dNo;
	private String zName;
	private String type;	 
	private String cases;
	private String changeName;
	private String remark;
	private String waterCase;
	private String eCase;
	private String gascase;
	private String stopCase;
	private String mandCase;
	private String changedate;
	private String userid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getdNo() {
		return dNo;
	}

	public void setdNo(String dNo) {
		this.dNo = dNo;
	}

	public String getzName() {
		return zName;
	}

	public void setzName(String zName) {
		this.zName = zName;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCases() {
		return cases;
	}
	public void setCases(String cases) {
		this.cases = cases;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getWaterCase() {
		return waterCase;
	}
	public void setWaterCase(String waterCase) {
		this.waterCase = waterCase;
	}

	public String geteCase() {
		return eCase;
	}

	public void seteCase(String eCase) {
		this.eCase = eCase;
	}

	public String getGascase() {
		return gascase;
	}
	public void setGascase(String gascase) {
		this.gascase = gascase;
	}
	public String getStopCase() {
		return stopCase;
	}
	public void setStopCase(String stopCase) {
		this.stopCase = stopCase;
	}
	public String getMandCase() {
		return mandCase;
	}
	public void setMandCase(String mandCase) {
		this.mandCase = mandCase;
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

	@Override
	public String toString() {
		return "Change{" +
				"id=" + id +
				", dNo='" + dNo + '\'' +
				", zName='" + zName + '\'' +
				", type='" + type + '\'' +
				", cases='" + cases + '\'' +
				", changeName='" + changeName + '\'' +
				", remark='" + remark + '\'' +
				", waterCase='" + waterCase + '\'' +
				", eCase='" + eCase + '\'' +
				", gascase='" + gascase + '\'' +
				", stopCase='" + stopCase + '\'' +
				", mandCase='" + mandCase + '\'' +
				", changedate='" + changedate + '\'' +
				", userid='" + userid + '\'' +
				'}';
	}
}
