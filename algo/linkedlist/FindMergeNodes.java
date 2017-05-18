package algo.linkedlist;

public class FindMergeNodes {
	
	public static void main(String[] args) {
		Node list1 = LinkedListUtils.createLinkedList(new int[]{2 , 4 , 3 , 5 , 7});
		LinkedListUtils.printList(list1);
		Node list2 = LinkedListUtils.createLinkedList(new int[]{6 , 11 , 3 , 5 , 7 , 4 , 6});
		LinkedListUtils.printList(list2);
		int mergedVal = findMergeNodes(list1, list2);
		System.out.println(mergedVal);
	}

	public static int findMergeNodes(Node headA, Node headB){
		
		Node currentA = headA;
		Node currentB = headB;
		while(currentA.data != currentB.data){
			
			if(currentA != null){
				currentA = currentA.next;
			}
			else{
				currentA = headB;
			}
			
			if(currentB != null){
				currentB = currentB.next;
			}
			else{
				currentB = headA;
			}
		}
		
		return currentB.data;
		
	}
}
