package com.visa.prj.client;

@FunctionalInterface
interface Computation{
	int compute(int x,int y);
	//int cp(int x);
}
public class FunctionalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computation c1= new Computation() {
			
			@Override
			public int compute(int x, int y) {
				// TODO Auto-Computation c5 = (x,y) -> x*y;
				return x+y;
			}
		};
		doTask(c1,4,5);
		Computation c2= new Computation() {
			
			@Override
			public int compute(int x, int y) {
				// TODO Auto-generated method stub
				return x-y;
			}
		};
		doTask(c2,4,5);
		
		Computation c3 = (int x,int y) -> {return x*y;};
		doTask(c3, 2, 3);
		
		Computation c5 = (x,y) -> x*y;
		doTask(c5, 2, 3);
	}

	private static void doTask(Computation c1, int j, int k) {
		// TODO Auto-generated method stub
		System.out.println(c1.compute(j,k));
	}

}
