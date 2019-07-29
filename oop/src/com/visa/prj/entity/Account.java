/**
 * 
 */
package com.visa.prj.entity;

/**
 * @author root
 *
 */ 
public class Account {
	private double balance; //State of object
	private static int count;
	public Account() 
	{
		count++;
	}
	/**
	 * method to credit amount into account
	 * @param amt is amount to be added
	 */
	public void deposit(double amt) {
		this.balance+=amt;
	}
	/**
	 * method to retrieve Balance
	 * @return the current balance
	 */
	public double getBalance() {
		return this.balance;
	}
	
	public static int getCount() {
		return count;
	}
}
