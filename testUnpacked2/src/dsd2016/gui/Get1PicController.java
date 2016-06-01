package dsd2016.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.binary.Base64;

import dsd2016.api.DSD2016JAVA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class Get1PicController implements Initializable {

	private mainController application;
	private String inB64Pic = new String();
	private StringBuilder outmsg = new StringBuilder();
	private static int errorCode_L;
	
	
	@FXML private ImageView imageCur;
	
	public void setApp(mainController application){  
		this.application = application;  
	}
	
	@FXML
	public void B_Back(ActionEvent event){
		application.gotoLogIn();
	}
	
	@FXML
	public void B_Upload(ActionEvent event){
		errorCode_L = DSD2016JAVA.validateUser(application.ID,inB64Pic,outmsg); 
		if(errorCode_L == 1){
			application.gotoReturnLIS();
		}
		else
			application.gotoReturnLIF();
	}
	
	@FXML
	public void B_Shot(ActionEvent event){
		get1Pic();
	}
	
	public static int getErrorCode(){
		return errorCode_L;
	}
	
	public void get1Pic(){
		FileChooser fileChooser = new FileChooser();	
		File file = fileChooser.showOpenDialog(application.getStage());
		if(file==null) return;
		imageCur.setImage(new Image("file:///"+file.getPath()));
		
        InputStream in = null;  
        byte[] data = null;  
        try   
        {  
            in = new FileInputStream(file);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
            inB64Pic = Base64.encodeBase64String(data);
            
	    }    
        catch (IOException ex)   
        {  
            ex.printStackTrace();  
        } 
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
