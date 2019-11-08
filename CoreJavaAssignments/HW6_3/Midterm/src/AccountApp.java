

import java.text.NumberFormat;
import java.util.Scanner;

/* @Midterm: AccountApp.java
 * @Author: WanLing Hsieh
 * @Description: an application (user) class 
 * */
public class AccountApp {
    public static void main(String[] args)
    {
        // declare and initialize the sales tax constant
        //final double SALES_TAX_PCT = .05;
    	double checking = 1000;
    	double savings  = 1000;
    	double amount   = 0; 
    	
    	Checking c = new Checking(1000);
    	Savings s = new Savings(1000);

        // welcome the user to the program
        System.out.println("Welcome to the Account application");
        System.out.println();  // print a blank line
        System.out.println("Starting Balances");          
   
        // get the currency formatter objects
        NumberFormat currency = NumberFormat.getCurrencyInstance();
     
        // display the starting balances
        String message =
        	"Checking: " + currency.format(c.getBalance()) + "\n"
          + "Savings:  " + currency.format(savings) + "\n"; 
        System.out.println(message);

        // Start the transaction
        System.out.println("Enter the transactions for the month");
        System.out.println();  // print a blank line
        // create a Scanner object and start a while loop
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) 
		{				            
			// ask user to enter either w or d
			String transaction = Validator.getEitherString(sc, "Withdrawal or deposit? (w/d): ", "w", "d");

			// ask user to enter either c or s
			String account = Validator.getEitherString(sc, "Checking or savings? (c/s): ", "c", "s");

			// Overdraft is not allowed and final balance should not be negative for any accounts
			amount = Validator.getDoubleWithinRange(sc, "Amount?: ", 0, 1000);

			if ( account.equalsIgnoreCase("s") ) {
				if ( transaction.equalsIgnoreCase("d"))
					s.deposit(amount);
				else 
					s.withdraw(amount); //
			}
			else if ( account.equalsIgnoreCase("c") ) {
				if ( transaction.equalsIgnoreCase("d"))
					c.deposit(amount);
				else 
					c.withdraw(amount); //				
			}
			
		
 	        // see if the user wants to continue
			System.out.println();
			choice = Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
            System.out.println();
        } // end while
				
		// calculate and print Monthly payments and fees
	    System.out.println("Monthly Payments and Fees");
	    String message2 =
            	"Checking:			" + currency.format(c.getCheckingFee()) + "\n"
              + "Savings interest payment:	" + currency.format(s.getInterestPayment()) + "\n"; 
            System.out.println(message2);

		// deduct fees from checking
		c.deductFees();
		// deposit interest to saving
		s.addInterest();
                     
         // calculate and print final balances 
    	    System.out.println("Final Balances");
        String message3 =
            	"Checking:	" + currency.format(c.getBalance()) + "\n"
              + "Savings:	" + currency.format(s.getBalance()) + "\n"; 
            System.out.println(message3);
	    		
    } // end main	
}
