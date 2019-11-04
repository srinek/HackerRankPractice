package algo.dp;

public class MinSumPartition {

	
	/**
	 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
	 

	If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

	Example:

	Input:  arr[] = {1, 6, 11, 5} 
	Output: 1
	Explanation:
	Subset1 = {1, 5, 6}, sum of Subset1 = 12 
	Subset2 = {11}, sum of Subset2 = 11  
	
	*/
	
	public static void main(String[] args) {
		
		MinSumPartition min = new MinSumPartition();
		min.minPartition(new int[]{1, 6, 11, 5});
	}
	
	private void minPartition(int[] arr){
		
		int sumTotal = 0;
		int subsetSum = 0;
		
		for(int i=0; i<arr.length; i++){
			sumTotal += arr[i];
		}
		
		System.out.println(_minminPartition(arr, arr.length-1, sumTotal, subsetSum));
	}

	private int _minminPartition(int[] arr, int i, int sumTotal, int subsetSum) {
		
		if(i == 0){
			return Math.abs((sumTotal - subsetSum) - subsetSum);
		}
		return Math.min(_minminPartition(arr, i-1, sumTotal, subsetSum+arr[i]), 
				_minminPartition(arr, i-1, sumTotal, subsetSum));
		
	}
	
	private void minPartitionDP(int[] arr){
		
	}
}
