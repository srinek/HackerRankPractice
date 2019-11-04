package strings;

/*
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * 
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */
public class RegExMatching {
	
	
	public boolean isMatch(String t, String p) {
		
		if(p == null || p.isEmpty()){
			return t == null || t.isEmpty();
		}
	
		boolean first_match = t.charAt(0) == p.charAt(0) || 
				p.charAt(0) == '.';
		
		if(p.length() >=2 && p.charAt(1) == '*'){
			return isMatch(t, p.substring(2)) || 
					(first_match && isMatch(t.substring(1), p));
		}
		else{
			return first_match && isMatch(t.substring(1), p.substring(1));
		}
	}
	
	

}
