package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
// https://leetcode.com/problems/diameter-of-binary-tree/submissions/

public class MaxDiameter {
//// Naive Approach T->O(n^2)
//    public int diameterOfBinaryTree(Node root) {
//        if(root == null)
//            return 0;
//
//        int l = maxDepth(root.left);
//        int r = maxDepth(root.right);
//        int max = l+r;
//
//        int left = diameterOfBinaryTree(root.left);
//        int right = diameterOfBinaryTree(root.right);
//
//        return Math.max(max, Math.max(left, right));
//    }
//
//    public int maxDepth(Node root){
//        if(root == null)
//            return 0;
//
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//
//        return 1+Math.max(left, right);
//    }

    // Optimal T->O(n)
    public int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        maxHeight(root, diameter);
        return diameter[0];
    }

    int maxHeight(Node root, int[] diameter){
        if(root == null)
            return 0;

        int left = maxHeight(root.left, diameter);
        int right = maxHeight(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);

        return 1+Math.max(left,right);
    }
}
