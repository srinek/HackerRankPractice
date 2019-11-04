package trees;

import java.io.*;
import java.util.*;

/*

Consider the following floor map that represents wework offices. The floor is an M x N grid of square shaped offices. Some of the offices have glass walls that can be removed so they can connect to their adjacent offices. Such convertible offices are marked by 1. Offices that can not be connected and thus are of fixed size are marked by 0:

WeWork is launching a new product: WeWork SMB, this product entails:

1. Interconnected offices made up of at least 2 offices.
2. Interconnected office must share a glass wall (diagonals are not permitted).

Write a program that counts the number of possible WeWork SMBs.

Example above:

Input:

{{0, 1, 0, 0, 0, 0, 1, 1},
 {1, 1, 0, 0, 0, 0, 0, 1},
 {0, 0, 0, 0, 1, 1, 0, 0},
 {0, 1, 0, 1, 1, 0, 0, 0},
 {0, 0, 0, 1, 0, 0, 0, 0},
 {1, 1, 0, 1, 0, 1, 1, 0},
 {1, 1, 0, 0, 0, 0, 0, 0}}

Output: 5

*/


public class WeWorkSMBBSTSolution {
  
  static class countSMB{
    
    int result = 0;
    
    public int count(int [][] grid) {
      
      
      boolean[][] visited = new boolean[grid.length][grid[0].length];
      
      
      for(int i=0; i<grid.length; i++){
         for(int j=0; j<grid[i].length; j++){
             
              if( visited[i][j] ){
                  continue;
              }
             
              if(grid[i][j] == 1 ){
                   
                   visited[i][j] = true;
                  
                  if( visitNeighbours(grid, i+1, j, visited) 
                   | visitNeighbours(grid, i, j+1, visited)
                   | visitNeighbours(grid, i-1, j, visited)
                   | visitNeighbours(grid, i, j-1, visited)) {
                	  System.out.println(i +" "+j);
                          
                    
                    
                    result++;
                  }
              } 
           
         }
      }
      
      return result;
      
    }
    
    private boolean visitNeighbours(int [][] grid, int i, int j, boolean[][] visited){
      
      if(i < 0 || i >= grid.length || j<0 || j>= grid[0].length){
         
        return false;
      }
      if( visited[i][j]){
          if(grid[i][j] == 1){
             return true;
          }
          return false;
      }
        
      
      
      if(grid[i][j] == 0){
          return false;
      }
      visited[i][j] = true;
      visitNeighbours(grid, i+1, j, visited); 
      visitNeighbours(grid, i, j+1, visited);
      visitNeighbours(grid, i, j-1, visited);
      visitNeighbours(grid, i-1, j, visited);
      return true;
      
      
      
      
    }
    
  }
  
  
  public static void assertEquals(int expected, int actual) {
    
    if( expected == actual) {
      
      System.out.println("PASSED: " + expected + " == " + actual);
      
    } else {
      
      System.out.println("FAILED: " + expected + " != " + actual);
      
    }
  }
  
  
  public static void main(String[] args) {
   
    int [][] floor1 = {{1,0,1},
                       {0,0,1},
                       {0,0,1}};
    
    int [][] floor2 = {{0, 1, 0, 0, 0, 0, 1, 1},
                       {1, 1, 0, 0, 0, 0, 0, 1},
                       {0, 0, 0, 0, 1, 1, 0, 0},
                       {0, 1, 0, 1, 1, 0, 0, 0},
                       {0, 0, 0, 1, 0, 0, 0, 0},
                       {1, 1, 0, 1, 0, 1, 1, 0},
                       {1, 1, 0, 0, 0, 0, 0, 0}};
    
    
    countSMB smb = new countSMB();
    
    //int floorCount1 = smb.count(floor1);    // 1 SMBs
    int floorCount2 = smb.count(floor2);    // 5 SMBs
    
    //assertEquals(1, floorCount1); 
    assertEquals(5, floorCount2);
    
  }
}
