package com.visa.prj.entity;

public class Tv extends Product {
public String connectivity;

public Tv() {
	super();
	// TODO Auto-generated constructor stub
}

public Tv(int id, String name, double price, String connectivity) {
	super(id, name, price);
	// TODO Auto-generated constructor stub
}

public String getConnectivity() {
	return connectivity;
}

public void setConnectivity(String connectivity) {
	this.connectivity = connectivity;
}


}
