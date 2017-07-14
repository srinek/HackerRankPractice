package algo.arrays;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		Instant start = Instant.now();
		Scanner scan = new Scanner(System.in);
		int asize = scan.nextInt();
		//System.out.println("--- "+(asize < 3) +" ---  "+ (asize > Math.pow(10, 7)));
		//assert  asize < 3 ||  asize > Math.pow(10, 7) : "N is not in limits";
		if(asize < 3 ||  asize > Math.pow(10, 7)){
			throw new Exception("N "+asize+" is not in limits");
		}
		long[] a = new long[asize];
		long m = scan.nextInt();
		//assert  m < 1 || m > Math.pow(10, 5) * 2 : "M is not in limits";
		if( m < 1 || m > Math.pow(10, 5) * 2){
			throw new Exception("M "+m+" is not in limits");
		}
		for(long i=0; i < m; i++){
			int begin = scan.nextInt();
			int end = scan.nextInt();
			//assert  begin < 1 || end < begin || end > asize : "a or b  out of limits";
			if(  begin < 1 || end < begin || end > asize){
				throw new Exception("a "+begin+" or b "+end+"  out of limits");
			}
			int toAdd = scan.nextInt();
			//assert toAdd < 0 ||  toAdd > Math.pow(10, 9) : "k is not in limits";
			if(toAdd < 0 ||  toAdd > Math.pow(10, 9)){
				throw new Exception("k "+toAdd+" is not in limits");
			}
			
			a[begin-1] += toAdd;
			if(end <= asize -1){
				a[end] += -toAdd;
			}
			System.out.println("-- "+Arrays.toString(a)+" ---");
		}
		//System.out.println("-- "+Arrays.toString(a)+" ---");
		long maxVal = a[0];
		for(int k=1; k <asize; k++){
			a[k] += a[k-1];
			if(a[k] > maxVal){
				maxVal = a[k];
			}
		}
		scan.close();
		Instant end = Instant.now();
		//System.out.println(Duration.between(start, end).getSeconds());
		System.out.println(maxVal);
	}
}