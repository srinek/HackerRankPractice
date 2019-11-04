package algo.dp;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class StockMaxProfit {
	
	public static void main(String[] args) {
		StockMaxProfit obj = new StockMaxProfit();
		//System.out.println( obj.findMaxProfit(new int[]{9, 10, 8, 18, 4, 8, 11, 9}));
		//System.out.println( obj.findTotalProfits(new int[]{9, 10, 8, 18, 4, 8, 11, 9}));
		System.out.println( obj.findTotalProfits____2(new int[]{9, 10, 8, 18, 4, 8, 11, 9}));
	}

	public int findMaxProfit(int[] stockPrices){
		
		int profit = 0;
		if(stockPrices.length < 2){
			return profit;
		}
		
		int min = stockPrices[0];
		int max = 0;
		for(int i = 1; i < stockPrices.length; i++){
			max = stockPrices[i];
			profit = Math.max((max - min), profit) ;
			min = Math.min(min, stockPrices[i]);
		}
		return profit;
	}
	
	public int findTotalProfits____2(int[] stockPrices){
		int totalProfit = 0;
		if(stockPrices.length < 2){
			return totalProfit;
		}
		
		int buyPrice = stockPrices[0];
		int profit = 0;
		for(int i=1; i <  stockPrices.length; i++){
			int price = stockPrices[i];
			if(price-buyPrice > profit){
				profit = price-buyPrice;
			}
			else{
				totalProfit+= profit;
				profit = 0;
				buyPrice = price;
			}
			if(profit > 0 && i == stockPrices.length-1){
				totalProfit+= profit;	
			}
			
		}
		
		return totalProfit;
	}
	
	
	public int findTotalProfits(int[] stockPrices){
		
		int profitSoFar = 0;
		if(stockPrices.length < 2){
			return profitSoFar;
		}
		
		Map<Integer, Integer> allProfits = new HashMap<>();
		int minIndex = 0;
		int min = stockPrices[minIndex];
		int max = 0;
		for(int i = 1; i < stockPrices.length - 1; i++){
			max = stockPrices[i];
			profitSoFar = Math.max((max - min), profitSoFar) ;
			trackProfits(minIndex, profitSoFar, allProfits);
			minIndex = Math.min(min, stockPrices[i]) == min ? minIndex : i;
			profitSoFar = Math.min(min, stockPrices[i]) == min ? profitSoFar : 0;
			min = Math.min(min, stockPrices[i]);
		}
		return sumAllProfits(allProfits);
	}
	
	private int sumAllProfits(Map<Integer, Integer> allProfits){
		
		int sum = 0;
		for(int val : allProfits.values()){
			sum += val;
		}
		return sum;
	}
	
	
	private void trackProfits(int profitIndex, int profit, Map<Integer, Integer> allProfits) {
		if( allProfits.get(profitIndex) != null){
			int temp = allProfits.get(profitIndex);
			profit = Math.max(temp, profit);
		}

		allProfits.put(profitIndex, profit);
	}
}
