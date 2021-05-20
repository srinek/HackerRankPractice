package algo.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, top = 0;
        int right = n - 1, down = m - 1;
        int i = 0, j = 0;
        while (true) {
            for (j = left; j <= right; j++) {
                result.add(matrix[i][j]);
            }
            j--;
            top++;
            if (left > right || top > down) {
                break;
            }
            for (i = top; i <= down; i++) {
                result.add(matrix[i][j]);
            }
            i--;
            right--;
            if (left > right || top > down) {
                break;
            }
            for (j = right; j >= left; j--) {
                result.add(matrix[i][j]);
            }
            j++;
            down--;
            if (left > right || top > down) {
                break;
            }
            for (i = down; i >= top; i--) {
                result.add(matrix[i][j]);
            }
            i++;
            left++;
            if (left > right || top > down) {
                break;
            }
        }
        return result;
    }
}
