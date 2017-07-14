package algo.queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = scan.nextInt();
		Stack<Integer> first = new Stack<>();
		Stack<Integer> second = new Stack<>();
		while(total-- > 0){
			int op = scan.nextInt();
			if(op == 1){
				process(first, second, op, scan.nextInt());
			}
			else{
				process(first, second, op, 0);
			}
		}
		scan.close();
	}
	
	public static void process(Stack<Integer> first, Stack<Integer> second, int op, int val){
		if(first == null || second == null){
			return;
		}
		if(op == 1){
			first.push(val);
		}
		if(op == 2){
			if(second.isEmpty()){
			   copyStacks(first, second);
			}
			second.pop();
		}
		if(op == 3){
			if(second.isEmpty()){
				copyStacks(first, second);
			}
			System.out.println(second.peek());
		}
	}

	private static void copyStacks(Stack<Integer> first, Stack<Integer> second) {
        while(!first.isEmpty()){
        	second.push(first.pop());
        }
	}

}
