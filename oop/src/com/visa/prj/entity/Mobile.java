package com.visa.prj.entity;

public class Mobile extends Product {
	public String connectivity;
	
	public Mobile() {
	}

	public Mobile(int id, String name, double price, String connectivity) {
		super(id, name, price);
		this.connectivity = connectivity;
	}

	@Override
	public boolean isExpensive() {
		// TODO Auto-generated method stub
		if("3G".equalsIgnoreCase(connectivity)&&getPrice()>5000)
			return true;
		else if("4G".equalsIgnoreCase(connectivity) && getPrice()>15000)
			return true;
		
		return false;
	}

	public Mobile(String connectivity) {
		this.connectivity = connectivity;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

}
