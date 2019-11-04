package algo.dp;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/coin-change/solution/
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChangeUnique {
	
	public static void main(String[] args) {
		
		CoinChangeUnique coinChange = new CoinChangeUnique();
	 	System.out.println(coinChange.coinChange(new int[]{2}, 21));
	}
	
	public int coinChange(int[] coins, int amount) {
        int max = amount + 1;             
        int[] dp = new int[amount + 1];  
        Arrays.fill(dp, max);  
        dp[0] = 0;   
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
	 /*public int coinChange(int[] coins, int total) {
	        
	        int[][] results = new int[coins.length+1][total+1]; // we start from 0 to length
			
			results[0][0] = Integer.MAX_VALUE; // hypothetical for base line
			

			
			for(int i = 0; i <= coins.length; i++){
				for(int j = 0; j <= total; j++){
					
	                if(i == 0 ){
	                    results[i][j] = Integer.MAX_VALUE;
	                }
	                else if(j == 0){
	                	results[i][j] = 0;
	                }
					else if(coins[i-1] > j){
					    	results[i][j] = results[i-1][j];
					}
					else{
						results[i][j] = Math.min(1+results[i][j-coins[i-1]] , results[i-1][j]);
					}
				}
			}
			if(results[coins.length][total] < 0){
				return -1;
			}
			return results[coins.length][total];
	    }*/

}
