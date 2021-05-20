package algo.linkedlist;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode list1 = LinkedListUtils.createLinkedListNode(new int[]{1,2,3,4,5,6,7,8,9});
        LinkedListUtils.printListNode(list1);
        ReverseNodesInKGroup i = new ReverseNodesInKGroup();
        ListNode newHead = i.reverseKGroup(list1, 3);
        LinkedListUtils.printListNode(newHead);
    }


    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode kNode = head;
        ListNode prevHead = null;
        int i = 0;
        ListNode result = head;
        while (kNode != null) {

            if (i < k-1) {
                kNode = kNode.next;
                i++;
                continue;
            }

            ListNode temp = kNode.next;
            kNode.next = null;
            ListNode newHead = reverseList(cur, k);
            if (prevHead != null) {
                prevHead.next = newHead;
            } else {
                result = newHead;
            }
            prevHead = cur;
            cur = kNode = temp;
            i=0;
        }
        if (cur != null && prevHead != null) {
            prevHead.next = cur;
        }
        return result;
    }

    private ListNode reverseList(final ListNode head, final int k) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
