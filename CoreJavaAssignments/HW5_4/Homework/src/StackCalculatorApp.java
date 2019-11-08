


import java.util.Scanner;

/*  
 * @HomeWork #5-4: StackCalculatorApp.java
 * @Author: WanLing Hsieh
 * @Description: This app interpret the commands entered by the user
 */
public class StackCalculatorApp {
	
	private static Scanner sc;

	public static void main (String[] args) {
		
		StackCalculator cal = new StackCalculator(); 
		double result; 
	    // display a welcome message
		System.out.println("Welcome to the Stack Calculator.");
		System.out.println();
		System.out.println("Commands: push n, add, sub, mult, div, clear, or quit.");
 
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
		{	
    		System.out.println();	
			System.out.print("? ");
			sc = new Scanner(System.in);
			String command = sc.nextLine();
						
			if (command.split(" ").length > 1) {
				cal.push(Double.valueOf(command.split(" ")[1]));
			}
			else if (command.equalsIgnoreCase("add")) {
				result = cal.add();
				cal.push(result);
			}
			else if (command.equalsIgnoreCase("sub")) {
				result = cal.subtract();
				cal.push(result);
			}
			else if (command.equalsIgnoreCase("mult")) {
				result = cal.multiply();
				cal.push(result);					
			}
			else if (command.equalsIgnoreCase("div")) {
				result = cal.multiply();
				cal.push(result);				
			}
			else if (command.equalsIgnoreCase("clear")) {
				System.out.println("empty");
				cal.clear();					
			} 
			else if (command.equalsIgnoreCase("quit")) {
				System.out.println();
				System.out.println("Thanks for using the Stack Calculator");
				System.exit(1);
			}
			else
				System.out.println("Error! You typed in wrong command.");
			
			
			for (int i = cal.getValues().length - 1; i >=0; i--) {
				System.out.println(cal.getValues()[i]);
			}	
				
		} // end while 
	} // end main		
} // end StackCalculatorApp
