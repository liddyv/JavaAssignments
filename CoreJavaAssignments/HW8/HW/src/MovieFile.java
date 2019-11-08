

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MovieFile extends Thread {
	
	private final String FIELD_SEP = "\t";
	private MovieDB movieDB = null;
	StringTokenizer tokenizer = null;
	private Connection conn = null;
	
	@Override
	public void run() {
		
        Thread ct = Thread.currentThread();
        System.out.println(ct.getName() + " started");
        
		try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                new FileWriter("../HW/src/hw8/imdb-output.tsv"))))
		{
			// fill array
			ArrayList<Movie> movies = getMovies();
			
			// sort by year -good
			Collections.sort(movies, Comparator.comparingInt(Movie::getMovieYear));
						
			// write all movies in the array list to the file
			for (Movie m : movies)
			{
			 out.print(m.getMovieYear() + FIELD_SEP);
			 out.print(m.getMovieName() + FIELD_SEP);
			 out.println(m.getActorName());
			}
		}
		catch(IOException e)
		{
		System.out.println(e);
		}
	} // end run()
	
	synchronized ArrayList<Movie> getMovies() {
		try {
			conn = movieDB.connect();
			ArrayList<Movie> movies = new ArrayList<Movie>();
			//String query = "select MOVIEYEAR, MOVIE, ACTOR from MOVIES ORDER BY MOVIEYEAR ASC";
		    	String query = "select * from MOVIES";
				PreparedStatement ps = conn.prepareStatement(query);
		       ResultSet rs = ps.executeQuery();

		       while(rs.next())
		       {
		           int movieYear = rs.getInt("MOVIEYEAR");
		           String movie = rs.getString("MOVIE");
		           String actor = rs.getString("ACTOR");

		           Movie m = new Movie(actor, movie, movieYear);
		           movies.add(m);
		       }
		       rs.close();
		       ps.close();
		       conn.close();
		       return movies;
		   }
		   catch(SQLException sqle)
		   {
		       //sqle.printStackTrace();  // for debugging
		       return null;
		   }
		}

}
