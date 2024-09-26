package edu.westga.cs1302.emilycollinsproject1.view;

import edu.westga.cs1302.emilycollinsproject1.model.Food;
import edu.westga.cs1302.emilycollinsproject1.model.FoodType;
import edu.westga.cs1302.emilycollinsproject1.utilities.Utilities;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/** Codebehind for the Main Window of the application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
	@FXML
	private Label pantryLabel;
	
	@FXML
	private Label foodNameLabel;

	@FXML
	private Label foodTypeLabel;
	
	@FXML
    private Label quantityLabel;
	
	@FXML
	private ListView<Food> pantryListView;
	
	@FXML
	private ComboBox<FoodType> foodTypeComboBox;
	
	@FXML
	private TextField foodNameTextField;
	
	@FXML
    private TextField quantityTextField;

	@FXML
	private Button addFoodButton;
	
	@FXML
    private Button decreaseQuantityButton;
	
	@FXML
    private Button increaseQuantityButton;
	
	@FXML
    private Button deleteFoodButton;
	
	@FXML
    private Button viewTotalQuantityButton;
	
	@FXML
    private Button editQuantityButton;
	
	/**
	 * Constructor for MainWindow.
	 * 
	 * @postcondition this.foodTypeComboBox is initialized
	 */
	public MainWindow() {
		this.foodTypeComboBox = new ComboBox<FoodType>();
	}
	
	/**
	 * Adds food object if not existing, otherwise adjusts quantity. 
	 * 
	 * @precondition this.foodNameTextField.getText() != null && this.foodTypeComboBox.getValue() != null
	 * @postcondition Pantry contains new food item, or existing food items quantity increases.
	 * @param event event that triggered method
	 * @throws IllegalArgumentException - throws from Food class if either field is null
	 */
	@FXML
	public void addFood(ActionEvent event) {
		try {
			Food food = new Food(this.foodNameTextField.getText(), this.foodTypeComboBox.getValue());
			if (this.checkFood(food) == -1) {
				food.increaseQuantity();
				this.pantryListView.getItems().add(food);
				this.pantryListView.refresh();
			} else {
				this.pantryListView.getItems().get(this.checkFood(food)).increaseQuantity();
				this.pantryListView.refresh();
			}
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		}
	}
	
	/**
	 * Sets quantity of a food object from what the user put into quantity text field.
	 * 
	 * @precondition this.quantityTextField.getText() != null
	 * @postcondition - selected food object will have updated quantity
	 * @param event - editQuantityButton triggered
	 * @throws IllegalArgumentException if parsing does not work correctly or NullPointerException if fields are null
	 */
	@FXML
	public void setQuantity(ActionEvent event) {
		try {
			this.pantryListView.getSelectionModel().getSelectedItem().setQuantity(Integer.parseInt(this.quantityTextField.getText().trim()));
			this.pantryListView.refresh();
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Fields cannot be empty, please try again.");
			errorPopup.showAndWait();
		}
	}
	
	/**
	 * Increases the quantity of a food object by 1.
	 * 
	 * @precondition this.pantryListView.getSelectionModel().getSelectedItem() != null
	 * @postcondition this.pantryListView.getSelectionModel().getSelectedItem().getQuantity += 1
	 * @param event increaseQuantityButton triggered
	 * @throws IllegalArgumentException or NullPointerException if selected item is null
	 */
	@FXML 
	public void increaseQuantity(ActionEvent event) {
		try {
			this.pantryListView.getSelectionModel().getSelectedItem().increaseQuantity();
			this.pantryListView.refresh();
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Fields cannot be empty, please try again.");
			errorPopup.showAndWait();
		}
	}
	
	/**
	 * Decreases the quantity of a food object by 1.
	 * 
	 * @precondition this.pantryListView.getSelectionModel().getSelectedItem() != null
	 * @postcondition this.pantryListView.getSelectionModel().getSelectedItem().getQuantity -= 1
	 * @param event decreaseQuantityButton triggered
	 * @throws IllegalArgumentException or NullPointerException if selected item is null
	 */
	@FXML 
	public void decreaseQuantity(ActionEvent event) {
		try {
			this.pantryListView.getSelectionModel().getSelectedItem().decreaseQuantity();
			this.pantryListView.refresh();
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Fields cannot be empty, please try again.");
			errorPopup.showAndWait();
		}
	}
	
	/**
	 * Removes selected food from the pantry.
	 * 
	 * @precondition this.pantryListView.getSelectionModel().getSelectedItem() != null
	 * @postcondition pantry no longer contains selected food object
	 * @param event deleteFoodButton triggered
	 * @throws IllegalArgumentException or NullPointerException if selected item is null
	 */
	@FXML
	public void removeFood(ActionEvent event) {
		try {
			this.pantryListView.getItems().remove(this.pantryListView.getSelectionModel().getSelectedItem());
			this.pantryListView.refresh();
		} catch (IllegalArgumentException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText(ex.getMessage() + " Please try again.");
			errorPopup.showAndWait();
		} catch (NullPointerException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Please select a food and try again.");
			errorPopup.showAndWait();
		}
	}
	
	/**
	 * Gets the total quantity of all the food objects in the pantry.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @param event viewTotalQuantityButton triggered
	 * @throws NullPointerException if pantry is null
	 */
	@FXML
	public void getTotalQuantity(ActionEvent event) {
		try {
			int sum = Utilities.findSum(this.pantryListView.getItems());
			Alert infoPopup = new Alert(Alert.AlertType.INFORMATION);
			infoPopup.setContentText("Total quantity of food in pantry: " + sum);
			infoPopup.showAndWait();
		} catch (NullPointerException ex) {
			Alert errorPopup = new Alert(Alert.AlertType.ERROR);
			errorPopup.setContentText("Information is empty/unavailable.");
			errorPopup.showAndWait();
		}
	}
	
	/**
	 * Initialize method
	 */
	@FXML
	public void initialize() {
		this.foodTypeComboBox.setItems((FXCollections.observableArrayList(FoodType.values())));
	}
	
	/**
	 * Checks the pantry if food object is already in pantry, and if so, returns the index of the object
	 * 
	 * @precondition food != null
	 * @postcondition none
	 * @param food the food being checked for
	 * @return returns -1 if food was not found in pantry, returns the index if food was found
	 * @throws IllegalArgumentException if food is null or invalid
	 */
	private int checkFood(Food food) {
		if (food == null) {
			throw new IllegalArgumentException("Food is invalid, please try again.");
		}
		for (Food currFood : this.pantryListView.getItems()) {
			if (currFood.equals(food)) {
				return this.pantryListView.getItems().indexOf(currFood);
			}
		}
		return -1;
	}
}
