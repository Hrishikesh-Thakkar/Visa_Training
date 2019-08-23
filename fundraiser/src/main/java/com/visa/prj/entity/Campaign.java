package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="campaigns")

public class Campaign {

	public Campaign() {
		// TODO Auto-generated constructor stub
	}
@Id
String title;
String description;
String image;
@JsonFormat(pattern="dd-MM-yyyy")
Date deadline;
double amount;
String terms;
String status;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Date getDeadline() {
	return deadline;
}
public void setDeadline(Date deadline) {
	this.deadline = deadline;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getTerms() {
	return terms;
}
public void setTerms(String terms) {
	this.terms = terms;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
