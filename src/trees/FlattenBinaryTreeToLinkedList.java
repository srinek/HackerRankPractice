package trees;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        if (root.left == null) {
            return;
        }
        root.right = root.left;
        root.left = null;
        TreeNode t = root;
        TreeNode prev = root;
        while (t != null) {
            prev = t;
            t = t.right;
        }
        prev.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList i = new FlattenBinaryTreeToLinkedList();
        i.flatten(root);
    }
}
