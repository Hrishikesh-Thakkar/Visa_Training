package com.visa.prj.client;

import com.visa.prj.entity.Account;

/**
 * This is a class to represent account business data.
 * It allows Payment transfer
 * @author root
 *
 */
public class AccountClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account first= new Account();
		Account second= new Account();
	
		first.deposit(600);
		second.deposit(800);
		System.out.println("First Account: "+first.getBalance());
		System.out.println("Second Account: "+second.getBalance());
		System.out.println("First Account: "+Account.getCount());
	
	}

}
