package dsd2016.gui_old;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SignUpPage extends Pane{
	public ImageView back = new ImageView("image/Back.png");
	public ImageView train = new ImageView("image/Train.png");
	public ImageView  add_ = new ImageView ("image/add.png");
	public ImageView[] images = new ImageView[8];
	ArrayList<String> inB64Pics = new ArrayList<>(8);
	public ImageView imageCur = new ImageView("image/addpic.png");
	public FlowPane imagePane = new FlowPane(10,10);
	public Text tx1 = new Text("Press add button to capture next picture when the 8 ");
	public Text tx2 = new Text( "pictures have been taked, press train"
			+ "button to continue");
	public ProgressBar pbs = new ProgressBar(0);
	public Text rateOfProgress = new Text("0/8");
	public int photosUpdated = 0;
	int emptyImage = 0;
	SignUpPage(Stage primaryStage) {
		super();
		setVisible(false);
		setPadding(new Insets(0, 10, 0, 10));
		tx1.setFont(Font.font ("Verdana", 20));
		tx2.setFont(Font.font ("Verdana", 20));
		rateOfProgress.setFont(Font.font ("Verdana", 15));
		pbs.setPrefWidth(300);
		back.setCursor(Cursor.HAND);
		back.setFitHeight(60);
		back.setFitWidth(200);
		train.setCursor(Cursor.HAND);
		train.setFitHeight(60);
		train.setFitWidth(200);
		add_.setCursor(Cursor.HAND);
		add_.setFitHeight(60);
		add_.setFitWidth(150);
		
		
		for(int i=0;i<8;++i) {
			images[i] = new ImageView("image/addpic.png");
			images[i].setFitHeight(100);
			images[i].setFitWidth(100);
			imagePane.getChildren().add(images[i]);
		}
		imageCur.setFitHeight(350);
		imageCur.setFitWidth(350);
		imagePane.setPrefSize(250,500);
		//setStyle("-fx-border-color:blue;-fx-border-width:5");
		getChildren().addAll(train,tx1,tx2,imageCur,back,add_,pbs,rateOfProgress);
		//getChildren().addAll(images[0]);	
		getChildren().addAll(images);	
		tx1.setX(107);
		tx1.setY(50);
		tx2.setX(100);
		tx2.setY(75);
		imageCur.setX(80);
		imageCur.setY(150);
		pbs.setLayoutX(80);
		pbs.setLayoutY(520);
		rateOfProgress.setX(200);
		rateOfProgress.setY(555);
		back.setX(30);
		back.setY(600);
		train.setX(300);
		train.setY(600);
		add_.setX(550);
		add_.setY(600);
		for(int i=0;i<8;++i) {
			images[i].setX(500+(i%2)*110);
			images[i].setY(120+(i/2)*110);
		}
		
	
		add_.setOnMousePressed(e -> {
			
			FileChooser fileChooser = new FileChooser();
			List<File> listOfImages = 
                    fileChooser.showOpenMultipleDialog(primaryStage);
			if(listOfImages==null) return;
 			for(int i=0;i<listOfImages.size();++i) {
				String imageURL = "file:///"+listOfImages.get(i).getPath();
				images[emptyImage].setImage(new Image(imageURL));
				imageCur.setImage(new Image(imageURL));
				
//				System.out.println(imageURL);
				InputStream in = null;  
		        byte[] data = null;  
				try {
					in = new FileInputStream(listOfImages.get(i));          
		            data = new byte[in.available()];  
		            in.read(data);  
		            in.close();  
		            inB64Pics.add(emptyImage,Base64.encodeBase64String(data));
		      
		           /* byte[] dataRe = Base64.decodeBase64(inB64Pics.get(emptyImage));
		            String imgFilePath = "d://"+emptyImage+"test.jpg";//新生成的图片  
		            OutputStream out = new FileOutputStream(imgFilePath);      
		            out.write(dataRe);  
		            out.flush();  
		            out.close();*/
		            
		            emptyImage = (emptyImage+1)%8;
					++(photosUpdated);
		            pbs.setProgress(photosUpdated/8.);
		            rateOfProgress.setText(
		            		(photosUpdated>8?8:photosUpdated)+"/8");				 
			     }
				catch (IOException ex)   
		        {  
		            ex.printStackTrace();  
		        } 
			}
		});
	}

}
