package edu.westga.cs1302.project3.view;

import java.io.File;
import java.io.IOException;

import edu.westga.cs1302.project3.model.Task;
import edu.westga.cs1302.project3.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/** Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
    private Button addTaskButton;

    @FXML
    private Button removeTaskButton;

    @FXML
    private ListView<Task> taskListView;
    
    @FXML
    private AnchorPane pane;
    
    @FXML
    private MenuItem fileLoadTasksMenuItem;

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem fileSaveTasksMenuItem;
    
    private ViewModel vm;
    
    @FXML
    public void initialize() {
    	this.vm = new ViewModel();
    	this.bindToViewModel();
    	this.setUpEventHandlers();
    }

	private void setUpEventHandlers() {
		this.fileLoadTasksMenuItem.setOnAction((event) -> {
			this.loadData();
		});
		
		this.fileSaveTasksMenuItem.setOnAction((event) -> {
			this.saveData();
		});
	}

	private void bindToViewModel() {
		this.taskListView.setItems(this.vm.getTaskList());
	}
    
	private void saveData() {
		FileChooser fileChooser = new FileChooser();
		Window owner = this.pane.getScene().getWindow();
		File selectedFile = fileChooser.showSaveDialog(owner);
		if (selectedFile != null) {
			try {
				this.vm.saveData(selectedFile);
			} catch (IOException exception) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to save to file! Please try again or select a different file!");
				alert.showAndWait();
			}
		}
	}
	
	private void loadData() {
		FileChooser fileChooser = new FileChooser();
		Window owner = this.pane.getScene().getWindow();
		File selectedFile = fileChooser.showOpenDialog(owner);
		if (selectedFile != null) {
			try {
				this.vm.loadData(selectedFile);
			} catch (IOException exception) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Unable to load from file! Please try again or select a different file!");
				alert.showAndWait();
			}
		}
	}
}
