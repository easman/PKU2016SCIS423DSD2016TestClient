package dsd2016.gui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import  dsd2016.api.DSD2016JAVA;

public class PageController extends Application{
	
	
	
	public void start(Stage primaryStage) {
		//页面初始化
		Pane basePane = new Pane();
		Index index = new Index(primaryStage);
		InputID inputID = new InputID(primaryStage);
		LogInPage logInPage = new LogInPage(primaryStage);
		ReturnPage_LIF returnPage_LIF = new ReturnPage_LIF(primaryStage);
		ReturnPage_LIS returnPage_LIS = new ReturnPage_LIS(primaryStage);
		ReturnPage_SUF returnPage_SUF = new ReturnPage_SUF(primaryStage);
		ReturnPage_SUS returnPage_SUS = new ReturnPage_SUS(primaryStage);
		SignUpPage signUpPage = new SignUpPage(primaryStage);
		
		basePane.getChildren().addAll(index,inputID,logInPage,returnPage_LIF ,
				returnPage_LIS,returnPage_SUF,returnPage_SUS,signUpPage);
		
		index.setVisible(true);
		
		//按钮动作设定
		index.SignUpNow.setOnMousePressed(e -> {
			signUpPage.setVisible(true);
			index.setVisible(false);});
		signUpPage.back.setOnMousePressed(e -> {
			index.setVisible(true);
			signUpPage.setVisible(false);});
		signUpPage.train.setOnMousePressed(e -> {
			//该按钮根据DSD2016JAVA.registerNewUser返回值决定跳转页面
			StringBuilder outmsg = new StringBuilder();
			ArrayList<String> outB64Pics = new  ArrayList<>();
			int errorCode = DSD2016JAVA.registerNewUser(signUpPage.inB64Pics,outB64Pics,outmsg); 
			if(errorCode!=1){
				returnPage_SUF.outmsg = new StringBuilder("Error message:  ").append(outmsg.toString());
				returnPage_SUF.tx2.setText(returnPage_SUF.outmsg.toString());
				returnPage_SUF.setVisible(true);
			}
			else {
				returnPage_SUS.outmsg = new StringBuilder("Your ID is ").append(outmsg.toString());
				returnPage_SUS.tx2.setText(returnPage_SUS.outmsg.toString());
				returnPage_SUS.setVisible(true);
			}
			signUpPage.setVisible(false);});
		returnPage_SUF.back.setOnMousePressed(e -> {
			signUpPage.setVisible(true);
			returnPage_SUF.setVisible(false);});
		returnPage_SUS.logIn.setOnMousePressed(e -> {
			inputID.setVisible(true);
			returnPage_SUS.setVisible(false);});
		index.logIn.setOnMousePressed(e -> {
			inputID.setVisible(true);
			index.setVisible(false);});
		inputID.back.setOnMousePressed(e -> {
			index.setVisible(true);
			inputID.setVisible(false);});
		inputID.submit.setOnMousePressed(e -> {
			logInPage.setVisible(true);
			inputID.setVisible(false);});
		logInPage.back.setOnMousePressed(e -> {
			inputID.setVisible(true);
			logInPage.setVisible(false);});
		logInPage.upload.setOnMousePressed(e -> {
			//该按钮根据DSD2016JAVA.validateUser返回值决定跳转页面
			StringBuilder outmsg = new StringBuilder();
			int errorCode2 = DSD2016JAVA.validateUser(inputID.IDinput.getText(),
					logInPage.inB64Pics,outmsg); 
			if(errorCode2!=1){
				returnPage_LIF.outmsg = new StringBuilder("Error message:  ").append(outmsg.toString());
				returnPage_LIF.tx2.setText(returnPage_LIF.outmsg.toString());
				returnPage_LIF.setVisible(true);
			}
			else {
				returnPage_LIS.setVisible(true);
			}
			logInPage.setVisible(false);});
		returnPage_LIF.back.setOnMousePressed(e -> {
			logInPage.setVisible(true);
			returnPage_LIF.setVisible(false);});

		Scene scene = new Scene(basePane,800,800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Face auth");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
