package test;

import cart.classes.*;
import static org.junit.Assert.*;
import org.junit.*;

public class OrderLineTest {

	private String desc = new String("AB description");
    private Float prc = new Float(4.32);
    private Item i1 = new Item(this.desc, this.prc);
    private int qnty = 2;


	/**
 	 * Tests the getItem method
 	 */
    @Test public void getItemTest() {
    	try {
		    OrderLine ol1 = new OrderLine(this.i1, this.qnty);
		    assertTrue(Item.class.isInstance(ol1.getItem()));

		} catch (Exception e) {
			System.out.println("Exception thrown from OrderLine instantiation");
		}
    }

    /**
     * Tests the getQuantity method
     */
    @Test public void getQuantityTest() {
    	try {
		    OrderLine ol1 = new OrderLine(this.i1, this.qnty);
		   	assertEquals(ol1.getQuantity(), this.qnty);

		} catch (Exception e) {
			System.out.println("Exception thrown from OrderLine instantiation");
		}
    }
}