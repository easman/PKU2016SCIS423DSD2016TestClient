package dsd2016.gui_old;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReturnPage_LIS extends Pane{
	public ImageView succeed = new ImageView("image/succeed.png");
	public ImageView Continue = new ImageView("image/Continue.png");
	public Text tx = new Text("Good! Your face matches with user account");
	ReturnPage_LIS(Stage stage){
		super();
		setVisible(false);
		setPadding(new Insets(0, 10, 0, 10));
		//setStyle("-fx-border-color:blue;-fx-border-width:5");
		
		Continue.setCursor(Cursor.HAND);
		Continue.setFitHeight(60);
		Continue.setFitWidth(200);
		
		succeed.setFitHeight(350);
		succeed.setFitWidth(350);
		
		getChildren().addAll(succeed,Continue,tx);
		tx.setX(85);
		tx.setY(90);
		tx.setFont(Font.font ("Verdana", 30));
		Continue.setX(305);
		Continue.setY(600);
		succeed.setX(230);
		succeed.setY(150);
	}
}

