package com.internshala.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	@FXML
	public Label WelcomeLabel;

	@FXML
	public TextField userInputField;

	@FXML
	public Button Convert;

	@FXML
	public ChoiceBox<String> choiceBox;

	private static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT="Fahrenheit to Celsius";

	 private boolean is_C_TO_F=true;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);

		choiceBox.setValue(C_TO_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		{
			if(newValue.equals(C_TO_F_TEXT))
			{
				is_C_TO_F=true;
			}
			else
				is_C_TO_F=false;
		});

		Convert.setOnAction(event ->
		{
			convert();
		});

	}

	private void convert()
	{
		String input=userInputField.getText();

		float entertemperature = 0.0f;
		try
		{
			 entertemperature = Float.parseFloat(input);
		}
		catch(Exception e)
		{
			warnUser();
			return;
		}
		float newTemperature=0.0f;
		if(is_C_TO_F)
		{
			newTemperature=(entertemperature * 9 / 5 )+32;
		}
		else newTemperature = (entertemperature - 32) * 5 / 9;

		Display(newTemperature);

	}

	private void warnUser()
	{
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setContentText("Invalid Temperature! Entered");
		alert.setContentText("Please Enter Valid Temperature");
		alert.show();
	}

	private void Display(float newTemperature)
	{
		String Unit = is_C_TO_F? " F" :" C";
		//System.out.println(newTemperature + Unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The Temperature is :  " + newTemperature + Unit);
        alert.show();
	}
}
