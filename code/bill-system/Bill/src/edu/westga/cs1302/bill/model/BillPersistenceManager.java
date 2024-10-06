package edu.westga.cs1302.bill.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Supports saving and loading bill data,
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class BillPersistenceManager {
	
	public static final String DATA_FILE = "data.txt";
	
	/** Save the bill!
	 * 
	 * Writes all bill data to DATA_FILE
	 * 
	 * @precondition bill != null
	 * @postcondition none
	 * 
	 * @param bill the bill to save
	 * @throws IOException 
	 */
	public static void saveBillData(Bill bill) throws IOException {
		try (FileWriter writer = new FileWriter(DATA_FILE)) {
			for (BillItem currItem : bill.getItems()) {
				writer.write(currItem.getName() + "," + currItem.getAmount() + System.lineSeparator());
			}
		}
	}

	/** Load the bill!
	 * 
	 * Reads from DATA_FILE
	 * File is assumed to use the same format as saveBillData
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the bill loaded
	 * @throws FileNotFoundException file at DATA_FILE location does not exist
	 * @throws IOException invalid name/amount found when trying to create a billitem
	 */
	public static Bill loadBillData() throws IOException, FileNotFoundException, NumberFormatException {
		Bill bill = new Bill();
		File inputFile = new File(DATA_FILE);
		try (Scanner reader = new Scanner(inputFile)) {
			for (int lineNumber = 1; reader.hasNextLine(); lineNumber++) {
				String strippedLine = reader.nextLine().strip();
				String[] tokens = strippedLine.split(",");
				try {
					String name = tokens[0];
					double amount = Double.parseDouble(tokens[1]);
					BillItem nextItem = new BillItem(name, amount);
					bill.addItem(nextItem);
				} catch (NumberFormatException numError) {
					throw new IOException(
							"Amount was not a valid number value! Error on line " + lineNumber + " : " + strippedLine);
				} catch (IllegalArgumentException studentDataError) {
					throw new IOException(
							"Unable to create bill item, bad name/amount on line " + lineNumber + " : " + strippedLine);
				} catch (IndexOutOfBoundsException studentDataError) {
					throw new IOException(
							"Missing either name and/or amount on line " + lineNumber + " : " + strippedLine);
				}
			}
		}
		return bill;
	}

}
