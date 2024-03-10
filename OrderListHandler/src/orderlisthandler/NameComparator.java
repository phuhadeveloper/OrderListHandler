package orderlisthandler;

/**
 * A NameComparator class that implements the Comparator interface
 * to compare two OrderDetails objects with respect to lastName
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import java.util.Comparator;

public class NameComparator implements Comparator<OrderDetails> {

	public int compare(OrderDetails order1, OrderDetails order2) {
		return order1.getLastName().compareToIgnoreCase(order2.getLastName());
	}
}
