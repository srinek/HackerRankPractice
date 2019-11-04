package algo.arrays;

import java.util.Arrays;
import java.util.BitSet;

/*
 * https://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html
 * 
 */
public class MissingNumberInSequence {

	public static void main(String[] args) {
		MissingNumberInSequence prg = new MissingNumberInSequence();
		System.out.println(Arrays.toString(prg.findMissingNumbers(new int[]{1,2,3,4,6,8})));
		/*BitSet test =  new BitSet();
		test.set(0);
		test.set(1);
		test.set(2);
		test.set(5);
		System.out.println(test.nextClearBit(5));*/
	}
	
	public int[] findMissingNumbers(int[] arr){
		if(arr == null){
			return new int[0];
		}
		int count = arr.length;
		BitSet bitset =  new BitSet();
		for(int number : arr){
			bitset.set(number-1);
		}
		System.out.println(bitset);
		
		int missingCount = arr[arr.length-1] - count;
		int[] result = new int[missingCount];
		int missingIndex = 0;
		for(int i=0; i<missingCount; i++){
			missingIndex = bitset.nextClearBit(missingIndex);
			result[i] = missingIndex+1;
			missingIndex++;
		}
		return result;
	}
}
