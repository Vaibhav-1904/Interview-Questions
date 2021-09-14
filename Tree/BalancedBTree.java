package ImportantQ.Tree;
import ImportantQ.Tree.Node.Node;
// a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
// https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBTree {
//    // Naive Approach T -> O(n^2)
//    public boolean isBalanced(Node root) {
//        if(root == null)
//            return true;
//
//        int l = maxDepth(root.left);
//        int r = maxDepth(root.right);
//
//        if(Math.abs(l - r) > 1)
//            return false;
//
//        boolean left = isBalanced(root.left);
//        boolean right = isBalanced(root.right);
//
//        if(!left || !right)
//            return false;
//
//        return true;
//    }
//
//    int maxDepth(Node root){
//        if(root == null)
//            return 0;
//
//        int l = maxDepth(root.left);
//        int r = maxDepth(root.right);
//
//        return 1 + Math.max(l, r);
//    }

    // Optimal T -> O(n)
    public boolean isBalanced(Node root) {
        return maxDepth(root) != -1;
    }

    public int maxDepth(Node root){
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        if(left == -1)
            return -1;

        int right = maxDepth(root.right);
        if(right == -1)
            return -1;

        if(Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
}
