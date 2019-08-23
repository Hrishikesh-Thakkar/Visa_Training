package com.visa.prj.entity;

import java.util.Date;

public class Report {

	private int id;
	String desc;
	Employee resolvedBy;
	Date time;
	Date startDate;
	Date endDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Employee getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
