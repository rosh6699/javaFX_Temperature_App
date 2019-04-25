package com.rosh.javaApp;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


	@FXML
	public Labeled welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox2;
	@FXML
	public TextField textField2;
	@FXML
	public Button btnConvert;

	private static final String C_TO_F_TEXT = " Celsius to Fahrenheit";
	private static final String F_TO_C_TEXT = " Fahrenheit to Celsius";

	private boolean isCF=true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox2.getItems().add(C_TO_F_TEXT);
		choiceBox2.getItems().add(F_TO_C_TEXT);

		choiceBox2.setValue(C_TO_F_TEXT);

		choiceBox2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
					System.out.println(newValue);
					if(newValue.equals(C_TO_F_TEXT)) {
						isCF = true;
					}
					else
						isCF=false;
					


				});


				btnConvert.setOnAction(event -> { System.out.println("CONVERT");

					convert();
				});
	}

	private void convert() {
		String input=textField2.getText();
		float enteredTemp=0.0f;
		try {
			 enteredTemp = Float.parseFloat(input);
		}catch (Exception ex){
			warnUser();
			return;
		}
		float newTemp=0.0f;
		if(isCF){
			newTemp = enteredTemp*9/5 +32;

		}
		else
			newTemp=(enteredTemp-32)*5/9;

		display(newTemp);
	}

	private void warnUser() {
		Alert alert= new Alert(Alert.AlertType.ERROR);
		alert.setTitle("ERROR OCCURED");
		alert.setContentText("Please enter a valid temperature");
		alert.show();
	}

	private void display(float newTemp) {

		String unit= isCF?" F":" C";
		System.out.println("The new temperature is "+newTemp+unit);

		Alert alert= new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("RESULT");
		alert.setContentText("The new temperature is "+newTemp+unit);
		alert.show();

	}


}
