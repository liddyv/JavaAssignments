

import java.util.ArrayList;
import java.util.Scanner;

/*  
 * @HomeWork #6-1: countryMaintenanceApp.java
 * @Author: WanLing Hsieh
 * @Description: 
 * This app displays the menus and responds to user's choices.
 */
public class ConversionsApp {
	private static ConversionTextFile conversionFile = new ConversionTextFile();
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		System.out.println("");
		displayMenu();
		
		int menuNum = 0; 
		int conversionNum = 1;
		
		while (!(menuNum == 4)) {
	       	// get input from user
			menuNum = Validator.getInt(sc, "Enter menu number: ");
 			System.out.println();
			
			if (menuNum == 1) {
				displayAllConversions();  
				
				/*
				 * After the user selects a conversion, the application
				 *  prompts the user to enter a unit of measurement, 
				 *  calculates the conversion, displays the result */
				conversionNum = Validator.getInt(sc, "Enter conversion number: ");
				System.out.println();
				
				// Get conversion from unit 
				String from = getConversionFrom(conversionNum);
				
				// ask user to Enter a unit of measurement: " 
				double unit = Validator.getDouble(sc, "Enter " + from + ": " );
				
				// calculate and display conversion result 
				calcDisplayConversionResult(conversionNum, unit);
				
				System.out.println();
				displayMenu();
			}
			else if (menuNum == 2) {
				addConversion();
				System.out.println();
				displayMenu();
			}
			else if (menuNum == 3) {
				deleteConversion();
				displayMenu();
			}
			else if (menuNum == 4) {
				System.out.println("Goodbye");
			}
			else
				System.out.println("Error! You typed in wrong menu number.");

		}
	}
	
	private static void calcDisplayConversionResult(int conversionNum, double unit) {
		// 1. read conversionText file
		ArrayList<Conversion> conversions = conversionFile.getConversions();
		
		// 2. find which line is conversionNum line
		conversionNum--;
		Conversion c = conversions.get(conversionNum);
		
		// 3. Get from, to, and ratio
		String from = c.getFromUnit();
		String to = c.getToUnit();
		double ratio = c.getRatio();
		
		// 4. get value by calling Conversion's calcFormattedConversionToValue
		String result = c.calcFormattedConversionToValue(unit, ratio);
		
		// 5. display result
		System.out.println(unit + " " + from + " = " + result + " " + to);
	}

	private static String getConversionFrom(int conversionNum) {

		// 1. read conversionText file and get array with conversions
		ArrayList<Conversion> conversions = conversionFile.getConversions();
		
		// 2. find which line is conversionNum line
		conversionNum--; 
		Conversion c = conversions.get(conversionNum);
		
		// 3. Get conversion from
		String from = c.getFromUnit();
		
		// 4. return from 
		return from;
	}

	private static void deleteConversion() {
		String from = Validator.getRequiredString(sc, "Enter 'From' unit you want to delete.");
		
		Conversion c = conversionFile.get(from);
		if (c!=null) {
			conversionFile.delete(c);
			System.out.println(c.getFromUnit() + "  To " + c.getToUnit() + " : " + c.getRatio() + " has been deleted. \n");
		}
	}

	private static void addConversion() {
		String from = Validator.getRequiredString(sc, "Enter 'From' unit: ");
		String to = Validator.getRequiredString(sc, "Enter 'To' unit: ");
		Double ratio = Validator.getDouble(sc, "Enter the conversion ratio: ");
		
		//Conversion c = new Conversion(from, to, ratio);

		Conversion c = new Conversion();
		c.setFromUnit(from);
		c.setToUnit(to);
		c.setRatio(ratio);
		System.out.println(c);
		
		conversionFile.add(c);
		
		System.out.println("This entry has been saved.");
	}

	private static void displayAllConversions() {
		ArrayList<Conversion> conversions = conversionFile.getConversions();
		StringBuilder sb = new StringBuilder(); 
		
		//	Conversion c = new Conversion(from, to, Double.parseDouble(ratio));
		int i = 0;
		for (Conversion c : conversions) { 
			sb.append(++i + " - " + c.getFromUnit());
			sb.append(" to " + c.getToUnit() + ": ");
			sb.append(c.getRatio()+"\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void displayMenu() {
	    // display a welcome message
		System.out.print("1 - Convert a length \n");
		System.out.print("2 - Add a type of conversion \n");
		System.out.print("3 - Delete a type of conversion \n");
		System.out.print("4 - Exit \n");
	}
}
