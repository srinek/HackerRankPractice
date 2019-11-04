package graphs;

import java.util.Scanner;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

https://leetcode.com/explore/interview/card/amazon/78/trees-and-graphs/894/
 */

public class FindIslands {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int rows = scanner.nextInt();
		int cols = scanner.nextInt();
		char[][] inp = new char[rows][cols];
		for(int i=0; i< rows; i++){
			for(int j=0; j< cols; j++){
				inp[i][j] = scanner.next().charAt(0);
			}
		}
		scanner.close();
		FindIslands islands = new FindIslands();
		System.out.println(islands.numIslands(inp));
		
	}
	
	
	   public int numIslands(char[][] grid) {
		   
		   return dfs(grid);
	   }
	   
	   private int  dfs(char[][] grid){
		   if(grid == null){
			   return 0;
		   }
		   int rn = grid.length;
		   int cn = rn > 0 ? grid[0].length : 0;
		   int count = 0;
		   
		   for(int i=0; i < rn; i++){
			   for(int j=0; j<cn; j++){
				   if(grid[i][j] == '1'){
					   count++;
					   dfsUtil(grid, i, j);
				   }
			   }
		   }
		   return count;
	   }
	   
	   private void dfsUtil(char[][] grid, int i, int j){
		   int rn = grid.length;
		   int cn = rn > 0 ? grid[0].length : 0;
		   if(i >= rn || j >= cn || i < 0 || j <0){  // out of bounds
			   return;
		   }
		   if(grid[i][j] == '0'){ // already visited
			   return;
		   }
		   grid[i][j] = '0'; // mark as visited
		   
		   //visit neighbours here
		   dfsUtil(grid, i-1, j);
		   dfsUtil(grid, i+1, j);
		   dfsUtil(grid, i, j-1);
		   dfsUtil(grid, i, j+1);
		   
	   }
}
