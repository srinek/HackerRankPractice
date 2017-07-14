package algo.linkedlist;

public class ReverseDoubleLinkedList {

	
	public static void main(String[] args) {
		Node list1 = LinkedListUtils.createDoublyLinkedList(new int[]{2,3,5,8,9,12});
		LinkedListUtils.printList(list1);
		Node mergedList = reverseLinkedList(list1);
		System.out.println();
		LinkedListUtils.printList(mergedList);
	}
	
	public static Node reverseLinkedList(Node head){
		
		Node temp = head;
		Node prev = null;
		Node ret = null;
		while(temp != null){
			temp = head.next;
			head.next = prev;
			head.prev = temp;
			prev = head;
			if(temp != null){
				head = temp;
			}
		}
		return head;
	}
}
