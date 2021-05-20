package algo.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length < 2){
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        Stack<int[]> stack = new Stack();
        stack.push(intervals[0]);
        for(int j=1; j < intervals.length; j++){
            int[] top = stack.peek();
            if(top[1] >= intervals[j][0]){
                top[0] = Math.min(top[0], intervals[j][0]);
                top[1] = Math.max(top[1], intervals[j][1]);
                stack.pop();
                stack.push(top);
            }
            else{
                stack.push(intervals[j]);
            }
        }
        int[][] output = new int[stack.size()][2];
        int k = 0;
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            output[k][0] = top[0];
            output[k][1] = top[1];
            k++;
        }
        return output;
    }
}
