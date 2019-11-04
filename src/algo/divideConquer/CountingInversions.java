package algo.divideConquer;

import java.util.Arrays;

public class CountingInversions {
	
	private int countInversions(int[] arr, int l, int r){
		
		int inversionCount = 0;
		if( l < r){
			int m = (l+r)/2;
			inversionCount = countInversions(arr, l, m);
			inversionCount += countInversions(arr, m+1, r);
			inversionCount += mergeAndCount(arr, l, m, r);
		}
		return inversionCount;
	}

	private int mergeAndCount(int[] arr, int l, int m, int r) {
		
		//System.out.println(1 + " " + m + " " + r);
		int n1 = m-l+1;
		int n2 = r-m;
		int[] left = new int[n1];
		int[] right = new int[n2];
		int inversionCount = 0;
		
		//populate left and right arrays
		for(int i=0; i<n1; i++){
			left[i] = arr[l+i];
		}
		for(int i=0; i<n2; i++){
			right[i] = arr[m+1+i];
		}
		
		//sort and merge the left and right
		int i=0, j= 0;
		int k = l;
		while( i < n1 && j < n2){
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k] = right[j];
				j++;
				inversionCount += (m+1-i);
				
			}
			k++;
		}
		
		while(i < n1){
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while(j < n2){
			arr[k] = right[j];
			j++;
			k++;
		}
		return inversionCount;
	}
	
	
	public static void main(String[] args) {
		int arr[] = new int[]{20, 4, 6};//{1, 20, 6, 4, 5};
		CountingInversions c = new CountingInversions();
        System.out.println("Number of inversions are " + c.countInversions(arr, 0, 2));
        System.out.println(Arrays.toString(arr));
     
	}

}
