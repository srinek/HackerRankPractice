package algo.linkedlist;

public class CycleDetection {
	
	
	public static void main(String[] args) {
		Node list1 = LinkedListUtils.createCyclicLinkedList(new int[]{2 , 4 , 3 , 5 , 7});
		LinkedListUtils.printList(list1);
		boolean hasCycle = hasCycle(list1);
		System.out.println(hasCycle);
	}
	
	public static boolean hasCycle(Node head){
		
		if(head == null || head.next == null){
			return false;
		}
		Node sRunner = head;
		Node fRunner = head;
		while(fRunner != null && fRunner.next != null){
			fRunner = fRunner.next.next;
			sRunner = sRunner.next;
			if(fRunner == sRunner){
				return true;
			}
		}
		return false;
	}

}
