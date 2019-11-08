

import java.io.*;
import java.util.*;
import java.sql.*;

/*  
 * @HomeWork #8: MovieDB.java
 * @Author: WanLing Hsieh
 * @Description: 
 * This class contains methods. i.e. db connection, read and write files ...
 */
class MovieDB {

	StringTokenizer tokenizer = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	
	ArrayList<Movie> movies = null; 
	private final String FIELD_SEP = "\t";

	Connection connect() {
    	String url = "jdbc:derby:MovieDB;create=true";
    	String username = "";
    	String password = "";
    	try
    	{
    	Connection connection = DriverManager.getConnection(url, username, password);
    	return connection;
    	}
    	catch(SQLException e)
    	{
    	System.err.println("SQLException: " + e);
    	return null;
    	}
    } // end connection

	void createDatabase() {
		try {

			//STEP 1: Open a connection
			System.out.println("Connecting to database...");
			conn = connect();

			//STEP 2: Execute a query
			System.out.println("Creating database...");
			stmt = conn.createStatement();

			String sql = "CREATE DATABASE MovieDB";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");

		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			//finally block used to close resources
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException se2) {} // nothing we can do
			try {
				if (conn != null) conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} //end finally try
		} //end try
	}
	
	void createTable() {
		try {
			
			//STEP 1: Open a connection
			System.out.println("Connecting to database...");
			conn = connect();
	
			//STEP 2: Execute a query
			System.out.println("Creating Tables...");
			stmt = conn.createStatement();
			/*
			String sql1 = "CREATE TABLE movies(" +
					"year INT, " +
					"movie VARCHAR(255), " +
					"actor VARCHAR(255))";
			 */
			
			String sql1 = "CREATE TABLE movies" +
				"(actor VARCHAR(255)," +
				"movie VARCHAR(255)," +
				"movieYear INT)";
	
			stmt.executeUpdate(sql1);
			System.out.println("Created table MOVIES in given database...");
	
		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			//finally block used to close resources
			try {
				if (stmt != null) stmt.close();
			} catch (SQLException se2) {} // nothing we can do
			try {
				if (conn != null) conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} //end finally try
		} //end try
	}

	void readFileToPrint() {
	
		//STEP 1: Read imdb.tsv file 
		BufferedReader in = null;
		try {
			//in = new BufferedReader(new FileReader("../HW/src/hw8/imdb.tsv"));
			in = new BufferedReader(new FileReader("../HW/src/imdb.tsv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Read File
		String input = null;
		try {
			input = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Read first line.

		//STEP 2: choose a data structure to read the data file
		while (input != null) {
			tokenizer = new StringTokenizer(input, "\\t+");
			List<String>dataArray = new ArrayList<String>();

			dataArray.add(input);
			try {
				input = in.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*
			while (tokenizer.hasMoreElements()) {
				dataArray.add(tokenizer.nextElement().toString());
			}
			*/
			// STEP 3: print out data	
			for (String item:dataArray) {
				System.out.print(item + "  ");
			}
			System.out.println(); // Print the data line. 
			try {
				input = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Read next line of data. 
		}
		// STEP 4: Close the file once all data has been read. 
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// End the printout with a blank line
		System.out.println();
		
	} // end readFileToPrint()
	
	synchronized void readFileIntoMovieDB() {
		String input;

		// Read imdb.tsv file
		BufferedReader in = null;
		
		try {
			//in = new BufferedReader(new FileReader("../HW/src/hw8/imdb.tsv"));
			in = new BufferedReader(new FileReader("../HW/src/imdb.tsv"));
			while ((input = in .readLine()) != null) {

				//tokenizer = new StringTokenizer(input, "\\t+");
				tokenizer = new StringTokenizer(input, "\t");
				String actor = tokenizer.nextToken();
				String movie = tokenizer.nextToken();
				String movieYear = tokenizer.nextToken();
				
				int movieYear1 = 0000;		
				try {
					if (input != null) movieYear1 = Integer.parseInt(movieYear);
				} catch (NumberFormatException e) {
					movieYear1 = 0000;
				}

				// set movies object
				Movie movies = new Movie();
				movies.setActorName(actor);
				movies.setMovieName(movie);
				movies.setMovieYear(movieYear1);
				// debug successfully
				//System.out.println("movies objects - " + movies + " is added"); // debug
				
				//insert data to db
				
				//Open a connection
				try {
					Connection conn = connect();
					String sqlcode = "insert into movies (actor, movie, movieYear) values(?,?,?)";		
					PreparedStatement ps = conn.prepareStatement(sqlcode); // create a statement
	
					// set using read data -good
					ps.setString(1, actor);
					ps.setString(2, movie);
					ps.setInt(3, movieYear1);
					
					/*
					// debug 
					System.out.println("set actor: " + actor); // debug
					System.out.println("set movie: " + movie); // debug
					System.out.println("set movieYear1: " + movieYear1); // debug
					*/
					
	/*			
					// set using movies object data -good
					ps.setString(1, movies.getActorName());
					ps.setString(2, movies.getMovieName());
					ps.setInt(3, movies.getMovieYear());
	*/			
					
					/*
					// debug 
					System.out.println("set movies.getActorName(): " + movies.getActorName()); // debug
					System.out.println("set movies.getMovieName(): " + movies.getMovieName()); // debug
					System.out.println("set movies.getMovieYear(): " + movies.getMovieYear()); // debug
					 */
					
					//System.out.println("Inserting Data to database ..........");
	
					ps.executeUpdate();
					//STEP 4: Close a connection
					ps.close();
					conn.close();
	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // end while
			
			System.out.println("All DB Data Inserted...");
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	


		
	} // end readFileIntoMovieDB()

	
	ArrayList<Movie> getMovies() {
		try {
			conn = connect();
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
	
	void listMovies() {
		try {
			conn = connect();
			
			String selectStatement = 
					"select MOVIEYEAR, MOVIE, ACTOR from MOVIES ORDER BY MOVIEYEAR ASC";
				//	"select MOVIEYEAR, MOVIE, ACTOR from MOVIES GROUP BY MOVIEYEAR, MOVIE, ACTOR ORDER BY MAX(MOVIEYEAR) ASC";
				//	"select DISTINCT MOVIEYEAR, MOVIE, ACTOR from MOVIES ORDER BY MOVIEYEAR ASC";
			PreparedStatement ps = conn.prepareStatement(selectStatement);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
		           String movieYear = rs.getString("MOVIEYEAR");
		           String movie = rs.getString("MOVIE");
		           String actor = rs.getString("ACTOR");
		           
		           String movieString = 
		        		   StringUtil.padWithSpaces(movieYear, 10)
		        		 + StringUtil.padWithSpaces(movie, 30)
		        		 + StringUtil.padWithSpaces(actor, 30);
		           System.out.println(movieString);
			}
			System.out.println("End of Report");
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	
	void saveMoviesToFile() {
		try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
               // new FileWriter("../HW/src/hw8/imdb-output.tsv"))))
                new FileWriter("../HW/src/imdb-output.tsv"))))
		{
			// fill array
			ArrayList<Movie> movies = getMovies();
			// sort by year -good
			Collections.sort(movies, Comparator.comparingInt(Movie::getMovieYear));
			
			// sort by move name -good
			//Collections.sort(movies, Comparator.comparing(Movie::getMovieName));
			
			// use Lambdas! -good
			/*
			Collections.sort(movies, (s1, s2) ->
					Integer.compare(s1.getMovieYear(), s2.getMovieYear())
					);
			*/
			
			
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
	} // end saveMoviesToFile()

	
} // end MovieDB