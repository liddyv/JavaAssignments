

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/* 
 * @HomeWork #5-1: StudentApp.java
 * @Author: WanLing Hsieh
 * @Description: Get user input and display sorted data	*/
public class StudentApp {
	
	public static void main (String[] args) {
		int number; 
		String last = "";
		String first = "";
		int score = 100; 

		// display a welcome message
		System.out.println("Welcome to the Student Scores Application");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) 
		{	
			// ask Number to students
			number = Validator.getIntWithinRange(sc, "Enter number of students to enter: ", 0);
			
			// Array with Student object
			Student[] students = new Student[number];
			
			// add students into Student array
			for (int i =0; i < students.length; i++) {
				System.out.println();
				int j =i + 1;
				last = Validator.getRequiredString(sc, "Student " + j + " last name: ");
				first = Validator.getRequiredString(sc, "Student " + j + " first name: ");
				score = Validator.getIntWithinRange(sc, "Student " + j + " score: ", 0, 100);
				students[i] = new Student(last, first, score);
			}
			
			/* Sort Student array  
			 * Arrays.sort(students, new sortStudents()); // if use implements Comparator<Student>
			 */
			Arrays.sort(students); // if implements Comparable<Student>
			System.out.println();
			// print sorted Student array
			for (int i = 0; i < students.length; i++) {
				System.out.println(students[i]);
			}
			
	        // see if the user wants to continue
			System.out.println();
			choice = Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
            System.out.println();
        } // end while		
	} // end main	

} // end studentApp
