package backtracking;

/*
 * https://leetcode.com/problems/word-search/
 * 
 * 
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
"ABCESEEEFS"
 */
public class WordSearch {
	
	  public static void main(String[] args) {
		 
		  
		  System.out.println('A' ^ 256);
		  System.out.println(321 ^ 256);
		  
		  WordSearch search = new WordSearch();
		  char[][] board = new char[3][4];
		  board[0] = new char[]{'A','B','C','E'};
		  //board[1] = new char[]{'S','F','C','S'};
		  board[1] = new char[]{'S','F','E','S'};
		  board[2] = new char[]{'A','D','E','E'};
		  /*char[][] board = new char[2][1];
		  board[0] = new char[]{'a'};
		  board[1] = new char[]{'s'};*/
		  System.out.println(search.exist(board, "ABCESEEE"));
		  
	  }

	  public boolean exist(char[][] board, String word) {
	  
		  if(board == null || board.length == 0){
			  return false;
		  }
		  boolean result = false;
		  for(int i=0; i<board.length; i++){
			  for(int j=0; j<board[i].length; j++){
				  if(result){
					  return true;
				  }
				  result = this.helper(board, word, 0, i, j);
			  }
		  }
		  return result;
		  
	  }


	private boolean helper(char[][] board, String word, int currentIndex, int i, int j) {
		if(currentIndex == word.length()){
			return true;
		}
		if(i < 0 || j < 0 || i >= board.length || j >= board[i].length){
			return false;
		}
		if(currentIndex >= word.length()){
			return false;
		}
		if(board[i][j] != word.charAt(currentIndex)){
			return false;
		}
		board[i][j] ^= 1;
		boolean exist = helper(board, word, currentIndex+1, i+1, j) 
					|| helper(board, word, currentIndex+1, i, j+1)
					|| helper(board, word, currentIndex+1, i-1, j)
					|| helper(board, word, currentIndex+1, i, j-1);
		board[i][j] ^= 1;
		return exist;
	}
	  
	  
}
