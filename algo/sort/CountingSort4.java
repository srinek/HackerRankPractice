package algo.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountingSort4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int index = 0;
		int[] arr = new int[n];
		Map<Integer, List<String>> records = new HashMap<>();
		List<String> strList = null;
		int half = n/2;
		String str = "";
		while(index < n){
			arr[index] = scan.nextInt();
			if(index < half){
				str = "-";
				scan.next();
			}
			else{
				str = scan.next();
			}
			strList = records.get(arr[index]);
			if(strList == null){
				strList = new ArrayList<>();
				strList.add(str);
				records.put(arr[index], strList);	
			}
			else{
				strList.add(str);
			}
			index++;
		}
		scan.close();
		int[] result = new int[100];
		sort(arr, result, records);
	}

	private static void sort(int[] arr, int[] result, Map<Integer, List<String>> records) {
		
		for(int i : arr){
			result[i]++;
		}
		
		for(int i = 0; i < result.length; i++){
			int count = result[i];
			for(int k = 0; k < count; k++){
				System.out.print(getStringValue(records, i, k)+" ");
			}
		}
		
	}

	private static String getStringValue(Map<Integer, List<String>> records, int i, int k) {
		List<String> strList = records.get(i);
		if(strList != null){
			return strList.get(k);
		}
		return null;
	}
	
	
}
