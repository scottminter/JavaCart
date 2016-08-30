package test;

import cart.classes.*;
import static org.junit.Assert.*;
import org.junit.*;

public class OrderTest {

	private String desc = new String("AB description");
    private Float prc = new Float(4.32);
    private Item i1 = new Item(this.desc, this.prc);
    private int qnty = 2;

    /**
     * Tests both and size methods
     */
	@Test public void addAndSizeTest() {
		try {
		    OrderLine ol1 = new OrderLine(this.i1, this.qnty);
		    Order o1 = new Order();

		    // get size of order before adding order line
		    int presize = o1.size();

		    // add order line to the order
		    o1.add(ol1);

		    // get size of order after adding order line
		    int postsize = o1.size();

		    assertEquals(presize, 0);
		    assertEquals(postsize, 1);

		} catch (Exception e) {
			System.out.println("Exception thrown from class instantiation");
		}
	}

	/**
	 * Tests the get method
	 */
	@Test public void getTest() {
		try {
		    OrderLine ol2 = new OrderLine(this.i1, this.qnty);
		    Order o2 = new Order();

		    // add order line to the order
		    o2.add(ol2);

		    assertTrue(OrderLine.class.isInstance(o2.get(0)));

		} catch (Exception e) {
			System.out.println("Exception thrown from class instantiation");
		}
	}

	/**
	 * Tests the clear method
	 */
	@Test public void clearTest() {
		try {
		    OrderLine ol3 = new OrderLine(this.i1, this.qnty);
		    Order o3 = new Order();

		    // add order line to the order
		    o3.add(ol3);

		    // clear Order
		    o3.clear();

		    // get size after clear
		    int postsize = o3.size();

		    assertEquals(postsize, 0);

		} catch (Exception e) {
			System.out.println("Exception thrown from class instantiation");
		}
	}
}