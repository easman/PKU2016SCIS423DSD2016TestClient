package testUnpacked;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InputID extends Pane{
	public TextField IDinput = new TextField();
	public Text tx = new Text("Please input your ID");
	public ImageView cam = new ImageView("image/cam.png");
	public ImageView submit = new ImageView("image/Submit.png");
	public ImageView back = new ImageView("image/Back.png");
	
	InputID(Stage stage){
		super();
		setVisible(false);
		setPadding(new Insets(0, 10, 0, 10));
		//setStyle("-fx-border-color:blue;-fx-border-width:5");
		
		cam.setFitHeight(350);
		cam.setFitWidth(350);
		IDinput.prefHeight(73);
		IDinput.setPrefWidth(221);
		back.setCursor(Cursor.HAND);
		back.setFitHeight(60);
		back.setFitWidth(200);
		submit.setCursor(Cursor.HAND);
		submit.setFitHeight(60);
		submit.setFitWidth(200);
		
		getChildren().addAll(cam,IDinput,back,submit,tx);	
		tx.setX(207);
		tx.setY(440);
		tx.setFont(Font.font ("Verdana", 40));
		IDinput.setLayoutX(297);
		IDinput.setLayoutY(491);
		IDinput.setFont(Font.font ("Verdana", 30));
		cam.setX(223);
		cam.setY(42);
		back.setX(180);
		back.setY(600);
		submit.setX(430);
		submit.setY(600);
	}
	
	
	public String returnIDinput(){
		return IDinput.getText();
	}
}
