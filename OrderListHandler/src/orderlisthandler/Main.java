package orderlisthandler;

/**
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to CSC400 Restaurant!");
		
		Order orderQueue = new Order();
		
		Display display = new Display();
		
		HashSet<String> set = new HashSet<>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		Scanner scanner = new Scanner(System.in);
		boolean shouldContinue = true;
		
		while (shouldContinue) {
			System.out.println("Option 1. Add an Order");
			System.out.println("Option 2. Remove an Order");
			System.out.println("Option 3. Display Current Queue");
			System.out.println("Option 4. Exit");
			System.out.println("Please enter an option: ");
	
			String input = scanner.next();
			while(!set.contains(input)) {
				System.out.println("Please enter a valid input: ");
				input = scanner.next();
			}
			
			if (input.equals("1")) {
				System.out.println("Please enter last name, order number, and total cost for order: ");
				String lastName = scanner.next();
				int orderNumber = scanner.nextInt();
				double totalCost = scanner.nextDouble();
				orderQueue.enqueue(new OrderDetails(lastName, orderNumber, totalCost));
				display.addNewOrder(new OrderDetails(lastName, orderNumber, totalCost));
			}
			if (input.equals("2")) {
				try {
					OrderDetails removedOrder = orderQueue.dequeue();
					System.out.println(removedOrder.toString() + " has been removed.");
					display.removeOrder(removedOrder);
				} catch(NoSuchElementException e) {
					System.out.println("Queue is empty.");
				}
			}
			if (input.equals("3")) {
				if (orderQueue.size() == 0) {
					System.out.println("Queue is empty.");
				} else {
					System.out.println("Current orders in Queue: ");
					Object[] orders = display.getItemsInOriginalOrderArray();
					String[] contents = new String[orderQueue.size()];
					for (int i =0; i < orders.length; i++) {
						contents[i] = orders[i].toString();
					}
					System.out.println(String.join(", ", contents));
				}
			}
			if (input.equals("4")) {
				shouldContinue = false;
			}
		}
		
		scanner.close();
	}
}
