package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private CheckBox mustIncludeDigits;
	@FXML
	private CheckBox mustIncludeLowerCaseLetters;
	@FXML
	private CheckBox mustIncludeUpperCaseLetters;
	@FXML
	private TextField minimumLength;
	@FXML
	private TextArea output;
	@FXML
	private Label errorLabel;
	@FXML
	private Button passwordButton;
	
	private ViewModel viewmodel;
    
    private void bindComponentsToViewModel() {
    	this.errorLabel.textProperty().bind(this.viewmodel.errorProperty());
    	this.minimumLength.textProperty().bindBidirectional(this.viewmodel.minimumLengthProperty());
    	this.mustIncludeDigits.selectedProperty().bindBidirectional(this.viewmodel.includeDigitsProperty());
    	this.mustIncludeLowerCaseLetters.selectedProperty().bindBidirectional(this.viewmodel.includeLowerCaseLettersProperty());
    	this.mustIncludeUpperCaseLetters.selectedProperty().bindBidirectional(this.viewmodel.includeUpperCaseLettersProperty());
    	this.output.textProperty().bind(this.viewmodel.outputProperty());
    }

    @FXML
    void initialize() {
        assert this.mustIncludeDigits != null : "fx:id=\"mustIncludeDigits\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeLowerCaseLetters != null : "fx:id=\"mustIncludeLowerCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.mustIncludeUpperCaseLetters != null : "fx:id=\"mustIncludeUpperCaseLetters\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.minimumLength != null : "fx:id=\"minimumLength\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.output != null : "fx:id=\"output\" was not injected: check your FXML file 'MainWindow.fxml'.";

        this.minimumLength.setText("1");
        this.viewmodel = new ViewModel();
        this.bindComponentsToViewModel();
        this.passwordButton.setOnAction((event) -> {
        	this.viewmodel.generatePassword(); });
    }
}
