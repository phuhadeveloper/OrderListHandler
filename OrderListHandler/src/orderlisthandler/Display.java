package orderlisthandler;

/**
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import java.util.ArrayList;
import java.util.Comparator;

public class Display {
	private ArrayList<OrderDetails> itemsInOriginalOrder;
	private ArrayList<OrderDetails> sortedNameList;
	private ArrayList<OrderDetails> sortedOrderNumberList;
	
	public Display() {
		sortedNameList = new ArrayList<>();
		sortedOrderNumberList = new ArrayList<>();
		itemsInOriginalOrder = new ArrayList<>();
	}
	
	public void addNewOrder(OrderDetails newOrder) {
		itemsInOriginalOrder.add(newOrder);
		sortedNameList.add(newOrder);
		sortedOrderNumberList.add(newOrder);
		quickSort(sortedNameList, new NameComparator());
		quickSort(sortedOrderNumberList, new OrderNumberComparator());
		
		displayContentOfList(sortedNameList, "Orders in queue sorted by name(descending order)");
		displayContentOfList(sortedOrderNumberList, "Orders in queue sorted by Order #(descending order)");
	}
	
	private void displayContentOfList(ArrayList<OrderDetails> list, String prefix) {
		String[] contents = new String[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			contents[i] = list.get(i).toString();
		}
		
		System.out.println(prefix + ": " + String.join(", ", contents));
	}
	
	public void removeOrder(OrderDetails order) {
		sortedNameList.remove(order);
		sortedOrderNumberList.remove(order);
		itemsInOriginalOrder.remove(order);
	}
	
	public Object[] getItemsInOriginalOrderArray() {
		return itemsInOriginalOrder.toArray();
	}
	
	public static void quickSort(ArrayList<OrderDetails> orderList, Comparator<OrderDetails> c) {
		quickSortHelper(orderList, c, 0, orderList.size() - 1);
	}
	
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
	
	private static void swap(ArrayList<OrderDetails> list, int index1, int index2) {
		OrderDetails temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
	
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
