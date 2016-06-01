package dsd2016.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ReturnSUFController implements Initializable {

	@FXML private Label label_0;
	@FXML private Label label_1;
	@FXML private Label label_2;
	
	private mainController application;
	
	public void setApp(mainController application){  
		this.application = application;  
	}
	
	public void showError(){
		if(Get8PicController.getErrorCode() == 0){
			label_0.setVisible(true);
			label_1.setVisible(false);
			label_2.setVisible(false);	
		}
		else if(Get8PicController.getErrorCode() == -1){
			label_1.setVisible(true);
			label_0.setVisible(false);
			label_2.setVisible(false);	
		}
		else if(Get8PicController.getErrorCode() == -2){
			label_2.setVisible(true);
			label_1.setVisible(false);
			label_0.setVisible(false);		
		}
	}
	
	@FXML
	public void B_Reupload(ActionEvent event){
		application.gotoGet8Pic();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
