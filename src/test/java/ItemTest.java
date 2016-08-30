package test;

import cart.classes.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * Tests for the Item class
 */ 
public class ItemTest {
 	
 	private String desc = new String("some description");
 	private Float prc = new Float(3.25);
 	private Item i1 = new Item(this.desc, this.prc);

 	/**
 	 * Tests the getDescription method
 	 */
    @Test public void getDescriptionTest() {
    	String description = this.i1.getDescription();
        assertEquals(description, this.desc);
    }
 
 	/**
 	 * Tests the getPrice method
 	 */
 	@Test public void getPriceTest() {
 		Float price = this.i1.getPrice();
 		assertEquals(price, this.prc);
 	}    
}