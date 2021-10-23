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
//        int max = l + r;
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
//        return 1 + Math.max(left, right);
//    }

    // Optimal T->O(n)
    public int diameterOfBinaryTree(Node root) {
        int[] maxDiameter = new int[1]; //  Since java is a reference type language
        maxDiameter[0]  = Integer.MIN_VALUE;
        maxHeight(root, maxDiameter);
        return maxDiameter[0];
    }

    int maxHeight(Node root, int[] maxDiameter){
        if(root == null)
            return 0;

        int left = maxHeight(root.left, maxDiameter);
        int right = maxHeight(root.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], left + right);

        return 1 + Math.max(left,right);
    }
}
