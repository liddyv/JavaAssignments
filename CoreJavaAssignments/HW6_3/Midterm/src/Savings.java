

/* @Midterm: Savings.java
 * @Author: WanLing Hsieh
 * @Description: implement saving account's instance variables & operations	
 * */
class Savings extends Account{
	
	private double interestPayment;
	private double interestRate = 1;
	
	/**
	 * Constructs a savings account with a given balance
	 * @param initBalance The initial balance
	 */
	Savings(double initBalance) {
		super(initBalance);
	}
	
	// Constructor with parameters
	/**
	 * Constructs a savings account with a given balance 
	 * 	& interest rate
	 * @param initBalance The initial balance
	 * @param rate The interest rate
	 */
	Savings(double initBalance, double rate) {
		super(initBalance);
		interestRate = rate;
	}

	/**
	 * Adds the earned interest to the account balance
	 */
	void addInterest() {
		super.deposit(getInterestPayment()); 
	}
	
	/**
	 * calculate interest payment
	 * @return the earned Interest amount
	 */
	double getInterestPayment() {
		interestPayment = getBalance() * interestRate / 100;
		return interestPayment;
	}

	/**
	 * deposit money to balance
	 */
	public void deposit(double d) {
		super.deposit(d);
	}

	/**
	 * deduct money from balance
	 */
	 public void withdraw(double w) {
		super.withdraw(w);
	}
	
	@Override
	public String toString() {
		return  "Checking balance: " + getBalance();
	}
}
