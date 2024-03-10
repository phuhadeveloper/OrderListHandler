package orderlisthandler;

/**
 * This class tries to model an Order form that includes customer lastName, orderNumber, and totalCost
 * Methods include getters and setters, toString, and equals 
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

public class OrderDetails {
	private String lastName;
	private int orderNumber;
	private double totalCost;
	
	//constructor that initializes the variables
	public OrderDetails(String lastName, int orderNumber, double totalCost) {
		this.lastName = lastName;
		this.orderNumber = orderNumber;
		this.totalCost = totalCost;
	}
	
	// getters and setters
	public String getLastName() {return lastName;}
	public int getOrderNumber() {return orderNumber;}
	public double getTotalCost() {return totalCost;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setOrderNumber(int orderNumber) {this.orderNumber = orderNumber;}
	public void setTotalCost(double totalCost) {this.totalCost = totalCost;}
	
	// equals method
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof OrderDetails)) return false;
		
		OrderDetails order = (OrderDetails) o;
		
		if (lastName.compareToIgnoreCase(order.getLastName()) != 0) return false;
		if (orderNumber != order.getOrderNumber()) return false;
		if (Math.abs(totalCost - order.getTotalCost()) <= 0.000001) return true;
		
		return false;
	}
	
	//toString method
	@Override
	public String toString() {
		return "[" + lastName + ", #" + orderNumber + ", $" + totalCost + "]";
 	}
}
