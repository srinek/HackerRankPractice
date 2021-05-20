package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/all-oone-data-structure/
 *
 * Implement a data structure supporting the following operations:
 *
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
public class AllOoneDataStructure {

    private static class Node {
        public Node next;
        public Node prev;
        public Set<String> vals = new HashSet<>();
        public int count;

        public Node(final int count) {
            this.count = count;
        }

        public Node inc() {
            count++;
            return this;
        }

        public Node addVal(final String key) {
            vals.add(key);
            return this;
        }

        public Node removeVal(final String key) {
            vals.remove(key);
            return this;
        }

    }
    final Map<Integer, Node> nodeMap = new HashMap<>();
    final Map<String, Integer> countMap = new HashMap<>();
    private Node head;
    private Node tail;

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int count = 0;
        if (countMap.containsKey(key)) {
            count = countMap.get(key);
            countMap.put(key, count+1);
        } else {
            countMap.put(key, 1);
        }
        Node current = null;
        if (nodeMap.containsKey(count + 1)) {
            current = nodeMap.get(count + 1);
        } else {
            current =  new Node(count+1);
            nodeMap.put(count+1, current);
        }
        current.addVal(key);
        Node prev = nodeMap.get(count);
        if (prev != null) {
            prev.removeVal(key);
            if (prev.vals.isEmpty()) {
                nodeMap.remove(count);
                if (tail == prev) {
                    current.prev = tail.prev;
                    if (tail.prev != null) {
                        tail.prev.next = current;
                    }
                    tail = current;
                } else {
                    current.next = prev.next;
                    prev.next.prev = current;
                }
            } else {
                current.next = prev;
                prev.prev = current;
            }
        }
        if (head == null) {
            head = current;
        } else if (head.count < current.count) {
            head.prev = current;
            current.next = head;
            head = current;
        }
        if (tail == null) {
            tail = current;
        } else if (tail.count > current.count) {
            tail.next = current;
            current.prev = tail;
            tail = current;
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!countMap.containsKey(key)) {
            return;
        }
        int count = countMap.get(key);
        if (count == 1) {
            countMap.remove(key);
        } else {
            countMap.put(key, count-1);
        }
        Node current = null;
        if (nodeMap.containsKey(count - 1)) {
            current = nodeMap.get(count - 1);
            current.addVal(key);
        } else if (count > 1){
            current = new Node(count-1);
            nodeMap.put(count-1, current);
            current.addVal(key);
        }
        Node prev = nodeMap.get(count);
        prev.removeVal(key);
        if (prev.vals.isEmpty()) {
            nodeMap.remove(count);
            if (head == prev) {
                head = current;
            } else if (current != null){
                current.prev = prev.prev;
                prev.prev.next = current;
                if (tail == prev) {
                    tail = current;
                }
            }
            if (tail == prev) {
                tail = tail.prev;
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head == null) {
            return "";
        }
        return head.vals.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (tail == null) {
            return "";
        }
        return tail.vals.iterator().next();
    }

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    private static void test1() {
        AllOoneDataStructure i = new AllOoneDataStructure();
        i.inc("N");
        i.inc("N");
        i.inc("N");
        i.inc("N");
        i.inc("N");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
        i.inc("D");
        i.inc("D");
        i.inc("D");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
        i.inc("A");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
        i.dec("D");
        i.dec("D");
        i.dec("A");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
    }

    private static void test2() {
        AllOoneDataStructure i = new AllOoneDataStructure();
        i.inc("N");
        i.inc("D");
        i.inc("N");
        i.inc("D");
        i.inc("N");
        i.inc("D");
        i.inc("N");
        i.inc("N");
        i.inc("K");
        i.inc("K");
        i.inc("A");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
        i.dec("N");
        i.dec("N");
        i.dec("N");
        i.dec("N");
        i.inc("V");
        i.inc("V");
        i.inc("V");
        i.inc("V");
        i.inc("V");
        i.dec("A");
        i.dec("D");
        i.dec("D");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
    }

    private static void test3() {
        AllOoneDataStructure i = new AllOoneDataStructure();
        i.inc("N");
        i.inc("N");
        i.inc("D");
        i.inc("D");
        i.inc("N");
        i.dec("D");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
        i.inc("D");
        i.inc("D");
        i.inc("A");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
        i.inc("A");
        i.inc("A");
        System.out.println(i.getMaxKey() +" "+i.getMinKey());
    }
}
