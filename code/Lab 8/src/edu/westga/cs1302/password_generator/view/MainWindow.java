package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
	private Label errorTextLabel;
	@FXML
	private Button generatePasswordButton;
	@FXML
	private ListView<String> passwordsListView;
    
    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.passwordsListView.itemsProperty().bind(this.vm.getPasswords());
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	
    	this.setUpListenersForValidation();
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    }
    
    private void setUpListenersForValidation() {
    	this.minimumLength.textProperty().addListener((obs, oldValue, newValue) -> {
    		if (newValue != null) {
    			if (!newValue.matches("\\d+")) {
    				this.vm.setErrorText("Invalid minimum length. Please try again.");
    			} else {
    				this.vm.setErrorText("");
    			}
    		}
    	});
    }
}
