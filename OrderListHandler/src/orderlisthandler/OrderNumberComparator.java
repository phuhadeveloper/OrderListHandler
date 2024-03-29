package orderlisthandler;

/**
 * A OrderNumber Comparator class that implements the Comparator interface
 * to compare two OrderDetails objects with respect to order number
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import java.util.Comparator;

public class OrderNumberComparator implements Comparator<OrderDetails> {
	
	public int compare(OrderDetails order1, OrderDetails order2) {
		return order1.getOrderNumber() - order2.getOrderNumber();
	}
}
