package algo.linkedlist;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<Integer> heap = new PriorityQueue<>();
        Queue<ListNode> trackQueue = new LinkedList<>();
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        for(ListNode list : lists){
            if(list != null){
                heap.offer(list.val);
                if(list.next != null){
                    trackQueue.offer(list.next);
                }
            }

        }
        while(!trackQueue.isEmpty()){

            ListNode list = trackQueue.poll();
            heap.offer(list.val);
            if(list.next != null){
                trackQueue.offer(list.next);
            }
        }
        while(!heap.isEmpty()){
            cur.next = new ListNode(heap.poll());
            cur = cur.next;
        }
        return result.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
