package design.vendingMachine.impl;

import java.util.ArrayList;
import java.util.List;

import design.vendingMachine.VendingMachine;
import design.vendingMachine.VendingMachineAction;
import design.vendingMachine.VendingMachineState;

public class DispenseChangeVendingMachineState implements VendingMachineState {

	private List<VendingMachineAction> allowedActions = new ArrayList<>();
	
	private VendingMachineAction nextValidAction =  null;
	
	public DispenseChangeVendingMachineState(){
		this.allowedActions.add(VendingMachineAction.REFILL_ITEMS);
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
		machine.setNextState(VendingMachineStateFactory.getReadyState());
		//machine.setDisplayMessage(nextValidAction.getDisplayMessage());

	}

}
