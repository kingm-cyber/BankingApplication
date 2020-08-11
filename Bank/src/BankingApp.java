/*
 * Purpose: Allow users to create a bank account and perform transactions
 * Made By: Matthew King
 * Made on: 8/10/2020
 */

/*
 * To Do:
 * 1. to make the BankAccount class better, replace ints with doubles, then format
 * so that it will only allow for 2 digits after the decimal place
 * 2. print statements so that it says "Your balance is $2.00" instead of just 2
 */

import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {

		BankAccount b1 = new BankAccount("1234", "Matt's Account");
		b1.showMenu();

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

	// if this messes up just replace getter method with variable
	public void printPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Previous Transaction: " + getPreviousTransaction() + " Deposited.");
		} else if (previousTransaction < 0) {
			System.out.println("Previous Transaction: " + Math.abs(getPreviousTransaction()) + " Withdrawn.");
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

	// deposit method
	// might not need to be using getter/setter methods, so check this if deposit
	// method doesn't work
	public void deposit(int n) {
		if (n >= 0) {
			setBalance(getBalance() + n);
			setPreviousTransaction(n);
		}

	}

	// withdraw method
	// make this more robust so it allows users to immediately enter a different
	// value
	// if the amount they are trying to withdraw is wrong (use while(k - n < 0))
	public void withdraw(int n) {
		int k = getBalance();

		if (k - n >= 0) {
			setBalance(getBalance() - n);
			setPreviousTransaction(0 - n);
		} else {
			System.out.println("You cannot withdraw that amount, please try a different amount.");
		}

	}

	// showMenu method displays menu to allow for user interaction
	public void showMenu() {
		// create a scanner to take in input for choosing options
		Scanner scan = new Scanner(System.in);
		char userInput = '\0';

		// create a scanner to take in input for entering an amount to deposit/withdraw
		Scanner scan2 = new Scanner(System.in);
		int amount = 0;

		System.out.println("Welcome " + username + "!");
		System.out.println("Your ID is: " + userId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Check Previous Transaction");
		System.out.println("E. Exit\n");

		do {

			System.out.println("-----------------------------------");
			System.out.println("Choose an option (A-E): ");
			System.out.println("-----------------------------------");
			userInput = scan.next().charAt(0);
			System.out.println("\n");

			switch (userInput) {
			case 'A':
				System.out.println("Your current balance is: " + getBalance());
				break;

			case 'B':
				System.out.println("Enter an amount to deposit: ");
				amount = scan2.nextInt();
				deposit(amount);
				System.out.println("Your current balance is now: " + getBalance());
				break;

			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				amount = scan2.nextInt();
				withdraw(amount);
				System.out.println("Your current balance is now: " + getBalance());
				break;

			case 'D':
				printPreviousTransaction();
				break;

			case 'E':
				System.out.println("Your final balance is: " + getBalance());
				System.out.println("Thank you for choosing our services! Come again soon!");
				break;

			default:
				System.out.println("Invalid Option! Please try again.");
				System.out.println("(Reminder: Options are case sensitive!)");
				break;
			}

		} while (userInput != 'E');

		scan.close();
		scan2.close();

	}

}