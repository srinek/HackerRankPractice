package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class AlienDictionary {
	
	
	private static class Graph{
		
		public List<Node> vertices = new ArrayList<>();
		
		
		public boolean createNode(char c){
			return this.vertices.add( new Node(c));
		}
		
		public void addEdge(Node n1, Node n2){
			n1.adjList.add(n1);
		}
		
		public Node findNode(char c){
			
			for(Node vertex : vertices){
				if(vertex.data == c){
					return vertex;
				}
			}
			
			return null;
		}
		
		public String topologicalSort(){
			
			StringBuilder result = new StringBuilder();
			Stack<Node> s = new Stack<>();
			for(Node vertex : this.vertices){
				dfsUtil(vertex, s);
			}
			
			while(!s.isEmpty()){
			    result.append(s.pop().data);
			}
			
			return result.toString();
		}
		
		private void dfsUtil(Node vertex, Stack<Node> s){
			vertex.visited = true;
			
			
			for(Node n : vertex.adjList){
				if(!vertex.visited){
					dfsUtil(n, s);	
				}
			}
			
			s.push(vertex);
		}
	}

	private static class Node{
		
		public char data;
		
		public List<Node> adjList = new ArrayList<>();
		
		public boolean visited = false;
		
		public Node(char c){
			this.data = c;
		}
		
	}
	
	
	public String alienOrder(String[] words) {
        
		if(words == null || words.length == 0){
			return "";
		}
		
		Graph g = new Graph();
		Set<Character> uniqueChars = new HashSet<>();
		
		for(int i=words.length-1; i>=0 ; i--){
			
			String tempWord = words[i];
			char[] chars = tempWord.toCharArray();
			char previous = '\u0000';
			for(int j=chars.length-1; j>=0; j--){
				if(uniqueChars.add(chars[j])){
					g.createNode(chars[j]);
				}
				if(previous != '\u0000' && previous != chars[j]){
					g.addEdge(g.findNode(chars[j]), g.findNode(previous));
				}
				previous  = chars[j];
				
			}
		}
		
		String s = g.topologicalSort();
		
		return s;
    }
	
	public static void main(String[] args) {
		
		AlienDictionary dict = new AlienDictionary();
		
		String s = dict.alienOrder(new String[]{"wrt",
				  "wrf",
				  "er",
				  "ett",
				  "rftt"});
		
		System.out.println(s);
	}
}
