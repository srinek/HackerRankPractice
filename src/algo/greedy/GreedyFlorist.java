package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

	private static int getMinimumCost(int n, int k, int[] c) {
		Arrays.sort(c);
		int minCost = 0;
		int j = 1, cnt = 1;
		for(int i = 0; i < n; i++, cnt++){
			minCost += (j) * c[(n-1)- i];
			if((cnt % k) == 0) {
				j++;
			}
		}
		
		return minCost;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}
		in.close();
		int minimumCost = getMinimumCost(n, k, c);
		System.out.println(minimumCost);
	}
}
