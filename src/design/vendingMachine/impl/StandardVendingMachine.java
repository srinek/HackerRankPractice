package design.vendingMachine.impl;

import java.util.HashMap;
import java.util.Map;

import design.vendingMachine.Item;
import design.vendingMachine.MoneyBill;
import design.vendingMachine.Price;
import design.vendingMachine.VendingMachine;
import design.vendingMachine.VendingMachineAction;
import design.vendingMachine.VendingMachineState;

public class StandardVendingMachine implements VendingMachine {
	
	private Map<String, Integer> itemMap = new HashMap<>();
	
	private VendingMachineState currentState;
	
	private String displayMessage = "Machine initializing";
	
	private MoneyBill moneyBill = null;
	

	@Override
	public void initialize() {
		
		if(itemMap.isEmpty()){
			this.currentState = VendingMachineStateFactory.getNoItemsState();
			this.currentState.doWork(this);
		}
		else{
			this.currentState = VendingMachineStateFactory.getReadyState();
		}
	}

	@Override
	public void acceptMoney(MoneyBill bill) throws Exception {
		
		if(!this.currentState.isActionAllowed(this, VendingMachineAction.INSERT_COIN)){
			return;
		}
		this.moneyBill = bill;
		this.currentState.doWork(this);
	}

	@Override
	public void pickItem(String itemCode) {
		
		if(!this.currentState.isActionAllowed(this, VendingMachineAction.PICK_ITEM)){
			return;
		}
		this.currentState.doWork(this);
		
	}

	@Override
	public Item vendItem(String itemCode) {
		if(!this.currentState.isActionAllowed(this, VendingMachineAction.VEND_ITEM)){
			return null;
		}
		this.currentState.doWork(this);
		// update item qty
		return new ItemImpl(0, 1);
	}

	@Override
	public Price dispenseChange() {
		if(!this.currentState.isActionAllowed(this, VendingMachineAction.DISPENSE_CHANGE)){
			return null;
		}
		this.currentState.doWork(this);
		return null;
	}

	@Override
	public String getDisplayMessage() {

		return this.displayMessage;
	
	}

	@Override
	public void setDisplayMessage(String message) {
	
		this.displayMessage = message;
	
	}

	@Override
	public void prependDisplayMessage(String message) {
	
		this.displayMessage = message + this.displayMessage;
	
	}

	@Override
	public void setNextState(VendingMachineState nextState){
		
		this.currentState = nextState;
		
	}

	@Override
	public void addItem(String itemCode, int itemQty) {

			this.itemMap.put(itemCode, itemQty);
		
	}

}
