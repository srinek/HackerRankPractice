package strings;

import java.util.Arrays;

/**
https://leetcode.com/problems/reverse-words-in-a-string-ii/

 * Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */

public class ReverseWordsInString2 {

	
	public static void main(String[] args) {
		ReverseWordsInString2 r = new ReverseWordsInString2();
		char[] s = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		r.reverseWords(s);
		System.out.println(Arrays.toString(s));
	}
	
	public void reverseWords(char[] s) {
	     
        if(s == null || s.length == 0){
            return;
        }
        int slow=0, fast=0;
        while(fast < s.length){
            
            if(s[fast] == ' '){
                int j = fast-1;
                reverse(s, slow, j);
                slow = fast+1;
            }
            fast++;
        }
        int j = fast-1;
        reverse(s, slow, j);
        reverse(s, 0, s.length-1);
        
    }
    
    private void reverse(char[] s, int slow, int j){
        
        while(slow < j){
            swap(s, slow, j);
            slow++;
            j--;
        }
    }
    
    private void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
