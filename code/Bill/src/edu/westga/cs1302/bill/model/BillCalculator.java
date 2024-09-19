package edu.westga.cs1302.bill.model;

public class BillCalculator {
	
	public static double getSubTotal(BillItem[] items) {
		double subTotal = 0.0;
		for (BillItem item : items) {
			if (item != null) {
				subTotal += item.getAmount();
			}
		}
		return subTotal;
	}
	
	public static double getTax(BillItem[] items) {
		return BillCalculator.getSubTotal(items) * 0.1;
	}
}
