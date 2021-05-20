package heap;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * Example 4:
 *
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * Example 5:
 *
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int ri = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result[ri++] = nums[queue.peekFirst()];
            }
        }
        return result;
    }

    //sorting

    public int[] maxSlidingWindow_sort(int[] nums, int k) {
        Comparator<Integer> c = (o1, o2) -> {
            if (nums[o1] != nums[o2]) {
                return Integer.compare(nums[o2], nums[o1]);
            }
            return Integer.compare(o1, o2);
        };
        int[] result = new int[nums.length - k + 1];
        TreeSet<Integer> max = new TreeSet<>(c);
        for(int i = 0; i < k; i++) {
            max.add(i);
        }
        result[0] = nums[max.first()];
        for (int i = k, r = 1; i < nums.length; i++, r++) {
            max.remove(i - k);
            max.add(i);
            result[r] = nums[max.first()];
        }
        return result;
    }
}
