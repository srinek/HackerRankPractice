package trees;

public class HuffmanDecoding {

	class Node {
		public int frequency; // the frequency of this tree
		public char data;
		public Node left, right;
	}
    // 1001011
	void decode(String S, Node root) {
		if(root == null || S == null){
			System.out.print("");
			return;
		}
		Node temp = root;
		for(int i = 0; i < S.length(); i++){
			int c = Integer.parseInt(S.charAt(i)+"");
			if(c == 1){
			   temp = temp.right;	
			}
			else{
				temp = temp.left;
			}
			if(temp.data != '\0'){
				System.out.print(temp.data);
				temp = root;
			}
		}
	}
}
