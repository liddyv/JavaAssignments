

/*  
 * @HomeWork #5-3: Movie.java
 * @Author: WanLing Hsieh
 * @Description: This class contains title & category fields for movie object
 */
public class Movie {
	
	String title;
	String category;
	
	// constructor
	Movie(String title, String category) {
		this.title = title;
		this.category = category;
	}

	String getString() {
		return "Movie's title is: "+ title + " & category is: " + category;
	}
}
