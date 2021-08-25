package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import utils.Bacon;
import utils.Caesar;
import utils.Vigenere;

public class AppController implements Initializable {
	
	private String selectedMethod = "";
	private String key;
	private String plaintext = "";
	private String ciphertext;
	
	@FXML
	private ComboBox<String> methodBox = new ComboBox<String>();
	@FXML
	private TextArea preArea = new TextArea();
	@FXML
	private TextArea postArea = new TextArea();
	
	ObservableList<String> methods = FXCollections.observableArrayList("Bacon", "Caesar", "Vigenere");
	
	public AppController() {
	}
	
	/** Encrypts the given plaintext using the selected method.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void encryptSelected(ActionEvent event) throws IOException {
		plaintext = preArea.getText();
		switch(selectedMethod) {
			case "Bacon":	ciphertext = Bacon.encrypt(plaintext);
				break;
			case "Caesar":	ciphertext = Caesar.encrypt(plaintext);
				break;
			case "Vigenere":	ciphertext = Vigenere.encrypt(plaintext);
				break;
		}
		postArea.setText(ciphertext);
	}
	
	/** Decrypts the given ciphertext using the selected method.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void decryptSelected(ActionEvent event) throws IOException {
		ciphertext = preArea.getText();
		switch(selectedMethod) {
			case "Bacon":	plaintext = Bacon.decrypt(ciphertext);
				break;
			case "Caesar":	plaintext = Caesar.decrypt(ciphertext);
				break;
			case "Vigenere":	plaintext = Vigenere.decrypt(ciphertext);
				break;
		}
		postArea.setText(plaintext);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		methodBox.setItems(methods);
		methodBox.valueProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue ov, String oldVal, String newVal) {
				selectedMethod = newVal;
			}
		});
	}
	
	@FXML
	public void setDark(ActionEvent event) {
		Scene scene = App.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("/view/Dark.css").toExternalForm());
	}
	
	@FXML
	public void setTerminal(ActionEvent event) {
		Scene scene = App.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("/view/Terminal.css").toExternalForm());
	}
}
