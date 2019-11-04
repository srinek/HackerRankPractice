package design.vendingMachine.impl;

import java.util.ArrayList;
import java.util.List;

import design.vendingMachine.VendingMachine;
import design.vendingMachine.VendingMachineAction;
import design.vendingMachine.VendingMachineState;

public class PickItemVendingMachineState implements VendingMachineState {

	private List<VendingMachineAction> allowedActions = new ArrayList<>();
	
	private VendingMachineAction nextValidAction =  VendingMachineAction.DISPENSE_CHANGE;
	
	public PickItemVendingMachineState(){
		this.allowedActions.add(VendingMachineAction.REFILL_ITEMS);
		this.allowedActions.add(VendingMachineAction.VEND_ITEM);
	}
	
	@Override
	public boolean isActionAllowed(VendingMachine machine, VendingMachineAction action) {
		if(machine == null){
			throw new IllegalStateException(" machine cannot be null");
		}
		if(!this.allowedActions.contains(action)){
			machine.prependDisplayMessage(action.getNotAllowedMessage());
			return false;
		}
		return true;
	}

	@Override
	public void doWork(VendingMachine machine) {
		
		if(machine == null){
			throw new IllegalStateException(" machine cannot be null");
		}
		machine.setNextState(VendingMachineStateFactory.getVendItemState());
		machine.setDisplayMessage(nextValidAction.getDisplayMessage());

	}

}
