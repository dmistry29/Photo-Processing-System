package sysutilities;

public class Address{
	
	private String street;
	private String city;
	private String state; 
	private String zip;
	
	public Address(String street, String city, String state, String zip) {
		if(street == null || city == null || state == null || zip == null) {
			throw new IllegalArgumentException("Invalid Address Argument");
		}
		else {
			this.street = street.trim();
			this.city = city.trim();
			this.state = state.trim();
			this.zip = zip.trim();
		}
	}
	
	public Address() {
		this("8223 Paint Branch Dr.", "College Park", "MD", "20742");
	}
	
	public Address(Address address) {
		this(address.street, address.city, address.state, address.zip);
	}
	
	public Address(Address address, String street) {
		this(street.trim(), address.city, address.state, address.zip);
	}

	public String getStreet() {
		return this.street;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public String getZip() {
		return this.zip;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Address)) {
			return false;
		}
		
		Address temp = (Address)obj;
		
		if(this.street.compareTo(temp.street) == 0 && this.city.compareTo(temp.city) == 0 && this.state.compareTo(temp.state) == 0 && this.zip.compareTo(temp.zip) == 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		String answer = this.street + " " + this.city + " " + this.state + " " + this.zip;
		return answer;
	}

	
}
