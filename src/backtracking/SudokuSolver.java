package backtracking;

/*
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.
 */
public class SudokuSolver {
	
    public void solveSudoku(char[][] board) {
       if(board == null || board.length == 0){
    	   return;
       }
       solve(board);
    }

	private boolean solve(char[][] board) {
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == '.'){
					for(char k='1'; k <= '9'; k++){
						if(isValid(board, i, j, k)){
							board[i][j] = k;
							if(solve(board)){
								return true;
							}
							else{
								board[i][j] = '.';
							}
						}
					}
				}
				
			}
		}
		return false;
		
	}

	private boolean isValid(char[][] board, int row, int col, char c) {
		 for(int i = 0; i < 9; i++) {
	            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
	            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
	            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
	board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
	        }
	        return true;
	}
	

}
