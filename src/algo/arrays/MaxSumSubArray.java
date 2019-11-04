package algo.arrays;


/*
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 */
public class MaxSumSubArray {
	
	
	public static void main(String[] args){
		
		int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maxSumSubArray(arr));
		
	}

	// [-2, -3, 4, -1, -2, 1, 5, -3]  ==> 7 
	public static int maxSumSubArray(int[] arr){
		
		if(arr == null || arr.length == 0){
			return 0;
		}
		int start = 0, end = 0, s = 0;
		int maxSum = arr[0];
		int maxSumSoFar = 0;
		for(int i = 0; i < arr.length; i++){
			maxSumSoFar += arr[i];
			
			if(maxSumSoFar > maxSum){
				start = s;
				end = i;
				maxSum = maxSumSoFar;
			}
			if(maxSumSoFar < 0){
				s = i+1;
				maxSumSoFar = 0;
			}
		}
		System.out.printf("start %s end %s \n", start, end);
		return maxSum;
	}
	
	
}
