package com.internshala.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application
{
	public static void main(String args[])
	{
		System.out.println("main");
		launch();
	}

	@Override
	public void init() throws Exception
	{
		System.out.println("INIT");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		System.out.println("Start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = CreateMenu();
		rootNode.getChildren().add(0,menuBar );

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		//primaryStage.setResizable(false);
		primaryStage.show();

	}


	private MenuBar CreateMenu()
	{
		Menu FileMenu=new Menu("File");

		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event ->
		{
			System.out.println("New Menu Item Click");
		});

		SeparatorMenuItem s=new SeparatorMenuItem();
		MenuItem QuitMenuItem= new MenuItem("Quit");

		QuitMenuItem.setOnAction(event ->
		{
			Platform.exit();
			System.exit(0);

		});
		FileMenu.getItems().addAll(newMenuItem,s,QuitMenuItem);

		Menu HelpMenu=new Menu("Help");
		MenuItem aboutApp=new MenuItem("About");

		HelpMenu.setOnAction(event -> aboutApp());

		HelpMenu.getItems().addAll(aboutApp);


		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(FileMenu,HelpMenu);

		return menuBar;

	}
	private void aboutApp()
	{
		Alert AlertDialog = new Alert(Alert.AlertType.INFORMATION);
		AlertDialog.setTitle("My First Desktop Application");
		AlertDialog.setHeaderText("Temperature Converter. ");
		AlertDialog.setContentText("This is a converter which converts temperature from Celsius to farhenheit as well as it also converts temperature from fahrenheit to Celsius.");

		ButtonType yesbtn=new ButtonType("Yes");  // Adding Custom Buttons.
		ButtonType nobtn=new ButtonType("No");

		AlertDialog.getButtonTypes().setAll(yesbtn,nobtn);

        Optional<ButtonType> Clickedbtn = AlertDialog.showAndWait();

        if(Clickedbtn.isPresent() && Clickedbtn.get() == yesbtn)
        {
        	System.out.println("Yes button is clicked");
        }
        else
	        System.out.println("No Button is Clicked");


	}

	@Override
	public void stop() throws Exception
	{
		System.out.println("Stopped");
		super.stop();
	}
}
