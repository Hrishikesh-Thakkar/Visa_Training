package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FruitClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> fruit = new HashMap<String, Integer>();
		addFruit(fruit,"mango");
		addFruit(fruit,"mango");
		addFruit(fruit,"mango");
		addFruit(fruit,"mango");
		addFruit(fruit,"mango");
		addFruit(fruit,"apple");
		addFruit(fruit,"apple");
		addFruit(fruit,"orange");
		addFruit(fruit,"orange");
		addFruit(fruit,"orange");
		addFruit(fruit,"orange");
		addFruit(fruit,"jackfruit");	
	//	addFruit(fruit,"jackfruit");
	}

	private static void addFruit(Map<String, Integer> fruit, String string) {
		// TODO Auto-generated method stub
        
       
        
		if(fruit.get(string)!=null)
		{
			int num = fruit.get(string);
			num++;
			fruit.put(string,num);
		}
		else
			fruit.put(string,1);
		 List<String> outputArray = new ArrayList<>();
	        for (String f : fruit.keySet()) {
				outputArray.add(f);
			}
        SortComparator comp = new SortComparator(fruit); 
        Collections.sort(outputArray, comp); 

        for (Iterator<String> iterator = outputArray.iterator(); iterator.hasNext();) {
			String string2 = (String) iterator.next();
			System.out.println(string2+" "+fruit.get(string2));
		}
        
		System.out.println();
	}
}
