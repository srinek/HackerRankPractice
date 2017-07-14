package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinAbsDifference {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		int min = minAbsDifference(a);
		System.out.println(min);
	}

	private static int minAbsDifference(int[] a) {
		
		if(a.length == 0){
			return 0;
		}
		int diff = Integer.MAX_VALUE;
		
		Arrays.sort(a);
		for(int i = 1; i < a.length; i++){
			int ldiff = Math.abs(a[i-1] - a[i]);
			if(ldiff < diff){
				diff = ldiff;
			}
		}
		return diff;
	}
	
	
}
