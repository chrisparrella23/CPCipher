package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.App;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileHelper {
	public static void save(TextArea theArea) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		File file = fc.showSaveDialog(null);
		if (file != null) {
			saveFile(theArea.getText(), file);
		}
	}
	
	public static void saveFile(String content, File file) {
		try {
			FileWriter fw = null;
			fw = new FileWriter(file);
			fw.write(content);
			fw.close();
		} catch (IOException e) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public static void open(TextArea theArea, File file) {
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		Scanner fileScan = new Scanner((Readable) new BufferedReader(fr));
		while (fileScan.hasNextLine()) {
			sb.append(fileScan.nextLine() + "\n");
		}
		fileScan.close();
		theArea.setText(sb.toString());
	}
}
