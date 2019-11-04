package algo.linkedlist;

/*
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {

	
	
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 
	 public static void main(String[] args) {
		 SwapNodesInPairs pairs = new SwapNodesInPairs();
		 ListNode n1 = pairs.new ListNode(1);
		 ListNode n2 = n1.next = pairs.new ListNode(2);
		 ListNode n3 = n2.next = pairs.new ListNode(3);
		 ListNode n4 = n3.next = pairs.new ListNode(4);
		 pairs.swapPairs(n1);
	}
	
	
	public ListNode swapPairs(ListNode head) {
        ListNode newHead = head;
        newHead = swapNodes(head, null, newHead);
        return newHead;
    }
    
    private ListNode swapNodes(ListNode n1, ListNode prev, ListNode newHead){
        if(n1 == null){
            return newHead;
        }
        if(n1.next != null){
            if(newHead == n1){
                newHead = n1.next;
            }
            ListNode temp = n1.next.next;
            n1.next.next = n1;
            if(prev != null){
              prev.next = n1.next;
            }
            n1.next = temp;
        }
        
        return swapNodes(n1.next, n1, newHead);
    }
}
