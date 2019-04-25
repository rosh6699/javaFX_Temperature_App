package com.rosh.javaApp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void init() throws Exception {

		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {


		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		Scene scene = new Scene(rootNode);

		rootNode.getChildren().add(0, menuBar);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");

		primaryStage.show();

	}

	private MenuBar createMenu() {


		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);


		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);

		});


		aboutApp.setOnAction(event -> aboutApp());
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		helpMenu.getItems().addAll(aboutApp);

		return menuBar;
	}

	public static void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My first JavaAPP");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("Check It Out");


		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
			System.out.println("yes");
		}

		if (clickedBtn.isPresent() && clickedBtn.get() == noBtn) {
			System.out.println("no");
		}
	}


	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
