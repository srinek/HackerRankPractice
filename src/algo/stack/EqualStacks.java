package algo.stack;

import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {
	
	
	public static void main(String args[]){
		
		 Scanner in = new Scanner(System.in);
	     int n1 = in.nextInt();
	     int n2 = in.nextInt();
	     int n3 = in.nextInt();
	     int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
	     int height = 0;
	     Stack<StackVal> stack1 = new Stack<>();
	     for(int i = h1.length -1; i >= 0; i--){
	    	 int val = h1[i];
	    	 height = height + val;
	    	 StackVal stackval = new StackVal(val, height);
	    	 stack1.push(stackval);
	     }
	     height = 0;
	     Stack<StackVal> stack2 = new Stack<>(); 
	     for(int i = h2.length -1; i >= 0; i--){
	    	 int val = h2[i];
	    	 height = height + val;
	    	 StackVal stackval = new StackVal(val, height);
	    	 stack2.push(stackval);
	     }
	     height = 0;
	     Stack<StackVal> stack3 = new Stack<>(); 
	     for(int i = h3.length -1; i >= 0; i--){
	    	 int val = h3[i];
	    	 height = height + val;
	    	 StackVal stackval = new StackVal(val, height);
	    	 stack3.push(stackval);
	     }
	     System.out.println(adjustStackHeights(stack1, stack2, stack3) );
	     in.close();
	}
	
	public static int adjustStackHeights(Stack<StackVal> stack1, Stack<StackVal> stack2, Stack<StackVal> stack3){
		
		while(!isEqualStacks(stack1, stack2, stack3)){
			Stack<StackVal> heighestStack = findHeighestStack(stack1, stack2, stack3);
			heighestStack.pop();
		}
		if(stack1.isEmpty()){
			return 0;
		}
		return stack1.peek().height;
	}
	
	public static Stack<StackVal> findHeighestStack(Stack<StackVal> stack1, Stack<StackVal> stack2, Stack<StackVal> stack3){
		
		int _1_h = 0;
		if(!stack1.isEmpty()){
			_1_h = stack1.peek().height;
		}
		int _2_h = 0;
		if(!stack2.isEmpty()){
			_2_h = stack2.peek().height;
		}
		int _3_h = 0;
		if(!stack3.isEmpty()){
			_3_h = stack3.peek().height;
		}
		
		if(_1_h >= _2_h && _1_h > _3_h){
			return stack1;
		}
		if(_2_h >= _1_h && _2_h > _3_h){
			return stack2;
		}
		return stack3;
	}
	
	public static boolean isEqualStacks(Stack<StackVal> stack1, Stack<StackVal> stack2, Stack<StackVal> stack3){
		
		if(stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty()){
			return true;
		}
		if(stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()){
			return false;
		}
		if(stack1.peek().height == stack2.peek().height && 
				stack2.peek().height == stack3.peek().height){
			return true;
		}
		return false;
	}
	
	
public static class StackVal{
		
		public StackVal(int val, int height){
			this.val = val;
			this.height = height;
		}
		public int val;
		public int height;
	} 

}
