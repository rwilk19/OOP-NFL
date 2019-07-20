package nfl;

//Stadium implements the RevenueSource interface. 
public class Stadium implements RevenueSource<Stadium> {
	private String name; 
	private String address;
	private int capacity;
	private double averageTicketPrice;
	
	public Stadium(String name, String address, int capacity, double averageTicketPrice) {
		this.name = name;
		this.address = address;
		this.capacity = capacity; 
		this.averageTicketPrice = averageTicketPrice;
	}
	
	//Implements the RevenueSource interface's method
	@Override
	public double getRevenueAmt() {
		return (capacity * averageTicketPrice);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setAverageTicketPrice(double price) {
		this.averageTicketPrice = price;
	}
	public double getAverageTicketPrice() {
		return averageTicketPrice;
	}
	public String toString() {
		return "Stadium Name: " + this.name + ", Address: " + this.address + ", Capacity: " +
				this.capacity + ", Average Ticket Price: " + this.averageTicketPrice;
	}
}