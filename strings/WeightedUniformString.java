package strings;

import java.util.Scanner;

public class WeightedUniformString {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		int total = scan.nextInt();
		int[] weights = new int[total];
		for(int i = 0; i < total; i++){
			weights[i] = scan.nextInt();
		}
		scan.close();
		printWeights(str, weights);
	}
	
	//abccddde
	private static void printWeights(String str, int[] weights){
		
		int[] chars = new int[str.length()];
		int i = 0;
		for(char c: str.toCharArray()){
			chars[i++] = c - 96;
		}
		int prev = chars[0];
		for(int k = 1; k < chars.length; k++){
			int val = chars[k];
			if(prev == val){
				chars[k] += chars[k-1];
			}
			prev = val;
		}
		boolean matched = false;
		for(int j : weights){
			for(int k : chars){
				if( j == k){
					matched = true;
					break;
				}
			}
			if(matched){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
			matched = false;
		}
	}

}
