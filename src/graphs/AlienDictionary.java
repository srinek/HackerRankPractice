package graphs;

import java.util.*;

/**
 * https://leetcode.com/problems/alien-dictionary/
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 *
 * A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 */


/* Test cases

["wrt","wrf","er","ett","rftt"]
["z","x"]
["z","x","z"]
["ab","efgh"]
["ab", "adc"]
["wrt","wrtkj"]
["aac","aabb","aaba"]
["z","x","a","zb","zx"]
["ri","xz","qxf","jhsguaw","dztqrbwbm","dhdqfb","jdv","fcgfsilnb","ooby"]
["a","b","ca","cc"]
["wnlb"]
 */
public class AlienDictionary {

	private static class Graph{
		public List<Node> nodes = new ArrayList<>();
		public Map<Character, Node> nodeMap = new HashMap<>();
		public boolean hasCycle = false;
		
		public String topologicalSort(){
			StringBuilder result = new StringBuilder();
			Stack<Node> s = new Stack<>();
			for(Node n : this.nodes){
				if(!n.visited){
					dfsUtil(n, s);
				}
			}
			while(!s.isEmpty()){
			    result.append(s.pop().data);
			}
			return result.toString();
		}
		
		private void dfsUtil(Node node, Stack<Node> s){
			if (node.explored) {
				hasCycle = true;
				return;
			}
			node.explored = true;
			for(Node adj : node.adjList){
				if(!adj.visited){
					dfsUtil(adj, s);
				}
			}
			node.visited = true;
			s.push(node);
		}
	}

	private static class Node{
		public char data;
		public Set<Node> adjList = new HashSet<>();
		public boolean visited = false;
		public boolean explored = false;
		
		public Node(char c){
			this.data = c;
		}
	}
	
	public String alienOrder(String[] words) {
		if(words == null || words.length == 0){
			return "";
		}
		if (words.length == 1) {
			return words[0];
		}
		Graph g = new Graph();
		Map<Character, Node> nodeMap = g.nodeMap;
		for(int i = 0; i <  words.length - 1; i++) {
			String w1 = words[i];
			String w2 = words[i + 1];
 			int min = Math.min(w1.length(), w2.length());
			int j = 0;
			for (; j < min; j++) {
				char c1 = w1.charAt(j);
				char c2 = w2.charAt(j);
				if (!nodeMap.containsKey(c1)) {
					Node n = new Node(c1);
					g.nodes.add(n);
					nodeMap.put(c1, n);
				}
				if (!nodeMap.containsKey(c2)) {
					Node n = new Node(c2);
					g.nodes.add(n);
					nodeMap.put(c2, n);
				}
 				if (c1 == c2) {
 					continue;
				}
 				nodeMap.get(c1).adjList.add(nodeMap.get(c2));
				break;
			}
 			if (j == min) {
 				if (w1.length() > w2.length()) {
					return "";
				}
			}
			for (int k = j; k < w1.length(); k++) {
				char c1 = w1.charAt(k);
				if (!nodeMap.containsKey(c1)) {
					Node n = new Node(c1);
					g.nodes.add(n);
					nodeMap.put(c1, n);
				}
			}
			for (int k = j; k < w2.length(); k++) {
				char c2 = w2.charAt(k);
				if (!nodeMap.containsKey(c2)) {
					Node n = new Node(c2);
					g.nodes.add(n);
					nodeMap.put(c2, n);
				}
			}
		}
		String s = g.topologicalSort();
		if (g.hasCycle) {
			return "";
		}
		return s;
    }
	
	public static void main(String[] args) {
		
		AlienDictionary dict = new AlienDictionary();
		String s = dict.alienOrder(
			new String[]{
				"a","b","ca","cc"
			}
		);
		System.out.println(s);
		/*s = dict.alienOrder(
			new String[]{
				"n","a","b","nc"
			}
		);
		System.out.println(s);
		s = dict.alienOrder(
			new String[]{
				"aac","aabb","aaba"
			}
		);
		System.out.println(s);
		s = dict.alienOrder(
			new String[]{
				"ab",
				"abcd"
			}
		);
		System.out.println(s);
		s = dict.alienOrder(
			new String[]{
				 "wrt",
				 "wrf",
				 "er",
				 "ett",
				 "rftt"
			}
		);
		
		 System.out.println(s);
		 s = dict.alienOrder(
			new String[]{
				"z",
				"x",
				"z"
			}
		);
		System.out.println(s);
		s = dict.alienOrder(
			new String[]{
				"ab",
				"adc"
			}
		);
		System.out.println(s);
		s = dict.alienOrder(
			new String[]{
				"ab",
				"efg"
			}
		);
		System.out.println(s);*/
	}
}
