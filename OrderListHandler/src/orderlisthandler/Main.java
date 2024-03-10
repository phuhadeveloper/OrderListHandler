package orderlisthandler;

/**
 * This class utilizes the Order and Display class to create a program that takes orders,
 * removes orders, and display orders
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// print out the banner
		System.out.println("******************************");
		System.out.println("Welcome to CSC400 Restaurant!");
		System.out.println("******************************");
		
		// create a new queue
		Order orderQueue = new Order();
		
		// create a new display object
		Display display = new Display();
		
		// help to check if user inputs are valid
		HashSet<String> set = new HashSet<>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		
		// create new scanner
		Scanner scanner = new Scanner(System.in);
		// condition to continue/discontinue the program
		boolean shouldContinue = true;
		
		while (shouldContinue) {
			// display choices
			System.out.println("Option 1. Add an Order");
			System.out.println("Option 2. Remove an Order");
			System.out.println("Option 3. Display Current Queue");
			System.out.println("Option 4. Exit");
			System.out.print("Please enter an option: ");
			
			// get and validate input
			String input = scanner.next();
			while(!set.contains(input)) {
				System.out.print("Please enter a valid input: ");
				input = scanner.next();
			}
			
			// choice 1, add new order
			if (input.equals("1")) {
				// get lastName
				System.out.print("Please enter last name: ");
				String lastName = scanner.next();
				
				// get and validate order number
				System.out.print("Please enter order number: ");
				while(!scanner.hasNextInt()) {
					System.out.print("Please enter a valid order number:");
					scanner.next();
				}
				int orderNumber = scanner.nextInt();
			
				// get and validate price
				System.out.print("Please enter total Cost: ");
				while(!scanner.hasNextDouble()) {
					System.out.print("Please enter a valid price:");
					scanner.next();
				}
				double totalCost = scanner.nextDouble();
			
				// add new order to queue and display object
				orderQueue.enqueue(new OrderDetails(lastName, orderNumber, totalCost));
				display.addNewOrder(new OrderDetails(lastName, orderNumber, totalCost));
			}
			
			// choice 2, remove order
			if (input.equals("2")) {
				// can throw an exception when removing from an empty queue
				try {
					// remove from queue
					OrderDetails removedOrder = orderQueue.dequeue();
					System.out.println(removedOrder.toString() + " has been removed.");
					// remove the object from display's arrays
					display.removeOrder(removedOrder);
				} catch(NoSuchElementException e) {
					System.out.println("Queue is empty.");
				}
			}
			
			// choice 3, display queue
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
			
			// choice 4, end program, change shouldContinue to false
			if (input.equals("4")) {
				shouldContinue = false;
			}
			
			// Ask if user want to continue the program
			System.out.print("Continue? y/n: ");
			String userInput = scanner.next();
			if (userInput.compareToIgnoreCase("n") == 0) {
				shouldContinue = false;
			}
		}
		
		// close scanner
		scanner.close();
	}
}
