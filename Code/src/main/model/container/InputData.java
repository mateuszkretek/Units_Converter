package main.model.container;

/**
 * Class for storing data passed by User
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class InputData {
	/**
	 * double type variable for storing numerical value for conversion
	 */
	private double inputValue;

	/**
	 * String object for storing input value unit
	 */
	private String inputUnit;

	/**
	 * String object for storing output value unit
	 */
	private String outputUnit;

	/**
	 * Default constructor for {@link InputData} class object
	 */
	public InputData() {
		super();
	}

	/**
	 * Constructor with parameters for {@link InputData} class object
	 *
	 * @param inputValue double type variable representing numerical value for conversion
	 * @param inputUnit  String object for storing output value unit
	 * @param outputUnit String object for storing output value unit
	 */
	public InputData(double inputValue, String inputUnit, String outputUnit) {
		this.inputValue = inputValue;
		this.inputUnit = inputUnit;
		this.outputUnit = outputUnit;
	}

	/**
	 * Method for setting new data for existing {@link InputData} class object
	 *
	 * @param inputValue double type variable representing numerical value for conversion
	 * @param inputUnit  String object for storing output value unit
	 * @param outputUnit String object for storing output value unit
	 */
	public void setData(double inputValue, String inputUnit, String outputUnit) {
		this.inputValue = inputValue;
		this.inputUnit = inputUnit;
		this.outputUnit = outputUnit;
	}

	/**
	 * Method for getting input value
	 *
	 * @return input value
	 */
	public double getValue() {
		return inputValue;
	}

	/**
	 * Method for getting input value unit
	 *
	 * @return input value unit
	 */
	public String getInputUnit() {
		return inputUnit;
	}

	/**
	 * Method for getting output value unit
	 *
	 * @return output value unit
	 */
	public String getOutputUnit() {
		return outputUnit;
	}
}
