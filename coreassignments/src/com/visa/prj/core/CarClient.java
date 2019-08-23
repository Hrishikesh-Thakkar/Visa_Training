package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.visa.prj.entity.Car;

public class CarClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("KA-51-A-9",null));
		cars.add(new Car("KA-51-L-41",null));
		cars.add(new Car("KA-57-DE-111",null));
		cars.add(new Car("KA-04-500",null));
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("KA-01","Koramangala");
		m.put("KA-02","Rajajinagar");
		m.put("KA-03","Indiranagar");
		m.put("KA-04","Yeswanthpur");
		m.put("KA-05","Jayanagar");
		m.put("KA-50","Yelahanka");
		m.put("KA-51","Electronic City");
		m.put("KA-52","Nelamangala");
		m.put("KA-53","KR Puram");
		m.put("KA-54","Nagamangala");
		m.put("KA-55","Mysore East");
		m.put("KA-56","Basavakalyan");
		m.put("KA-57","Shantinagar");

		for (Car car : cars) {
			String key = car.getLicense().substring(0,5);
			car.setLocation(m.get(key));
		}
	Collections.sort(cars, new Comparator<Object>() {
		public int compare(Object a, Object b) {
			String x1 = ((Car)a).getLocation();
			String x2 = ((Car)b).getLocation();
			if(x1.compareTo(x2)!=0) {
				return 1;
			}
			String x3= ((Car)a).getLicense();
			String x4 = ((Car)b).getLicense();
			
			return x3.compareTo(x4);
		}
});
	for (Iterator<Car> iterator = cars.iterator(); iterator.hasNext();) {
		Car car = (Car) iterator.next();
		System.out.println(car.getLicense());
	}
	}
}
