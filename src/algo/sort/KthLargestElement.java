package algo.sort;

import java.util.Random;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class KthLargestElement {
    Random r = new Random();
    public int findKthLargest(int[] nums, int k) {

        return quickSelection(nums, 0, nums.length-1, nums.length-k);
    }

    private int quickSelection(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int partitionIndex = partition(nums, left, right);
        if (partitionIndex == k) {
            return nums[k];
        } else if(partitionIndex < k) {
            return quickSelection(nums, partitionIndex + 1, right, k);
        }
        return quickSelection(nums, left, partitionIndex - 1, k);
    }

    private int partition(int[] nums, int left, int right) {
        int partitionIndex = left + r.nextInt(right-left);
        swap(nums, right, partitionIndex);

        int ptr = left;
        for (int i=left; i<right; i++) {
            if (nums[i] < nums[right]) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
        swap(nums, right, ptr);
        return ptr;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement i = new KthLargestElement();
        //System.out.println(i.findKthLargest(new int[] {3,2,1,5,6,4}, 6));
        System.out.println(i.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
