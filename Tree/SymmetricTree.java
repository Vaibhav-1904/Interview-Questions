package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
// https://leetcode.com/problems/symmetric-tree/
// Is Tree Symmetric or not, mirror Images by taking root of tree as center should be same.
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || mirror(root.left, root.right);
    }

    boolean mirror(TreeNode left, TreeNode right){

        if(left == null || right == null)
            return left == right;

        if(left.val != right.val)
            return false;

        return mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}
