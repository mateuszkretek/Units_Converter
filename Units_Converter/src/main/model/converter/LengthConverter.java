package main.model.converter;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * Class responsible for conversion of length values
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class LengthConverter extends Converter {

	/**
	 * Constructor of {@link LengthConverter} class objects
	 *
	 * @throws FileNotFoundException if config file was not found
	 */
	public LengthConverter() throws FileNotFoundException {
		this.configFileName = "src/resources/config/length_converter_config.txt";
		this.supportedUnitsCollection = new HashMap<>();
		this.readConfig();
	}
}
