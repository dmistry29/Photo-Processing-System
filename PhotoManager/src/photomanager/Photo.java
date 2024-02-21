package photomanager;

public class Photo implements Comparable<Photo> {
	private String photoSource;
	private int width, height;
	private String date;
	private StringBuffer comments;

	
	public Photo(String photoSource, int width, int height, String date) {
		
		if(photoSource == null || photoSource.isBlank() || date == null || date.isBlank()) {
			throw new IllegalArgumentException("Constructor: Invalid Arguments");
		}
		
		if(width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Constructor: Invalid Arguments");
		}
		
		this.photoSource = photoSource;
		this.width = width;
		this.height = height;
		this.date = date;
		
		comments = new StringBuffer("");
		
	}

	public String toString() {
		return photoSource + "," + width + "," + height + "," + date;
	}

	public String getPhotoSource() {
		return this.photoSource;
	}

	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}

	public String getDate() {
		return this.date;
	}

	public Photo addComments(String newComment) {
		if(newComment == null || newComment.isBlank()) {
			throw new IllegalArgumentException("Invalid Comment");
		}
		
		if(comments.length() != 0) {
			comments.append(",");
		}
		comments.append(newComment);
		return this;
	}

	public String getComments() {
		return comments.toString();
	}
	
	public Photo(Photo photo) {
		
		this.photoSource = photo.photoSource;
		this.date = photo.date;
		this.width = photo.width;
		this.height = photo.height;
		
		comments = new StringBuffer(photo.comments);
	}

	public int compareTo(Photo photo) {
		
		long currentObject = Utilities.getDate(this.date);
		long parameterObject = Utilities.getDate(photo.date);
		
		if(currentObject < parameterObject) {
			return -1;
		}
		else if (currentObject > parameterObject){
			return 1;
		}
		
		return 0;
	}
}