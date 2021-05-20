package algo.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/lru-cache/
 * 
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2);

cache.put(1, 1);
cache.put(2, 2);
*
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */




class LRUCache {
	
	private static class CacheNode{
		
		public int key;
		public int val;
		public CacheNode next;
		public CacheNode prev;
		
		public CacheNode(int key, int val){
			this.key = key;
			this.val = val;
		}
	}
	
	private int capacity = 0;
	
	private Map<Integer, CacheNode> map = new HashMap<>();
	
	private CacheNode head = null;
	private CacheNode tail = null;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
	}
	
	public void put(int key, int val){
		
		if(map.containsKey(key)){
			CacheNode temp =  map.get(key);
			temp.val = val;
			this.remove(temp);
			this.setHead(temp);
		}
		else{
			if(map.size() >= this.capacity){
				map.remove(this.tail.key);
				this.remove(this.tail);
				
			}
			CacheNode temp = new CacheNode(key, val);
			map.put(key, temp);
			this.setHead(temp);
		}
	}
	
	private void setHead(CacheNode node){
		
		if(this.head == null){
			this.head = node;
		}
		else{
			node.next = this.head;
			node.prev = null;
			this.head.prev = node;
			this.head = node;
		}
		if(this.tail == null){
			this.tail = this.head;
		}
	}
	
	private void remove(CacheNode node){
		// remove head
		//remove tail
		//remove in middle
		
		if(node.prev == null){ // this is head
			this.head = node.next;
		}
		else{
			node.prev.next = node.next;
		}
		if(node.next == null){ // this is tail
			this.tail = node.prev;
		}
		else{
			node.next.prev = node.prev;
		}
	}


	public int get(int key){
		if(!map.containsKey(key)){
			return -1;
		}
		CacheNode temp =  map.get(key);
		this.remove(temp);
		this.setHead(temp);
		return temp.val;
	}
    
    public static void main(String[] args){
    	LRUCache lru = new LRUCache(2);
    	lru.put(1, 1);
    	lru.put(2, 2);
    	lru.put(3, 3);
    	lru.put(2, 2);
    	
    }
}