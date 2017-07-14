package recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CandiesRecursion {
	
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
		Map<String, Integer> cache = new HashMap<>();
		System.out.println(optimalDistribution(ratings, 0, 0, cache));
		//System.out.println(optimalDistribution(new int[]{1,2,3,4}, 0, 0));
	}

	private static int optimalDistribution(int[] ratings, int index, int prevDistribution, 
			Map<String, Integer> cache){
		String key = index+","+prevDistribution;
		if(cache.get(key) != null){
			return cache.get(key);
		}
		if(index >= ratings.length){
			cache.put(key, 0);
			return 0;
		}
		int length = ratings.length - index;
		int[] minarr = new int[length];
		if(index > 0 && ratings[index-1] < ratings[index]){
			int result = (prevDistribution + 1) + optimalDistribution(ratings, index+1, prevDistribution + 1, cache);
			cache.put(key, result);
			return result;
		}
		if(index > 0 && ratings[index-1] > ratings[index]){
			if(prevDistribution <= 1){
				int result = (int)Math.pow(10, 6);
				cache.put(key, result);
				return result;
			}
		}
		for(int i = 0; i < length; i++){
			int result = (length - i) + optimalDistribution(ratings, index+1, (length - i), cache);
			cache.put(key, result);
			minarr[i] = result;
			
		}
		return min(minarr);
	}
	
	private static int min(int... arr){
		if(arr.length == 0){
			return 0;
		}
		int min = Math.abs(arr[0]);
		for(int i = 1; i < arr.length; i++){
			if(Math.abs(arr[i]) < min){
				min = arr[i];
			}
		}
		return min;
	}
}
