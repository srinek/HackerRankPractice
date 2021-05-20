package strings;

import java.util.Arrays;

/**
https://leetcode.com/problems/reverse-words-in-a-string/
 * Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 
 */

public class ReverseWordsInString {

	
	public static void main(String[] args) {
		ReverseWordsInString r = new ReverseWordsInString();
		//String s = " the    sky    is blue";
		String s = " a good   example";
		s  = r.reverseWords(s);
		System.out.println(s);
	}
	
	public String reverseWords(String s) {
        
        if(s == null){
            return s;
        }
        
        s = s.replaceAll("\\s+", " ");
        s = s.trim();
        
        
        char[] ca = s.toCharArray();

        
        int slow =0, fast = 0;
        
        while(fast < s.length()){
            
            if(ca[fast] == ' '){
                
                int j = fast -1;
                reverseWord(ca, slow, j);
                slow = fast+1;
            }
            
            fast++;
        }
        int j = fast -1;
        reverseWord(ca, slow, j);
        reverseWord(ca, 0, s.length()-1);
        
        StringBuilder str = new StringBuilder();
        for(int k=0; k< s.length(); k++){
            str.append(ca[k]);
        }
        return str.toString().trim();
    }
    
    public void reverseWord(char[] ca, int s, int j){
        
        while(s < j){
            
            swap(ca, s, j);
            s++;
            j--;
        }
    }
    
    public void swap(char[] ca, int s, int j){
        
        char c = ca[s];
        ca[s] = ca[j];
        ca[j] = c;
    }
}
