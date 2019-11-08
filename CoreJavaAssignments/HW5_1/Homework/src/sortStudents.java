

/* 
 * @HomeWork #5-1: sortStudent.java
 * @Author: WanLing Hsieh
 * @Description: Not used in this assignment. 
 * 	Alternative way: This class comparing last name then first name	*/
import java.util.Comparator;

public class sortStudents implements Comparator<Student> {

	@Override
	public int compare(Student a, Student b) {
		int n = a.getLast().compareTo(b.getLast());
		return n == 0 ? a.getFirst().compareTo(b.getFirst()) : n ;
		//return a.getLast().compareTo(b.getLast());
	}
}
