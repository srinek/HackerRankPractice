package algo.sort;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid + 1] > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
