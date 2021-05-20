package algo.arrays;

import java.util.Arrays;

/*
 * mary has n (always even) chocolates, which she has to share half with her brother.
 * She wants to make sure she gets maximum unique chocolates. Find how many max unique chocolates she can get.
 * for Ex : [3,4,6,6, 7, 7] - should return 3
 *          [80,80,80,80, 6757774, 80, 80, 123221] - should return 3.  
 */
public class MaximumizeUniqueElements {
	
	//[1,4,4,4,4,6]
	//[1,4,4,4,4,4]
	//[1,2]
	//[3,4,6,6, 7, 7]
	//[80,80,80,80, 6757774, 80, 80, 123221]
	public static int findMaximumUniqueElements(int[] a){
		
		if(a == null || a.length == 0){
			return 0;
		}
		Arrays.sort(a);
		int result = 0;
		for(int i=0; i<a.length-1; i++){
			if(a[i] != a[i+1] && result < a.length/2){
				result++;
			}
		}
		if(result < a.length/2){
			result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		//System.out.println(findMaximumUniqueElements(new int[]{1,2}));
		System.out.println(findMaximumUniqueElements(new int[]{2,2,2,2,2,2}));
		//System.out.println(findMaximumUniqueElements(new int[]{80,80,80,80, 6757774, 80, 80, 123221}));
	//	System.out.println(findMaximumUniqueElements(new int[]{3,4,6,6, 7, 7}));
	}
	
}