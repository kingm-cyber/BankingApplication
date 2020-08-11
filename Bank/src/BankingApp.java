/*
 * Purpose: Allow users to create a bank account and perform transactions
 * Made By: Matthew King
 * Made on: 8/10/2020
 */

import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {

		// creates a BankAccount object and try selecting options

	}

}

class BankAccount {

	private int balance;
	private int previousTransaction;
	private String userId;
	private String username;

	// creates a no-arg constructor
	public BankAccount() {
		this.balance = 0;
		this.previousTransaction = 0;
		this.userId = "0000";
		this.username = "default";
	}

	// creates a constructor
	public BankAccount(String theUserId, String theUsername) {
		this.userId = theUserId;
		this.username = theUsername;
	}

	// setter/getter methods for variables
	public int getBalance() {
		return balance;
	}

	public void setBalance(int n) {
		balance = n;
	}
	
	//////////////////////////////////////////////////////////////
	//if previous transaction is messing up, use the variable instead of the getter method inside of the printPrevT method
	public void printPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + getPreviousTransaction());
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(getPreviousTransaction()));
		} else {
			System.out.println("No previous transactions recorded.");
		}
	}

	public void setPreviousTransaction(int n) {
		previousTransaction = n;
	}
	
	public int getPreviousTransaction() {
		return previousTransaction;
	}
	//////////////////////////////////////////////////////////////
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String k) {
		userId = k;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String k) {
		username = k;
	}

	/*
	 * write a deposit and withdraw method
	 */
	
	//deposit method
	//might not need to be using getter/setter methods, so check this if deposit method doesn't work
	public void deposit(int n) {
		if(n != 0) {
			setBalance(n);
			setPreviousTransaction(n);
		}
		
	}
	
	/*
	 * write a showMenu method which displays options that the user can select
	 */
	
	
	
	
	
	
	

}