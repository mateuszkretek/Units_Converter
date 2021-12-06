package com.units_converter.controller.command;

import com.units_converter.controller.container.Supplier;

public class SetInputValueCommand extends Command {
	double inputValue;

	public SetInputValueCommand(Supplier supplier, double inputValue) {
		super(supplier);
		this.inputValue = inputValue;
	}

	@Override
	public void execute() {
		supplier.setInputValue(inputValue);
		supplier.setCommandSuccess(true);
	}
}
