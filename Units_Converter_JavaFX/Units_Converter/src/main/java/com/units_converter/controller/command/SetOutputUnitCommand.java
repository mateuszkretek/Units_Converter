package com.units_converter.controller.command;

import com.units_converter.controller.container.Supplier;

public class SetOutputUnitCommand extends Command {
	String outputUnit;

	public SetOutputUnitCommand(Supplier supplier, String outputUnit) {
		super(supplier);
		this.outputUnit = outputUnit;
	}

	@Override
	public void execute() {
		supplier.setOutputUnit(outputUnit);
		supplier.setCommandSuccess(true);
	}
}
