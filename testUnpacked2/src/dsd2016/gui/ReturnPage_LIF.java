package dsd2016.gui;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReturnPage_LIF extends Pane{
	public ImageView failed = new ImageView("image/failed.png");
	public ImageView back = new ImageView("image/Back.png");
	public StringBuilder outmsg = new StringBuilder("Error message:  ");
	public Text tx1 = new Text("Sorry! Your face dosen't match with user account");
	public Text tx2 = new Text(outmsg.toString());
	
	ReturnPage_LIF(Stage stage){
		super();
		setVisible(false);
		setPadding(new Insets(0, 10, 0, 10));
		//setStyle("-fx-border-color:blue;-fx-border-width:5");
		
		back.setCursor(Cursor.HAND);
		back.setFitHeight(60);
		back.setFitWidth(200);
		
		failed.setFitHeight(350);
		failed.setFitWidth(350);
		
		getChildren().addAll(failed,back,tx1,tx2);
		tx1.setX(30);
		tx1.setY(75);
		tx1.setFont(Font.font ("Verdana", 30));
		tx2.setX(10);
		tx2.setY(130);
		tx2.setFont(Font.font ("Verdana", 20));
		back.setX(305);
		back.setY(600);
		failed.setX(230);
		failed.setY(150);
	}


}
