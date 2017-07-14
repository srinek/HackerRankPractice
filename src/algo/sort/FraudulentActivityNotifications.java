package algo.sort;

import java.util.Scanner;

public class FraudulentActivityNotifications {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int d = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scan.nextInt();
		}
		scan.close();
		System.out.println(findNotifications(arr, d));
	}
	
	private static int findNotifications(int[] arr, int d){
		if(arr.length <= d){
			return 0;
		}
		int start = d;
		int notifications = 0;
		int medianIndex = d %2 == 0 ? d/2 : (d/2)+1;
		double median = 0;
		int[] countsort =  null;
		for(int i = start; i < arr.length; i++){
			if(countsort == null){
				countsort = getCountSort(arr, i-d, i, d);
			}
			int k = 0;
			int currCountSortIndex = 0;
			while(k < medianIndex){
				int total = countsort[currCountSortIndex];
				k = k + total;
				currCountSortIndex += 1;
			}
			int mid1 = currCountSortIndex - 1;
			median = computeMedian(mid1, currCountSortIndex, countsort, k, medianIndex, d) ;
			if(arr[i] >= 2*median){
				notifications += 1;
			}
			countsort[arr[i-d]]--;
			countsort[arr[i]]++;
		}
		
		return notifications;
	}

	private static double computeMedian(int currCountSortIndex, int mid2, int[] countsort, int total, int medianIndex, int d) {
		if(total > medianIndex || d % 2 != 0){  //same element repeated more than once or odd no. of days
			return currCountSortIndex;
		}
		while(countsort[currCountSortIndex] == 0){
			mid2++;
		}
		double ret = (double)(currCountSortIndex + mid2) / 2;
		return ret;
	}

	private static int[] getCountSort(int[] arr, int start, int end, int d) {
		
			int[] countsort = new int[201];
			
			for(int i = start; i < end; i++){
				countsort[arr[i]]++;
			}

			return countsort;
	}
}
