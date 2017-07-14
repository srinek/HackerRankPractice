package algo.linkedlist;

public class SortedDoublyLinkedList {
	
	public static void main(String[] args) {
		int[] data = {2,5,4,1,6};
		Node head = null;
		for(int n : data){
			head = sortedLinkedList(head, n);
		}
		LinkedListUtils.printList(head);
	}

	public static Node sortedLinkedList(Node head, int data){
		
		if(head == null){
			head = new Node(data);
			return head;
		}
		Node n = new Node(data);
		Node current = head;
		Node prev = null;
		while(current != null){
			if(current.data > data){
				n.next = current;
				n.prev = prev;
				current.prev = n;
				if(prev != null){
					prev.next = n;
				}
				break;
			}
			prev = current;
			current = current.next;
		}
		
		if(current == null){
			prev.next = n;
			n.prev = prev;
		}
		
		return head;
	}
}
