package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		long accountNumber;
		String name;
		char initialDeposit;
		double initialDepositValue;
		double depositValue;
		double withdrawValue;
		Account account;
		
		System.out.print("Enter account number: ");
		accountNumber = scanner.nextLong();
		
		scanner.nextLine();
		
		System.out.print("Enter account holder: ");
		name = scanner.nextLine();
		
		System.out.print("Is there an initial deposit (y/n)? ");
		initialDeposit = scanner.next().charAt(0);
		
		if (initialDeposit == 'y') {
			
			System.out.print("Enter initial deposit value: ");
			initialDepositValue = scanner.nextDouble();
			
			account = new Account(accountNumber, name, initialDepositValue);
			
		} else {
			
			account = new Account(accountNumber, name);
			
		}
		
		System.out.println("");
		
		System.out.println("Account data: ");
		System.out.println(account);
		
		System.out.println("");
		
		System.out.print("Enter a deposit value: ");
		depositValue = scanner.nextDouble();
		account.deposit(depositValue);
		System.out.println("Updated account data: ");
		System.out.println(account);
		
		System.out.println("");
		
		System.out.print("Enter a withdraw value: ");
		withdrawValue = scanner.nextDouble();
		account.withdraw(withdrawValue);
		System.out.println("Updated account data: ");
		System.out.println(account);
		
		scanner.close();

	}

}
