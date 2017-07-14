package algo.greedy;

import java.util.Scanner;

public class MarkAndToys {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] prices = new int[n];
		for(int i = 0; i < n; i++){
			prices[i] = scan.nextInt();
		}
		scan.close();
		int maxtoys = findMaxtoysCount(prices, k);
		System.out.println(maxtoys);
	}

	private static int findMaxtoysCount(int[] prices, int k) {
		
		int priceSum = 0;
		int result = 0;
		for(int i = 0; i < prices.length - 1; i++){
			for(int j = i+1; j < prices.length; j++){
				if(prices[i] > prices[j]){
					swap(i , j, prices);
				}
			}
			priceSum += prices[i];
			if(priceSum > k){
				result = i;
				break;
			}
		}
		return result;
	}

	private static void swap(int i, int j, int[] prices) {
		
		int temp = prices[i];
		prices[i] = prices[j];
		prices[j] = temp;
		
	}
}
