package edu.westga.cs1302.bill.model;

import java.util.Comparator;

/**
 * Class for comparing bill's cost in an descending order.
 * 
 * @author Emily Collins
 * @version Fall 2024
 */
public class BillDescendingCostComparator implements Comparator<BillItem> {

	@Override
	public int compare(BillItem itemOne, BillItem itemTwo) {
		if (itemOne.getAmount() < itemTwo.getAmount()) {
			return 1;
		} else if (itemOne.getAmount() < itemTwo.getAmount()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Descending";
	}

}
