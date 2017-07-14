package algo.greedy;

import java.util.Scanner;

public class BeautifulPair {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[1001];
		int[] b = new int[n];
		for(int i = 0; i < n; i++){
			a[scan.nextInt()]++;
		}
		for(int i = 0; i < n; i++){
			b[i] = scan.nextInt();
		}
		scan.close();
		
		int result = findMaxDisjointPairs(a,b);
		System.out.println(result);
	}

	private static int findMaxDisjointPairs(int[] a, int[] b) {
	    int result = 0;
		for(int i = 0; i< b.length; i++){
			if(a[b[i]] > 0 ){
				a[b[i]] --;
				result++;
				continue;
			}
		}
		if(result == b.length){ // all elements are same, must swap 1 element in B
			result--;
		}
		else{  // at least 1 element in B not matching, swap 1 element
			result++;
		}
		return result;
	}
}
