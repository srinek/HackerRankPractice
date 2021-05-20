package trees;

/**
 * https://leetcode.com/explore/interview/card/facebook/52/trees-and-graphs/544/
 *
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [4,2,5,1,3]
 *
 *
 * Output: [1,2,3,4,5]
 *
 * Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 *
 * Example 2:
 *
 * Input: root = [2,1,3]
 * Output: [1,2,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 * Explanation: Input is an empty tree. Output is also an empty Linked List.
 * Example 4:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * -1000 <= Node.val <= 1000
 * Node.left.val < Node.val < Node.right.val
 * All values of Node.val are unique.
 * 0 <= Number of Nodes <= 2000
 */
public class ConvertBinarySearchTreeToDoublyLinkedList {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node tail = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        head = tail = root;
        inorder(root, null);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private Node inorder(Node current, Node prev) {
        if (current == null) {
            return prev;
        }
        if (current.val < head.val) {
            head = current;
        }
        if (current.val > tail.val) {
            tail = current;
        }
        prev = inorder(current.left, prev);
        if (prev != null) {
            current.left = prev;
            prev.right = current;
        }
        return inorder(current.right, current);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node l = new Node(2);
        Node r = new Node(5);
        root.left = l;
        root.right = r;
        l.left = new Node(1);
        l.right = new Node(3);
        ConvertBinarySearchTreeToDoublyLinkedList c = new ConvertBinarySearchTreeToDoublyLinkedList();
        c.treeToDoublyList(root);
    }

}
