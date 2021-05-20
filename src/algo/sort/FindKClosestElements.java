package algo.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 *
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr is sorted in ascending order.
 * -104 <= arr[i], x <= 104
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (x > arr[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int i = l - 1, j = l;
        //result.add(arr[l]);
        while(i >= 0 && j < arr.length && k > 0) {
            int left = Math.abs(arr[i] - x);
            int right = Math.abs(arr[j] - x);
            if (left <= right) {
                i--;
            } else {
                j++;
            }
            k--;
        }
        while(i >= 0 && k > 0) {
            i--;
            k--;
        }
        while(j < arr.length && k > 0) {
            j++;
            k--;
        }
        List<Integer> result = new ArrayList<>();
        for(int b = i + 1; b < j; b++) {
            result.add(arr[b]);
        }
        return result;
    }

    public static void main(String[] args) {
        FindKClosestElements i = new FindKClosestElements();
        System.out.println(i.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
    }
}
