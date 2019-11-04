package algo.arrays;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		SingleElementInSortedArray sol = new SingleElementInSortedArray();
		
		System.out.println(sol.singleNonDuplicate(new int[]{1,1,2,2,3,3,4,4,5}));
		
	}
	public int singleNonDuplicate(int[] nums) {

		int l = 0, r = nums.length-1, mid = 0;

		while (l <= r) {
			mid = (l + r) / 2;
			if (mid == 0 || mid == nums.length - 1) {
				return nums[mid];
			}
			if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
				return nums[mid];
			}
			if (nums[mid] == nums[mid - 1]) {
				if ((mid - 1 - l) % 2 == 1) {
					r = mid-1;
				} else {
					l = mid + 2;
				}
			} else { // equals to mid+1
				if ((r  - (mid + 1)) % 2 == 1) {
					l = mid + 2;
				} else {
					r = mid-1;
				}
			}
		}
		return nums[l];
	}

}
