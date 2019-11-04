package design.vendingMachine;

/*
 * Actions : insert coin, pick item, vend item, dispense change, refill items
 * States : Ready, No_Item_state, money_accepted, item_picked, item_vended, change_dispensed
 */
public interface VendingMachine {

	public void initialize();
	
	public void acceptMoney(MoneyBill bill) throws Exception;
	
	public void pickItem(String itemCode);
	
	public Item vendItem(String itemCode);
	
	public Price dispenseChange();
	
	/*
	 * message to display on vending machine display
	 */
	public String getDisplayMessage();
	
	public void setDisplayMessage(String message);
	
	public void prependDisplayMessage(String message);
	
	public void setNextState(VendingMachineState nextState);
	
	public void addItem(String itemCode, int itemQty);
}
