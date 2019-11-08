

/* 
 * @HomeWork #5-1: Student.java
 * @Author: WanLing Hsieh
 * @Description: Student class comparing last name then first name	*/
public class Student implements Comparable<Student> {
	// instance variables
	private String last, first; // student's last and first names
	private int score; // student's score

	/** constructor
	 * Give the student's last, first names and score, it creates a Student object
	 * @param last The last name of the student
	 * @param first The first name of the student
	 * @param score The score of the student
	 */
	Student(String last, String first, int score) {
		this.last = last;
		this.first = first;
		this.score = score;
	}
	
	// instance methods for accessing the instance variables (getters)
	/**
	 * getLast()
	 * @return Returns the last name of the student
	 */
	String getLast() {
		return last;
	}
	
	/**
	 * getFirst()
	 * @return Returns the first name of the student
	 */
	String getFirst() {
		return first; 
	}
	
	/**
	 * getScore()
	 * @return Returns the score of the student
	 */
	int getScore() {
		return score; 
	}

	/** returns a String with all the information in a single Student instance
    * @return A string representation of a Student object
	 */
	public String toString() {
		return this.getLast() + ", " + this.getFirst() + ": " + this.getScore();
	}	
	
	/** 
	 * The students is sorted by last name. 
	 * If two students have the same last name, 
	 * the first name is used to determine the final sort order
	 * return a.getLast().compareTo(b.getLast());
	 */
	@Override
	public int compareTo(Student other) {
		int n = (this.getLast().compareTo(other.getLast()));
		//return n == 0 ? this.getFirst().compareTo(other.getFirst()) : n ;
		if (n==0)
			return this.getFirst().compareTo(other.getFirst());
		else
			return n;
	} // end compareTo()


	
} // end Student 
