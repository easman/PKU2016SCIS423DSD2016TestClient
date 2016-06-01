package dsd2016.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class IndexController implements Initializable {

	private mainController application;
	
	public void setApp(mainController application){  
		this.application = application;  
	}
	
	@FXML
	public void B_SignUpNow(ActionEvent event){
		application.gotoSignUp();
	}
	
	@FXML
	public void B_LogIn(ActionEvent event){
		application.gotoLogIn();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	

}
