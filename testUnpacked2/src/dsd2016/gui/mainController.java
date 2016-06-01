package dsd2016.gui;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class mainController extends Application{
	
	private Stage stage;  
	private final double MINIMUM_WINDOW_WIDTH = 800.0;  
	private final double MINIMUM_WINDOW_HEIGHT = 650.0;  
	public String NUN;
	public String NPW;
	public String NID;
	public String UN;
	public String PW;
	public String ID;

	Stage getStage(){
		return stage;
	}
	
	
	@Override  
	public void start(Stage primaryStage) throws Exception {  
	stage = primaryStage;  
	stage.setTitle("Face auth");  
	stage.setMinWidth(MINIMUM_WINDOW_WIDTH);  
	stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);  
	stage.setResizable(false);
	gotoIndex();  
	stage.show();  
	}
	
	/**
	 * a method to jump to Page Get1Pic
	 */
	public void gotoGet1Pic(){  
		try {  
			Get1PicController get1Pic = (Get1PicController) replaceSceneContent("Get1Pic.fxml");  
			get1Pic.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to jump to Page Get8Pic
	 */
	public void gotoGet8Pic(){  
		try {  
			Get8PicController get8Pic = (Get8PicController) replaceSceneContent("Get8Pic.fxml");  
			get8Pic.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to jump to Page Index
	 */
	public void gotoIndex(){  
		try {  
		    IndexController index = (IndexController) replaceSceneContent("Index.fxml");  
		    index.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to jump to Page LogIn
	 */
	public void gotoLogIn(){  
		try {  
			LogInController logIn = (LogInController) replaceSceneContent("Login.fxml");  
			logIn.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to jump to Page ReturnLIF
	 */
	public void gotoReturnLIF(){  
		try {  
			ReturnLIFController returnLIF = (ReturnLIFController) replaceSceneContent("ReturnLIF.fxml");  
			returnLIF.showError();
			returnLIF.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to jump to Page ReturnLIS
	 */
	public void gotoReturnLIS(){  
		try {  
			ReturnLISController returnLIS = (ReturnLISController) replaceSceneContent("ReturnLIS.fxml");  
			returnLIS.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to jump to Page ReturnSUF
	 */
	public void gotoReturnSUF(){  
		try {  
			ReturnSUFController returnSUF = (ReturnSUFController) replaceSceneContent("ReturnSUF.fxml");  
			returnSUF.showError();
			returnSUF.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to jump to Page ReturnSUS
	 */
	public void gotoReturnSUS(){  
		try {  
			ReturnSUSController returnSUS = (ReturnSUSController) replaceSceneContent("ReturnSUS.fxml");  
			returnSUS.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to jump to Page SignUp
	 */
	public void gotoSignUp(){ 
		
		try {  
			SignUpController signUp = (SignUpController) replaceSceneContent("SignUp.fxml");  
			signUp.setApp(this);  
		} catch (Exception ex) {  
		    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);  
			}  
		}
	
	/**
	 * a method to change fxml file 
	 * @param fxml
	 * @return
	 * @throws Exception
	 */
	private Initializable replaceSceneContent(String fxml) throws Exception {  
		FXMLLoader loader = new FXMLLoader();  
		InputStream in = mainController.class.getResourceAsStream(fxml);  
		loader.setBuilderFactory(new JavaFXBuilderFactory());  
		loader.setLocation(mainController.class.getResource(fxml));  
		AnchorPane page;  
		try {  
		    page = (AnchorPane) loader.load(in);  
		} finally {  
		    in.close();  
		}   
		Scene scene = new Scene(page, 800, 600);  
		stage.setScene(scene);  
		stage.sizeToScene();  
		return (Initializable) loader.getController();  
		}


	public static void main(String[] args) {  
		launch(args);  
		} 

  

}
