package cart.classes;

/**
 * Represents an order line
 *
 * Order lines contains the @link Item and the quantity.
 */
public class OrderLine {

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
}