package entities;

public class Account {

	private long accountNumber;
	private String name;
	private double balance;
	private final double TAX = 5; 
	
	public Account(long accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}
	
	public Account(long accountNumber, String name, double initialDeposit) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.deposit(initialDeposit);
	}
	
	public void deposit(double depositValue) {
		this.balance += depositValue;
	}
	
	public void withdraw(double withdrawValue) {
		this.balance -= withdrawValue + this.TAX;
	}
	
	public String toString() {
		return "Account "
				+ this.accountNumber
				+ ", Holder: "
				+ this.name
				+ ", Balance: $"
				+ String.format("%.2f", this.balance);
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}
	
}
