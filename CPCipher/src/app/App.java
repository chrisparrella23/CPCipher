package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Bacon;
import utils.ROT13;

public class App extends Application {
	private static Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/AppView.fxml"));
			primaryStage.setTitle("CPCipher");
			scene = new Scene(root, 720, 300);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Scene getScene() {
		return scene;
	}

}
