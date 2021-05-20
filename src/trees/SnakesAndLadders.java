package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/snakes-and-ladders/
 * 
 * On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  For example, for a 6 x 6 board, the numbers are written as follows:


You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:

You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
(This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations, regardless of the size of the board.)
If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].

Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.
* (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)

Return the least number of moves required to reach square N*N.  If it is not possible, return -1.

Example 1:

Input: [
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
At the beginning, you start at square 1 [at row 5, column 0].
You decide to move to square 2, and must take the ladder to square 15.
You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
You then decide to move to square 14, and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
Note:

2 <= board.length = board[0].length <= 20
board[i][j] is between 1 and N*N or is equal to -1.
The board square with number 1 has no snake or ladder.
The board square with number N*N has no snake or ladder.
 */
public class SnakesAndLadders {
	
    public int snakesAndLadders(int[][] board) {
        
        if(board == null){
            return 0;
        }
        int n = board.length;
        int total = n*n;
        
        boolean[] visited = new boolean[n*n+1];
        visited[1] = true;
        Queue<Step> bfs = new LinkedList<>();
        bfs.add(new Step(1, 0));
        
        while(!bfs.isEmpty()){
            
            Step start = bfs.poll();
            
            if(start.index == total){
                return start.steps;
            }
            
            int end = Math.min(start.index+6, total);
            for(int i=start.index+1; i<=end; i++){
                    int boardVal = getBoardIndices(board, i, n);
                    boardVal = boardVal == -1 ? i : boardVal;
                    if(!visited[boardVal]){
                        //System.out.println(boardVal +" "+(start.steps+1));
                        bfs.add(new Step(boardVal, start.steps+1));
                        visited[boardVal] = true;
                    }
            }
            
        }
        
        return -1;
        
    }
    
    private static class Step{
        
        public int index;
        public int steps;
        
        public Step(int index, int steps){
            this.index = index;
            this.steps = steps;
        }
        
        
        public String toString(){
        	return this.index +"("+ this.steps+")";
        }
    }
    
    private int getBoardIndices(int[][] board, int num, int n){
        
        int oldRow = (num-1)/n;
        int newRow = n-1 -oldRow;
        int oldCol = (num-1)%n;
        int newCol = oldRow%2 == 0 ? oldCol :  n -1 -oldCol;
        //System.out.println(num +" "+newRow +" "+newCol);
        return board[newRow][newCol];
    }

	   
	   public static void main(String[] args) {
		
		   //int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
		   //int[][] board = {{-1,-1, -1,-1},{-1,-1,-1,-1}, {-1,-1,-1,-1}, {-1,7,-1,-1}};
		   int[][] board = {{-1,-1,-1,190,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,47,-1,-1,-1,-1,-1,-1,-1,-1,117,-1},{-1,-1,-1,-1,-1,154,136,-1,-1,-1,-1,-1,-1,-1,-1},{215,47,-1,-1,-1,-1,-1,114,-1,-1,-1,-1,-1,-1,-1},{131,-1,-1,15,131,-1,-1,175,153,-1,-1,-1,-1,-1,-1},{206,-1,-1,-1,-1,-1,-1,14,-1,147,-1,188,-1,107,-1},{-1,14,-1,-1,-1,-1,-1,-1,119,-1,-1,-1,-1,-1,-1},{-1,-1,-1,62,-1,-1,-1,-1,141,-1,-1,-1,149,-1,-1},{149,-1,-1,-1,-1,-1,-1,-1,-1,117,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,55,-1,-1,-1,-1,183,-1,-1,-1,-1},{82,-1,-1,-1,121,55,5,-1,-1,-1,-1,-1,-1,-1,-1},{85,-1,-1,71,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,108},{-1,-1,-1,-1,28,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{207,-1,-1,111,-1,-1,-1,-1,15,-1,-1,-1,-1,199,78},{-1,-1,-1,-1,-1,134,-1,-1,84,-1,-1,-1,66,71,-1}};
		   SnakesAndLadders snake = new SnakesAndLadders();
		   System.out.println(snake.snakesAndLadders(board));
		   
	   }
}
