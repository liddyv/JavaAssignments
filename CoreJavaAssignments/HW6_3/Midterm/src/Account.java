

/* @Midterm: Account.java
 * @Author: WanLing Hsieh
 * @Description: Implement common operations of all accounts
 * */
class Account implements AccountInterface {
	private double balance;
	
	/**
	 * Constructs a bank account with a zero balance
	 */
	Account() {
		balance = 0;
	}
	
	/**
	 * Constructs a bank account with a given balance
	 * @param initBalance The initial balance
	 */
	Account(double initBalance) {
		this.balance = initBalance;
	}

	/**
	 * Deposits money into the bank account.
	 * @param d The deposit amount
	 */
	public void deposit(double d) {
		balance += d;
	}

	/**
	 * Withdraws money from the bank account
	 * @param w The withdraw amount
	 */
	public void withdraw(double w) {
		//boolean isEnough = true;
		if (w > balance) {
			System.out.println("\nYour current account balance is: " + balance + "\n" +
					"and you want to withdraw: " + w + "\nApperently, your don't have enough fund. Please try again!");
		}
		else 
			balance -= w;
	}
	
	/**
	 * Gets the current balance of the bank account
	 * @return The current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Transfer money from the bank account to another account
	 * @param amount The amount to transfer
	 * @param other The other account
	 */
	public void transfer(double amount, Account other) {
		withdraw(amount);
		other.deposit(amount);
	}
	
	public String toString() {
		return null;
	}
}
/*
interface Account {
	static double balance = 0;
	
	abstract double withdrawal(double w);
	abstract double deposit(double d);
	abstract double getBalance();
	abstract String getDisplayText();
	
}
*/
