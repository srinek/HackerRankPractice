package design.vendingMachine.impl;

import design.vendingMachine.VendingMachine;
import design.vendingMachine.VendingMachineAction;
import design.vendingMachine.VendingMachineState;

public class NoItemsVendingMachineState implements VendingMachineState {
	
	private VendingMachineAction nextValidAction =  VendingMachineAction.REFILL_ITEMS;

	@Override
	public boolean isActionAllowed(VendingMachine machine, VendingMachineAction action) {
		
		return false;
	}

	@Override
	public void doWork(VendingMachine machine) {
		
		if(machine == null){
			throw new IllegalStateException(" machine cannot be null");
		}
		
		machine.setDisplayMessage(nextValidAction.getDisplayMessage());
	}

}
