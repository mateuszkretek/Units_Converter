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

	/**
	 * FXML loader
	 * @param fxml
	 * @return
	 * @throws IOException
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	/**
	 * Main method of program
	 * @param args
	 */
	public static void main(String[] args) {
		launch();
	}

	/**
	 * Method starting scene
	 */
	@Override
	public void start(Stage stage) throws Exception {
		scene = new Scene(loadFXML("units_converter"), 1280, 720);
		stage.setScene(scene);
		stage.show();
	}


/*
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

