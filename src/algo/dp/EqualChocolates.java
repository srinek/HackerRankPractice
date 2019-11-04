package algo.dp;

import java.util.Scanner;

/*
 * https://www.hackerrank.com/challenges/equal/problem
 */
public class EqualChocolates {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int totaltests = scan.nextInt();
		
		for(int test_i = 0; test_i < totaltests; test_i++){
			int arrsize = scan.nextInt();
			int[] arr = new int[arrsize];
			int min = Integer.MAX_VALUE;
			for(int arr_i = 0; arr_i < arrsize; arr_i++){
				arr[arr_i] = scan.nextInt();
				if(arr[arr_i] < min){
					min = arr[arr_i];
				}
			}
			//System.out.println(findMinSteps(arr, min));
		}
			
		
		scan.close();
	}
	
	/*100% correct Java 8 Solution

	import java.io.; import java.util.;

	public class Solution {

	public static long find_min_actions(int[] cookies) {

	    Arrays.sort(cookies);

	    long sum = Long.MAX_VALUE;

	    for(int base = 0; base < 3; base++) {
	        int current_sum = 0;
	        for(int i = 0; i < cookies.length; i++) {
	            int delta = cookies[i] - cookies[0] + base;
	            current_sum += (int)delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1;
	        }
	        sum = Math.min(current_sum,sum);
	    }

	    return sum;
	}

	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    while(n-->0) {
	        int m = in.nextInt();
	        int cookies[] = new int[m];
	        for(int cookie_i=0; cookie_i < m; cookie_i++){
	            cookies[cookie_i] = in.nextInt();
	        }
	        System.out.println(find_min_actions(cookies));
	    }


	}
	}*/

}
