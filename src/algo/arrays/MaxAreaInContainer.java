package algo.arrays;

/*
 * https://leetcode.com/problems/container-with-most-water/
 */

/*
 * 	Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class MaxAreaInContainer {

	
	public static void main(String[] args) {
		MaxAreaInContainer test  = new MaxAreaInContainer();
		//System.out.println(test.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
		System.out.println(test.maxArea(new int[]{15,1,1}));
	}
	
	 // 1, 2, 3,4
	   public int maxArea(int[] height) {
	        
		   if(height == null || height.length == 0){
			   return 0;
		   }
		   
		   int left = 0, right = height.length-1;
		   int maxArea = Integer.MIN_VALUE;
		   while( left < right){
			   int smallest = height[left];
			   if(height[left] < height[right]){
				   maxArea = computeArea(left, right, maxArea, smallest);
				   left++;
			   }
			   else{
				   smallest = height[right];
				   maxArea = computeArea(left, right, maxArea, smallest);
				   right--;
			   }
			   
			   
		   }
		   return maxArea;
	   }

	private int computeArea(int left, int right, int maxArea, int smallest) {

			   maxArea = Math.max(smallest * (right-left), maxArea);
		   
		return maxArea;
	}
}
