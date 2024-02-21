package photomanager;

import java.io.*;
import java.util.*;


public class PhotoManager {
	private ArrayList<Photo> allPhotos;

	public PhotoManager() {
		allPhotos = new ArrayList<>();
	}

	public boolean addPhoto(String photoSource, int width, int height, String date) {
		
		if(this.findPhoto(photoSource) == -1) {
			
			try {
			Photo photo = new Photo(photoSource, width, height, date);
			allPhotos.add(photo);
			}
			
			catch (IllegalArgumentException e) {
				System.err.println("addPhoto: Invalid Arguments");
				return false; 
			}
			
			return true;
		}
		
		return false;
	}

	public String toString() {
		String ans = "";
		for(Photo pic : allPhotos) {
			ans += pic.toString() + "\n";
		}
		return ans;
	}

	public int findPhoto(String photoSource) {
		for(int i = 0; i < allPhotos.size(); i++) {
			if(allPhotos.get(i).getPhotoSource().equals(photoSource)) {
				return i;
			}
		}
		return -1;
	}

	public boolean addComment(String photoSource, String newComment) {
		
		if(this.findPhoto(photoSource) == -1 || newComment == null || newComment.isBlank() || photoSource == null || photoSource.isBlank()) {
			return false;
		}
		
		allPhotos.get(this.findPhoto(photoSource)).addComments(newComment);
		return true;
	}

	public String getComments(String photoSource) {
		
		if(this.findPhoto(photoSource) == -1 || photoSource == null || photoSource.isBlank()) {
			return null;
		}
		
		String ans = allPhotos.get(this.findPhoto(photoSource)).getComments();
		return ans;
		
	}

	public void removeAllPhotos() {
		allPhotos.clear();
	}

	public boolean removePhoto(String photoSource) {
		if(this.findPhoto(photoSource) == -1 || photoSource == null || photoSource.isBlank()) {
			return false;
		}
		
		int ind = this.findPhoto(photoSource);
		allPhotos.remove(ind);
		return true;

	}

	public boolean loadPhotos(String filename) {
		if(filename == null || filename.isBlank()) {
			return false;
		}
		
		try {
			Scanner sc = new Scanner(new File(filename));
			while(sc.hasNextLine()) {
				String source = sc.next();
				int width = sc.nextInt();
				int height = sc.nextInt();
				String date = sc.next();
				Photo pic = new Photo(source, width, height, date);
				allPhotos.add(pic);
			}
			
			sc.close();
			return true;
			
		}
		
		catch (Exception e){
			System.err.println("Invalid argument");
			return false;
		}
	}

	public void sortPhotosByDate() {
		Collections.sort(allPhotos);
	}

	public void createHTMLPage(String htmlFilename) {
		String body = "";

		for (Photo photo : allPhotos) {
			body += "<img src=\"" + photo.getPhotoSource() + "\" ";
			body += "width=\"" + photo.getWidth() + "\" ";
			body += "height=\"" + photo.getHeight() + "\" ";
			body += "alt=\"photo image\"><br>\n";
		}

		Utilities.generateHTMLPageWithBody(htmlFilename, body);
	}
}