package algo.arrays;

import java.util.Arrays;
import java.util.Stack;

//https://www.geeksforgeeks.org/the-stock-span-problem/
public class StockSpan {

	
	
	public static void main(String[] args) {
		//System.out.println(Arrays.toString(stockInput(new int[]{ 100, 80, 60, 70, 60, 75, 85 })));
		System.out.println(Arrays.toString(stockInput(new int[]{3,2,6,5,0,3 })));
	}
	
	public static int[] stockInput(int[] input){
		
	  	
		if(input == null || input.length == 0){
			return null;
		}
		int[] span = new int[input.length];
		Stack<Integer> stack = new Stack<>();
		span[0] = 1;
		stack.push(0);
		
		for(int i=1; i<input.length; i++){
			
			while(!stack.isEmpty() && input[stack.peek()] <= input[i]){
				stack.pop();
			}
			
			if(!stack.isEmpty()){
				span[i] = i - stack.peek();
			}
			stack.push(i);
		}
		
		return span;
		
	}

}
