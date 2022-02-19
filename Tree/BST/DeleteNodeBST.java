package ImportantQ.Tree.BST;
import ImportantQ.Tree.Node.TreeNode;
// https://leetcode.com/problems/delete-node-in-a-bst/

public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key)
            return helper(root);

        TreeNode head = root;
        while(root != null) {
            if(root.val > key){
                if(root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                }else{
                    root = root.left;// when the given key is not present
                }
            }else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return head;
    }

    public TreeNode helper(TreeNode root){
        if(root.left == null)
            return root.right;
        else if(root.right == null)
            return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    public TreeNode findLastRight(TreeNode root){
        while(root.right != null)
            root = root.right;
        return root;
    }
}
