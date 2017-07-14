package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int[] c = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}
		in.close();
		int maxdiff = maxDiff(c, k);
		System.out.println(maxdiff);
	}

	private static int maxDiff(int[] c, int k) {
		Arrays.sort(c);
		int i = 0;
		int j = 1;
		int result = 0;
		
		while(j < c.length){
			
			if(c[j] - c[i] == k){
				result++;
				i++;
				j++;
			}
			else if(c[j] - c[i] > k){
				i++;
			}
			else if(c[j] - c[i] < k){
				j++;
			}
		}
		
		return result;
	}
}
