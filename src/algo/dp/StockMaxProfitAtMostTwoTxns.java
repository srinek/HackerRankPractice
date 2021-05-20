package algo.dp;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).



Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
Example 4:

Input: prices = [1]
Output: 0
 */
public class StockMaxProfitAtMostTwoTxns {
	
	public static void main(String[] args) {
		StockMaxProfitAtMostTwoTxns obj = new StockMaxProfitAtMostTwoTxns();
		//System.out.println( obj.findMaxProfit(new int[]{9, 10, 8, 18, 4, 8, 11, 9}));
		//System.out.println( obj.findTotalProfits(new int[]{9, 10, 8, 18, 4, 8, 11, 9}));
		System.out.println( obj.maxProfit(new int[]{9, 10, 8, 18, 4, 8, 11, 9}));
	}

	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length <= 1) return 0;

		int leftMin = prices[0];
		int rightMax = prices[length - 1];

		int[] leftProfits = new int[length];
		// pad the right DP array with an additional zero for convenience.
		int[] rightProfits = new int[length + 1];

		// construct the bidirectional DP array
		for (int l = 1; l < length; ++l) {
			leftProfits[l] = Math.max(leftProfits[l - 1], prices[l] - leftMin);
			leftMin = Math.min(leftMin, prices[l]);

			int r = length - 1 - l;
			rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - prices[r]);
			rightMax = Math.max(rightMax, prices[r]);
		}

		int maxProfit = 0;
		for (int i = 0; i < length; ++i) {
			maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
		}
		return maxProfit;
	}

}
