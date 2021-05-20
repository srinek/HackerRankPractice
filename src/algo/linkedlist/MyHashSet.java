package algo.linkedlist;

public class MyHashSet {

	
	ListNode[] bucket;
    /** Initialize your data structure here. */
    public MyHashSet() {
        this.bucket = new ListNode[10000];
    }
    
    private int getBucketIndex(int key){
        return Integer.valueOf(key).hashCode() % this.bucket.length;
    }
    public void add(int key) {
       int hash = this.getBucketIndex(key);
       ListNode node = this.bucket[hash];
       while(node != null){
           if(node.val == key){
               return;
           }
           node = node.next;
       }
       node = this.bucket[hash];
       ListNode temp = new ListNode(key);
        temp.next = node;
       this.bucket[hash] = temp;
        
    }
    
    public void remove(int key) {
        int hash = this.getBucketIndex(key);
        ListNode root = this.bucket[hash];
        ListNode cur = root, prev = null;
        boolean keyFound = false;
        while(cur != null){
            if(cur.val == key){
                keyFound = true;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        if(keyFound){
            if(prev != null){
                prev.next = cur.next;
            }
            else{
                this.bucket[hash] = cur.next;
            }
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = this.getBucketIndex(key);
        ListNode node = this.bucket[hash];
        while(node != null){
           if(node.val == key){
               return true;
           }
           node = node.next;
       }
       return false;
    }
    
    private static class ListNode{
        
        public int val;
        public ListNode next;
        
        public ListNode(int val){
            this.val = val;
        }
    }
}
