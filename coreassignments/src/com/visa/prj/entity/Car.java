package com.visa.prj.entity;

public class Car {
	String license;
	String location;
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLicense() {
		return license;
	}

	public Car(String license,String location) {
		super();
		this.license = license;
		this.location = location;
	}

	public void setLicense(String license) {
		this.license = license;
	}
}
