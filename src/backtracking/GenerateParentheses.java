package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParentheses {
	
	
	static int count = 0;
	public static void main(String[] args) {
		GenerateParentheses test = new GenerateParentheses();
		//System.out.println(test.generateParenthesis(2));
		System.out.println(test.generateParenthesis(2));
		System.out.println(count);
	}
	
	
	
	public List<String> generateParenthesis(int i) {
		List<String> result = new ArrayList<>();
		char[] str = new char[2*i];
		backTracking(i, str, 0, 0,result);
		return result;
	}
	
	
	private void backTracking(int n, char[] str, int open, int close, List<String> result) {
		
		if(str.length == (open+close)){
			result.add(new String(str));
			return;
		}
		
		if(open < n){
			str[open+close] = '(';
			backTracking(n, str, open+1, close, result);
		}
		if(close < open){
			str[open+close] = ')';
			backTracking(n, str, open, close+1, result);
		}
		
	}



	//** recursive **??
	
	

    
















	public List<String> generateParenthesisReursive(int n) {
        
    	char[] chars = new char[2*n];
    	List<String> result = new ArrayList<>();
    	generatePatentheses(chars, 0, result);
    	return result;
    }

	private void generatePatentheses(char[] chars, int start, List<String> result) {
		count++;
		System.out.print(" " +start);
		System.out.println("  ==== " +new String(chars));
		if(start == chars.length){
			System.out.println("************");
			if(isValid(chars)){
				result.add(new String(chars));
			}
		}
		else{
			chars[start] = '(';
			generatePatentheses(chars, start+1, result);
			chars[start] = ')';
			generatePatentheses(chars, start+1, result);
		}
		
	}

	private boolean isValid(char[] chars) {
		int total = 0;
		for(int i=0; i<chars.length; i++){
			if(chars[i] == '('){
				total++;
			}
			else{
				total--;
			}
			if(total < 0){
				return false;
			}
		}
		if(total == 0){
			return true;
		}
		return false;
	}
}
