package dsd2016.gui_old;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class test extends Application{
	
	public void start(Stage primaryStage) {
		Pane basePane = new Pane();
		ReturnPage_LIF ex = new ReturnPage_LIF(primaryStage);
		basePane.getChildren().addAll(ex);
		ex.setVisible(true);
		
		Scene scene = new Scene(basePane,800,800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Face auth");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
