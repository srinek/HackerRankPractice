package trie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 500
 * word in addWord consists lower-case English letters.
 * word in search consist of  '.' or lower-case English letters.
 * At most 50000 calls will be made to addWord and search.
 */
public class WordDictionary {

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean eow;
        Character c;

        public TrieNode(Character c) {
            this.c = c;
        }
    }

    TrieNode root = new TrieNode(null);
    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode current = node.children.get(c);
            if (current == null) {
                current = new TrieNode(c);
                node.children.put(c, current);
            }
            node = current;
        }
        node.eow = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word);
    }

    public boolean searchHelper(TrieNode node, String word) {
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode current = node.children.get(c);
            if (current == null) {
                if (c == '.') {
                    return searchChildren(word.substring(i+1), node.children.values());
                }
                return false;
            }
            node = current;
        }
        if (node.eow) {
            return true;
        }
        return false;
    }

    private Boolean searchChildren(final String word, Collection<TrieNode> children) {
        for (TrieNode child: children) {
            if (searchHelper(child, word)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("at");
        System.out.println(w.search(".at"));
        w.addWord("bat");
        System.out.println(w.search(".at"));
    }
}
