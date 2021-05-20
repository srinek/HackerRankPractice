package gsCodesprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 
 * https://www.hackerrank.com/contests/gs-codesprint/challenges/buy-maximum-stocks/problem
 * 
 * In a stock market, there is a product with its infinite stocks. The stock prices are given for  days, where denotes the price of the stock on the  day. There is a rule that a customer can buy at most  stock on the  day.
 * If the customer has an amount of  dollars initially, find out the maximum number of stocks they can buy?

For example, for  days the price of a stock is given as . You can buy  stock worth  on day , stocks worth  each on day  and  stocks worth  each on day . If , you can buy all the stocks (total ) for .

Input Format

The first line contains an integer  denoting the number of days. 
The next line contains  space-separated integers where  integer denotes the price of the stock on the day. Next line contains a positive integer  which is the initial amount with the customer.

Constraints

Output Format

Print the maximum number of stock that a customer can buy.

Sample Input 0

3
10 7 19
45
Sample Output 0

4
Explanation 0

The customer can purchase  stock on day ,  stock on day  and  stock on day  for ,  and  respectively. Hence, total amount is  and number of stocks purchased is .
 */
public class BuyMaximumStocks {
	
	
	public static class StockPair implements  Comparable<StockPair>{
		public int stockPrice;
		public int qty;
		
		public StockPair(int stockPrice, int stockQty){
			this.stockPrice = stockPrice;
			this.qty = stockQty;
		}

		@Override
		public int compareTo(StockPair o) {
			if(this.stockPrice > o.stockPrice){
				return 1;
			}
			if(this.stockPrice < o.stockPrice){
				return -1;
			}
			if(this.qty > o.qty){
				return -1;
			}
			if(this.qty < o.qty){
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			return "{"+ this.stockPrice + ","+this.qty +"}";
		}
	
	}
	
	public static long buyMaximumProducts(int n, long k, int[] a) {
	  
	  List<StockPair> stockPairs = new ArrayList<>();
	  for(int i=0; i<n; i++){
		  stockPairs.add(new StockPair(a[i], i+1));
	  }
  
	  Collections.sort(stockPairs);
	  //System.out.println(stockPairs);
	  long totalCount = 0;
	  for(int i=0; i<n ; i++){
		 StockPair stock = stockPairs.get(i);
		 
		 if(k < stock.stockPrice){
			 break;
		 }
		 long l = stock.qty * stock.stockPrice <= k ? stock.qty : k/stock.stockPrice;
		 k = k - l * stock.stockPrice;
		 totalCount += l;
	  }
	  
	  return totalCount;
	}
	
	

	
	
	
/*
3  
99 20 1 
100

3
3 1 4
9
 */
	    public static void main(String[] args) {
	        /*Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for(int arr_i = 0; arr_i < n; arr_i++){
	            arr[arr_i] = in.nextInt();
	        }
	        long k = in.nextLong();*/
	        long result = buyMaximumProducts(3, 28, new int[]{10,7, 5});
	        System.out.println(result);
	        //in.close();
	    }

}
