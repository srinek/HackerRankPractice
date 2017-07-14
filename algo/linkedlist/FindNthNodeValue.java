package algo.linkedlist;

public class FindNthNodeValue {

	
	public int findNthNodeFromTail(Node head, int n){
		
		int index = 0;
		Node current = head;
		Node result = head;
		while(current != null){
			current = current.next;
			if(index++ > n){
				result = result.next;
			}
		}
		return result.data;
	}
}
