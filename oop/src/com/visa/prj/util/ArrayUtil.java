package com.visa.prj.util;

import java.util.Arrays;

public class ArrayUtil {
	public static int getSum(int[] elems) {
		int sum=0;
		for (int i : elems) {
			sum+=i;
		}
		return sum;
	}
	public static void sort(int[] elems) {
		Arrays.sort(elems);
	}
	public static int getCount(int[] elems,int x) {
		int counts=0;
		for (int i : elems) {
			if(i==x)
				counts++;
		}
		return counts;
	}
}
