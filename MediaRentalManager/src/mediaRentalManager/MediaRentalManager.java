package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalManagerInt{
	
	ArrayList<Customer> allCustomers;
	ArrayList<Media> allMedia;
	private static int limitedPlanLimit = 2;
	
	public MediaRentalManager() {
		
		allCustomers = new ArrayList<>();
		allMedia = new ArrayList<>();
		
	}
	
	@Override
	public void addCustomer(String name, String address, String plan) {
		
		allCustomers.add(new Customer(name, address, plan));
		
	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {
		
		allMedia.add(new Movie(title, copiesAvailable, rating));
		
	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		
		allMedia.add(new Album(title, copiesAvailable, artist, songs));
		
	}

	@Override
	public void setLimitedPlanLimit(int value) {
		
		limitedPlanLimit = value;
	}

	@Override
	public String getAllCustomersInfo() {
		
		String answer = "***** Customers' Information *****\n";
		Collections.sort(allCustomers);
		
		for(Customer customer : allCustomers) {
			
			answer += "Name: " + customer.getName() + ", Address: " + customer.getAddress() + ", Plan: " + customer.getPlan().toUpperCase() + "\n";
			answer += "Rented: [";
			
			for(int i = 0; i < customer.getRented().size(); i++) {
				
				answer += customer.getRented().get(i);
				
				if(i != customer.getRented().size() - 1) {
					
					answer += ", ";
				}
				
			}
			
			answer += "]\n";
			answer += "Queue: [";
			
			for(int i = 0; i < customer.getQueue().size(); i++) {
				
				answer += customer.getQueue().get(i);
				
				if(i != customer.getQueue().size() - 1) {
					
					answer += ", ";
					
				}
			}
			
			answer += "]\n";
		}
		
		return answer;
	}

	@Override
	public String getAllMediaInfo() {
		
		String answer = "***** Media Information *****\n";
		Collections.sort(allMedia);
		
		for(Media media : allMedia) {
			
			if(media instanceof Movie) {
				
				Movie temp = (Movie)media;
				answer += "Title: " + temp.getTitle() + ", Copies Available: " + temp.getNumOfCopies() + ", Rating: " + temp.getRating().toUpperCase() + "\n";
			
			}
			
			else {
				
				Album temp = (Album)media;
				answer += "Title: " + temp.getTitle() + ", Copies Available: " + temp.getNumOfCopies() + ", Artist: " + temp.getArtist() + ", Songs: " + temp.getSongs() + "\n";
			
			}
		}
		
		return answer;
	}

	@Override
	public boolean addToQueue(String customerName, String mediaTitle) {
		
		for(Customer customer : allCustomers) {
			
			if(customer.getName().equals(customerName)) {
				
				customer.getQueue().add(mediaTitle);
				return true;
			
			}
		}
		
		return false;
	}

	@Override
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		
		for(Customer customer : allCustomers) {
			
			if(customer.getName().equals(customerName)) {
				
				customer.getQueue().remove(mediaTitle);
				return true;
			
			}
		}
		
		return false;
	}

	@Override
	public String processRequests() {
		
		String ans = "";
		Collections.sort(allCustomers);
		
		for(Customer customer : allCustomers) {
			
			ArrayList<String> tempQueue = new ArrayList<>();
			
			if(customer.getPlan().toUpperCase().equals("LIMITED")) {
				
				if(customer.getQueue().size() != 0) {
					
					for(String item : customer.getQueue()) {
						
						tempQueue.add(item);
					
					}
					
					int count = 0;
					
					for(String item : tempQueue) {	
						
						if(count < limitedPlanLimit ) {
							
							for(Media media : allMedia) {
								
								if(media.getTitle().equals(item) && media.getNumOfCopies() != 0) {
									
									customer.getRented().add(item);
									media.setNumOfCopies(media.getNumOfCopies()-1);
									ans += "Sending " + item + " to " + customer.getName() + "\n";
									customer.getQueue().remove(item);
									count++;
								
								}
							}
						}
					}
				}
			}
			
			else if(customer.getPlan().toUpperCase().equals("UNLIMITED")) {
				
				if(customer.getQueue().size() != 0) {
					
					for(String item : customer.getQueue()) {
						tempQueue.add(item);
					}
					
					for(String item : tempQueue) {
						
						for(Media media : allMedia) {
							
							if(media.getTitle().equals(item) && media.getNumOfCopies() != 0) {
								
								customer.getRented().add(item);
								media.setNumOfCopies(media.getNumOfCopies()-1);
								ans += "Sending " + item + " to " + customer.getName() + "\n";
								customer.getQueue().remove(item);
							
							}
						}
					}
				}
			}
			
		}
		
		return ans;
	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		
		for(Customer customer : allCustomers) {
			
			if(customer.getName().equals(customerName)) {
				
				customer.getRented().remove(mediaTitle);
				
				for(Media media : allMedia) {
					
					if(media.getTitle().equals(mediaTitle)) {
						
						media.setNumOfCopies(media.getNumOfCopies()+1);
					
					}
				}
				
				return true;
			
			}
		}
		
		return false;
	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		
		ArrayList<String> ans = new ArrayList<>();
		
		boolean isTitle = title != null;
		boolean isRating = rating != null;
		boolean isArtist = artist != null;
		boolean isSong = songs != null;
		
		Collections.sort(allMedia);
		
		if(isTitle) {
			
			for(Media media : allMedia) {
				
				if(media.getTitle().equals(title)) {
					
					ans.add(media.getTitle());
				
				}
			}
		}
		
		else if(isRating) {
			
			for(Media media : allMedia) {
				
				if(media instanceof Movie) {
					
					Movie temp = (Movie)media;
					
					if(temp.getRating().equals(rating)) {
						
						ans.add(temp.getTitle());
					
					}
				}	
			}
		}
		
		else if(isArtist) {
			
			for(Media media : allMedia) {
				
				if(media instanceof Album) {
					
					Album temp = (Album)media;
					
					if(temp.getArtist().equals(artist)) {
						
						ans.add(temp.getTitle());
					
					}
				}	
			}
		}
		
		else if(isSong) {
			
			for(Media media : allMedia) {
				
				if(media instanceof Album) {
					
					Album temp = (Album)media;
					
					if(temp.getSongs().contains(songs)) {
						
						ans.add(temp.getTitle());
					
					}
				}	
			}
		}
		
		else {
			
			for(Media media : allMedia) {
				
				ans.add(media.getTitle());	
			
			}
		}
		
		return ans;
	}

}
