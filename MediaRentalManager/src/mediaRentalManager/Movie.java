package mediaRentalManager;

public class Movie extends Media {
	private String rating;
	
	public Movie(String title, int numOfCopies, String rating) {
		super(title, numOfCopies);
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
