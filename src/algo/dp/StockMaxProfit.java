package algo.dp;

import java.util.HashMap;
import java.util.Map;

public class StockMaxProfit {
	
	public static void main(String[] args) {
		StockMaxProfit obj = new StockMaxProfit();
		//System.out.println( obj.findMaxProfit(new int[]{9, 10, 8, 18, 4, 8, 11, 9}));
		System.out.println( obj.findTotalProfits(new int[]{9, 10, 8, 18, 4, 8, 11, 9}));
	}

	public int findMaxProfit(int[] stockPrices){
		
		int profit = 0;
		if(stockPrices.length < 2){
			return profit;
		}
		
		int min = stockPrices[0];
		int max = 0;
		for(int i = 1; i < stockPrices.length - 1; i++){
			max = stockPrices[i];
			profit = Math.max((max - min), profit) ;
			min = Math.min(min, stockPrices[i]);
		}
		return profit;
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
