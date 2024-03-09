package orderlisthandler;

/**
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import java.util.LinkedList;
import java.util.Queue;

public class Order {
	private Queue<OrderDetails> orderQueue;
	
	public Order() {
		orderQueue = new LinkedList<>();
	}
	
	public boolean enqueue(OrderDetails newOrder) {
		return orderQueue.add(newOrder);
	}
	
	public OrderDetails dequeue() {
		return orderQueue.remove();
	}
	public int size() {
		return orderQueue.size();
	}
}

