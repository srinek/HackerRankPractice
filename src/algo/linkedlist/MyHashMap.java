package algo.linkedlist;

public class MyHashMap {
	
	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		map.put(1, 1);
		map.put(10001, 100001);
		map.put(2, 2);
		map.put(10002, 10002);
		map.put(10000, 100000);
		
		System.out.println( map.get(10001));
		map.remove(1);
		System.out.println( map.get(1));
		System.out.println( map.get(10001));
	}

	private Entry[] buckets = null;
	public MyHashMap(){
		buckets = new Entry[10000];
	}
	
	private int getBucketIndex(int key){
		return Integer.valueOf(key).hashCode() % buckets.length;
	}
	
	public void put(int key, int value){
		
		int hash = getBucketIndex(key);
		Entry entry = this.buckets[hash];
		while(entry != null){ // update existing key
			if(entry.key == key){
				entry.value = value;
				return;
			}
			entry = entry.next;
		}
		Entry existing = this.buckets[hash];
		Entry node = new Entry(key, value);
		node.next = existing;
		this.buckets[hash] = node;
	}
	
	public int get(int key){
		int hash = getBucketIndex(key);
		Entry entry = this.buckets[hash];
		while(entry != null){ 
			if(entry.key == key){
				return entry.value;
			}
			entry = entry.next;
		}
		
		return -1;
	}
	
	public void remove(int key){
		int hash = getBucketIndex(key);
		Entry root = this.buckets[hash];
		Entry cur = root;
		Entry prev = null;
		boolean keyFound = false;
		while(cur != null){ 
			if(cur.key == key){
				keyFound = true;
				break;
			}
			prev = cur;
			cur = cur.next;
		}
		if(keyFound){
			if(prev != null){  // middle/last node
				prev.next = cur.next;
			}
			else{
				this.buckets[hash] = cur.next;  // first node
			}
		}
	}
	
	private static class Entry{
		
		public int key;
		public int value;
		
		public Entry next;
		
		public Entry(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
}
