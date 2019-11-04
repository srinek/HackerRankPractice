package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeDeserializeTree {

	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
    	StringBuilder result = new StringBuilder();
    	serializeHelper(root, result);
        System.out.println(result.toString());
    	return result.toString();
    }
    
    private void serializeHelper(TreeNode node, StringBuilder ret){
    	
    	if(node == null){
    		ret.append(",null,");
    		return;
    	}
    	
    	ret.append(node.val);
        ret.append(",");
    	serializeHelper(node.left, ret);
    	serializeHelper(node.right, ret);
    	
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    	List<String> list = new ArrayList<>(Arrays.asList(data.split(","))) ;
    	TreeNode  tree = deserializeHelper(list);
    	return tree;
    }
    
    private TreeNode deserializeHelper(List<String> list){
    	
    	if(list.size() == 0){
    		return null;
    	}
        while(list.get(0).equals("")){
            list.remove(0);
        }
    	if(list.get(0).equals("null")){
    		list.remove(0);
    		return null;
    	}
    	String val = list.remove(0);
    	TreeNode node = new TreeNode(Integer.valueOf(val));
    	node.left = deserializeHelper(list);
    	node.right = deserializeHelper(list);
    	return node;
    }
}
