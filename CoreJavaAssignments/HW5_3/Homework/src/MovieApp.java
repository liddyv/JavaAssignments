

import java.util.ArrayList;
import java.util.Scanner;

/* 
 * @HomeWork #5-3: MovieApp.java
 * @Author: WanLing Hsieh
 * @Description: 
 * 	This app stores a list of 100 movies and displays them by category. 	
 */
public class MovieApp {
	
	public static void main (String[] args) {
		
		ArrayList<Movie> movies = new ArrayList<Movie>(100);
		// fill the array list with 100 Movie objects.
		addMovies(movies); 
		
		// Debug code: list all objects in movies ArrayList
		//listMovies(movies);
		
		// display a welcome message
		System.out.println("Welcome to the Student Scores Application");
		System.out.println();
		System.out.println("There are 100 movies in the list");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) 
		{	
			
			// ask user for category. Available category: animated, drama, horror, scifi. 
			String category = Validator.getRequiredString(sc, 
						"What category are you interested in? ");
			
			// print the movie title if movies ArrayList contains this category
			searchMovies(movies, category); 
			
	        // see if the user wants to continue
			System.out.println();
			choice = Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
            System.out.println();
        } // end while		
	} // end main	
	

	// Adding movies into movies ArrayList
	public static void addMovies(ArrayList<Movie> movies) {
		for (int i = 0; i < 100; i++) {
			movies.add(MovieIO.getMovie(i));	
		}
	}// end addMovies

	// print out movie's title in movies ArrayList
	public static void listMovies(ArrayList<Movie> movies) {
		if (!movies.isEmpty()) {
			for (Movie movie : movies) {
				System.out.println(movie.title);
			}	
		}
	} // end displayMovies
	
	public static void searchMovies(ArrayList<Movie> movies, String category) {
		// debug code: System.out.println("movies.size() = " + movies.size());
		// print movie title if category matches. 
		for (int i =0; i < movies.size(); i++) {
			if (movies.get(i).category.contains(category)) {
				// print the movie's title
				System.out.println(movies.get(i).title);
			}				 
		}	
	} // end searchMovies
}
