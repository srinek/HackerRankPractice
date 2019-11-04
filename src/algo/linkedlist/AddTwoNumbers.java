package algo.linkedlist;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Input: (2) + (9 -> 9 -> 9)
Output: 7 -> 6 -> 4
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers test = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = test.addTwoNumbers(l1, l2);
		
		while(result != null){
			System.out.print(result.val);
			System.out.print("-->");
			result = result.next;
		}
		
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		if(l1 == null){
			return l2;
		}
		if(l2 == null){
			return l1;
		}
		
		int carryover = 0;
		ListNode result = null, head = null;
		int tempSum = 0;
		while(l1 != null && l2 != null){
			tempSum = l1.val + l2.val + carryover;
			result = createNode(result, tempSum);
			if(head == null){
				head = result;
			}
			carryover = tempSum/10;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l2 != null){
			tempSum = l2.val + carryover;
			result = createNode(result, tempSum);
			if(head == null){
				head = result;
			}
			carryover = tempSum/10;
			l2 = l2.next;
		}
		while(l1 != null){
			tempSum = l1.val + carryover;
			result = createNode(result, tempSum);
			if(head == null){
				head = result;
			}
			carryover = tempSum/10;
			l1 = l1.next;
		}
		if(carryover > 0){
			result.next = new ListNode(carryover);
		}
		return head;
    }

	private ListNode createNode(ListNode result, int tempSum) {
		int nodeVal = tempSum%10;
		if(result == null){
			result = new ListNode(nodeVal);
		}
		else{
			result = result.next = new ListNode(nodeVal);
		}
		return result;
	}
	
	

	
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 