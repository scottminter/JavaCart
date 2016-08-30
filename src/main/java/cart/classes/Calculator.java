package cart.classes;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Calculates and diplays the totals for the order
 */
public class Calculator {

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