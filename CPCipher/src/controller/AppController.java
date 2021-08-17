package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import utils.Caesar;
import utils.Vigenere;

public class AppController implements Initializable {
	
	private String selectedMethod;
	
	@FXML
	private ComboBox<String> methodBox;
	
	@FXML
	private TextArea preArea;
	@FXML
	private TextArea postTextArea;
	
	ObservableList<String> methods = FXCollections.observableArrayList("Caesar", "Vigenere");
	
	public AppController() {
		methodBox.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue ov, String oldVal, String newVal) {
				selectedMethod = newVal;
			}
		});
		
//		methodBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//			public void changed(ObservableValue ov, String oldVal, String newVal) {
//				
//			}
//		});
	}
	
//	@FXML
//	private void encryptSelected(String selectedMethod, String plaintext, String key) {
//		String plaintext = preArea.getText();
//		String key = 
//		switch(selectedMethod) {
//			case "Caesar":	Caesar.encrypt(plaintext, Integer.parseInt(key));
//				break;
//			case "Vigenere":	Vigenere.encrypt(plaintext, key);
//				break;
//		}
//	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		methodBox.setItems(methods);
	}
}
