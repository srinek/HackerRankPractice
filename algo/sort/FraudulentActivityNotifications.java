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
		for(int i = start; i < arr.length; i++){
			notifications += getNotification(arr, i-d, i, d);
		}
		return notifications;
	}

	private static int getNotification(int[] arr, int start, int end, int d) {
		
		int[] countsort = new int[200];
		
		for(int i = start; i < end; i++){
			countsort[arr[i]]++;
		}
		int median = findMedian(countsort, d);
		if(arr[end] >= median * 2){
			return 1;
		}
		return 0;
	}

	private static int findMedian(int[] countsort, int d) {
		
		int[] temp = new int[d];
		int tempfull = 0;
		for(int i = 0; i < countsort.length; i++){
			int total = countsort[i];
			while(total > 0){
				temp[tempfull++] = i;
				total--;
			}
			if(tempfull >= d){
				break;
			}
		}
		int mid = d/2;
		if(temp.length % 2 == 1){
			return temp[mid];
		}
        int even = temp[mid-1] + temp[mid];
        return even/2;
		
	}
}
