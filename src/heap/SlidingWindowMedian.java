package heap;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;

/**
 * https://leetcode.com/problems/sliding-window-median/
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.
 *
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 * You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 * Explanation:
 * Window position                Median
 * ---------------                -----
 * [1  3  -1] -3  5  3  6  7        1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7        3
 *  1  3  -1  -3 [5  3  6] 7        5
 *  1  3  -1  -3  5 [3  6  7]       6
 * Example 2:
 *
 * Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 * Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * 231 <= nums[i] <= 231 - 1
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> c = (o1, o2) -> {
            if (nums[o1] != nums[o2]) {
                return Integer.compare(nums[o1], nums[o2]);
            }
            return Integer.compare(o1, o2);
        };
        TreeSet<Integer> max = new TreeSet<>(c.reversed());
        TreeSet<Integer> min = new TreeSet<>(c);
        Runnable balance = () -> {
            while (max.size() > min.size()) {
                min.add(max.pollFirst());
            }
        };
        Supplier<Double> median = () -> {
            if (k % 2 == 0) {
                double d = ((double)nums[max.first()] + nums[min.first()]) / 2;
                return d;
            }
            double d = (double)nums[min.first()];
            return d;
        };

        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            max.add(i);
        }
        balance.run();
        result[0] = median.get();
        for (int i = k, r = 1; i < nums.length; i++, r++) {
            if (!max.remove(i - k)) {
                min.remove(i - k);
            }
            min.add(i);
            max.add(min.pollFirst());
            balance.run(); result[r] = median.get();
        }

        return result;
    }
}
