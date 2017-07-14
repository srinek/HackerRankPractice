package algo.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CastleOntheGrid {

	private static int UNVISITED = -1;
	private static int RESTRICTED = -2;
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		char[][] chars = new char[n][n];
		int k = 0;
		while(k < n){
			String str = scan.next();
			for(int i = 0; i < n; i++){
				chars[k][i] = str.charAt(i);
			}
			k++;
		}
		Board board = new Board(chars, n);
		//System.out.println(board);
		//System.out.println("---------------------------------------------------------------------------------");
		System.out.println(findPaths(board, n, scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println(board);
		scan.close();
	}
	

    private static int findPaths(Board board, int n, int a, int b, int c, int d) {
		
    	Queue<int[]> queue = new ArrayDeque<>();
    	queue.offer(new int[]{a,b});
    	int result = 0;
    	board.getValues()[a][b] = result;
    	while(!queue.isEmpty()){
    		
    		int[] start = queue.poll();
    		int ta = start[0];
    		int tb = start[1];
    		result = board.getValues()[ta][tb] + 1;
    		if(ta == c && tb == d){
    			break;
    		}
    		
    		for(int i = ta-1; i >= 0; i--){
    			int la = i;
    			int lb = tb;
    			if(board.getValues()[la][lb] == UNVISITED){
    				board.getValues()[la][lb] = result;
    				queue.offer(new int[]{la, lb});
    			}
    			else if(board.getValues()[la][lb] == RESTRICTED){
    				break;
    			}
    		}
    		
    		for(int i = tb-1; i >= 0; i--){
    			int la = ta;
    			int lb = i;
    			if(board.getValues()[la][lb] == UNVISITED){
    				board.getValues()[la][lb] = result;
    				queue.offer(new int[]{la, lb});
    			}
    			else if(board.getValues()[la][lb] == RESTRICTED){
    				break;
    			}
    		}
    		
    		for(int i = ta+1; i < n; i++){
    			int la = i;
    			int lb = tb;
    			if(board.getValues()[la][lb] == UNVISITED){
    				board.getValues()[la][lb] = result;
    				queue.offer(new int[]{la, lb});
    			}
    			else if(board.getValues()[la][lb] == RESTRICTED){
    				break;
    			}
    		}
    		
    		for(int i = tb+1; i < n; i++){
    			int la = ta;
    			int lb = i;
    			if(board.getValues()[la][lb] == UNVISITED){
    				board.getValues()[la][lb] = result;
    				queue.offer(new int[]{la, lb});
    			}
    			else if(board.getValues()[la][lb] == RESTRICTED){
    				break;
    			}
    		}
    	}
    	
    	return board.getValues()[c][d];
    	
		
	}


	public static class Board{
    	
    	int[][] values = null;
    	public Board(char[][] input, int n){
    		values = new int[n][n];
    		for(int i = 0; i< input.length; i++){
    			for(int j = 0; j < input[i].length; j++){
    				if(input[i][j] == '.'){
    					values[i][j] = UNVISITED;	
    				}
    				else if(input[i][j] == 'X'){
    					values[i][j] = RESTRICTED;
    				}
    			}
    		}
    	}
    	
    	public int[][] getValues(){
    		return this.values;
    	}
    	
    	private String pad(int val){
    		if(val <= 0){
    			return val+"";
    		}
    		if(val >= 0&& val < 10){
    			return " "+val;
    		}
    		return val+"";
    	}
    	
    	@Override
    	public String toString() {
    		String str = new String();
    		for(int i = 0; i< values.length; i++){
    			for(int j = 0; j < values[i].length; j++){
    				
    				str += "{"+pad(j)+","+pad(values[i][j]) + "}  ";
    			}
    			str += "\n"; 
    		}
    		return str.toString();
    	}
    }
}
