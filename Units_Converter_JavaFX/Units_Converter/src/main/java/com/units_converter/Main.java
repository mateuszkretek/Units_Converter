package com.units_converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of program
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class Main extends Application {
	private static Scene scene;

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		scene = new Scene(loadFXML("units_converter"), 640, 480);
		stage.setScene(scene);
		stage.show();
	}


	/**
	 * Main method of program
	 *
	 *
	 *//*
	public void main(String args) {
		ConversionController controller = new ConversionController();
		if (controller.checkConfig()) {
			if (!controller.handleArgs(args)) {
				controller.getInputData();
			}
			if (controller.detectConverterType())
				if (controller.convertValue())
					controller.printConvertedData();
		}
	}*/


}

