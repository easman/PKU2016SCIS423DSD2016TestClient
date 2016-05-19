package dsd2016.gui;





import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LogInPage extends Pane{
	public ImageView back = new ImageView("image/Back.png");
	public ImageView shot = new ImageView("image/Shot.png");
	public ImageView upload = new ImageView("image/Upload.png");
	public ImageView imageCur = new ImageView("image/addpic.png");
	public String inB64Pics = new String();
	public Text tx1 = new Text("Press shot button to take the picture ");
	public int photosUpdated = 0;
	LogInPage(Stage stage) {
		super();
		setVisible(false);
		setPadding(new Insets(0, 10, 0, 10));
		tx1.setFont(Font.font ("Verdana", 20));
		back.setCursor(Cursor.HAND);
		back.setFitHeight(60);
		back.setFitWidth(200);
		shot.setCursor(Cursor.HAND);
		shot.setFitHeight(60);
		shot.setFitWidth(200);
		upload.setCursor(Cursor.HAND);
		upload.setFitHeight(60);
		upload.setFitWidth(200);
		imageCur.setFitHeight(350);
		imageCur.setFitWidth(350);
		//setStyle("-fx-border-color:blue;-fx-border-width:5");
		getChildren().addAll(shot,tx1,imageCur,back,upload);
		tx1.setX(207);
		tx1.setY(50);
		imageCur.setX(230);
		imageCur.setY(150);
		back.setX(180);
		back.setY(600);
		shot.setX(430);
		shot.setY(600);
		upload.setX(300);
		upload.setY(660);
		
		shot.setOnMousePressed(e -> {
			
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			
			File file = fileChooser.showOpenDialog(stage);
			if(file==null) return;
			imageCur.setImage(new Image("file:///"+file.getPath()));
			++photosUpdated;
			
	        InputStream in = null;  
	        byte[] data = null;  
	        //读取图片字节数组  
	        try   
	        {  
	            in = new FileInputStream(file);          
	            data = new byte[in.available()];  
	            in.read(data);  
	            in.close();  
	            inB64Pics = Base64.encodeBase64String(data);
	            
	            /*byte[] dataRe = Base64.decodeBase64(inB64Pics);
	            String imgFilePath = "d://cameraTest.jpg";//新生成的图片  
	            OutputStream out = new FileOutputStream(imgFilePath);      
	            out.write(dataRe);  
	            out.flush();  
	            out.close();  */
		    }    
	        catch (IOException ex)   
	        {  
	            ex.printStackTrace();  
	        } 
			
		});
		
	}

}

