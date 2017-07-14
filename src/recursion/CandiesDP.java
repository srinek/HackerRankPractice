package recursion;

import java.util.Scanner;

public class CandiesDP {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ratings = new int[n];
		int index = 0;
		while(index < n){
			ratings[index] = scan.nextInt();
			index++;
		}
		scan.close();
		System.out.println(optimalDistribution(ratings));
	}

	private static long optimalDistribution(int[] ratings) {
		int length = ratings.length;
		int[] result = new int[length];
		int dist = 1;
		result[0] = 1;
		for(int i = 1; i < ratings.length; i++){
			if(ratings[i] > ratings[i-1]){
				dist++;
			}
			else{
				dist = 1;
			}
			result[i] = dist;
		}
		dist = 1;
		for(int i = length - 2; i >= 0; i--){
			if(ratings[i] > ratings[i+1]){
				dist++;
			}
			else{
				dist = 1;
			}
			result[i] = Math.max(result[i], dist) ;
		}
		long total = 0;
		for(int i = 0; i < result.length; i++){
			total += result[i];
		}
		return total;
	}
}
