package algo.linkedlist;

public class DeleteDupsFromSoertedList {

	public static void main(String[] args) {
		Node list1 = LinkedListUtils.createLinkedList(new int[]{1,1,1,3,3,5,6});
		LinkedListUtils.printList(list1);
		
		Node noDupsList = deleteDups(list1);
		LinkedListUtils.printList(noDupsList);
	}
	
	//1 -> 1 -> 1 -> 3 -> 3 -> 5 -> 6 -> NULL
	public static Node deleteDups(Node head){
		
		if(head == null){
			return head;
		}
		Node current = head;
		Node prev = null;
		while(current != null){
			prev = current;
			current = current.next;
			while(current != null && prev.data == current.data){
				prev.next = current.next;
				current = current.next;
			}
		}
		return head;
	}

	
	
	
}
