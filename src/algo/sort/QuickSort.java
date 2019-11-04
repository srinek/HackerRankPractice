package algo.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		//int[] arr = new int[]{5,4,3,2,1};
		int[] arr = new int[]{4,3,2,1,5};
		sort.sortArray(arr);
		///System.out.println(Arrays.toString(arr));
	}
	
	
	public int[] sortArray(int[] nums) {

		qSort(nums, 0, nums.length);

		return nums;

	}

	
	private void qSort(int[] nums, int l, int r) {
		
		  if(l < r){
			  int p = partition(nums, l ,r);
			  qSort(nums, l, p-1);
			  qSort(nums, p+1, r);
		  }
		
		
	}
	
	
	
	private int partition(int[] nums, int l, int r){
		
		int pivotIndex = ThreadLocalRandom.current().nextInt(l, r);
		
		swap(nums, pivotIndex, r-1);
		System.out.println("-----------------------");
		System.out.println(l+" "+ r +"  "+Arrays.toString(nums));
		
		int pivot = nums[r-1];
		// 4 5 2 1 3
		int i = l;
		int j = i;
		
		for( ; j<r; j++){
			
			if( nums[j] <= pivot){
				swap(nums, i, j);
				i++;
			}
		}
		//swap(nums, i, j);
		
		System.out.println(i+" "+ pivotIndex +"  "+Arrays.toString(nums));
		
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 1 2 4 3
	/*private void qSort(int[] nums, int l, int h) {

		if (l < h) {

			int pi = partition(nums, l, h);
			qSort(nums, l, pi-1);
			qSort(nums, pi + 1, h);
		}
	}

	private int partition(int[] nums, int l, int h) {

		
		int p = nums[h];

		int i = l;
		for (int j = l; j <= h; j++) {

			if (nums[j] <= p) {
				swap(nums, i, j);
				i++;
			}
		}
		return i - 1;
	}*/

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
