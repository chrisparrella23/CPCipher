package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class AppController implements Initializable {
	
	@FXML
	private ComboBox<String> methodBox;
	
	ObservableList<String> methods = FXCollections.observableArrayList("Caesar", "Vigenere");
	
	public AppController() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		methodBox.setItems(methods);
	}
}
