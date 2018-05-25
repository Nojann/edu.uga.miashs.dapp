package main.java.edu.uga.miashs.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		DappCore app = new DappCore(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
