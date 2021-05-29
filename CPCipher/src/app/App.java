package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	private static Scene scene;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("CPCipher");
//		BorderPane root = new BorderPane();
		primaryStage.show();
	}

}
