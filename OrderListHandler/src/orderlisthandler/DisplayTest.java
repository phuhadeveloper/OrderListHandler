package orderlisthandler;

/**
 * This test class aim to test the quickSort method in the Display class
 * 
 * author: Phu Ha
 * date: Mar 09, 20204
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisplayTest {
	ArrayList<OrderDetails> list;
	ArrayList<OrderDetails> expected;
	
	@BeforeEach
	void setUp() {
		list = new ArrayList<>();
		expected = new ArrayList<>();
	}

	@Test
	void testQuickSort_ArrayOfSizeZero() {
		assertArrayEquals(expected.toArray(), list.toArray());
	}
	
	@Test
	void testQuickSort_ArrayOfSizeOne() {
		OrderDetails order1 = new OrderDetails("a", 123, 12.12);
		list.add(order1);
		expected.add(order1);
		Display.quickSort(list, new NameComparator());
		assertArrayEquals(expected.toArray(), list.toArray());
	}
	
	@Test
	void testQuickSort_ArrayOfSizeTwo() {
		OrderDetails order1 = new OrderDetails("a", 123, 12.12);
		OrderDetails order2 = new OrderDetails("b", 234, 12.12);
		list.add(order1);
		list.add(order2);
		expected.add(order2);
		expected.add(order1);
		
		Display.quickSort(list, new NameComparator());
		
		assertArrayEquals(expected.toArray(), list.toArray());
	}
	
	@Test
	void testQuickSort_ArrayOfSizeThree() {
		OrderDetails order1 = new OrderDetails("a", 123, 12.12);
		OrderDetails order2 = new OrderDetails("b", 234, 12.12);
		OrderDetails order3 = new OrderDetails("c", 321, 12.12);
		list.add(order3);
		list.add(order2);
		list.add(order1);
		expected.add(order3);
		expected.add(order2);
		expected.add(order1);
		
		Display.quickSort(list, new NameComparator());
		
		assertArrayEquals(expected.toArray(), list.toArray());
	}

	@Test
	void testQuickSort_ArraySizeGreaterThanThree() {
		OrderDetails order1 = new OrderDetails("a", 123, 12.12);
		OrderDetails order2 = new OrderDetails("b", 234, 12.12);
		OrderDetails order3 = new OrderDetails("c", 321, 12.12);
		OrderDetails order4 = new OrderDetails("d", 123, 12.12);
		OrderDetails order5 = new OrderDetails("e", 234, 12.12);
		OrderDetails order6 = new OrderDetails("f", 321, 12.12);
		list.add(order3);
		list.add(order1);
		list.add(order2);
		list.add(order6);
		list.add(order4);
		list.add(order5);
		expected.add(order6);
		expected.add(order5);
		expected.add(order4);
		expected.add(order3);
		expected.add(order2);
		expected.add(order1);
		
		Display.quickSort(list, new NameComparator());
		
		assertArrayEquals(expected.toArray(), list.toArray());
	}
}
