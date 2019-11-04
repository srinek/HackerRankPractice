package design.vendingMachine.impl;

import design.vendingMachine.MoneyBill;

public class VendingMachineTest {

	
	public static void main(String[] args) throws Exception{
		
		outOfStockTest();
		System.out.println("-------------------------------------------------");
		normalOperationTest();
	}
	 
	public static void outOfStockTest() throws Exception{
		StandardVendingMachine vendingMachine = new StandardVendingMachine();
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.initialize();
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.acceptMoney(MoneyBill.TEN);
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.pickItem("A1");
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.vendItem("A1");
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.dispenseChange();
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.initialize();
	}
	
	public static void normalOperationTest() throws Exception{
		
		StandardVendingMachine vendingMachine = new StandardVendingMachine();
		vendingMachine.addItem("A1", 10);
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.initialize();
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.acceptMoney(MoneyBill.TEN);
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.pickItem("A1");
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.vendItem("A1");
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.dispenseChange();
		System.out.println( vendingMachine.getDisplayMessage() );
		vendingMachine.initialize();
	}
}
