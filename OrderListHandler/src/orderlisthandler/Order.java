package orderlisthandler;

/**
 * This class represents the queue that takes care of orders
 * follow FIFO (first-in first-out) property of a queue
 * methods include, enqueue, dequeue, size
 * 
 * This is basically a wrapper class to the Linked List queue implementation
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import java.util.LinkedList;
import java.util.Queue;

public class Order {
	private Queue<OrderDetails> orderQueue;
	
	// using the linked list implementation of queue
	public Order() {
		orderQueue = new LinkedList<>();
	}
	 
	// enqueue method to add new order to the back of the list
	public boolean enqueue(OrderDetails newOrder) {
		return orderQueue.add(newOrder);
	}
	
	// dequeue to remove item at the front of the list
	public OrderDetails dequeue() {
		return orderQueue.remove();
	}
	
	// return the number of items in the list
	public int size() {
		return orderQueue.size();
	}
}

