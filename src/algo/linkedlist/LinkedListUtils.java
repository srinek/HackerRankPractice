package algo.linkedlist;

public class LinkedListUtils {
	
	public static Node createLinkedList(int[] input){
		Node head = null;
		Node prev = null;
		for(int k : input){
			Node n = new Node();
			n.data = k;
			if(prev != null){
				prev.next = n;
			}
			else{
				head = n;
			}
			prev = n;
		}
		return head;
	}
	
	public static Node createCyclicLinkedList(int[] input){
		Node head = null;
		Node prev = null;
		for(int k : input){
			Node n = new Node();
			n.data = k;
			if(prev != null){
				prev.next = n;
			}
			else{
				head = n;
			}
			prev = n;
		}
		return head;
	}
	
	public static void printList(Node head){
		while(head != null){
			if(head.prev != null && head.next != null){
				System.out.print("[ "+head.prev.data +", " + head.data + ", "+head.next.data+"]" );
			}
			else if(head.prev != null){
				System.out.print("[ "+head.prev.data +", " + head.data + ", null]" );
			}
			else if(head.next != null){
				System.out.print("[ null, " + head.data + ", "+head.next.data+"]" );
			}
			head = head.next;
		}
		System.out.println();
	}

	public static Node createDoublyLinkedList(int[] input) {
		Node head = null;
		Node prev = null;
		for(int k : input){
			Node n = new Node();
			n.data = k;
			if(prev != null){
				prev.next = n;
				n.prev = prev;
			}
			else{
				head = n;
			}
			prev = n;
		}
		return head;
	}

}
