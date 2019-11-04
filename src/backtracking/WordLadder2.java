package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 * 
 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder2 {
	
	
	 public static void main(String[] args) {
		 WordLadder2 ladder2 = new WordLadder2();
		 /*List<String> wordList = new ArrayList<>();
		 wordList.add("hot");
		 wordList.add("dot");
		 wordList.add("dog");
		 wordList.add("lot");
		 wordList.add("log");
		 wordList.add("cog");
		 System.out.println(ladder2.findLadders("hit", "cog", wordList));*/
		 /*List<String> wordList = new ArrayList<>();
		 wordList.add("a");
		 wordList.add("b");
		 wordList.add("c");
		 System.out.println(ladder2.findLadders("a", "c", wordList));*/
		 List<String> wordList = new ArrayList<>();
		 wordList.add("ted");
		 wordList.add("tex");
		 wordList.add("red");
		 wordList.add("tax");
		 wordList.add("tad");
		 wordList.add("den");
		 wordList.add("rex");
		 wordList.add("pee");
		 System.out.println(ladder2.findLadders("red", "tax", wordList));
	}
	 

	class Node{
		 
		 public String word;
		 public List<String> path = new ArrayList<>();
		 
		 public Node(String word, List<String> path){
			 this.word = word;
			 this.path = path;
		 }
        
		@Override 
		public String toString(){
			return "{"+this.word +"  -- "+ this.path +"}";
		}
		 
	 }
	// ["hot","dot","dog","lot","log","cog"]
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	        
		  List<List<String>> result = new ArrayList<>();
		
		  if(beginWord == null || endWord == null){
			  return result;
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
 		  
		  Queue<Node> bfsQ = new LinkedList<>();
		  bfsQ.add(new Node(beginWord, Arrays.asList(beginWord)));
		  visitedMap.put(beginWord, true);
		  int shortest = Integer.MAX_VALUE;
		  //System.out.println(dict);
		  while(!bfsQ.isEmpty()){
			  
			  Node p = bfsQ.poll();
			  String tempWord = p.word;
			  for(int i=0 ; i< tempWord.length(); i++){
				  String generic = tempWord.substring(0, i)+"*"+tempWord.substring(i+1);
				  List<String> neighbours = dict.getOrDefault(generic, new ArrayList<String>());
				  
				  for(String eachNeighbor : neighbours){
					  if(eachNeighbor.equals(endWord)){
						  List<String> endPath = new ArrayList<>(p.path);
						  endPath.add(endWord);
						  shortest = Math.min(shortest, endPath.size());
						  result.add(endPath);
					  }
					  else if(visitedMap.get(eachNeighbor) == null || !visitedMap.get(eachNeighbor)){
						 List<String> newPath = new ArrayList<>(p.path);
						 newPath.add(eachNeighbor);
						 Node n = new Node(eachNeighbor, newPath);
						 bfsQ.offer(n);
						 visitedMap.put(eachNeighbor, true);
					   }
					  
				  }
			  }
		  }
		  List<List<String>> newResult = new ArrayList<>();
		  for(int i=0; i<result.size(); i++){
			  if(shortest == result.get(i).size()){
				  newResult.add(result.get(i));
			  }
		  }
		  return newResult;
	}

}
