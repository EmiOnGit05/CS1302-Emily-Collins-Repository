package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
	private Label errorTextLabel;
	@FXML
	private Button generatePasswordButton;
	@FXML
	private MenuItem fileAboutMenuItem;

	@FXML
	private MenuItem fileCloseMenuItem;

	@FXML
	private Menu fileMenu;
	@FXML
    private AnchorPane guiPane;

	private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.output.textProperty().bind(this.vm.getPassword());
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    	
		this.fileAboutMenuItem.setOnAction((event) -> {
			this.actionAbout();
		});
		
		this.fileCloseMenuItem.setOnAction((event) -> {
			this.actionClose();
		});
	}
    
    /**
     * Sends an informative alert about the application.
     * 
     * @preconditions none
     * @postconditions none
     */
    public void actionAbout() {
    	Alert popup = new Alert(AlertType.INFORMATION);
    	popup.setContentText("This project uses input from the user to generate a random password and store it in a list.");
    	popup.setTitle("Emi Collins");
    	popup.showAndWait();
    }
    
    /**
     * Closes the application.
     * 
     * @precondition none
     * @postcondition window is closed
     */
    public void actionClose() {
    	this.guiPane.getScene().getWindow().hide();
    	
    }
}
