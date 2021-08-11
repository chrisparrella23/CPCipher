package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	private static Scene scene;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("AppView.fxml"));
		primaryStage.setTitle("CPCipher");
		primaryStage.setScene(new Scene(root, 720, 300));
//		BorderPane root = new BorderPane();
		primaryStage.show();
	}

}
