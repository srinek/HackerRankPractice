package algo.greedy;

import java.util.Scanner;

public class PermutingTwoArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		while(tests-- > 0){
			int n = scan.nextInt();
			int k = scan.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for(int i = 0; i < n; i++){
				int val = scan.nextInt();
				a[i] = val;
			}
			for(int i = 0; i < n; i++){
				int val = scan.nextInt();
				b[i] = val;
			}
			String perm = validPermutationExist(a, b, k);
			System.out.println(perm);
		}
		scan.close();
	}

	private static String validPermutationExist(int[] a, int[] b, int k) {
		
		for(int i = 0; i < a.length - 1; i++){
			for(int j = i+1; j < a.length; j++){
				if(a[i] > a[j]){
					swap(i, j, a);
				}
				if(b[i] < b[j]){
					swap(i, j, b);
				}
			}
			if(a[i] + b[i] < k){
				return "NO";
			}
		}
		return "YES";
	}

	private static void swap(int i, int j, int[] prices) {
		
		int temp = prices[i];
		prices[i] = prices[j];
		prices[j] = temp;
		
	}
}
