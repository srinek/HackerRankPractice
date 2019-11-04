package algo.arrays;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class LargestRectangleOfHistogram {
	
	
	public int maxRectangleArea(int[] input){
		
		
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(i < input.length){
			
			if(stack.empty() || input[stack.peek()] <= input[i]){
				stack.push(i++);
			}
			else{
				int top = stack.pop();
				int area = input[top] * ( stack.empty() ? i : i-1-stack.peek());
				maxArea = Math.max(maxArea, area);
			}
		}
		
		while(!stack.empty()){
			int top = stack.pop();
			int area = input[top] * ( stack.empty() ? i : i-1-stack.peek());
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
	}
	
	public static void main(String[] args){
		LargestRectangleOfHistogram histArea = new LargestRectangleOfHistogram();
		int[] arr = new int[]{6, 2, 5, 4, 5, 1, 6};
		System.out.println(histArea.maxRectangleArea(arr));
	}

}
