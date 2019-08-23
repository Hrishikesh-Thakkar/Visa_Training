package com.visa.prj.core;

import java.util.Comparator;
import java.util.Map;

public class SortComparator implements Comparator<String> {
	private final Map<String, Integer> m;
	public Map<String, Integer> getM() {
		return m;
	}


	public SortComparator(Map<String, Integer> fruit) {
		// TODO Auto-generated constructor stub
		this.m=fruit;
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		
		return m.get(o2)-m.get(o1);
	}

}
