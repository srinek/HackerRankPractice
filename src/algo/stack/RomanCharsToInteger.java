package algo.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanCharsToInteger {

	
	
	public int romanToInt(String s) {

		if (s == null) {
			return 0;
		}

		char[] romanChars = s.toCharArray();

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < romanChars.length; i++) {
			if (romanChars[i] == 'V' && "I".equals(safePeek(stack))) {
				stack.push(stack.pop() + "V");
			} else if (romanChars[i] == 'X' && "I".equals(safePeek(stack))) {
				stack.push(stack.pop() + "X");
				System.out.println(stack);

			} else if (romanChars[i] == 'L' && "X".equals(safePeek(stack))) {
				stack.push(stack.pop() + "L");

			} else if (romanChars[i] == 'C' && "X".equals(safePeek(stack))) {
				stack.push(stack.pop() + "C");

			} else if (romanChars[i] == 'D' && "C".equals(safePeek(stack))) {
				stack.push(stack.pop() + "D");
			} else if (romanChars[i] == 'M' && "C".equals(safePeek(stack))) {
				stack.push(stack.pop() + "M");
			} else {
				stack.push(romanChars[i] + "");
			}

		}

		Map<String, Integer> map = getMap();
		int result = 0;
		while (!stack.isEmpty()) {
			result += map.get(stack.pop());
		}

		return result;
	}

	private String safePeek(Stack<String> stack) {

		if (!stack.isEmpty()) {
			System.out.println("--- " + stack.peek());
			return stack.peek();
		}
		return null;
	}

	private Map<String, Integer> getMap() {

		Map<String, Integer> map = new HashMap<>();

		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);

		return map;
	}
}
