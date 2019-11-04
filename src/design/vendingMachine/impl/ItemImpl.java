package design.vendingMachine.impl;

import design.vendingMachine.Item;
import design.vendingMachine.Price;

public class ItemImpl implements Item {

	
	private double price;
	private int qty;
	
	public ItemImpl(double price, int qty){
		
		this.price = price;
		this.qty = qty;
	}
	
	@Override
	public Price getPrice() {
		return new PriceImpl(price);
	}

	@Override
	public boolean isAvailable() {
		if(this.qty <= 0){
			return false;
		}
		return true;
	}

	@Override
	public void decrementQtyByOne() {
		this.qty--;

	}

	@Override
	public void addQty(int qty) {
		this.qty += qty;

	}

}
