package design.vendingMachine;

public interface Item {

	public Price getPrice();
	
	public boolean isAvailable();
	
	public void decrementQtyByOne();
	
	public void addQty(int qty);
}
