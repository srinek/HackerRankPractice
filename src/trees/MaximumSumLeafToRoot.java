package trees;

public class MaximumSumLeafToRoot {

	private static int maxSum(Node root){
		if(root == null){
			return 0;
		}
		int maxLeft = 0;
		int maxRight = 0;
		if(root.hasLeft()){
			maxLeft = maxSum(root.getLeft());
		}
		if(root.hasRight()){
			maxRight = maxSum(root.getRight());
		}
		return root.getData() + Math.max(maxLeft, maxRight);
	}
	
	public static void main(String[] args) {
		Node root = new Node(-15); 
		
		Node l1 = root.addLeft(5);
		Node r1 = root.addRight(6);
		
		Node ll2 = l1.addRight(-8);
		Node lr2 = l1.addRight(1);
		
		Node ll3 = ll2.addLeft(2);
		Node lr3 = ll2.addRight(6);
		
		Node rl2 = r1.addLeft(3);
		Node rr2 = r1.addRight(9);
		
		Node rr3 = rr2.addRight(0);
		
		Node rl4 = rr3.addLeft(4);
		Node rr4 = rr3.addRight(-1);
		
		Node rl5 = rr4.addLeft(10);
		
		System.out.println( maxSum(root) );
	}
	
	static class Node {
		
		public Node(int data){
			this.data = data;
		}
	    private int data;
	    private Node left;
	    private Node right;
	    
	    public boolean hasLeft(){
	    	if(this.left != null){
	    		return true;
	    	}
	    	return false;
	    }
	    
	    public boolean hasRight(){
	    	if(this.right != null){
	    		return true;
	    	}
	    	return false;
	    }
	    
	    public Node getLeft(){
	    	return this.left;
	    }
	    
	    public Node getRight(){
	    	return this.right;
	    }
	    
	    public int getData(){
	    	return this.data;
	    }
	    
	    public Node addLeft(int data){
	    	this.left = new Node(data);
	    	return this.left;
	    }
	    
	    public Node addRight(int data){
	    	this.right = new Node(data);
	    	return this.right;
	    }
	}
}


