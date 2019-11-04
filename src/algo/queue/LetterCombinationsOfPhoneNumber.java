package algo.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * 
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfPhoneNumber {

	
	public List<String> letterCombinations(String digits) {
		   
		   String[] strMap = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		   
		   int[] nums = new int[digits.length()];
		   for(int i=0; i<digits.length(); i++){
			   nums[i] = Character.getNumericValue(digits.charAt(i));
		   }
        Queue<String> q = new LinkedList<>();
        if(nums.length > 0){
            q.offer("");
        }
        for(int i=0; i<nums.length; i++){
            combinations(q, strMap[nums[i]]);
        }
		   return new ArrayList<>(q);
	}
 
 private void combinations(Queue<String> q, String s){
     
     int size = q.size();
     while(size > 0){
         String temp = q.poll();
         for(int i=0; i<s.length(); i++){
             q.offer(temp+s.charAt(i));
         }
         size--;
     }
 }
	   
}
