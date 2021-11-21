package main.controller.container;

import main.model.container.ConvertedData;
import main.model.container.InputData;
import main.model.converter.Converter;
import main.view.UserInterface;

import java.util.ArrayList;
import java.util.Map;

/**
 * Class storing data needed for proper program functioning
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class Supplier {
	/**
	 * Object implementing {@link UserInterface} interface and representing output for information for user
	 */
	private UserInterface view;

	/**
	 * Map storing list of supported units and converters for them
	 */
	private Map<ConverterType, ArrayList<String>> supportedUnitsCollection;

	/**
	 * ArrayList storing starting arguments for program
	 */
	private ArrayList<String> args;

	/**
	 * Boolean value storing status of command success
	 */
	private boolean commandSuccess;

	/**
	 * Map storing converters and enum type describing their type
	 */
	private Map<ConverterType, Converter> converterCollection;

	/**
	 * {@link InputData} object for storing data passed by User
	 */
	private InputData inputData;

	/**
	 * {@link ConverterType} object storing type of current conversion
	 */
	private ConverterType converterType;

	/**
	 * {@link ConvertedData} object storing data after conversion
	 */
	private ConvertedData convertedData;

	/**
	 * Default constructor
	 */
	public Supplier() {
		super();
	}

	/**
	 * Getter method for current view
	 *
	 * @return returns view
	 */
	public UserInterface getView() {
		return view;
	}

	/**
	 * Setter for current view
	 *
	 * @param view object which will be assigned
	 */
	public void setView(UserInterface view) {
		this.view = view;
	}

	/**
	 * Getter for list of supported units
	 *
	 * @return list of supported units
	 */
	public Map<ConverterType, ArrayList<String>> getSupportedUnitsCollection() {
		return supportedUnitsCollection;
	}

	/**
	 * Setter for list of supported units
	 *
	 * @param supportedUnitsCollection list of supported units
	 */
	public void setSupportedUnitsCollection(Map<ConverterType, ArrayList<String>> supportedUnitsCollection) {
		this.supportedUnitsCollection = supportedUnitsCollection;
	}

	/**
	 * Getter for list of starting parameters
	 *
	 * @return list of starting parameter
	 */
	public ArrayList<String> getArgs() {
		return args;
	}

	/**
	 * Setter for list of starting parameters
	 *
	 * @param args list of starting parameters
	 */
	public void setArgs(ArrayList<String> args) {
		this.args = args;
	}

	/**
	 * Getter for flag of command success
	 *
	 * @return value of flag
	 */
	public boolean getCommandSuccess() {
		return commandSuccess;
	}

	/**
	 * Setter for flag of command success
	 *
	 * @param commandSuccess value of flag
	 */
	public void setCommandSuccess(boolean commandSuccess) {
		this.commandSuccess = commandSuccess;
	}

	/**
	 * Getter for converter type
	 *
	 * @return {@link ConverterType} object storing converter type for current conversion
	 */
	public ConverterType getConverterType() {
		return converterType;
	}

	/**
	 * Setter for converter type
	 *
	 * @param converterType {@link ConverterType} object storing converter type for current conversion
	 */
	public void setConverterType(ConverterType converterType) {
		this.converterType = converterType;
	}

	/**
	 * Getter for map of converters and their types
	 *
	 * @return map of converters and their types
	 */
	public Map<ConverterType, Converter> getConverterCollection() {
		return converterCollection;
	}

	/**
	 * Setter for map of converters and their types
	 *
	 * @param converterCollection map of converters and their types
	 */
	public void setConverterCollection(Map<ConverterType, Converter> converterCollection) {
		this.converterCollection = converterCollection;
	}

	/**
	 * Getter for {@link InputData} object storing data passed by user
	 *
	 * @return {@link InputData} object storing data passed by user
	 */
	public InputData getInputData() {
		return this.inputData;
	}

	/**
	 * Setter for {@link InputData} object storing data passed by user
	 *
	 * @param inputData {@link InputData} object storing data passed by user
	 */
	public void setInputData(InputData inputData) {
		this.inputData = inputData;
	}

	/**
	 * Getter for {@link ConvertedData} object storing data after conversion
	 *
	 * @return {@link ConvertedData} object storing data after conversion
	 */
	public ConvertedData getConvertedData() {
		return convertedData;
	}

	/**
	 * Setter for {@link ConvertedData} object storing data after conversion
	 *
	 * @param convertedData {@link ConvertedData} object storing data after conversion
	 */
	public void setConvertedData(ConvertedData convertedData) {
		this.convertedData = convertedData;
	}
}
