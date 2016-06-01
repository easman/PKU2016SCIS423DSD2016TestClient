package dsd2016.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController implements Initializable {

	private mainController application;
	@FXML private TextField NewUserName;  
	@FXML private PasswordField NewPassword; 
	@FXML private Label label1;
	@FXML private Label label2;
	
	public void setApp(mainController application){  
		this.application = application;  
	}
	
	@FXML
	public void B_Back(ActionEvent event){
		application.gotoIndex();
	}
	
	@FXML
	public void B_Submit(ActionEvent event){
		application.NUN = NewUserName.getText();
		application.NPW = NewPassword.getText();
		//Judge whether the input is over 
		if(application.NUN.length() == 0 || application.NPW.length() == 0){
			label1.setVisible(true);
			label2.setVisible(false);
		}
		else{
			//Judge if the new user name already exists 
			if(storeController.userExist(application.NUN)){
				label2.setVisible(true);
				label1.setVisible(false);
			}
			else
				application.gotoGet8Pic();
		}
			
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
