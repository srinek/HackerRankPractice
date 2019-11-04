package design.vendingMachine.impl;

import design.vendingMachine.Price;

public class PriceImpl implements Price {

	
	private double price = 0;
	
	public PriceImpl(double price){
		
		this.price = price;
	}
	
	public PriceImpl(long price){
		
		this.price = (double)(price/100);
	}
	
	@Override
	public double getPrice() {
		
		return this.price;
	}

	@Override
	public long getCents() {
		
		return (long) (this.price * 100);
	}

	@Override
	public String getFormattedPrice() {
		return null;
	}

}
