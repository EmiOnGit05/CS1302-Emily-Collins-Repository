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
	
	public static double getTip(BillItem[] items) {
		return BillCalculator.getSubTotal(items) * 0.2;
	}
	
	public static double getTotal(BillItem[] items) {
		return BillCalculator.getSubTotal(items) + BillCalculator.getTax(items) + BillCalculator.getTip(items);
	}
}
