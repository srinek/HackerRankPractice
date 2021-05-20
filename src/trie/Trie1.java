package trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie1 {
	
	public static void main(String[] args) {
		
		/*Scanner scanner = new Scanner(System.in);
		int tests =  scanner.nextInt();
		Trie1 trie = new Trie1();
		while(tests-- > 0){
			int n = scanner.nextInt();
			while(n-- > 0){
				String s = scanner.next();
				trie.insertWord(s);
			}
			if(trie.delete(scanner.next())){
				System.out.println("1");
			}
			else{
				System.out.println("0");
			}
		}
		scanner.close();*/
		Trie1 trie = new Trie1();
		trie.insertWord("Nanda");
		trie.insertWord("Devi");
		trie.insertWord("Nama");
		trie.insertWord("Nabi");
		trie.insertWord("Nanna");
		trie.insertWord("Nekkanti");
		trie.insertWord("Na");
		System.out.println(trie.startsWith("Na"));
		
	}
	
	public static class TrieNode{
		
		private Map<Character, TrieNode> children = new HashMap<>();
		private boolean endOfWord = false;
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
		
		public Collection<TrieNode> getChildNodes(){
			return children.values();
		}
	}
	
	private TrieNode root = new TrieNode(null);  // null node
	
	//nanda
	public boolean insertWord(String sentence){
		if(sentence.length() == 0){
			return false;
		}
        return insertHelper(sentence, root);
		
	}
	
	private boolean insertHelper(String sentence, TrieNode current){
		TrieNode temp = current.find(sentence.charAt(0));
		if(temp == null){
			temp = new TrieNode(sentence.charAt(0));
			current.addChildren(sentence.charAt(0), temp);
			if(sentence.length() == 1){
				temp.setEndOfWord(true);
				return true;
			}
			return insertHelper(sentence.substring(1), temp);
		}
		if(sentence.length() == 1){
			temp.setEndOfWord(true);
			return true;
		}
		return insertHelper(sentence.substring(1), temp);
	}
	
	public boolean search(String sentence){
		if(sentence.length() == 0){
			return false;
		}
		return searchHelper(sentence, root);
	}
	
	private boolean searchHelper(String sentence, TrieNode current){
		TrieNode temp = current.find(sentence.charAt(0));
		if(temp == null){
			return false;
		}
		if(temp.endOfWord && sentence.length() == 1){
			return true;
		}
		if(sentence.length() == 1){
			return false;
		}
		
		return searchHelper(sentence.substring(1), temp);
	}
	
	
	public boolean delete(String sentence){
		if(sentence.length() == 0){
			return false;
		}
		return deleteHelper(sentence, root, null);
	}
	
	private boolean deleteHelper(String sentence, TrieNode current, TrieNode parent){
		TrieNode temp = current.find(sentence.charAt(0));
		if(temp == null){
			return false;
		}
		if(temp.endOfWord && sentence.length() == 1){
			if(temp.children.size() == 0){
				parent.children.remove(sentence.charAt(0));
			}
			else{
				temp.endOfWord = false;
			}
			return true;
		}
		if(sentence.length() == 1){
			return false;
		}
		if(deleteHelper(sentence.substring(1), temp, current)){
			if(temp.children.size() == 0){
				parent.children.remove(sentence.charAt(0));
			}
			else{
				temp.endOfWord = false;
			}
			return true;
		} 
		return false;
	}
	
	public List<String> startsWith(String prefix){
		
		return startsWithhelper(prefix, prefix, root);
	}
	
	
	public List<String> startsWithhelper(String orig, String prefix, TrieNode node){
		
		if(prefix.length() > 0){
			TrieNode temp =  node.find(prefix.charAt(0));
			
			if(temp == null){
				return new ArrayList<>();
			}
			return startsWithhelper(orig, prefix.substring(1), temp);
		}
		List<String> result = new ArrayList<>();
		populateAllNodes(node, result, orig);
		return result;
		
	}

	private void populateAllNodes(TrieNode node, List<String> result, String prefix) {
		
		if(node == null){
			return;
		}
		if(node.endOfWord){
			result.add(prefix);
		}
		for(TrieNode child : node.getChildNodes()){
			String tempPrefix = prefix;
			tempPrefix = prefix+child.c;
			populateAllNodes(child, result, tempPrefix);
		}
		
	}

}
