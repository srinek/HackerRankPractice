package algo.dp;

import java.util.Scanner;

/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	    int total = scan.nextInt();
	    int coinslength = scan.nextInt();
	    int[] coins = new int[coinslength];
	    int index = 0;
	    while(index < coinslength){
	    	coins[index++] = scan.nextInt();
	    }
		scan.close();
		System.out.println(findChange(coins, total));
	}

	private static long findChange(int[] coins, int total){
		
		long[][] results = new long[coins.length+1][total+1]; // we start from 0 to length
		
		results[0][0] = 1; // hypothetical for base line
		
        for(int j =0; j < coins.length; j++){
        	results[j][0] = 1;
        }
		
		for(int i = 1; i <= coins.length; i++){
			for(int j = 0; j <= total; j++){
				
				if(coins[i-1] > j){
				    	results[i][j] = results[i-1][j];
				}
				else{
					
					results[i][j] = results[i-1][j] + results[i][j - coins[i-1]];
				}
			}
		}
		
		return results[coins.length][total];
	}
}
