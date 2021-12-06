package com.units_converter.controller.command;

import com.units_converter.controller.container.Supplier;

public class SetInputUnitCommand extends Command {
	String inputUnit;

	public SetInputUnitCommand(Supplier supplier, String inputUnit) {
		super(supplier);
		this.inputUnit = inputUnit;
	}

	@Override
	public void execute() {
		supplier.setInputUnit(inputUnit);
		supplier.setCommandSuccess(true);
	}
}

