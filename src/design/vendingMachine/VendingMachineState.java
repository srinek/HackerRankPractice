package design.vendingMachine;

public interface VendingMachineState {
	
	public boolean isActionAllowed(VendingMachine machine, VendingMachineAction action);
	
	public void doWork(VendingMachine machine);


	
}


