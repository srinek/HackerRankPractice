package algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarcsCakeWalk {

	
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calories = new int[n];
        for(int calories_i=0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }
       long miles = findMinMiles(calories);
       System.out.println(miles);
    }

	private static long findMinMiles(int[] calories) {
		
		long miles = 0;
		Arrays.sort(calories);
        int k = 0;
		for(int i = calories.length - 1; i >=0; i--){
			miles += calories[i] * Math.pow(2, k);
			k++;
		}
		
		return miles;
	}
}
