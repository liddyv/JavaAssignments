

import java.util.ArrayList;
import java.util.Scanner;
/*  
 * @HomeWork #6-1: countryMaintenanceApp.java
 * @Author: WanLing Hsieh
 * @Description: 
 * 	This app list, add or exit based on the commands entered by the user
 */
public class CountriesApp {
	private static CountriesTextFile countryFile = new CountriesTextFile(); 
	
	static Scanner sc = new Scanner(System.in);

	public static void main (String[] args) {
		/*
		File directory = new File("./");
		   System.out.println(directory.getAbsolutePath());
		*/ 
		System.out.println("Welcome to the Countries Maintenance application \n");
		displayMenu();
		
		int number = 0;
		
        while (!(number == 3))
		{	
        	// get input from user
			number = Validator.getInt(sc, "Enter menu number: ");
 			System.out.println();
			
			if (number == 1) 
				displayAllCountries();  
			else if (number == 2) {
				addCountry();
			}
			else if (number == 3) {
				System.out.println("Goodbye");
			}
			else
				System.out.println("Error! You typed in wrong menu number.");
		} // end while 
	} // end main	

	private static void displayAllCountries() {
		ArrayList<String> countries = countryFile.getCountries();
		StringBuilder sb = new StringBuilder();
		for (String c : countries) {
			sb.append(c);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void addCountry() {
		String country = Validator.getRequiredString(sc, "Enter country: ");
		
		countryFile.add(country);
		System.out.println();
		System.out.println("This country has been saved.");
	}

	public static void displayMenu() {
	    // display a welcome message
		System.out.print("1 - List countries \n");
		System.out.print("2 - Add a country \n");
		System.out.print("3 - Exit \n");
	}
	
	public static void prompt() {
		System.out.print("\nEnter menu number: ");
	}

}
