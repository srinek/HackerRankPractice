package backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
/*
 * Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfPhoneNumber {

	   public List<String> letterCombinations(String digits) {
		   
		   String[] strMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		   
		   int[] nums = new int[digits.length()];
		   for(int i=0; i<digits.length(); i++){
			   nums[i] = Character.getNumericValue(digits.charAt(i));
		   }
		   
		   LinkedList<String> queue = new LinkedList<>();
		   if(nums.length > 0){
			   queue.add("");
		   }
		   for(int i=0; i<nums.length; i++){
			   helper(queue, strMap[nums[i]]);
		   }
		   return queue;
	   }
	   
	   private void helper(Queue<String> queue, String str){
		   
		   int k = queue.size(), l = 0;
		   while(l++ < k){
			   String temp = queue.poll();  // backtracking
			   for(int i=0; i<str.length(); i++){
				   queue.add(temp+str.charAt(i));
			   }
		   }
		   
	   }
	   
	   public static void main(String[] args) {
		   LetterCombinationsOfPhoneNumber test = new LetterCombinationsOfPhoneNumber();
		   System.out.println( test.letterCombinations("23") );
	   }
}
