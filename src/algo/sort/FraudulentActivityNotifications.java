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
		int mi = (d/2);
		double median = 0;
		int[] countsort =  null;
		for(int i = start; i < arr.length; i++){
			if(countsort == null){
				countsort = getCountSort(arr, i-d, i, d);
			}
            //System.out.println(Arrays.toString(countsort));
        	int total = 0;
            int csi = 0;
			int mid_1 = -1;
            int mid_2 = 0;
            while( total < mi+1){// mi+1 as countsort index is 1 up.
				int tempTotal = total + countsort[csi];
                if(tempTotal > total){
                    mid_1 = mid_2;
                    mid_2 = csi;
                }
                total = tempTotal;
                csi++;
			}
			median = computeMedian(mid_1, mid_2, d) ;
			if(arr[i] >= 2*median){
				notifications += 1;
			}
			countsort[arr[i-d]]--;
			countsort[arr[i]]++;
		}
		
		return notifications;
	}

	private static double computeMedian(int mi1, int mi2, int d) {
        int i = 0;
        int val1 = 0;
        int val2 = 0;
        //System.out.println(mi1+" "+mi2);
		if(d % 2 == 0){  //even
            /*while(countsort[i] != mi1){
                i++;
            }
            val1 = i;
            while(countsort[i] != mi2){
                i++;
            }
            val2 = mi2;
			double ret = (double)(val1 + val2) / 2;*/
            double ret = (double)(mi1 + mi2) / 2;
            return ret;
		}
        /*while(countsort[i] != mi2){  //odd
                i++;
        }
        return i;*/
        return mi2;
    }

	private static int[] getCountSort(int[] arr, int start, int end, int d) {
		
			int[] countsort = new int[201];
			
			for(int i = start; i < end; i++){
				countsort[arr[i]]++;
			}

			return countsort;
	}
	
	/*private static int findNotifications(int[] arr, int d){
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
	}*/
}
