package dsd2016.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.codec.binary.Base64;

import dsd2016.api.DSD2016JAVA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class Get8PicController implements Initializable {

	@FXML private ImageView imageCur0;
	@FXML private ImageView imageCur1;
	@FXML private ImageView imageCur2;
	@FXML private ImageView imageCur3;
	@FXML private ImageView imageCur4;
	@FXML private ImageView imageCur5;
	@FXML private ImageView imageCur6;
	@FXML private ImageView imageCur7;
	@FXML private ImageView imageCur;
	private int emptyImage = 0;
	private mainController application;
	private ArrayList<String> inB64Pics = new ArrayList<>(8);
	private ArrayList<String> outB64Pics = new ArrayList<>();
	private static int errorCode_S;
	private StringBuilder outmsg = new StringBuilder();
	
	public void setApp(mainController application){  
		this.application = application;  
	}
	
	public static int getErrorCode() {
		return errorCode_S;
	}
	
	@FXML
	public void B_Back(ActionEvent event){
		application.gotoSignUp();
	}
	
	@FXML
	public void B_Add(ActionEvent event){
		get8pic();
	}
	
	@FXML
	public void B_Upload(ActionEvent event){
		errorCode_S = DSD2016JAVA.registerNewUser(inB64Pics,outB64Pics,outmsg); 
		application.NID = outmsg.toString();
		if(errorCode_S == 1){
			storeController.storeRelation(application.NUN, 
					application.NPW, 
					application.NID);
//			System.out.println(outmsg.toString());
			application.gotoReturnSUS();
		}
		else
			application.gotoReturnSUF();
	}
	
	
	
	public void get8pic(){

		
		FileChooser fileChooser = new FileChooser();
		List<File> listOfImages = 
                fileChooser.showOpenMultipleDialog(application.getStage());
		if(listOfImages==null) return;
			for(int i=0;i<listOfImages.size();++i) {
			String imageURL = "file:///"+listOfImages.get(i).getPath();
			switch(emptyImage){
			case 0: imageCur0.setImage(new Image(imageURL)); break;
			case 1: imageCur1.setImage(new Image(imageURL)); break;
			case 2: imageCur2.setImage(new Image(imageURL)); break;
			case 3: imageCur3.setImage(new Image(imageURL)); break;
			case 4: imageCur4.setImage(new Image(imageURL)); break;
			case 5: imageCur5.setImage(new Image(imageURL)); break;
			case 6: imageCur6.setImage(new Image(imageURL)); break;
			case 7: imageCur7.setImage(new Image(imageURL)); break;
			}
			imageCur.setImage(new Image(imageURL));
			InputStream in = null;  
	        byte[] data = null;  
			try {
				in = new FileInputStream(listOfImages.get(i));          
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	            inB64Pics.add(emptyImage,Base64.encodeBase64String(data));
	            
	            emptyImage = (emptyImage+1)%8;
								 
		     }
			catch (IOException ex)   
	        {  
	            ex.printStackTrace();  
	        } 
			
		}
	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	

}
