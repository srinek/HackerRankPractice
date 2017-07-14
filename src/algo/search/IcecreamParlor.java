package algo.search;

import java.util.Scanner;

public class IcecreamParlor {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		int index = 0;
		while(index < tests){
			int total = scan.nextInt();
			int asize = scan.nextInt();
			int[] a = new int[asize];
			int i = 0;
			while(i < asize){
				a[i++] = scan.nextInt();
			}
			int[] result = new int[2];
			result[0] = -1;
			result[1] = -1;
			findNumber(a, total, 0, result);
			System.out.println((result[0]+1) +" "+(result[1]+1));
			//bruteforce(a, total, result);
			index++;
		}
		scan.close();
		
	}
	
	/*private static void bruteforce(int[] a, int total, int[] result){
		
		for(int i = 0; i < a.length; i++){
			for(int j = i+1; j < a.length; j++){
				if(a[i]+a[j] == total){
					System.out.println((i+1)+" "+(j+1));
					return;
				}
			}
		}
	}*/
	
	public static void findNumber(int[] a, int total, int i, int[] result){
		
		if(result[0] >= 0 && result[1] >= 0){
			return;
		}
		if(i >= a.length){
			return;
		}
		int reminder = total - a[i];
		
		if(reminder == 0 && result[0] >= 0){
			result[1] = i;
		}
		else if(reminder <= 0){
			findNumber(a, total, i+1, result); //exclude
		}
		else if(reminder > 0){
			result[0] = i;
			findNumber(a, reminder, i+1, result); //include
			if(result[1] < 0){ // problem not solved yet
				result[0] = -1;  // don;t add the result
				findNumber(a, total, i+1, result); //exclude
			}
			
		}
	}
	
}
