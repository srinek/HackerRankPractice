package algo.arrays;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/stockmax/problem
 */

public class StockMaximize {

	/*
	 * 3 3 5 3 2 3 1 2 100 4 1 3 1 6 2 4 5 3 1 3 4 6 2 1 3 2
	 */

	//1 2 100
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int N = in.nextInt();
			int[] prices = new int[N];
			for (int prices_i = 0; prices_i < N; prices_i++) {
				prices[prices_i] = in.nextInt();
			}
			//System.out.println(findMaxProfit(prices, 0));
			System.out.println(findMaxProfit(prices));
		}
		in.close();
	}
	
	private static long findMaxProfit(int[] input){
		
		long profit = 0;
		
		int maxSoFar = Integer.MIN_VALUE;
		
		for( int i = input.length-1; i >= 0; i--){
			
			if(input[i]  > maxSoFar){
				maxSoFar = input[i];
			}
			profit += ( maxSoFar - input[i]);
		}
		
		return profit;
	}

	private static long findMaxProfit(int[] input, int start) {

		int max = Integer.MIN_VALUE;

		for (int i = start; i < input.length; i++) {

			if (max < input[i]) {
				max = input[i];
			}
		}
		long maxprofit = 0;
		for (int i = start; i < input.length; i++) {

			if (input[i] != max) {
				maxprofit += (max - input[i]);
			} else {
				start = i + 1;
				break;
			}
		}
		if(start < input.length){
			maxprofit += findMaxProfit(input, start);
		}
		return maxprofit;

	}
}
