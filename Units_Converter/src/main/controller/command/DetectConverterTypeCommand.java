package main.controller.command;

import main.controller.container.ConverterType;
import main.controller.container.Supplier;
import main.controller.exception.UnitNotSupportedException;

import java.util.Map;

/**
 * Class responsible for detecting converter type
 *
 * @author Mateusz Kretek
 * @version 2.0
 */
public class DetectConverterTypeCommand extends Command {
	/**
	 * Default constructor
	 *
	 * @param supplier {@link Supplier} class object representing container for whole program
	 */
	public DetectConverterTypeCommand(Supplier supplier) {
		super(supplier);
	}

	//TODO streams in collections
	/**
	 * Method for executing command content
	 */
	@Override
	public void execute() {
		String inputUnit = supplier.getInputData().getInputUnit();
		String outputUnit = supplier.getInputData().getOutputUnit();
		try {
			ConverterType inputUnitType;
			ConverterType outputUnitType;
			inputUnitType = supplier.getSupportedUnitsCollection().entrySet().stream()
					.filter(entry -> entry.getValue().contains(inputUnit))
					.map(Map.Entry::getKey)
					.findFirst().orElseThrow(()-> new UnitNotSupportedException("Output unit not supported"));

			outputUnitType = supplier.getSupportedUnitsCollection().entrySet().stream()
					.filter(entry -> entry.getValue().contains(outputUnit))
					.map(Map.Entry::getKey)
					.findFirst().orElseThrow(()-> new UnitNotSupportedException("Output unit not supported"));
			if (inputUnitType == outputUnitType) {
				supplier.setConverterType(inputUnitType);
				supplier.setCommandSuccess(true);
			}
		} catch (UnitNotSupportedException unitNotSupportedException) {
			supplier.getView().printExceptionMessage(unitNotSupportedException.getMessage());
			supplier.setCommandSuccess(false);
		}
	}
}
