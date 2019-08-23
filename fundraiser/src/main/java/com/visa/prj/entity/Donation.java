package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="donations")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dId;
	
	private String user;
	
	@ManyToOne
	@JoinColumn(name="campaign")
	private Campaign campaign;
	
	String name;
	String phone;
	double amount;
	String method;
	String cardNo;
	@JsonFormat(pattern="dd-MM-yyyy")
	Date cardExp;
	int cardCode;
	int status;
	public Donation() {
		
	}
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Campaign getCampaign() {
		return campaign;
	}
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getCardExp() {
		return cardExp;
	}
	public void setCardExp(Date cardExp) {
		this.cardExp = cardExp;
	}
	public int getCardCode() {
		return cardCode;
	}
	public void setCardCode(int cardCode) {
		this.cardCode = cardCode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
