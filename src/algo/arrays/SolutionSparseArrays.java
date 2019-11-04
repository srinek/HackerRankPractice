package algo.arrays;

import java.util.Scanner;


/*
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class SolutionSparseArrays {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int first = scan.nextInt();
		String[] a = new String[first];
		for(int i = 0; i < first; i++){
			a[i] = scan.next();
		}
		int second = scan.nextInt();
		String[] b = new String[second];
		for(int j = 0; j < second; j++){
			b[j] = scan.next();
		}
		scan.close();
		SolutionSparseArrays sol = new SolutionSparseArrays();
		int[] ret = sol.matchstrings(a, b);
		for(int r : ret){
			System.out.println(r);
		}
	}
	
	public int[] matchstrings(String[] a, String[] b){
	
		int[] ret = new int[b.length];
		int index = 0;
		
		for(String b1 : b){
			for(String a1 : a){
				if(a1.equalsIgnoreCase(b1)){
					ret[index]++;
				}
			}
			index++;
		}
		return ret;
	}
}
