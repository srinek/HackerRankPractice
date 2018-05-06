package gsCodesprint;

import java.util.Scanner;

public class TraderProfit {

	
/*	static int traderProfit(int k, int n, int[] stocks) {
		int profit = 0;
        int lastBuyIndex = stocks.length;
        while(k > 0 && lastBuyIndex > 0){
        	int profitSoFar = 0;
            int maxSoFar = 0;
            for (int i = lastBuyIndex -1; i > -1 ; i--) {
            	if(stocks[i] > maxSoFar){
            		maxSoFar = stocks[i];
            	}
                int lProfit = maxSoFar - stocks[i];
                if(lProfit > profitSoFar){
                	profitSoFar = lProfit;
                	lastBuyIndex = i;
                }
            }
        	 profit += profitSoFar;
        	 k--;
        }
        
        return profit;
    }*/
	
	/*
3
6
20 45 20 580 420 900
	 */
	
	private static int traderProfit(int k, int n, int[] stocks) {
		

        int[][] res = new int[k+1][n];
        
        
        for(int i=1; i<k+1; i++){
        	int maxdiff= -stocks[0];
        	for(int j=1; j<n; j++){
        		maxdiff = Math.max(maxdiff, res[i-1][j] - stocks[j]);
        		res[i][j] = Math.max(res[i][j-1], maxdiff+stocks[j]);
        	}
        }
        return res[k][n-1];
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }
}
