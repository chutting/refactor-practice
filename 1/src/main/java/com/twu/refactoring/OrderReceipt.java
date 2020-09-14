package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;
    private final String HEADER = "======Printing Orders======\n";
    private final String TAX_PROMPT = "Sales Tax";
		private final String TOTAL_PROMPT = "Total Amount";


	public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append(HEADER);

		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());

		double totalSalesTax = 0d;
		double total = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(addTabAfterString(lineItem.getDescription()))
					.append(addTabAfterString(String.valueOf(lineItem.getPrice())))
					.append(addTabAfterString(String.valueOf(lineItem.getQuantity())))
					.append(lineItem.totalAmount())
					.append('\n');

			double salesTax = lineItem.totalAmount() * 0.10;
			totalSalesTax += salesTax;

			total += lineItem.totalAmount() + salesTax;
		}

		output.append(addTabAfterString(TAX_PROMPT)).append(totalSalesTax);

		output.append(addTabAfterString(TOTAL_PROMPT)).append(total);
		return output.toString();
	}

	private StringBuilder addTabAfterString(String string) {
		return new StringBuilder(string).append('\t');
	}


}