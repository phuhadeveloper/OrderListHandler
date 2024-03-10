package orderlisthandler;

/**
 * Display class, display the queue of orders
 * variables:
 * 	a list that contains the item in the original order of the queue
 *  a list sorted in descending order with respect to last name
 *  a list sorted in descending order with respect to order number
 * 
 * methods:
 *  addNewOrder: add new order to all three lists, sort and display the latter two lists
 *  removeOrder: remove order and display the lists
 *  getItemsInOriginalOrderArray: return the list that contains the items in the original order
 *  
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import java.util.ArrayList;
import java.util.Comparator;

public class Display {
	// this array keeps the original FIFO order of items
	private ArrayList<OrderDetails> itemsInOriginalOrder;
	// this array keeps orders in descending order by last name
	private ArrayList<OrderDetails> sortedNameList;
	// this array keeps orders in descending order by order number
	private ArrayList<OrderDetails> sortedOrderNumberList;
	
	// constructor that initializes the three arrays
	public Display() {
		sortedNameList = new ArrayList<>();
		sortedOrderNumberList = new ArrayList<>();
		itemsInOriginalOrder = new ArrayList<>();
	}
	
	// add orders to the three lists, sort and display two of them
	public void addNewOrder(OrderDetails newOrder) {
		itemsInOriginalOrder.add(newOrder);
		sortedNameList.add(newOrder);
		sortedOrderNumberList.add(newOrder);
		quickSort(sortedNameList, new NameComparator());
		quickSort(sortedOrderNumberList, new OrderNumberComparator());
		
		displaySortedLists();
		
	}
	
	// helper method that displays lists
	private void displaySortedLists() {
		if (sortedNameList.size() == 0 && sortedOrderNumberList.size() == 0) {
			System.out.println("Queue is empty");
		} else {
			displayContentOfList(sortedNameList, "Orders in queue sorted by name(descending order)");
			displayContentOfList(sortedOrderNumberList, "Orders in queue sorted by Order #(descending order)");
		}
	}
	
	// helper display method
	private void displayContentOfList(ArrayList<OrderDetails> list, String prefix) {
		String[] contents = new String[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			contents[i] = list.get(i).toString();
		}

		System.out.println(prefix + ": " + String.join(", ", contents));
		
	}
	
	// remove the specify order and displat lists
	public void removeOrder(OrderDetails order) {
		sortedNameList.remove(order);
		sortedOrderNumberList.remove(order);
		itemsInOriginalOrder.remove(order);
		
		displaySortedLists();
	}
	
	// return the array that keeps the original FIFO order
	public Object[] getItemsInOriginalOrderArray() {
		return itemsInOriginalOrder.toArray();
	}
	
	// quick sort method
	public static void quickSort(ArrayList<OrderDetails> orderList, Comparator<OrderDetails> c) {
		quickSortHelper(orderList, c, 0, orderList.size() - 1);
	}
	
	// quick sort helper method
	private static void quickSortHelper(ArrayList<OrderDetails> orderList, Comparator<OrderDetails> c, int first, int last) {
		
		if (first < last) {
			if (last - first == 1) {
				if (c.compare(orderList.get(first), orderList.get(last)) < 0) swap(orderList, first, last);
				return;
			}
			int mid = (first + last) / 2;
			if (c.compare(orderList.get(mid), orderList.get(first)) > 0) swap(orderList, first, mid);
			if (c.compare(orderList.get(mid), orderList.get(last)) < 0) swap(orderList, mid, last);
			
			if (last - first == 2) return;
			
			OrderDetails pivot = orderList.get(mid);
			
			// swap pivot with the last index
			swap(orderList, mid, last);
			
			int pivotIndex = partition(orderList, c, first, last - 1, pivot);
			
			// swap value at pivotIndex with the last value, which is the pivot
			swap(orderList, pivotIndex, last);
			
			quickSortHelper(orderList, c, first, pivotIndex - 1);
			quickSortHelper(orderList, c, pivotIndex + 1, last);
		}
	}
	
	// swap method for quick sort
	private static void swap(ArrayList<OrderDetails> list, int index1, int index2) {
		OrderDetails temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
	
	// partition method for quick sort
	private static int partition(ArrayList<OrderDetails> list, Comparator<OrderDetails> c, int first, int last, OrderDetails pivot) {
		
		boolean done = false;
		while(!done) {
			while(c.compare(pivot, list.get(first)) < 0) first++;
			while(c.compare(pivot, list.get(last)) > 0) last--;
			
			if (first < last) {
				swap(list, first, last);
				first++;
				last--;
			} else {
				done = true;
			}
		}
		return first;
	}
}
