package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetSubtotal {

	@Test
	void testGetSubtotal() {
		BillItem itemOne = new BillItem("Apple", 12.02);
		BillItem itemTwo = new BillItem("Orange", 12.6676);
		BillItem itemThree = new BillItem("Banana", 356.87);
		Bill bill = new Bill();
		bill.addItem(itemOne);
		bill.addItem(itemTwo);
		bill.addItem(itemThree);
		double subtotal = BillCalculator.getSubTotal(bill.getItems());
		assertEquals(381.5576, subtotal);
	}

}
