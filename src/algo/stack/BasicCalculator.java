package algo.stack;

import java.util.Stack;

/*
 * https://leetcode.com/problems/basic-calculator/
 * 
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 */
public class BasicCalculator {

	public static void main(String[] args) {
		BasicCalculator calc = new BasicCalculator();
		
		System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)"));
	}
	
	public int calculate(String s) {
		
		int sum = 0, result =0, sign = 1;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(c == ' '){
				continue;
			}
			if(Character.isDigit(c)){
				sum = ( sign * Character.getNumericValue(c) );
				while( i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
					sum = sum*10 + ( Character.getNumericValue(s.charAt(i+1)) );
					i++;
				}
				result += sum;
			}
			else if(c == '+'){
				sign = 1;
			}
			else if(c == '-'){
				sign = -1;
			}
			else if(c == '('){
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			}
			else{ // )
				result = result * stack.pop() + stack.pop();
			}
		}
		
		return result;
		
	}
	
	/*public int calculate(String s) {
	    
        Stack<Integer> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        return calcHelper(s, s1, s2);
    }*/
    
  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int index = 0;
    
    private int calcHelper(String s, Stack<Integer> s1, Stack<Character> s2){
            System.out.println(s1 +" -- "+s2);
            if(index == s.length()){
                return s1.pop();
            }
            if(s.charAt(index) == ' '){
                index++;
                return calcHelper(s, s1, s2);
            }
            else if(Character.isDigit(s.charAt(index))){
                s1.push(Character.getNumericValue(s.charAt(index)));
                if(!s2.isEmpty()){
                  s1.push(compute(s1, s2)); 
                }
                index++;
                return calcHelper(s, s1, s2);
            }
            else if(s.charAt(index) == '+' || s.charAt(index) == '-'){
                s2.push(s.charAt(index));
                index++;
                return calcHelper(s, s1, s2);
            }
            else if(s.charAt(index) == '('){
                Stack<Integer> tempS1 = new Stack<>();
                Stack<Character> tempS2 = new Stack<>();
                index++;
                s1.push(calcHelper(s, tempS1, tempS2));
                if(!s2.isEmpty()){
                  s1.push(compute(s1, s2)); 
                }
                index++;
                return calcHelper(s, s1, s2);
            }
            else if(s.charAt(index) == ')'){
                return s1.pop();
            }
            
            return 0;
    }
    
    private int compute(Stack<Integer> s1, Stack<Character> s2){
        int a = 0, b = 0;
        if(!s1.isEmpty()){
            b = Integer.valueOf(s1.pop());
        }
        if(!s1.isEmpty()){
             a = Integer.valueOf(s1.pop());
        }
        char c = ' ';
        if(!s2.isEmpty()){
             c = s2.pop();
        }
        if(c == '+'){
            return add(a, b); 
        }
        return subtract(a, b);
    }
    
    private int add(int a, int b){
        return a+b;
    }
    
    private int subtract(int a, int b){
        return a-b;
    }
}
