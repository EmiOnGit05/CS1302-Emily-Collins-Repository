package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTotal {

	@Test
	void testGetTotal() {
		BillItem itemOne = new BillItem("Apple", 12.02);
		BillItem itemTwo = new BillItem("Orange", 12.6676);
		BillItem itemThree = new BillItem("Banana", 356.87);
		Bill bill = new Bill();
		bill.addItem(itemOne);
		bill.addItem(itemTwo);
		bill.addItem(itemThree);
		double total = BillCalculator.getTotal(bill.getItems());
		assertEquals(496.02487999999994, total);
	}
	
	@Test
	void testGetTotalOneItem() {
		BillItem itemOne = new BillItem("Apple", 12.02);
		Bill bill = new Bill();
		bill.addItem(itemOne);
		double total = BillCalculator.getTotal(bill.getItems());
		assertEquals(15.626, total);
	}
	
	@Test
	void testGetTotalNoItems() {
		Bill bill = new Bill();
		double total = BillCalculator.getTotal(bill.getItems());
		assertEquals(0.00, total);
	}

}
