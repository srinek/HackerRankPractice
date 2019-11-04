package design.vendingMachine;

//Actions : insert coin, pick item, vend item, dispense change, refill items
public enum VendingMachineAction {

	
	INSERT_COIN("Please insert coins", "Cannot Insert Coins"),
	PICK_ITEM("Please pick items ", "Cannot Pick Items"),
	VEND_ITEM("vending Item", "Cannot Vend Items"),
	DISPENSE_CHANGE("Chage is diepsing", "Cannot Dispense Change"),
	REFILL_ITEMS("Out Of Stock, Please Refill", "Cannot Refill Items");
	
	private String notAllowedMessage;
	private String displayMessage;
	
	private VendingMachineAction(String displayMessage,  String notAllowedMessage){
		
		this.notAllowedMessage = notAllowedMessage;
		this.displayMessage = displayMessage;
	}
	
	public String getNotAllowedMessage(){
		
		return notAllowedMessage;
	}
	
	public String getDisplayMessage(){
		
		return displayMessage;
	}
}
