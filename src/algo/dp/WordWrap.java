package algo.dp;

import java.util.Arrays;

public class WordWrap {

	private static void wordWrap(int m, String[] words){
		
		int n = words.length;
		int[][] costTable = new int[n][n];
		prepareCostTable(m, words, n, costTable);
		int[] lineBreaks = new int[n];
		int[] costPerLineBreak = new int[n];
		int i =n, j=n;
		while( i >= 0){
			j = n;
			int cost = Integer.MAX_VALUE;
			while( j >= i){
				int val = costTable[i-1][j-1];
				if(val != Integer.MAX_VALUE){
					lineBreaks[i-1] = j;
					costPerLineBreak[i-1] = cost;
				}
				else{
					
				}
				int minCost = costTable[i-1][j-1];
				if(minCost < cost){
					cost = minCost;  
				}
				
				j--;
			}
			
			i--;
		}
		System.out.println(Arrays.toString(costPerLineBreak));
		System.out.println(Arrays.toString(lineBreaks));
	}

	private static void prepareCostTable(int m, String[] words, int n, int[][] costTable) {
		for(int i = 0; i < n; i++){
			int tempM = m;
			for(int j = i; j < n; j++){
				if(words[j].length() <= tempM){
					tempM = tempM - words[j].length();
					costTable[i][j] = (int)Math.pow(tempM, 2);
					tempM--; // assume a space
				}
				else{
					costTable[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for(int i = 0; i < costTable.length; i++){
			System.out.println(Arrays.toString(costTable[i]));
		}
	}
	
	public static void main(String[] args) {
		wordWrap(10, new String[]{"Nandan","Nek", "likes", "to", "code"});
	}
}
