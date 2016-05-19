package dsd2016.gui;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Index  extends Pane{
	public ImageView cam = new ImageView("image/cam.png");
	public ImageView logIn = new ImageView("image/logIn.png");
	public ImageView SignUpNow = new ImageView("image/SignUpNow.png");
	public Text title = new Text("Java Testing Client");
	Index(Stage stage){
		super();
		setVisible(false);
		setPadding(new Insets(0, 10, 0, 10));
		logIn.setCursor(Cursor.HAND);
		logIn.setFitHeight(60);
		logIn.setFitWidth(200);
		SignUpNow.setCursor(Cursor.HAND);
		SignUpNow.setFitHeight(60);
		SignUpNow.setFitWidth(200);
		cam.setFitHeight(350);
		cam.setFitWidth(350);
		
		//setStyle("-fx-border-color:blue;-fx-border-width:5");
		
		getChildren().addAll(logIn,SignUpNow,cam,title);
		
		title.setX(200);
		title.setY(100);
		title.setFont(Font.font ("Verdana", 50));
		cam.setX(230);
		cam.setY(150);
		SignUpNow.setX(180);
		SignUpNow.setY(600);
		logIn.setX(430);
		logIn.setY(600);
		
		
	}
}
