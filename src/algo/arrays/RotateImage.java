package algo.arrays;

/*
 * https://leetcode.com/problems/rotate-image/
 * 
 * 
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
 */
public class RotateImage {

	
public void rotate(int[][] matrix) {
        
        swapRows(matrix);
        transpose(matrix);
    }
    
    private void swapRows(int[][] matrix){
        
        int lo = 0;
        int hi = matrix.length-1;
        while(lo < hi){
            int[] temp = matrix[lo];
            matrix[lo] = matrix[hi];
            matrix[hi] = temp;
            lo++;
            hi--;
        }
    }
    
    private void transpose(int[][] matrix){
        
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
