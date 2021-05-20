package algo.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class LargestRectangle {
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		int[] buildings = new int[total];
		int index = 0;
		while(index < total){
			buildings[index] = scan.nextInt();
			index++;
		}
		scan.close();
		System.out.println(getLargestRectangle(buildings));
	}
	
	//1 4 4 3 4 5
	//5 4 3 2 1
	//1 2 3 4 5
	public static int getLargestRectangle(int[] a){
		
		if(a.length == 0){
			return 0;
		}
		int maxArea = -1;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int i = 1;
		int tempArea = 0;
		for(; i < a.length; i++){
			while( !stack.isEmpty() && a[stack.peek()] > a[i] ){
				// compute the area of the current element.
				int top = stack.pop();
				
				if(stack.isEmpty()){
					tempArea = a[top] * (i);
				}
				else{
					tempArea = a[top] * (i-stack.peek() - 1);
				}
				if(maxArea < tempArea){
					maxArea = tempArea;
				}
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			int top = stack.pop();
			if(stack.isEmpty()){
				tempArea = a[top] * (i);
			}
			else{
				tempArea = a[top] * (i - stack.peek() - 1);
			}
			
			if(maxArea < tempArea){
				maxArea = tempArea;
			}
		}
		return maxArea;
	}
	
	/*public static int getLargestRectangle(int[] a){
		
		if(a == null || a.length == 0){
			return 0;
		}
		
		Stack<Integer> stack = new Stack<>();
		int maxsum = -1;
		int prev = -1;
		int index = 0;
		for(int val : a){
		   if(val >= prev){
			   stack.push(index);
		   }
		   else{
			   maxsum = computeMax(a, stack, maxsum, index , val);
			  
			   stack.push(index);
		   }
		   prev = val;
		   index++;
		}
		while(!stack.isEmpty()){
			int top = stack.pop();
			int sum= 0;
			if(!stack.isEmpty()){
				   sum = a[top] * ( index - stack.peek() -1);
			}
			else{
				   sum = a[top] * index;
			}
			if(sum > maxsum){
			  maxsum = sum;
			}
		}
		return maxsum;
	}

	private static int computeMax(int[] a, Stack<Integer> stack, int maxsum, int index, int val) {
		int sum = -1;
		int top;
		while(!stack.isEmpty()){
			if(val < a[stack.peek()]){
				top = stack.pop();
				if(!stack.isEmpty()){
					   sum = a[top] * ( index - stack.peek() -1);
				}
				else{
					   sum = a[top] * index;
				}
				if(sum > maxsum){
				   maxsum = sum;
				}
			}
			else{
				break;
			}
		}
		return maxsum;
	}
	
	*/
}
