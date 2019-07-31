package com.visa.prj.entity;

public class Time {
	private int hrs;
	private int min;
	public Time() {
		this.hrs=0;
		this.min=0;
	}
	public Time(int i, int j) {
		// TODO Auto-generated constructor stub
		this.min=j;
		this.hrs=i;
	}
	public Time addTime(Time b) {
		Time c=new Time(0,0);
		Time a=new Time(this.hrs,this.min);
		c.setHrs(a.getHrs()+b.getHrs());
		c.setMin(a.getMin()+b.getMin());
		
		if(c.getMin()>=60) {
			c.setMin(c.getMin()-60);
			c.setHrs(c.getHrs()+1);
		}
		return c;
		
	}
	public static Time addTime(Time a, Time b) {
		Time c=new Time(0,0);
		c.setHrs(a.getHrs()+b.getHrs());
		c.setMin(a.getMin()+b.getMin());
		
		if(c.getMin()>=60) {
			c.setMin(c.getMin()-60);
			c.setHrs(c.getHrs()+1);
		}
		return c;
		
	}
	public int getHrs() {
		return hrs;
	}
	public void setHrs(int hrs) {
		this.hrs = hrs;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	
}
