package com.prj.visa.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.visa.prj.entity.Time;

public class TimeTest {

	@Test
	public void testAddTimeTime() {
		//assertEquals(expected, actual);
		Time a=new Time(10,0);
		Time b=new Time (2,15);
		Time expected= new Time(12,15);
		assertEquals(expected.getHrs(),a.addTime(b).getHrs());
		assertEquals(expected.getMin(),a.addTime(b).getMin());
	}

	@Test
	public void testAddTimeTimeTime() {
		Time a=new Time(10,0);
		Time b=new Time (2,15);
		Time expected= new Time(12,15);
		//System.out.println(expected.getHrs()+" "+expected.getMin());
		assertEquals(expected.getHrs(),Time.addTime(a, b).getHrs());
		assertEquals(expected.getMin(),Time.addTime(a, b).getMin());

	}

}
