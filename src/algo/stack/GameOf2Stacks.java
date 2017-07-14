package algo.stack;

import java.util.Scanner;
import java.util.Stack;

/*
 * Alexa has two stacks of non-negative integers, stack  and stack where index  denotes the top of the stack. Alexa challenges Nick to play the following game:

In each move, Nick can remove one integer from the top of either stack  or stack .
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
Given , , and  for  games, find the maximum possible score Nick can achieve (i.e., the maximum number of integers he can remove without being disqualified) during each game and print it on a new line.
 */
		
public class GameOf2Stacks {
	
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        int g = in.nextInt();
	        for(int a0 = 0; a0 < g; a0++){
	            int n = in.nextInt();
	            int m = in.nextInt();
	            int x = in.nextInt();
	            int[] a = new int[n];
	            for(int a_i=0; a_i < n; a_i++){
	                a[a_i] = in.nextInt();
	            }
	            int[] b = new int[m];
	            for(int b_i=0; b_i < m; b_i++){
	                b[b_i] = in.nextInt();
	            }
	            Stack<Integer> stackA = new Stack<>();
	            for(int a_i= a.length -1; a_i >= 0; a_i--){
	            	stackA.push(a[a_i]);
	            }
	            Stack<Integer> stackB = new Stack<>();
	            for(int b_i= b.length -1; b_i >= 0; b_i--){
	            	stackB.push(b[b_i]);
	            }
	            System.out.println(totalCount(stackA, stackB, x));
	        }
	}
 
	
	// 4 2 6 2
	// 3 5
	// 14
	public static int totalCount(Stack<Integer> stackA, Stack<Integer> stackB, int max){
		
		if(stackA == null && stackB == null){
			return 0;
		}
		
		int sum = 0;
		int index = 0;
		while(!stackA.isEmpty() && !stackB.isEmpty()){
			if(stackA.peek() > stackB.peek()){
				sum += stackB.pop();
			}
			else{
				sum += stackA.pop();
			}
			if(sum <= max){
			   index++;
			}
			else{
				return index;
			}
		}
		
		while(!stackA.isEmpty()){
			sum += stackA.pop();
			if(sum <= max){
				index++;
			}
			else{
				return index;
			}
		}
		
		while(!stackB.isEmpty()){
			sum += stackB.pop();
			if(sum <= max){
				index++;
			}
			else{
				return index;
			}
		}
		
		return index;
		
	}
}
