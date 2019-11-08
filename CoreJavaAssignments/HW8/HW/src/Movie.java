

/*  
 * @HomeWork #8: Movie.java
 * @Author: WanLing Hsieh
 * @Description: 
 * This class set/get actorName, movieName and movieYear
 */
class Movie {
	private String actorName;
	private String movieName;
	private int movieYear;

	// constructor
	Movie() {
		this("","", 0);
	}
	
	Movie(String actorName, String movieName, int movieYear) {
		this.actorName = actorName;
		this.movieName = movieName;
		this.movieYear = movieYear;
	}
	
	void setActorName(String actorName) {
		this.actorName = actorName;
	}
	
	String getActorName() {
		return actorName;
	}
	
	void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	String getMovieName() {
		return movieName;
	}
	
	void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}
	
	int getMovieYear() {
		return movieYear;
	}
	
	public String toString() {
		return "Actor: " + actorName + "\t" +
				"Movie: " + movieName + "\t" +
				"Year: " + movieYear + "\n";
	}
}
