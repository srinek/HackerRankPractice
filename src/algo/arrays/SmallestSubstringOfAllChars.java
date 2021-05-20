package algo.arrays;

public class SmallestSubstringOfAllChars {

	/**
	 * Smallest Substring of All Characters
Given an array of unique characters arr and a string str,
* Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr.
Return "" (empty string) if such a substring doesn�t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.
	
	input:  arr = ['x','y','z'], str = "xyyzyzyx"

			output: "zyx"*/
	
	
	static String getShortestUniqueSubstring(char[] arr, String str) {
		String minStr = "";
	    return getMinSubString(arr, str, minStr);
	     
	  }
	
	 static String getMinSubString(char[] arr, String str, String minStr){
		 if(arr == null | str == null){
	    	 return "";
	     }
	     if(arr.length > str.length()){
	    	 return "";
	     }
	     for(char c : arr){
	    	 int index = str.indexOf(c);
	    	 if(index == -1){
	    		 return "";
	    	 }
	     }
	     minStr = str;
	     String temp1 = getMinSubString(arr, str.substring(0, str.length()-1), minStr);
	     if(temp1 != "" && temp1.length() < minStr.length()){
	    	 minStr = temp1;
	     }
	     if(str.length() > 1){
	    	 String temp2 = getMinSubString(arr, str.substring(1, str.length()), minStr);
	    	 if(temp2 != "" && temp2.length() < minStr.length()){
		    	 minStr = temp2;
		     }
	     }
	     return minStr;
	 }

	  public static void main(String[] args) {
	    //System.out.print(getShortestUniqueSubstring(new char[]{'A','B','C'}, "ADOBECODEBANCDDD"));
		//System.out.print(getShortestUniqueSubstring(new char[]{'A','B'}, "EACBE"));
		  System.out.print(getShortestUniqueSubstring(new char[]{'A','A','B','C'}, "ABAACBAB"));
	  }
}
