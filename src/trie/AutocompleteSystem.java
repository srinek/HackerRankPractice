package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * https://leetcode.com/problems/design-search-autocomplete-system/
 * 
 * 
 * 
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences 
 * that have prefix the same as the part of sentence already typed. Here are the specific rules:

  The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
  The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
  If less than 3 hot sentences exist, then just return as many as you can.
  When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.

Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.

 
Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times
Now, the user begins another search:

Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.

 
Note:

The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class AutocompleteSystem {
	
	private static class TrieNode{
		
		private Map<Character, TrieNode> children = new HashMap<>();
		private boolean endOfWord = false;
		private int weight = 0;
		private Character c;
		
		public TrieNode(Character c){
			this.c = c;
		}
		
		public TrieNode find(Character c){
			return this.children.get(c);
		}
		
		public void addChildren(Character key, TrieNode node){
			this.children.put(key, node);
		}
		
		public void setEndOfWord(boolean eow){
			this.endOfWord = eow;
		}
		
		public boolean isEndOfWord(){
			return this.endOfWord;
		}
		
		public int getWeight(){
			return this.weight;
		}
		
		public void setWeight(int weight){
			this.weight = weight;
		}
	}
	
	private static class WeightedSentence implements Comparable<WeightedSentence>{
		
		public String word;
		public int weight;
		
		public WeightedSentence(String word, int weight){
			this.word = word;
			this.weight = weight;
		}
		
		public int compareTo(WeightedSentence input){

			if(input.weight - this.weight == 0){
				return this.word.compareTo(input.word);
			}
			return input.weight - this.weight;
		}
		
		@Override
		public String toString(){
			return super.toString() +" "+ word;
		}
		
		@Override
		public boolean equals(Object o){
			
			if(o == null){
				return false;
			}
			if(((WeightedSentence)o).word.equals(this.word)){
				return true;
			}
			return false;
		}
		
	}
	
	
	private TrieNode root = new TrieNode(null);  // null node
	
	
	//nanda
	public boolean insertWord(String sentence, int weight){
		if(sentence.length() == 0){
			return false;
		}
        return insertHelper(sentence, root, weight);
		
	}
	
	private boolean insertHelper(String sentence, TrieNode current, int weight){
		char c = sentence.charAt(0);
		TrieNode temp = current.find(c);
		if(temp == null){
			temp = new TrieNode(c);
			current.addChildren(c, temp);
			if(sentence.length() == 1){
				temp.setEndOfWord(true);
				temp.setWeight(temp.getWeight()+weight);
				return true;
			}
			return insertHelper(sentence.substring(1), temp, weight);
		}
		
		if(sentence.length() == 1){
			temp.setEndOfWord(true);
			temp.setWeight(temp.getWeight()+weight);
			return true;
		}
		return insertHelper(sentence.substring(1), temp, weight);
	}

	public AutocompleteSystem(String[] sentences, int[] times) {
		int i = 0;
		this.searchCurrent = root;
		this.searchStr = "";
		for(String sentence : sentences){
			insertWord(sentence, times[i++]);
		}
	}
    
	TrieNode searchCurrent = root;
	String searchStr = "";
	public List<String> input(char c) {
		
		List<WeightedSentence> result = new ArrayList<>();
		if(c != '#'){
			searchWordHelper(c, searchCurrent, result, searchStr);
			if(searchCurrent != null){
				searchCurrent = searchCurrent.find(c);
			}
			searchStr += c;
		}
		else{
			insertWord(searchStr, 1);
			searchCurrent = root;
			searchStr = "";
		}
		
		Collections.sort(result);
		int total = Math.min(result.size(), 3); 
		List<String> r = new ArrayList<>();
		int i = 0;
		while(i<total){
			r.add(result.get(i).word);
			i++;
		}
		System.out.println(r);
		return r;
		
	}
	
	private void searchWordHelper(char c, TrieNode current, List<WeightedSentence> result , String word){
		    
		    if(current == null){
		    	return;
		    }
		
			TrieNode temp = current.find(c);
			if(temp == null){
				return;
			}
			if(temp.isEndOfWord()){
				result.add(new WeightedSentence(word+c, temp.getWeight()));
			}
			for(Character child : temp.children.keySet()){
				searchWordHelper(child, temp,  result, word+c);
			}
	}
	

   

	
	/*
	 * ["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input","input","input"]
[[["abc","abbc","a"],[3,3,3]],["b"],["c"],["#"],["b"],["c"],["#"],["a"],["b"],["c"],["#"],["a"],["b"],["c"],["#"]]

[[],[],[],["bc"],["bc"],[],["a","abbc","abc"],["abbc","abc"],["abc"],[],["abc","a","abbc"],["abc","abbc"],["abc"],[]]
	 */
	
	public static void main(String[] args) {
		AutocompleteSystem auto = new AutocompleteSystem(new String[]{"abc","abbc","a"}, new int[]{3,3,3});
		auto.input('b');
		auto.input('c');
		auto.input('#');
		auto.input('b');
		auto.input('c');
		auto.input('#');
		auto.input('a');
		auto.input('b');
		auto.input('c');
		auto.input('#');
		auto.input('a');
		auto.input('b');
		auto.input('c');
		auto.input('#');
	}
}
