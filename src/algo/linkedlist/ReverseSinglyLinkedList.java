package algo.linkedlist;

public class ReverseSinglyLinkedList {

	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 
	
	
	public ListNode reverseList(ListNode head) {
        
		ListNode cur = head;
		ListNode prev = null;
		while(cur != null){
			ListNode temp = cur.next;
			cur.next = prev;
			prev = head;
			cur = temp;
		}
		
		return prev;
    }
}
