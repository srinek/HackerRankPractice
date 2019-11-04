package algo.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		//int[] arr = {12, 11, 13, 5, 6};
		//int[] arr = {1, 2, 3, 4, 5, 6};
		int[] arr = {6, 5, 4, 3, 2, 1};
		//int[] arr = {1, 2, 4, 3, 6, 5};
		//int[] arr = {1, 2, 4, 3, 6, 5, 7};
		//int[] arr = {1};
		//int[] arr = {1, 2};
		ms.sort(arr, 0, arr.length-1);
		System.out.println( Arrays.toString(arr));
	}

	private void sort(int[] arr, int i, int j) {
		
		if(i < j){
			int mid = (i+j)/2;
			sort(arr, i, mid);
			sort(arr, mid+1, j);
			merge(arr, i, mid, j);
		}
		
	}

	private void merge(int[] arr, int i, int mid, int j) {
		
		
		int[] a1 = Arrays.copyOfRange(arr, i, mid+1);
		int[] a2 = Arrays.copyOfRange(arr, mid+1, j+1);
		
		
		
		int m=0, n=0, k=i;
		while(m < a1.length && n < a2.length){
			if(a1[m] < a2[n]){
				arr[k] = a1[m];
				m++;
			}
			else{
				arr[k] = a2[n];
				n++;
			}
			k++;
		}
		while(m < a1.length){
			arr[k++] = a1[m++];
		}
		while(n < a2.length){
			arr[k++] = a2[n++];
		}
	}

	


}
