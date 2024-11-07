package edu.westga.cs1302.password_generator.viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * The class view model.
 * 
 * @author Emi Collins
 * @version Fall 2024
 */
public class ViewModel {
	private BooleanProperty includeDigitsProperty;
	private BooleanProperty includeLowerCaseLettersProperty;
	private BooleanProperty includeUpperCaseLettersProperty;
	private StringProperty minimumLengthProperty;
	private StringProperty outputProperty;
	private PasswordGenerator generator;
	
	/**
	 * Constructor for ViewModel.
	 * 
	 * @precondition none
	 * @postcondition this.includeDigitsProperty = new SimpleBooleanProperty(false) &&
	 * this.includeLowerCaseLettersProperty = new SimpleBooleanProperty(false) &&
	 * this.includeUpperCaseLettersProperty = new SimpleBooleanProperty(false) && 
	 * this.minimumLengthProperty = new SimpleStringProperty() &&
	 * this.generator = new PasswordGenerator(randomNumberGenerator.nextLong())
	 */
	public ViewModel() {
		this.includeDigitsProperty = new SimpleBooleanProperty(false);
		this.includeLowerCaseLettersProperty = new SimpleBooleanProperty(false);
		this.includeUpperCaseLettersProperty = new SimpleBooleanProperty(false);
		this.minimumLengthProperty = new SimpleStringProperty();
		this.outputProperty = new SimpleStringProperty();
		Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
	}
	
    void generatePassword() {
    	int minimumLength = -1;
    	
    	try {
    		minimumLength = Integer.parseInt(this.minimumLengthProperty.getValue());
    	} catch (NumberFormatException numberError) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLengthProperty.getValue());
    		alert.show();
    		return;
    	}
    	
    	try {
    		this.generator.setMinimumLength(minimumLength);
    	} catch (IllegalArgumentException invalidLengthError) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Invalid Minimum Length: " + invalidLengthError.getMessage());
    		alert.show();
    		return;
    	}
    	
    	this.generator.setMustHaveAtLeastOneDigit(this.includeDigitsProperty.getValue());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.includeLowerCaseLettersProperty.getValue());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.includeUpperCaseLettersProperty.getValue());
    	
    	String password = this.generator.generatePassword();
    	
    	this.outputProperty.set(password);
    }

}
