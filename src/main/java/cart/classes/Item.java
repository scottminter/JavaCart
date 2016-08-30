package cart.classes;

/**
 * Represents an item
 *
 * Contains a description and price of the item
 */
public class Item {

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
}