package trie;

import java.util.*;

public class Trie {
	
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
		Trie trie = new Trie();
		trie.insert("Nanda");
		trie.insert("Devi");
		trie.insert("Nama");
		trie.insert("Nabi");
		trie.insert("Nanna");
		trie.insert("Nekkanti");
		trie.insert("Na");
		System.out.println(trie.search("Na"));
		System.out.println(trie.startsWith("Na"));
		System.out.println(trie.search("Nb"));
		System.out.println(trie.startsWith("Nb"));
		System.out.println(trie.search("Q"));
		System.out.println(trie.search("Nama1"));
		System.out.println(trie.startsWith("Nama1"));
	}
	
	public static class TrieNode{
		
		public Map<Character, TrieNode> children = new HashMap<>();
		public boolean eow = false;
		private Character c;
		
		public TrieNode(Character c){
			this.c = c;
		}
	}
	
	private TrieNode root = new TrieNode(null);  // null node
	
	//nanda
	public void insert(String sentence){
		if(sentence.length() == 0){
			return;
		}
		TrieNode node = root;
        for (int i=0; i < sentence.length(); i++) {
        	Character c = sentence.charAt(i);
        	TrieNode current = node.children.get(c);
        	if (current == null) {
        		current = new TrieNode(c);
        		node.children.put(c, current);
			}
			node = current;
		}
		node.eow = true;
	}

	public boolean search(String sentence){
		return search(sentence, true);
	}
	
	private boolean search(String sentence, boolean checkWord){
		if(sentence.length() == 0){
			return false;
		}
		TrieNode node = root;
		for (int i=0; i < sentence.length(); i++) {
			Character c = sentence.charAt(i);
			TrieNode current = node.children.get(c);
			if (current == null) {
				return false;
			}
			node = current;
		}
		if (!checkWord || (checkWord && node.eow)) {
			return true;
		}
		return false;
	}

	public boolean delete(String sentence){
		if(sentence.length() == 0){
			return false;
		}
		return false;
	}
	
	public boolean startsWith(String prefix){
		return search(prefix, false);
	}
}
