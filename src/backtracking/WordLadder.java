package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/word-ladder/solution/
 * 
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {

	 class Pair{
		 
		 private String word;
		 private int level;
		 
		 public Pair(String word, int level){
			 this.word = word;
			 this.level = level;
		 }
		 
		 public String getWord() {
				return word;
		}
		public int getLevel() {
			return level;
		}
			
		 
	 }
	
	 public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        
		  if(beginWord == null || endWord == null){
			  return 0;
		  }
		  
		  Map<String, List<String>> dict = new HashMap<>();
		  
		  wordList.forEach(word -> {
			  for(int i=0 ; i< word.length(); i++){
				  String generic = word.substring(0, i)+"*"+word.substring(i+1);
				  List<String> neighbours = dict.getOrDefault(generic, new ArrayList<String>());
				  neighbours.add(word);
				  dict.put(generic, neighbours);
			  }
		  });
		  
		  Map<String, Boolean> visitedMap = new HashMap<>();
		  
		  Queue<Pair> bfsQ = new LinkedList<>();
		  bfsQ.add(new Pair(beginWord, 1));
		  visitedMap.put(beginWord, true);
		  while(!bfsQ.isEmpty()){
			  
			  Pair p = bfsQ.poll();
			  String tempWord = p.getWord();
			  for(int i=0 ; i< tempWord.length(); i++){
				  String generic = tempWord.substring(0, i)+"*"+tempWord.substring(i+1);
				  List<String> neighbours = dict.getOrDefault(generic, new ArrayList<String>());
				  for(String eachNeighbor : neighbours){
					  
					  if(eachNeighbor.equals(endWord)){
						  return p.level + 1;
					  }
					  if(visitedMap.get(eachNeighbor) == null || !visitedMap.get(eachNeighbor)){
						  bfsQ.add(new Pair(eachNeighbor, p.level+1));
						  visitedMap.put(eachNeighbor, true);
					  }
				  }
			  }
		  }
		  
		  return 0;
	 }
}
