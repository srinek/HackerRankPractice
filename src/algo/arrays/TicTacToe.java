package algo.arrays;


/*
 * https://leetcode.com/problems/design-tic-tac-toe/
 * 
 * 
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n2) per move() operation?
 */
public class TicTacToe {

	
	int[][] slots = null;
	
	int[] rows;
	int[] cols;
	int diag = 0;
	int antiDiag = 0;
	
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        slots = new int[n][n];
        rows = new int[n];
        cols = new int[n];
    }
    
    
    public int move(int row, int col, int player) {
    	
    	int toAdd = player == 1 ? 1 : -1;
    	
    	rows[row] += toAdd;
    	cols[col] += toAdd;
    	if(row == col){
    		diag += toAdd;
    	}
    	if(row+col+1 == rows.length){
    		antiDiag += toAdd;
    	}
    	
    	if(Math.abs(rows[row])  == rows.length ||
    			Math.abs(cols[col])  == rows.length || 
    			Math.abs(diag)  == rows.length || 
    			Math.abs(antiDiag)  == rows.length){
    		System.out.println(player);
    		return player;
    	}
    	System.out.println(0);
    	return 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
   /* public int move(int row, int col, int player) {
        
    	if(slots[row][col] != 0){
    		System.out.println(0);
    		return 0;
    	}
    	slots[row][col] = player;
        if(checkRow(row, col, player) ||
        		checkCol(row, col, player) ||
        		checkDiag1(row, col, player) ||
        		checkDiag2(row, col, player)){
        	System.out.println(player);
        	return player;
        }
        System.out.println(0);
    	return 0;
    }
    
    private boolean checkRow(int row, int col, int player){
    	
    	for(int i=0; i<slots.length; i++){
    		if(slots[row][i] != player){
    			return false;
    		}
    	}
    	return true;
    }
    
    
	private boolean checkCol(int row, int col, int player){
    	
    	for(int i=0; i<slots.length; i++){
    		if(slots[i][col] != player){
    			return false;
    		}
    	}
    	return true;
    }

	private boolean checkDiag1(int row, int col, int player){
    	
		if(row != col){
			return false;
		}
    	for(int i=0; i<slots.length; i++){
    		if(slots[i][i] != player){
    			return false;
    		}
    	}
    	return true;
    }
	
	private boolean checkDiag2(int row, int col, int player){
    	
		if(row + col + 1 != slots.length){
			return false;
		}
    	for(int i=0; i<slots.length; i++){
    		if(slots[i][slots.length-1-i] != player){
    			return false;
    		}
    	}
    	return true;
    }*/
	
	public static void main(String[] args) {
		TicTacToe tic = new TicTacToe(3);
		tic.move(0, 2, 1);
		tic.move(2, 0, 2);
		tic.move(1, 1, 1);
		tic.move(2, 1, 2);
		tic.move(2, 0, 1);
		tic.move(2, 2, 2);
		/*TicTacToe tic = new TicTacToe(2);
		tic.move(0, 1, 1);
		tic.move(1, 1, 2);
		tic.move(1, 0, 1);*/
	}
}
