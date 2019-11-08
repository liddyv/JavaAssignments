
import java.util.Scanner;

/* The <code>Validator</code> class validate the input the user entered
 * @HomeWork #6-1: Validator.java
 * @Author: WanLing Hsieh
 * @Description: Validate user input	*/
class Validator
{
	static int getInt(Scanner sc, String prompt)
	{
		int i = 0;
		boolean isValid = false;
		while (isValid == false)
		{
			System.out.println();
			System.out.print(prompt);
			if (sc.hasNextInt())
			{
				i = sc.nextInt();
				isValid = true;
			}
			else
			{
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine();  // discard any other data entered on the line
		}
		return i;
	}


	static int getIntWithinRange(Scanner sc, String prompt,
	int min, int max)
	{
		int i = 0;
		boolean isValid = false;
		while (isValid == false)
		{
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println(
					"Error! Number must be greater than " + min);
			else if (i > max)
				System.out.println(
					"Error! Number must be less than " + max);
			else
				isValid = true;
		}
		return i;
	}

	static int getIntWithinRange(Scanner sc, String prompt,
	int min)
	{
		int i = 0;
		boolean isValid = false;
		while (isValid == false)
		{
			i = getInt(sc, prompt);
			if (i < min)
				System.out.println(
					"Error! Enter only a positive integer");
			else
				isValid = true;
		}
		return i;
	}	

    // add a new method that forces the user to enter a string
	static String getRequiredString(Scanner sc, String prompt)
	{
		String s = "";
		boolean isValid = false;
		while (isValid == false)
		{
			System.out.print(prompt);
			s = sc.nextLine();
			//s = sc.next();
			if (s.equals(""))
			{
				System.out.println("Error! This entry is required. Try again.");
    		}
			else
			{
				isValid = true;
			}
		}
		return s;
	}	

	// add another new method that forces the user to enter one of two strings
	static String getChoiceString(Scanner sc, String prompt, String s1, String s2)
	{
		String s = "";
		boolean isValid = false;
		while (isValid == false)
		{
			s = getRequiredString(sc, prompt);
			if (s.equalsIgnoreCase(s2))
			{
				System.out.println(); 
				System.out.print("Goodbye. "); 
				isValid = true; 
			}
			else if (
				!s.equalsIgnoreCase(s1) &&
				!s.equalsIgnoreCase(s2)
				)
			{
				System.out.println("Error! Entry must be '"+
				s1 +"' or '"+ s2 +"'. Try again.");
			}
			else 
			{
				isValid = true;
			}
		}
		return s;
	}
	
	static String getEitherString(Scanner sc, String prompt, String s1, String s2)
	{
		String s = "";
		boolean isValid = false;
		while (isValid == false)
		{
			s = getRequiredString(sc, prompt);
			if (
				!s.equalsIgnoreCase(s1) &&
				!s.equalsIgnoreCase(s2)
				)
			{
				System.out.println("Error! Entry must be '"+
				s1 +"' or '"+ s2 +"'. Try again.");
			}
			else 
			{
				System.out.println(); 
				isValid = true;
			}
		}
		return s;
	}

}