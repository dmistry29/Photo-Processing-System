package mediaRentalManager;

public class Media implements Comparable<Media> {
	private String title;
	private int numOfCopies;
	private int originalNumber;
	
	public Media(String title, int numOfCopies) {
		this.title = title;
		this.numOfCopies = numOfCopies;
		this.originalNumber = numOfCopies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	public int getOriginalNumber() {
		return originalNumber;
	}

	public void setOriginalNumber(int originalNumber) {
		this.originalNumber = originalNumber;
	}

	@Override
	public int compareTo(Media media) {
		return this.title.compareTo(media.title);
	}
}
