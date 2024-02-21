package photomanager;

import static org.junit.Assert.assertTrue;

/**
 * @author UMCP CS Department
 *
 */
public class Driver {

	public static void main(String[] args) {
		PhotoManager arr = new PhotoManager();
		arr.addPhoto("umd/image9.jpg", 250, 740, "06/29/2005-1:50");
		arr.addPhoto("umd/image10.jpg", 430, 380, "07/03/2015-11:45");
		arr.addPhoto("umd/image11.jpg", 640, 570, "02/24/2019-18:38");
		arr.addPhoto("umd/image12.jpg", 980, 530, "09/19/2021-15:52");
		arr.removePhoto("umd/image11.jpg");
		System.out.println(arr);
		String ans = "umd/image9.jpg,250,740,06/29/2005-1:50\n";
		ans += "umd/image10.jpg,430,380,07/03/2015-11:45\n";
		ans += "umd/image12.jpg,980,530,09/19/2021-15:52\n";
		System.out.println(ans);
	}
}



