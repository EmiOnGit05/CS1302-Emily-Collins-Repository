package edu.westga.cs1302.bill.test.bill_persistence_manager;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.model.BillPersistenceManager;
import javafx.scene.control.Alert;

class TestSaveBillData {

	@Test
	void testSavesData() {
		BillItem itemOne = new BillItem("apple", 14.2);
		BillItem itemTwo = new BillItem("orange", 23.5);
		Bill bill = new Bill();
		bill.addItem(itemOne);
		bill.addItem(itemTwo);
		try {
			BillPersistenceManager.saveBillData(bill);
		} catch (IOException writeError) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Unable to save data to file!");
			alert.showAndWait();
		}
		Bill billTwo = new Bill();
		try {
			billTwo = BillPersistenceManager.loadBillData();
		} catch (IOException ex) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Unable to find file!");
			alert.showAndWait();
		}
		assertEquals("apple", billTwo.getItems()[0].getName());
		assertEquals("orange", billTwo.getItems()[1].getName());
		assertEquals(14.2, billTwo.getItems()[0].getAmount());
		assertEquals(23.5, billTwo.getItems()[1].getAmount());
	}

}
