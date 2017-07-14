package algo.stack;

public class StackImpl {

	public Node top = null;
	
	public void push(int ele){
		Node n = new Node();
		n.data = ele;
		if(top != null){
			top.next = n;
		}
		top = n;
	}
	
	public int pop() throws Exception{
		if(top != null){
			int data = top.data;
			top = top.prev;
			return data;
		}
		throw new Exception("stack empty");
	}
	
	public int peek() throws Exception{
		if(top != null){
			int data = top.data;
			return data;
		}
		throw new Exception("stack empty");
	}
	
	public class Node{
		public Node(){
			 
		}

		public int data;
		public Node next;
		public Node prev;
	}
	
}
