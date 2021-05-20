package algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        final Node resultHead = new Node(-1, null, null);
        final Map<Node, Node> cache = new HashMap<>();
        Node result = resultHead;
        while(head != null) {
            Node temp = cache.getOrDefault(head, new Node(head.val, null, null));
            cache.put(head, temp);
            result.next = temp;
            if (head.random != null) {
                Node random = cache.getOrDefault(head, new Node(head.val, null, null));
                cache.put(head.random, random);
                result.next.random = random;
            }
            head = head.next;
            result = result.next;
        }
        return resultHead.next;
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}
