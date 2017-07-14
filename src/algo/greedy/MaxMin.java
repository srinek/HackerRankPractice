package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
	
	 public static void main(String[] args) {

		  Scanner in = new Scanner(System.in);
	      int n = in.nextInt();
	      int k = in.nextInt();
	      int[] list = new int[n];

	      for(int i = 0; i < n; i ++)
	         list[i] = in.nextInt();
	      
	      int unfairness = minUnfairness(list, k);
	      
	      
	      
	      System.out.println(unfairness);
	   }

	private static int minUnfairness(int[] a, int k) {
	
		Arrays.sort(a);
		int i = 0;
		int j = k-1;
		int unfairness = Integer.MAX_VALUE;
		while(j < a.length){
			int temp = a[j] - a[i];
			if(temp < unfairness ){
			   unfairness = temp;
			}
			i += 1;
			j += 1;
		}
		return unfairness;
	}

}
