package design.vendingMachine;

public enum MoneyBill {
	
	QUARTER {
		
		public long getCents(){
			return 25;
		}
	},
	ONE {
		public long getCents(){
			return 100;
		}
	},
	FIVE {
		
		public long getCents(){
			return 500;
		}
	},
	TEN {
		
		public long getCents(){
			return 1000;
		}
	};
	
	public abstract long getCents();

}
