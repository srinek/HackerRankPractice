package algo.linkedlist;

public class BrowserNavigationHistory {
	
	private static class Node{
		
		public String val;
		public Node next;
		public Node prev;
		
		public Node(String val){
			this.val = val;
		}
	}
	
	private Node head;
	private Node tail;
	private Node current;
	
	public void addNode(String val){
		
		if(head == null && tail == null){
			this.head = this.current = this.tail = new Node(val);
			return;
		}
		Node temp = new Node(val);
		temp.prev = current;
		if(current.next != null){
			current.next.prev = null;
		}
		current.next = temp;
		current = tail = current.next;
	}
	
	public String navigateBack(){
		
		if(this.current == this.head){
			return null;
		}
		this.current = this.current.prev;
		return this.current.val;
	}
	
	public String navigateNext(){
		
		if(this.current == this.tail){
			return null;
		}
		this.current = this.current.next;
		return this.current.val;
	}
	
	
	public static void main(String[] args) {
		
		BrowserNavigationHistory navigation = new BrowserNavigationHistory();
		
		navigation.addNode("a");
		navigation.addNode("b");
		navigation.addNode("c");
		navigation.addNode("d");
		System.out.println(navigation.navigateBack());
		System.out.println(navigation.navigateBack());
		System.out.println(navigation.navigateNext());
		navigation.addNode("e");
		System.out.println(navigation.current.val);
		navigation.addNode("f");
		System.out.println(navigation.current.val);
		System.out.println(navigation.navigateBack());
	}

}
