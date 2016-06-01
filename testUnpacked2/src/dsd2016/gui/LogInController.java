package dsd2016.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController implements Initializable {

	private mainController application;
	private StringBuilder IDcode = new StringBuilder();
	@FXML private TextField UserName;  
	@FXML private PasswordField Password; 
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
		application.UN = UserName.getText();
		application.PW = Password.getText();
		if(application.UN.length() == 0 || application.PW.length() == 0){
			label2.setVisible(true);
			label1.setVisible(false);
		}
		else{
			if(storeController.returnID(application.UN, application.PW, IDcode) != 1){
				label1.setVisible(true);
				label2.setVisible(false);
				
			}
			else{
				application.ID = IDcode.toString();
				application.gotoGet1Pic();}
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
