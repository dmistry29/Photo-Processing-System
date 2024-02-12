package mediaRentalManager;

public class Album extends Media{
	private String songs; 
	private String artist;
	
	public Album(String title, int numOfCopies, String artist, String songs) {
		super(title, numOfCopies);
		this.artist = artist;
		this.songs = songs;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
