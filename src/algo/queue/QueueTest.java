package algo.queue;

import java.util.LinkedList;

public class QueueTest {

	public static void main(String[] args) {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(5);
		q.add(2,4);
		q.add(4,6);
		System.out.println(q);
		
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q);
		try {
			callrecursion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static int temp = 0;
	public static void callrecursion() throws Exception{
		if(temp++ < 10000){
			callrecursion();
		}
		throw new Exception("dump stack");
	}
}
