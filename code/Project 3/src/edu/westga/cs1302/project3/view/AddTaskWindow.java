package edu.westga.cs1302.project3.view;

import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

/** Codebehind for the Add Task Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class AddTaskWindow {
	@FXML
    private Button addTaskButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField titleTextField;
    
	public void bindToVM(ViewModel vm) {
		vm.getTaskTitle().bind(this.titleTextField.textProperty());
		vm.getTaskDescription().bind(this.descriptionTextArea.textProperty());
		
		this.cancelButton.setOnAction((event) -> {
			this.pane.getScene().getWindow().hide();
		});
		
		this.addTaskButton.setOnAction((event) -> {
			try {
				vm.addTask();
				this.pane.getScene().getWindow().hide();
			} catch (NullPointerException nullError) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText(nullError.getMessage());
				alert.showAndWait();
			}
		});
	}
}
