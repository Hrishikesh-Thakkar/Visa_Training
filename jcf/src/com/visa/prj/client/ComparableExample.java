package com.visa.prj.client;

import java.util.Arrays;

public class ComparableExample {
	
	public static void main(String[] args) {
		String[] names= {"Vighnesh","Pishi","Dhruv"};
		//Arrays.sort(names);
		Arrays.sort(names,(s1,s2) -> s1.length()-s2.length());
		
		for (String string : names) {
			System.out.println(string);
		}
	}
}
