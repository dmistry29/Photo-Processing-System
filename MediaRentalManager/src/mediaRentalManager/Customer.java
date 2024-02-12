package mediaRentalManager;

import java.util.ArrayList;

public class Customer implements Comparable<Customer>{
	private String name;
	private String address;
	private String plan;
	private ArrayList<String> queue;
	private ArrayList<String> rented;
	
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		queue = new ArrayList<>();
		rented = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	@Override
	public int compareTo(Customer customer) {
		return this.name.compareTo(customer.name);
	}

	public ArrayList<String> getQueue() {
		return queue;
	}

	public ArrayList<String> getRented() {
		return rented;
	}
	
}
