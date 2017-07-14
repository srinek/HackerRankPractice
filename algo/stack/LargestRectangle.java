package algo.stack;

import java.util.Scanner;

public class LargestRectangle {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] buildings = new int[total];
		int index = 0;
		while(index < total){
			buildings[index] = scan.nextInt();
			index++;
		}
		scan.close();
		System.out.println(getLargestRectangle(buildings));
	}
	
	public static int getLargestRectangle(int[] buildings) {
		int maxSumOfAll = 0;
		for(int i=0; i< buildings.length;  i++){
			int innerBegin = i;
			while(innerBegin >0 && buildings[i] <= buildings[innerBegin-1]){
				innerBegin--;
			}
			int maxsum = 0;
			int sum = 0;
			for(int k=innerBegin; k < buildings.length; k++){
				if(buildings[i] <= buildings[k]){
					sum += buildings[i];
				}
				else{
					if(sum > maxsum){
						maxsum = sum;
					}
					sum = 0;
					if(k > i){
						break;
					}
				}
			}
			if(sum > maxsum){
				maxsum = sum;
			}
			if(maxsum > maxSumOfAll){
				maxSumOfAll = maxsum;
			}
			//System.out.println(maxSumOfAll);
		}
		return maxSumOfAll;
	}
}
