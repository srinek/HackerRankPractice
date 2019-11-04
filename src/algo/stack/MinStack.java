package algo.stack;

import java.util.Stack;

/*
 * https://leetcode.com/problems/min-stack/
 * 
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
public class MinStack {
	
	
	private static class MinPair{
		
		public int val;
		public int minSoFar;
		
		public MinPair(int val, int minSoFar){
			this.val = val;
			this.minSoFar = minSoFar;
		}
	}
	
	private int minSoFar = Integer.MAX_VALUE;
	
	private Stack<MinPair> stack = new Stack<>();
	
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
    	minSoFar = Math.min(minSoFar, x);
    	MinPair p = new MinPair(x, minSoFar);
    	stack.push(p);
    }
    
    public void pop() {
        if(!stack.isEmpty()){
        	MinPair p = stack.pop();
        }
        if(!stack.isEmpty()){
        	minSoFar = stack.peek().minSoFar;
        }
        else{
        	minSoFar = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
    	if(!stack.isEmpty()){
        	return stack.peek().val;
        }
    	return 0;
    }
    
    public int getMin() {
        return minSoFar;
    }

}
