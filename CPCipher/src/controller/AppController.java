package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class AppController {
	
	@FXML
	private ObservableList<String> methods;
	@FXML
	private ComboBox<String> methodBox = new ComboBox<>();
	
	public AppController() {
		methods = FXCollections.observableArrayList("Caesar", "Vigenere");
		methodBox.setItems(methods);
	}
}
