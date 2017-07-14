package algo.dp;

public class LargestIncreasingSubsequence {
	
	public static void main(String[] args) {
		findLargestIncreasingSubsequence(new int[]{1,3,2,4});
	}

	// 1 3 2 4
	private static int findLargestIncreasingSubsequence(int[] arr){
		
		int result = 1;
		int[] outarr = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			outarr[i] = 1;
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j] && outarr[i] <= outarr[j]){
					outarr[i] = outarr[j] + 1;
				}
			}
		}
		
		for(int k = 0; k < outarr.length; k++){
			System.out.println(outarr[k]);
			if(outarr[k] > result){
				result = outarr[k];
			}
		}
		return result;
		
	}
}
