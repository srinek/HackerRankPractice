package algo.dp;

import java.util.Scanner;

public class SherlockAndCost {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		int index = 0;
		while(index++ < q){
			int n = scan.nextInt();
			int[] b = new int[n];
			for(int i = 0; i < n; i++){
				b[i] = scan.nextInt();
			}
			int cost = findCost(b);
			System.out.println(cost);
		}
		scan.close();
	}

	private static int findCost(int[] b) {
		
		int sum = 0;
		int hiPrevMaxsum = 0;
		int loPrevMaxsum = 0;
		for(int i = 1; i < b.length; i++){
			int tempHiPrevMaxsum = hiPrevMaxsum;
			hiPrevMaxsum = Math.max(hiPrevMaxsum+Math.abs(b[i]-b[i-1]), loPrevMaxsum+Math.abs(b[i]-1));
			loPrevMaxsum = Math.max(tempHiPrevMaxsum+Math.abs(b[i-1]-1), loPrevMaxsum+Math.abs(1-1));
		}
		sum = hiPrevMaxsum > loPrevMaxsum ? hiPrevMaxsum : loPrevMaxsum;
		return sum;
	}
}
