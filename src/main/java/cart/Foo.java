package cart;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.text.DecimalFormat;

/* ****************************************************************************************
 
Please remove all bugs from the code below to get the following output:

<pre>

*******Order 1*******
1 book: 13.74
1 music CD: 16.49
1 chocolate bar: 0.94
Sales Tax: 2.84
Total: 28.33
*******Order 2*******
1 imported box of chocolate: 11.5
1 imported bottle of perfume: 54.62
Sales Tax: 8.62
Total: 57.5
*******Order 3*******
1 Imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 10.73
1 box of imported chocolates: 12.94
Sales Tax: 8.77
Total: 67.98
Sum of orders: 153.81
 
</pre>
 
******************************************************************************************** */

/**
 * Represents an item
 *
 * Contains a description and price of the item
 */
class Item {

	private String description;
	private float price;

	/**
	 * Constructor
	 *
	 * @param description Description of the item
	 * @param price Price of the item
	 */
	public Item(String description, float price) {
		this.description = description;
		this.price = price;
	}

	/**
	 * Returns the item's description
	 *
	 * @return String Description of item
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the item's price
	 *
	 * @return float Price of the item
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * TODO: Remove this method
	 */
	public String toString() {
		return "Description: " + this.getDescription() + ", Price: $" + this.getPrice(); 
	}
}


/**
 * Represents an order line
 *
 * Order lines contains the @link Item and the quantity.
 */
class OrderLine {

	private Item item;
	private int quantity;

	/**
	 * Constructor
	 *
	 * @param item Item of the order 
	 * @param quantity Quantity of the item
	 */
	public OrderLine(Item item, int quantity) throws Exception {
		// Make sure both are set properly and throw exceptions if not
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		} else if (quantity <= 0) {
			System.err.println("ERROR - Quantity must be greater than 0");
			throw new Exception("Quantity is less than 0");
		}

		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * Returns the item object
	 *
	 * @return Item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Returns the quantity
	 *
	 * @return int 
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * TODO: Remove this
	 */
	public String toString() {
		return "Quantity: " + this.getQuantity() + ", " + this.getItem().toString();
	}
}

/**
 * Represents a customers order
 *
 * Contains a list of the items customer ordered
 */
class Order {

	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	/**
	 * Adds a new order line to the order list
	 *
	 * @param o Represents a new item that's been ordered
	 */
	public void add(OrderLine o) throws Exception {
		// if nothing is passed in then throw exception
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}

		this.orderLines.add(o);
	}

	/**
	 * Returns the size of the order
	 *
	 * @return int Order size
	 */
	public int size() {
		return this.orderLines.size();
	}

	/**
	 * Returns a line item from the order at a specific location
	 *
	 * @param i The line item to return
	 *
	 * @return OrderLine Order line item at a specific location
	 */
	public OrderLine get(int i) {
		return this.orderLines.get(i);
	}

	/**
	 * Empties out an order
	 */
	public void clear() {
		this.orderLines.clear();
	}

	/**
	 * Displays Data in List
	 */
	public void display() {
		for(int i = 0; i < this.size(); i++) {
			System.out.println(this.get(i).toString());
		}
	}
}

/**
 * Calculates and diplays the totals for the order
 */
class Calculator {

	/**
	 * Constructor
	 */
	public Calculator(){}

	/**
	 * Receives a collection of orders and calculates and displays data. 
	 * 
	 * For each order, iterates on the order lines and calculate the total 
	 * price which is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total price without taxes and total taxes paid
	 * for this order
	 *
	 * @param Map Containing ordered items
	 */
	public void calculate(Map<String, Order> o) {
		double grandtotal = 0;

		// Set up string formatting for price
		String pattern = "##0.0#";
		DecimalFormat df = new DecimalFormat(pattern);

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {
				//System.out.println(r.get(i).toString());
				
				// Calculate the taxes
				double tax = 0;

				if (r.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					// Extra 5% tax on imported items
					tax = r.get(i).getItem().getPrice() * 0.15;
				} else {
					tax = r.get(i).getItem().getPrice() * 0.10;
				}
				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() + tax;

				// Print out the item's total price
				System.out.println(r.get(i).getQuantity() + " " + r.get(i).getItem().getDescription() + ": " + df.format(totalprice));

				// Keep a running total
				totalTax += tax;
				total += r.get(i).getItem().getPrice();
				
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + df.format(totalTax));

			// Print out the total amount
			System.out.println("Total: " + df.format(total));
			
			// keep track of the grand total
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + df.format(grandtotal));
	}
}


public class Foo {

	public static void main(String[] args) throws Exception {

		Map<String, Order> o = new LinkedHashMap<String, Order>();

		// Instantiate a new order
		Order cart = new Order();
		cart.add(new OrderLine(new Item("book", (float) 12.49), 1));
		cart.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		cart.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", cart);
		cart = null;

		// Reinstantiate the Cart
		cart = new Order();
		cart.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		cart.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", cart);
		cart = null;

		// Reinstantiate the Cart
		cart = new Order();
		cart.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		cart.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		cart.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		cart.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		o.put("Order 3", cart);

		Calculator calc = new Calculator();
		calc.calculate(o);
	}
}
