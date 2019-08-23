package com.visa.prj.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
//ticket_id | ticket_desc   | raised_date | raised_by (FK)   
//	| resolved_by (FK) | resolved_date| resolve_text
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ticket_id")
private int ticketId;
@Column(name = "ticket_desc")
private String ticketDesc;
@Column(name = "raised_date")
private Date raisedDate;
@ManyToOne
@JoinColumn(name = "raised_by")
private Employee raisedBy;

@ManyToOne
@JoinColumn(name = "resolved_by")
private Employee resolvedBy;
public int getTicketId() {
	return ticketId;
}
public void setTicketId(int ticketId) {
	this.ticketId = ticketId;
}
public String getTicketDesc() {
	return ticketDesc;
}
public void setTicketDesc(String ticketDesc) {
	this.ticketDesc = ticketDesc;
}
public Date getRaisedDate() {
	return raisedDate;
}
public void setRaisedDate(Date raisedDate) {
	this.raisedDate = raisedDate;
}
public Employee getRaisedBy() {
	return raisedBy;
}
public void setRaisedBy(Employee raisedBy) {
	this.raisedBy = raisedBy;
}
public Employee getResolvedBy() {
	return resolvedBy;
}
public void setResolvedBy(Employee resolvedBy) {
	this.resolvedBy = resolvedBy;
}
public Date getResolvedDate() {
	return resolvedDate;
}
public void setResolvedDate(Date date) {
	this.resolvedDate = date;
}
public String getResolveText() {
	return resolveText;
}
public void setResolveText(String resolveText) {
	this.resolveText = resolveText;
}
@Column(name = "resolved_date")
private Date resolvedDate;
@Column(name = "resolve_text")
private String resolveText;


}
