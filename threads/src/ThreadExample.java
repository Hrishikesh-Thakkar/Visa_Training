
public class ThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Starts");
		NumberThread t1 = new NumberThread(1, 400);
		NumberThread t2 = new NumberThread(800, 1400);
		t1.start();
		t2.start();
		doTask();
		System.out.println("Main Dies");

	}

	private static void doTask() {
		// TODO Auto-generated method stub
		Thread t= Thread.currentThread();
		System.out.println(t.getName());
		System.out.println(t.getThreadGroup().getName());
		System.out.println(t.getPriority());
		System.out.println(t.isDaemon());
		/*
		 * JRE keeps checking status of non daemon threads
		 */
	}

}
