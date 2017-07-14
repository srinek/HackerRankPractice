package strings;

import java.util.Scanner;

public class FunnyString {

	  public static void main(String[] args) {
		  
		 Scanner scan = new Scanner(System.in);
		 int total = scan.nextInt();
		 for(int i=0; i < total; i++){
			 if(isFunnyString(scan.next())){
				 System.out.println("Funny");
			 }
			 else{
				 System.out.println("Not Funny");
			 }
		 }
		 scan.close();
	  }
	
	  private static boolean isFunnyString(String str){
		   if(str == null || str.trim().length() ==0){
			   return false;
		   }
		   
		   char[] chars = str.toCharArray();
		   int[] diffs = new int[chars.length - 1];
		   for(int i = 1; i < chars.length; i++){
			   diffs[i-1] = Math.abs(chars[i] - chars[i-1]);
		   }

		   for(int k=0; k< diffs.length ; k++){
			   if(diffs[k] != diffs[diffs.length - (k+1)]){
				   return false;
			   }
		   }
		   return true;
	   }
}
