package algo.dp;


/*
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 */
public class UniquePathsTwo {

public int uniquePathsWithObstacles(int[][] grid) {
        
        if(grid.length == 0){
            return 0;
        }
        
        return uniquePaths(grid);
    }
    
    public int uniquePaths(int[][] grid){
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i < m; i++){
            
            for(int j=0; j < n; j++){
                
                if(i == 0 && j ==0){
                    if(grid[i][j] == 0){
                        grid[i][j] = 1;
                    }
                    else{
                        return 0;
                    }
                }
                else if(i == 0){
                    if(grid[i][j] == 0){
                        grid[i][j] = grid[i][j-1];
                    }
                    else{
                        grid[i][j] = 0;
                    }
                }
                else if( j == 0){
                    if(grid[i][j] == 0){
                        grid[i][j] = grid[i-1][j];
                    }
                    else{
                        grid[i][j] = 0;
                    }
                }
                else{
                    if(grid[i][j] == 0){
                        grid[i][j] = grid[i-1][j] + grid[i][j-1];
                    }
                    else{
                        grid[i][j] = 0;
                    }
                }
            }
        
        }
        
        return grid[m-1][n-1];
        
    }
}
