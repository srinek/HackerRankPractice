package design.vendingMachine.impl;

import design.vendingMachine.VendingMachineState;

public class VendingMachineStateFactory {
	
	
	public static VendingMachineState getNoItemsState(){
		
		return new NoItemsVendingMachineState();
	}
	
	public static VendingMachineState getReadyState(){
		
		return new ReadyVendingMachineState();
	}
	
	
	public static VendingMachineState getMoneyAcceptedState(){
		
		return new MoneyAcceptedVendingMachineState();
	}
	
	public static VendingMachineState getPickItemState(){
		
		return new PickItemVendingMachineState();
	}
	
	public static VendingMachineState getVendItemState(){
		
		return new VendItemVendingMachineState();
	}

	public static VendingMachineState getDispenseChangetate(){
		
		return new DispenseChangeVendingMachineState();
	}
}
