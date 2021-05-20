package algo.arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */

//testcases
/*
[1,2,2,2,2,2,8]
2
[1,2,2,2,2,2,8]
1
[1,2,2,2,2,2,8]
8
[1,2,2,2,2,2,8,8,8]
8
[5,7,7,8,8,10]
6
 */
public class FindFirstAndLastPositionOfElementsInaSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            System.out.println(l +" "+r);
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result[0] = findLeft(nums, target, 0, mid);
                result[1] = findRight(nums, target, mid, r);
                return result;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return result;
    }

    private int findLeft(int[] nums, int target, int l, int r) {

        while (l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] < target) {
                l = mid + 1;
            } else if (mid == 0 || nums[mid - 1] < target) {
                return mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int findRight(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > target) {
                r = mid;
            } else if (mid == r || nums[mid + 1] > target) {
                return mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementsInaSortedArray f = new FindFirstAndLastPositionOfElementsInaSortedArray();
        //System.out.println(f.searchRange(new int[] {5,7,7,8,8,10}, 8));
        //System.out.println(f.searchRange(new int[] {8,8,8}, 8));
        //int[] result = f.searchRange(new int[] {1,2,3}, 8);
        int[] result = f.searchRange(new int[] {5,7,7,8,8,10}, 6);
        System.out.println(result[0] +" "+result[1]);
    }
}
