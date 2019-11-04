package backtracking;

import java.util.Arrays;

public class KnightsTour {
	
	
	public static void main(String[] args) {
		KnightsTour knights = new KnightsTour();
		knights.findKnghtsTour();
	}
	
	public void findKnghtsTour(){
		
		int[][] board = new int[8][8];
		int[] xmoves = {2, 1, -1, -2,  2,  1, -1, -2};
		int[] ymoves = {1, 2,  2,  1, -1, -2, -2, -1};
		for(int i=0; i<board.length; i++){
			Arrays.fill(board[i], -1);	
		}
		board[0][0] = 1;
		
		if(tourBoard(board, xmoves, ymoves, 1, 0, 0)){
			printBoard(board);
		}
		else{
			System.out.println(" no solution exist");
		}
	}

	private void printBoard(int[][] board) {
		for(int i=0; i < board.length; i++){
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println("========================================");
	}
	
	private boolean tourBoard(int[][] board, int[] xmoves, int[] ymoves, int moveNumber, int x, int y){
		
		if(moveNumber == 64){
			return true;
		}
		
		for(int i=0; i< xmoves.length; i++){
			int xMove = x + xmoves[i];
			int yMove = x + ymoves[i];
			if(canMove(board, xMove, yMove)){
				board[xMove][yMove] = moveNumber;
				if(tourBoard(board, xmoves, ymoves, moveNumber+1, xMove, yMove)){
					printBoard(board);
					return true;
				}
				else{
					board[xMove][yMove] = -1;
				}
			}
		}
		return false;
	}

	private boolean canMove(int[][] board, int i, int j) {
		return  i >= 0 
				&& j >= 0 
				&& i < board.length 
				&& j < board.length 
				&& board[i][j] == -1;
	}



}
