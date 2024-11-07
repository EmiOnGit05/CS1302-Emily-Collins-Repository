package edu.westga.cs1302.password_generator.viewmodel;

import java.util.Random;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
	private StringProperty errorProperty;
	private PasswordGenerator generator;
	
	/**
	 * Constructor for ViewModel.
	 * 
	 * @precondition none
	 * @postcondition this.includeDigitsProperty = new SimpleBooleanProperty(false)
	 *                && this.includeLowerCaseLettersProperty = new
	 *                SimpleBooleanProperty(false) &&
	 *                this.includeUpperCaseLettersProperty = new
	 *                SimpleBooleanProperty(false) && this.minimumLengthProperty =
	 *                new SimpleStringProperty() && this.generator = new
	 *                PasswordGenerator(randomNumberGenerator.nextLong()) &&
	 *                this.errorProperty = new SimpleStringProperty()
	 */
	public ViewModel() {
		this.includeDigitsProperty = new SimpleBooleanProperty(false);
		this.includeLowerCaseLettersProperty = new SimpleBooleanProperty(false);
		this.includeUpperCaseLettersProperty = new SimpleBooleanProperty(false);
		this.minimumLengthProperty = new SimpleStringProperty();
		this.outputProperty = new SimpleStringProperty();
		Random randomNumberGenerator = new Random();
        this.generator = new PasswordGenerator(randomNumberGenerator.nextLong());
        this.errorProperty = new SimpleStringProperty();
	}
	
	/**
	 * Getter for this.includeDigitsProperty
	 * @return this.includeDigitsProperty
	 */
	public BooleanProperty includeDigitsProperty() {
		return this.includeDigitsProperty;
	}
	
	/**
	 * Getter for this.includeLowerCaseLettersProperty
	 * @return this.includeLowerCaseLettersProperty
	 */
	public BooleanProperty includeLowerCaseLettersProperty() {
		return this.includeLowerCaseLettersProperty;
	}
	
	/**
	 * Getter for this.includeUpperCaseLettersProperty
	 * @return this.includeUpperCaseLettersProperty
	 */
	public BooleanProperty includeUpperCaseLettersProperty() {
		return this.includeUpperCaseLettersProperty;
	}
	
	/**
	 * Getter for this.minimumLengthProperty
	 * @return this.minimumLengthProperty
	 */
	public StringProperty minimumLengthProperty() {
		return this.minimumLengthProperty;
	}
	
	/**
	 * Getter for this.outputProperty
	 * @return this.outputProperty
	 */
	public StringProperty outputProperty() {
		return this.outputProperty;
	}
	
	/**
	 * Getter for this.errorProperty
	 * @return this.errorProperty
	 */
	public StringProperty errorProperty() {
		return this.errorProperty;
	}

    /**
	 * Generates a password.
	 * 
	 * @throws NumberFormatException - exception for parsing the minimumLength value
	 *                               && IllegalArgumentException - exception for if
	 *                               settingMinimumLength() goes wrong
	 * 
	 */
    public void generatePassword() {
    	int minimumLength = -1;
    	
    	try {
    		minimumLength = Integer.parseInt(this.minimumLengthProperty.getValue());
    		this.errorProperty.set("");
    	} catch (NumberFormatException numberError) {
    		this.errorProperty.set("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLengthProperty.getValue());
    		return;
    	}
    	
    	try {
    		this.generator.setMinimumLength(minimumLength);
    		this.errorProperty.set("");
    	} catch (IllegalArgumentException invalidLengthError) {
    		this.errorProperty.set("Invalid Minimum Length: " + invalidLengthError.getMessage());
    		return;
    	}
    	
    	this.generator.setMustHaveAtLeastOneDigit(this.includeDigitsProperty.getValue());
    	this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.includeLowerCaseLettersProperty.getValue());
    	this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.includeUpperCaseLettersProperty.getValue());
    	
    	String password = this.generator.generatePassword();
    	
    	this.outputProperty.set(password);
    }

}
