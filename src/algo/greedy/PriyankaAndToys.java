package algo.greedy;

import java.util.Scanner;

public class PriyankaAndToys {
	
	public static void main(String[] args) {
		
		Scanner  scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int index = 0;
		int[] toys = new int[10001];
		while(index < n){
			int weight = scan.nextInt();
			toys[weight]++; 
			index++;
		}
		scan.close();
		int unitsBought = minUnitsBought(toys);
		System.out.println(unitsBought);
	}

	private static int minUnitsBought(int[] toys) {
		int result = 0;		
		for(int i=0; i < toys.length; i++){
			if(toys[i] == 0){
				continue;
			}
			result++;
			for(int j =i;  j <= i+4; j++){
				toys[j] = 0;
			}
		}
		return result;
	}

}
