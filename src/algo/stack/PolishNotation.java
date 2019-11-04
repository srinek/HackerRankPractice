package algo.stack;

import java.util.Stack;

public class PolishNotation {
	
	
	 public static void main(String[] args) {
		
		 PolishNotation pol = new PolishNotation();
		 pol.evalRPN(new String[]{"2", "1", "+", "3", "*"});
	}
	
	 public int evalRPN(String[] tokens) {
	        
	        if(tokens == null){
	            return 0;
	        }
	        
	        Stack<Integer> stack = new Stack<>();
	        int result = 0;
	        
	        for(int i=0; i<tokens.length; i++){
	            
	            String temp = tokens[i];
	            
	            if(temp == "+"){
	                int a = stack.pop();
	                int b = stack.pop();
	                result = a + b;
	                stack.push(result);
	            }
	            else if(temp == "-"){
	                int a = stack.pop();
	                int b = stack.pop();
	                result = b - a;
	                stack.push(result);
	            }
	            else if(temp == "*"){
	                int a = stack.pop();
	                int b = stack.pop();
	                result = a * b;
	                stack.push(result);
	            }
	            else if(temp == "/"){
	                int a = stack.pop();
	                int b = stack.pop();
	                result = b / a;
	                stack.push(result);
	            }
	            else{
	                stack.push(Integer.valueOf(temp));
	            }
	        }
	        
	        return stack.pop();
	    }

}
