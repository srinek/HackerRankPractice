package algo.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/waiter/problem
 */
public class WaiterStack {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfElems = scan.nextInt();
		int noOfiter = scan.nextInt();
		Stack<Integer> stackA_0 = new Stack<>();
		while(noOfElems-- > 0){
			stackA_0.push(scan.nextInt());
		}
		int index = 1;
		
		Stack<Integer> stackA = null;
		while(index <= noOfiter){
			stackA_0 = printElems(stackA_0, nthPrime(index));
			index++;
		}
		while(!stackA_0.isEmpty()){
			System.out.println(stackA_0.pop());
		}
		scan.close();
	}
	
	// A0 - contains N numbers
	// Q iterations. each i-th iteration we check if element on top of the stack is divisible by ith prime. if divisible we push it to Bi else Ai. start printing Bi and Ai stating top of the stack
	
	public static Stack<Integer> printElems(Stack<Integer> stackA_0, int prime){
		
		Stack<Integer> stackB = new Stack<>();
		Stack<Integer> stackA = new Stack<>();
		if(stackA_0 == null){
			return stackA;
		}
		
		
		while(!stackA_0.isEmpty()){
			int elem = stackA_0.pop();
			if(elem % prime == 0){
				stackB.push(elem);
			}
			else{
				stackA.push(elem);
			}
		}
		
		while(!stackB.isEmpty()){
			System.out.println(stackB.pop());
		}
		
		return stackA;
		
		/**/
		
	}
	
	public static int nthPrime(int n) {
	    if (n < 2) return 2;
	    if (n == 2) return 3;
	    int limit, root, count = 1;
	    limit = (int)(n*(Math.log(n) + Math.log(Math.log(n)))) + 3;
	    root = (int)Math.sqrt(limit) + 1;
	    limit = (limit-1)/2;
	    root = root/2 - 1;
	    boolean[] sieve = new boolean[limit];
	    for(int i = 0; i < root; ++i) {
	        if (!sieve[i]) {
	            ++count;
	            for(int j = 2*i*(i+3)+3, p = 2*i+3; j < limit; j += p) {
	                sieve[j] = true;
	            }
	        }
	    }
	    int p;
	    for(p = root; count < n; ++p) {
	        if (!sieve[p]) {
	            ++count;
	        }
	    }
	    return 2*p+1;
	}

}
