package algo.arrays;

import java.util.Arrays;

public class BirthdayRotation {
	
	
	public static void main(String[] args) {
		int[] months = {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] output = rotateBirthdays(months, 10);
		System.out.println( Arrays.toString(output));
	}
	
	private static int[] rotateBirthdays(int[] months, int currentMonth){
		
		int[] output = new int[months.length];
		int ci = currentMonth-1;
		for(int i=0; i < months.length; i++){
			
			int rotateBy = i+ci >= months.length ? i+ci - months.length : i+ci ;
			//System.out.println( i+" "+months.length+" "+rotateBy);
			output[i] = months[rotateBy];
		}
		
		return output;
		
	}

}
