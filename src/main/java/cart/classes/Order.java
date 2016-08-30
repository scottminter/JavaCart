package cart.classes;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a customers order
 *
 * Contains a list of the items customer ordered
 */
public class Order {

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