package algo.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		int index = 0;
		while(index++ < tests){
			int count = scan.nextInt();
			int[] a = new int[count];
			int k = scan.nextInt();
			for(int i=0; i< count; i++){
				a[i] = scan.nextInt();
			}
			System.out.println(findClosestSum(a, k));
		}
		scan.close();
	}
	
	private static int findClosestSum(int[] a, int k){
		
		Arrays.sort(a);
		int[] mod_a = new int[a.length];
		
		for(int i=0; i<a.length; i++){
			if(a[i] > k){
				continue;
			}
			int mod =  k % a[i];
			if( mod == 0){
				return k;
			}
			mod_a[i] = mod;
		}
		int result = Integer.MAX_VALUE;
		for(int i=0; i< mod_a.length; i++){
			if(mod_a[i] == 0){
				continue;
			}
			for(int j=0; j<a.length; j++){
				if(mod_a[i] >= a[j]){
					int temp = mod_a[i] % a[j];
					if(temp < result){
						result = temp;
					}
				}
				else{
					break;
				}
			}
		}
		
		return k-result;
	}
}
 