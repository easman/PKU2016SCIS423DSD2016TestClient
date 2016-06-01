package dsd2016.gui_old;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NewUser extends Pane{
	public TextField userName = new TextField();
	public PasswordField userCode = new PasswordField();
	public Label tx = new Label("Please input your information");
	public Label tx1 = new Label("New User Name:");
	public Label tx2 = new Label("New Password :");
	public ImageView submit = new ImageView("image/Submit.png");
	public ImageView back = new ImageView("image/Back.png");
	public ImageView cam = new ImageView("image/cam.png");
	public ImageView top = new ImageView("image/Top.png");
	
	NewUser(Stage stage){
		super();
//		setWidth(800);
//		setHeight(800);
		setVisible(false);
		setPadding(new Insets(0, 10, 0, 10));
		setStyle("-fx-background-color:white");
		
		userName.prefHeight(29);
		userName.setPrefWidth(247);
		userCode.prefHeight(29);
		userCode.setPrefWidth(247);
		cam.setFitHeight(200);
		cam.setFitWidth(200);
		top.setFitHeight(97);
		top.setFitWidth(810);
		back.setCursor(Cursor.HAND);
		back.setFitHeight(39);
		back.setFitWidth(200);
		submit.setCursor(Cursor.HAND);
		submit.setFitHeight(39);
		submit.setFitWidth(200);
		
		getChildren().addAll(cam,back,submit,tx,tx1,tx2,userName,userCode,top);	
		tx.setLayoutX(120);
		tx.setLayoutY(339);
		tx.setFont(Font.font ("Verdana", 40));
		
		tx1.setLayoutX(169);
		tx1.setLayoutY(437);
		tx1.setFont(Font.font ("Verdana", 22));
		
		tx2.setLayoutX(169);
		tx2.setLayoutY(521);
		tx2.setFont(Font.font ("Verdana", 22));
		
		
		userName.setLayoutX(368);
		userName.setLayoutY(433);
		userName.setFont(Font.font ("Verdana", 22));
		userCode.setLayoutX(368);
		userCode.setLayoutY(513);
		userCode.setFont(Font.font ("Verdana", 22));
		cam.setX(306);
		cam.setY(125);
		top.setX(0);
		top.setY(0);
		back.setX(105);
		back.setY(610);
		submit.setX(509);
		submit.setY(610);
	}
	
	
	public String returnUserCode(){
		return userCode.getText();
	}
	
	public String returnUserName(){
		return userName.getText();
	}
	
}
