package algo.stack;

import java.util.Scanner;
import java.util.Stack;

public class MaxElementInStack {
	
	public static Stack<StackVal> stack = new Stack<>();

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfQueries = scan.nextInt();
		while(noOfQueries > 0){
			
			try {
				findMaxElement(scan);
			} catch (Exception e) {
				e.printStackTrace();
			}
			noOfQueries--;
		}
		scan.close();
	}
	
	public static void findMaxElement(Scanner scan) throws Exception{
		int query = scan.nextInt();
		if(query == 1){
			int val = scan.nextInt();
			StackVal stackVal = null;
			if(stack.isEmpty()){
				stackVal = new StackVal(val, val);
			}
			else{
				StackVal peek = stack.peek();
				stackVal = new StackVal(val, Math.max(val, peek.maxValInStack));
			}
			stack.push(stackVal);
		}
		else if(query == 2){
			stack.pop();
		}
		else if(query == 3){
			StackVal peek = stack.peek();
			System.out.println(peek.maxValInStack);
		}
	}
	
	public static class StackVal{
		
		public StackVal(int val, int max){
			this.val = val;
			this.maxValInStack = max;
		}
		public int val;
		public int maxValInStack;
	}
}
