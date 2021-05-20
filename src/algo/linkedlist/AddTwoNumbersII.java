package algo.linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * Example 2:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * Example 3:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 *
 * Follow up: Could you solve it without reversing the input lists?
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0;
        int n2 = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        while (c1 != null) {
            n1++;
            c1 = c1.next;
        }
        while (c2 != null) {
            n2++;
            c2 = c2.next;
        }
        c1 = l1;
        c2 = l2;
        return n1 >= n2 ? add(c1, c2, n1, n2) : add(c2, c1, n2, n1);
    }

    private ListNode add(ListNode c1, ListNode c2, int n1, int n2) {
        ListNode head = null;
        while (n1 > n2) {
            ListNode temp = new ListNode(c1.val);
            temp.next = head;
            head = temp;
            c1 = c1.next;
            n1--;
        }

        while(n1 > 0) {
            c1.val += c2.val;
            ListNode temp = new ListNode(c1.val);
            temp.next = head;
            head = temp;
            n1--;
            c1 = c1.next;
            c2 = c2.next;
        }
        ListNode cur = head;
        head = null;
        int carry = 0;
        while(cur != null) {
            int val = (cur.val + carry) % 10;
            carry = (cur.val + carry) / 10;
            ListNode temp = new ListNode(val);
            temp.next = head;
            head = temp;
            cur = cur.next;
        }
        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
