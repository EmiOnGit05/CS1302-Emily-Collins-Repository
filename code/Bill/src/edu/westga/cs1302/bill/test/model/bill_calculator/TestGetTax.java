package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTax {

	@Test
	void testGetTax() {
		BillItem itemOne = new BillItem("Apple", 12.02);
		BillItem itemTwo = new BillItem("Orange", 12.6676);
		BillItem itemThree = new BillItem("Banana", 356.87);
		Bill bill = new Bill();
		bill.addItem(itemOne);
		bill.addItem(itemTwo);
		bill.addItem(itemThree);
		double tax = BillCalculator.getTax(bill.getItems());
		assertEquals(38.15576, tax);
	}
	
	@Test
	void testGetTaxOneItem() {
		BillItem itemOne = new BillItem("Apple", 12.02);
		Bill bill = new Bill();
		bill.addItem(itemOne);
		double tax = BillCalculator.getTax(bill.getItems());
		assertEquals(1.202, tax);
	}
	
	@Test
	void testGetTaxNoItems() {
		Bill bill = new Bill();
		double tax = BillCalculator.getTax(bill.getItems());
		assertEquals(0.00, tax);
	}

}
