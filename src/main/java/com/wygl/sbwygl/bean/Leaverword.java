package com.wygl.sbwygl.bean;

import java.util.Date;

public class Leaverword {
	private Integer id;
	private String mark;
	private String leaverName;
	private String time;
	private String title;
	private String userId;
	private String type;
	private String answerContent;
	private String reDate;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getLeaverName() {
		return leaverName;
	}
	public void setLeaverName(String leaverName) {
		this.leaverName = leaverName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReDate() {
		return reDate;
	}

	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
}
