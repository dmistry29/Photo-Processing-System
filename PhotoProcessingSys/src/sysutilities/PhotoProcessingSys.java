package sysutilities;

import javax.swing.JOptionPane;

public class PhotoProcessingSys{
	private String name;
	private Address address;
	private double balance;
	private StringBuffer transactionLog = new StringBuffer("Image Transactions\n");
	private int count;
	
	public PhotoProcessingSys(String name, String street, String city, String state, String zip) {
		this.name = name;
		this.address = new Address(street, city, state, zip);
	}
	
	public PhotoProcessingSys() {
		this.name = "NONAME";
		this.address = new Address();
	}
	
	public String imageTransaction(String imageName, String task, String taskOptions, boolean graphicalMode) {
		
		String finalAnswer = "";
		
		if(graphicalMode) {
			PictureManager.graphicalModeOn();
		}
		else {
			PictureManager.graphicalModeOff();
		}
		
		if(task.equals("display")) {
			this.count += 1;
			finalAnswer += PictureManager.displayPicture(imageName);
			this.balance += 1.0;
			this.transactionLog.append("Transaction #").append(count).append(": ").append(finalAnswer);
		}
		else if(task.equals("clear")) {
			this.count += 1;
			finalAnswer += PictureManager.clearScreen();
			this.balance += 1.0;
			this.transactionLog.append("Transaction #").append(count).append(": ").append(finalAnswer);
		}
		else if(task.equals("displaylast")) {
			this.count += 1;
			finalAnswer += PictureManager.displayLastPicture();
			this.balance += 1.0;
			this.transactionLog.append("Transaction #").append(count).append(": ").append(finalAnswer);
		}
		else if(task.equals("blackandwhite")) {
			this.count += 1;
			finalAnswer += PictureManager.displayPictureBlackWhitePosterize(imageName, true, false);
			this.balance += 1.0;
			this.transactionLog.append("Transaction #").append(count).append(": ").append(finalAnswer);
		}
		else if(task.equals("posterize")) {
			this.count += 1;
			finalAnswer += PictureManager.displayPictureBlackWhitePosterize(imageName, false, true);
			this.balance += 1.0;
			this.transactionLog.append("Transaction #").append(count).append(": ").append(finalAnswer);
		}
		else if(task.equals("blackandwhiteposterize")) {
			this.count += 1;
			finalAnswer += PictureManager.displayPictureBlackWhitePosterize(imageName, true, true);
			this.balance += 1.0;
			this.transactionLog.append("Transaction #").append(count).append(": ").append(finalAnswer);
		}
		else if(task.equals("selectcolors")) {
			
			this.count += 1;
			
			boolean isGreen = false;
			boolean isRed = false;
			boolean isBlue = false;
			String normalTaskOptions = taskOptions.toLowerCase().trim();
			
			for(int i = 0; i < normalTaskOptions.length(); i++) {
				if(normalTaskOptions.charAt(i) == 'r') {
					isRed = true;
				}
			
				if(normalTaskOptions.charAt(i) == 'g') {
					isGreen = true;
				}
				
				if(normalTaskOptions.charAt(i) == 'b') {
					isBlue = true;
				}
			}
			
			finalAnswer += PictureManager.displayPictureSelectRedGreenBlue(imageName, isRed, isGreen, isBlue);
			this.balance += 2.0;
			this.transactionLog.append("Transaction #").append(count).append(": ").append(finalAnswer);
		}
		else {
			this.count += 1;
			finalAnswer += "Invalid photoProcessing option";
			this.transactionLog.append("Transaction #").append(count).append(": ").append(finalAnswer);
		}
		
		if(graphicalMode) {
			JOptionPane.showMessageDialog(null, "Continue");
		}
		
		return finalAnswer;
		
	}
	
	@Override
	public String toString() {
		String answer = "";
		answer += "Customer Name: " + this.name + "\n";
		answer += "Customer Address: " + address.toString() + "\n";
		answer += "Balance: " + this.balance + "\n";
		
		return answer;
 	}
	
	public String getTransactions() {
		String answer = "";
		answer = transactionLog.toString();
		return answer;
	}
	
	public double getBalance() {
		return this.balance;
	}
}