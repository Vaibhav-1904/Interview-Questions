package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
// https://leetcode.com/problems/symmetric-tree/
// Is Tree Symmetric or not, mirror Images by taking root of tree as center should be same.
public class SymmetricTree {
    public boolean isSymmetric(Node root) {
        return root == null || mirror(root.left, root.right);
    }

    boolean mirror(Node left, Node right){

        if(left == null || right == null)
            return left == right;

        if(left.data != right.data)
            return false;

        return mirror(left.left, right.right) && mirror(left.right, right.left);
    }
}
