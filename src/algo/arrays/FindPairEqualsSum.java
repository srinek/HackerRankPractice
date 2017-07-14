package algo.arrays;

public class FindPairEqualsSum {

	public static void main(String[] args) {
		int[] a = new int[]{2, 4, 5, 7, 9};
		findPairEqualsSum(a, 7);
	}
	
	//array is sorted
	public static void findPairEqualsSum(int[] arr, int sum){
		
		findMatchSum(arr, 0, arr.length-1, sum);
		
	}
	
	public static void findMatchSum(int[] arr, int left, int right, int sum){
		if(left == right || left > right){
			System.out.println(" done ");
			return;
		}
		if(arr[left]+ arr[right] == sum){
			System.out.println(arr[left] +" "+ arr[right]);
			findMatchSum(arr, left+1, right-1, sum);
		}
		if(arr[left] + arr[right] < sum){
			findMatchSum(arr, left+1, right, sum);
		}
		if(arr[left] + arr[right] > sum){
			findMatchSum(arr, left, right-1, sum);
		}
	}
}
