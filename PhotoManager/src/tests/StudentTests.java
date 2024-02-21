package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import photomanager.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
	
	@Test (expected = IllegalArgumentException.class)
	public void photoConstructorNullSource() {
		Photo photo = new Photo(null, 300, 400, "05/04/2021-17:35");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void photoConstructorNullDate() {
		Photo photo = new Photo("umd/image1.jpg", 300, 400, null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void photoConstructorBlankSource() {
		Photo photo = new Photo("", 300, 400, "05/04/2021-17:35");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void photoConstructorBlankDate() {
		Photo photo = new Photo("umd/image2.jpg", 300, 400, "");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void photoConstructorNegativeWidth() {
		Photo photo = new Photo("umd/image3.jpg", -300, 500, "09/14/1984-14:32");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void photoConstructorNegativeHeight() {
		Photo photo = new Photo("umd/image4.jpg", 300, -500, "09/14/1984-14:32");
	}
	
	@Test
	public void getMethods() {
		Photo photo  = new Photo("umd/image5.jpg", 250, 740, "08/23/2022-12:00");
		String expectedResults = "umd/image5.jpg, 250, 740, 08/23/2022-12:00";
		String ans = photo.getPhotoSource() + ", " + photo.getWidth() + ", " + photo.getHeight()  + ", " + photo.getDate();
		assertTrue(expectedResults.equals(ans));
	}
	
	@Test
	public void photoToString() {
		Photo photo  = new Photo("umd/image6.jpg", 250, 740, "08/23/2022-12:00");
		String expectedResults = "umd/image6.jpg,250,740,08/23/2022-12:00";
		assertTrue(expectedResults.equals(photo.toString()));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void photoAddCommentsBlank() {
		Photo photo  = new Photo("umd/image7.jpg", 250, 740, "04/19/2012-1:50");
		photo.addComments("");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void photoAddCommentsNull() {
		Photo photo  = new Photo("umd/image7.jpg", 250, 740, "04/19/2012-1:50");
		photo.addComments(null);
	}
	
	@Test 
	public void photoAddCommentsAndGetComments() {
		Photo photo  = new Photo("umd/image7.jpg", 250, 740, "04/19/2012-1:50");
		photo.addComments("This is a picture!");
		photo.addComments("It is my picture");
		String ans = "This is a picture!,It is my picture";
		assertTrue(ans.equals(photo.getComments()));
	}
	
	@Test
	public void compareToPositiveDate() {
		Photo photo  = new Photo("umd/image7.jpg", 250, 740, "03/16/2020-1:50");
		Photo photo2  = new Photo("umd/image7.jpg", 250, 740, "05/21/2012-6:40");
		assertTrue(1 == photo.compareTo(photo2));
	}
	
	@Test
	public void compareToNegativeDate() {
		Photo photo  = new Photo("umd/image7.jpg", 250, 740, "03/16/2020-1:50");
		Photo photo2  = new Photo("umd/image7.jpg", 250, 740, "05/21/2012-6:40");
		assertTrue(-1 == photo2.compareTo(photo));
	}
	
	@Test
	public void addPhotosToArray() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image8.jpg", 250, 740, "03/16/2020-1:50");
		assertTrue(false == arr.addPhoto("umd/image8.jpg", 650, 130, "04/13/2010-1:21"));
	}
	
	@Test
	public void addPhotosToArrayNullDateInput() {
		PhotoManager arr = new PhotoManager();
		boolean ans = arr.addPhoto("umd/image9.jpg", 250, 740, null);
		assertFalse(ans);
	}
	
	@Test
	public void addPhotosToArrayNullSourceInput() {
		PhotoManager arr = new PhotoManager();
		boolean ans = arr.addPhoto(null, 250, 740, "04/13/2010-1:21");
		assertFalse(ans);
	}
	
	@Test
	public void addPhotosToArrayBlankDateInput() {
		PhotoManager arr = new PhotoManager();
		boolean ans = arr.addPhoto("umd/image9.jpg", 250, 740, "");
		assertFalse(ans);
	}
	
	@Test
	public void addPhotosToArrayNegativeWidth() {
		PhotoManager arr = new PhotoManager();
		boolean ans = arr.addPhoto("umd/image9.jpg", -250, 740, "08/23/2001-19:45");
		assertFalse(ans);
	}
	
	@Test
	public void addPhotosToArrayNegativeHeight() {
		PhotoManager arr = new PhotoManager();
		boolean ans = arr.addPhoto("umd/image9.jpg", 250, -740, "07/21/1999-18:00");
		assertFalse(ans);
	}
	
	@Test
	public void addPhotosToArrayBlankSourceInput() {
		PhotoManager arr = new PhotoManager();
		boolean ans = arr.addPhoto("", 250, 740, null);
		assertFalse(ans);
	}
	
	@Test
	public void findPhotosTrue() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertTrue(2 == arr.findPhoto("umd/image11.jpg"));
	}
	
	@Test
	public void findPhotosFalse() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertTrue(-1 == arr.findPhoto("umd/image14.jpg"));
	}
	
	@Test
	public void addCommentAndGetComment() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.addComment("umd/image12.jpg", "Nice picture");
		String ans = "Nice picture";
		assertTrue(ans.equals(arr.getComments("umd/image12.jpg")));
	}
	
	@Test
	public void addCommentBlank() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertFalse(arr.addComment("umd/image12.jpg", ""));
	}
	
	@Test
	public void addCommentNullComment() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertFalse(arr.addComment("umd/image12.jpg", null));
	}
	
	@Test
	public void addCommentNullSource() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertFalse(arr.addComment(null, "Nice Picture"));
	}
	
	@Test
	public void addCommentMultiple() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.addComment("umd/image10.jpg", "Nice picture");
		arr.addComment("umd/image10.jpg", "Beautiful");
		String ans = "Nice picture,Beautiful";
		assertTrue(ans.equals(arr.getComments("umd/image10.jpg")));
	}
	
	@Test
	public void getCommentsNullSource() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.addComment("umd/image10.jpg", "Nice picture");
		arr.addComment("umd/image10.jpg", "Beautiful");
		assertTrue(null == arr.getComments(null));
	}
	
	@Test
	public void getCommentsBlankSource() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.addComment("umd/image10.jpg", "Nice picture");
		arr.addComment("umd/image10.jpg", "Beautiful");
		assertTrue(null == arr.getComments(""));
	}
	
	@Test
	public void getCommentsWrongSource() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.addComment("umd/image10.jpg", "Nice picture");
		arr.addComment("umd/image10.jpg", "Beautiful");
		assertTrue(null == arr.getComments("umd/image15.jpg"));
	}
	
	@Test
	public void removeAllTest() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.removeAllPhotos();
		String ans = "";
		assertTrue(ans.equals(arr.toString()));
	}
	
	@Test
	public void removeOne() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.removePhoto("umd/image11.jpg");
		String ans = "umd/image9.jpg,250,740,06/29/2005-1:50\n";
		ans += "umd/image10.jpg,430,380,07/03/2015-11:45\n";
		ans += "umd/image12.jpg,980,530,09/19/2021-15:52\n";
		assertTrue(ans.equals(arr.toString()));
	}
	
	@Test
	public void removeOneNullSource() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertFalse(arr.removePhoto(null));
	}
	
	@Test
	public void removeOneBlankSource() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertFalse(arr.removePhoto(""));
	}
	
	@Test
	public void removeOneWrongSource() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertFalse(arr.removePhoto("umd/image14.jpg"));
	}
	
	@Test
	public void sortPhotosTrue() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2023-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2013-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.sortPhotosByDate();
		String ans = "umd/image9.jpg,250,740,06/29/2005-1:50\n";
		ans+= "umd/image11.jpg,640,570,02/24/2013-18:38\n";
		ans+= "umd/image12.jpg,980,530,09/19/2021-15:52\n";
		ans+= "umd/image10.jpg,430,380,07/03/2023-11:45\n";
		assertTrue(ans.equals(arr.toString()));
	}
	
	@Test
	public void loadPhotosNullName() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2023-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2013-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertFalse(arr.loadPhotos(null));
	}
	
	@Test
	public void loadPhotosBlankName() {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2023-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2013-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		assertFalse(arr.loadPhotos(""));
	}
	
	
	
}