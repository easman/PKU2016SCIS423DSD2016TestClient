package dsd2016.gui_old;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReturnPage_SUS extends Pane{
	public ImageView succeed = new ImageView("image/succeed.png");
	public ImageView logIn = new ImageView("image/logIn.png");
	public StringBuilder outmsg = new StringBuilder("Your ID is ");

	public Text tx1 = new Text("Your account has been created sucessfully");
	public Text tx2 = new Text(outmsg.toString());
	ReturnPage_SUS(Stage stage){
		super();
		setVisible(false);
		setPadding(new Insets(0, 10, 0, 10));
		//setStyle("-fx-border-color:blue;-fx-border-width:5");
		
		logIn.setCursor(Cursor.HAND);
		logIn.setFitHeight(60);
		logIn.setFitWidth(200);
		
		succeed.setFitHeight(350);
		succeed.setFitWidth(350);
		
		getChildren().addAll(succeed,logIn,tx1,tx2);
		tx1.setX(103);
		tx1.setY(75);
		tx1.setFont(Font.font ("Verdana", 30));
		tx2.setX(250);
		tx2.setY(130);
		tx2.setFont(Font.font ("Verdana", 30));
		
		logIn.setX(305);
		logIn.setY(600);
		succeed.setX(230);
		succeed.setY(150);
	}
}
