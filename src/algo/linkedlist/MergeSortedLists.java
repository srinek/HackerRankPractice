package algo.linkedlist;

public class MergeSortedLists {

	public static void main(String[] args) {
		Node list1 = LinkedListUtils.createLinkedList(new int[]{2,3,5,8,9,12});
		LinkedListUtils.printList(list1);
		Node list2 = LinkedListUtils.createLinkedList(new int[]{3,4,6,7,10});
		LinkedListUtils.printList(list2);
		Node mergedList = mergeSortedLists(list1, list2);
		LinkedListUtils.printList(mergedList);
	}
	
	public static Node mergeSortedLists(Node head1, Node head2){
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		Node result = null;
		
	   if(head1.data <= head2.data){
		   result = head1;
		   result.next = mergeSortedLists(head1.next, head2);
	   }
	   else{
		   result = head2;
		   result.next = mergeSortedLists(head1, head2.next);
	   }
	   
	   return result;
	}
}
