

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieList extends Thread {
	private MovieDB movieDB = null;
	private Connection conn = null;
	
	// constructor
	MovieList() {
		conn = movieDB.connect();
	}
	@Override
	public void run() {
		try {
			
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
				} // end while
				System.out.println("End of Report");
				rs.close();
				ps.close();
				conn.close();				
		} catch (SQLException e) {
			System.out.println(e);
		}	
	} // end run
} // end MovieList
