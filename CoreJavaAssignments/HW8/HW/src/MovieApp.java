

/*  
 * @HomeWork #8: MovieApp.java
 * @Author: WanLing Hsieh
 * @Description: 
 * This application connects to a database and displays a list of all actors for each movie 
 * in each year, sorted by years
 */
public class MovieApp {

	// create the Customer DB object
	private static MovieDB movieDB = null;


	public static void main (String[] args) {
		//movieDB.createTable();	
		// display a welcome message
		System.out.println("Welcome to the Hollywood Movie Report \n");
		System.out.println("Year \t Movie \t\t\t\t Actors");
	 
		movieDB = new MovieDB();
		
		// good
		//System.out.println("ReadFileIntoMovieDB");
		movieDB.readFileIntoMovieDB();
		
		// good
		//System.out.println("saveMoviesToFile"); 
		movieDB.saveMoviesToFile();
			
		// good
		//System.out.println("listMovies - data from db");
		movieDB.listMovies();	
				
	}
}