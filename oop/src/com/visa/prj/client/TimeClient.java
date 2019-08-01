package com.visa.prj.client;

import com.visa.prj.entity.Time;

public class TimeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time t1=new Time(10,0);
		Time t2=new Time(2,15);
		Time t3=Time.addTime(t1,t2);
		System.out.println(t3.getHrs()+":"+t3.getMin());
		Time t4=t1.addTime(t2);
		System.out.println(t4.getHrs()+":"+t4.getMin());
	}

}
