package recursion;

public class StringCombinations {
	
	/*
	 * https://careercup.com/question?id=5700586788356096
	 * 
	 *  10$ should print 100, 101
	 *  23$$ should print 2322, 2323, 2332, 2333
	 */

	public static void main(String[] args){
	   stringCombinations("23$$", 0, "", new int[]{2,3});	
	}
	
	public static void stringCombinations(String input, int index, String print, int[] numbers){
		
		if(index >= input.length()){
			System.out.println(print);
			return;
		}
		//System.out.println(index);
		char c = input.charAt(index);
		if(Character.isDigit(c)){
			stringCombinations(input, index+1, print+c, numbers);
		}
		else{
			if(c == '$'){
				index = index + 1;
				for(int num : numbers){
					stringCombinations(input, index, print+num, numbers);
				}
			}
		}
	}
}
