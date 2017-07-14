package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class JimsBurgers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Burger[] burgers = new Burger[n];
		for(int i = 0; i < n; i++){
			int t = scan.nextInt();
			int d = scan.nextInt();
			Burger b = new Burger(t + d, i +1);
			burgers[i] = b;
		}
		scan.close();
		sortBurgersByTime(burgers);
	}
	
	
	private static void sortBurgersByTime(Burger[] burgers) {
		
		Arrays.sort(burgers);
		for(Burger burger : burgers){
			System.out.print(burger.getOrdNum() +" ");
		}
	}


	private static class Burger implements Comparable<Burger>{
		
		private int time;
		private int ordNum;
		
		public Burger(int time, int ordNum) {
			super();
			this.time = time;
			this.ordNum = ordNum;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public int getOrdNum() {
			return ordNum;
		}
		public void setOrdNum(int ordNum) {
			this.ordNum = ordNum;
		}
		@Override
		public int compareTo(Burger inburger) {
			if(this.time > inburger.getTime()){
				return 1;
			}
			if(this.time < inburger.getTime()){
				return -1;
			}
			return 0;
		}
		
	
		
	}
}
