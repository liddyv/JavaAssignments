

/* @Midterm: Cheecking.java
 * @Author: WanLing Hsieh
 * @Description: implement checking account's instance variables & operations
 * */
class Checking extends Account{
	
	private static final double TRANSACTION_FEE= 1; 
	private int month = 1;
		
	/**
	 * Constructs a checking account with a given balance
	 * @param initBalance The initial balance
	 */
	Checking(double initBalance) {
		/* construct superclass - Must be the first statement
		 *  in subclass constructor */
		super(initBalance);
		// initial transaction count
		//transactionCount = 0; 
	}
	
	public void deposit(double d) {
		//transactionCount++;
		// add deposit to balance
		super.deposit(d);
	}

	public void withdraw(double w) {
		//transactionCount++;
		// subtract money from balance
		super.withdraw(w);
	}

	/**
	 * deduct the accumulated fees and 
	 * 	reset the transaction count to 0.
	 */
	void deductFees() {
		super.withdraw(getCheckingFee());
		//transactionCount = 0;
	}

	double getCheckingFee() {
		return TRANSACTION_FEE * month;
	}

	// method overloading
	double getCheckingFee(int monthCount) {
		return TRANSACTION_FEE * monthCount;
	}

	@Override
	public String toString() {
		return  "Checking balance: " + getBalance();
	}

}
