package strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/word-break/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

public class WordBreak {
	
	
	public static void main(String[] args) {
		WordBreak wordBreak = new WordBreak();
		/*List<String> list = new ArrayList<>();
		list.add("leet");
		list.add("code");
		System.out.println(wordBreak.wordBreak("leetcode", list));*/
		
		List<String> list = new ArrayList<>();
		list.add("cats");
		list.add("dog");
		list.add("sand");
		list.add("and");
		list.add("cat");
		System.out.println(wordBreak.wordBreak("catsandog", list));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
	     
		 if(s == null || s.length() == 0){
			 return false;
		 }
		 return  bfsSol(s, wordDict);
	}
	
	//bfs
	
	private boolean bfsSol(String s, List<String> wordDict){
		
		boolean[] visited = new boolean[s.length()];
		
		Queue<Integer> bfs = new LinkedList<>();
		bfs.offer(0);
		
		while(!bfs.isEmpty()){
			
			int start = bfs.poll();
			if(!visited[start]){
				for(int i=start+1; i <= s.length(); i++){
					if(wordDict.contains(s.substring(start, i))){
						System.out.println(s.substring(start, i));
						bfs.add(i);
						if(i == s.length()){
							return true;
						}
					}
				}
				visited[start] = true;
			}
		}
		
		return false;
		
	}
	
	 // backtracking 
	private boolean wordBreakHelper(String s, List<String> wordDict, int start){
		 
		 if(start >= s.length()){
			 return true;
		 }
		 
		 for(int i=start; i<=s.length(); i++ ){
			 
			 if(wordDict.contains(s.substring(start, i)) && wordBreakHelper(s, wordDict, i)){
				 return true;
			 }
		 }
		 
		 return false;
	 }
}
