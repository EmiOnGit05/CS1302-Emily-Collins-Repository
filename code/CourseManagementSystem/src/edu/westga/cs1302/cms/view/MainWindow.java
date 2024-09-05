package edu.westga.cs1302.cms.view;

import edu.westga.cs1302.cms.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/** Code behind for the MainWindow of the application
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
    @FXML private TextField name;
    @FXML private ListView<Student> students;
    @FXML private Label gradeLabel;
    @FXML private TextField gradeTextField;

    @FXML
    void addStudent(ActionEvent event) {
    	String studentName = this.name.getText();
    	int studentGrade = Integer.parseInt(this.gradeTextField.getText());
		try {
			Student student = new Student(studentName, studentGrade);
			this.students.getItems().add(student);
		} catch (NumberFormatException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + ex.getMessage() + "\nPlease reenter grade and try again.");
			errorPopup.showAndWait();
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(
					"Unable to create student: " + ex.getMessage() + "\nPlease reenter name and try again.");
			errorPopup.showAndWait();
		}
    }

    @FXML
    void removeStudent(ActionEvent event) {
    	Student student = this.students.getSelectionModel().getSelectedItem();
		if (student != null) {
			this.students.getItems().remove(student);
		} else {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("No student selected. Unable to remove.");
			errorPopup.showAndWait();
		}
    }

    @FXML
    void initialize() {
        assert this.name != null : "fx:id=\"name\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert this.students != null : "fx:id=\"students\" was not injected: check your FXML file 'MainWindow.fxml'.";
      
    }

}
