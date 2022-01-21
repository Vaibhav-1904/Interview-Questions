package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;

// https://leetcode.com/problems/count-complete-tree-nodes/submissions/
// Complete Tree - every level, except possibly the last, is completely filled in a complete binary tree,
// and all nodes in the last level are as far left as possible.
public class CountNodesInCompleteTree {
    // Naive T-> O(n) S->O(log n)
//    public int countNodes(Node root) {
//        if(root == null)
//            return 0;
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }

    // OptimalT->O((logn)^2)
    public int countNodes(TreeNode root) {
        int lh = 0;
        int rh = 0;
        TreeNode treeNode = root;
        while(treeNode != null){
            lh++;
            treeNode = treeNode.left;
        }
        treeNode = root;
        while(treeNode != null){
            rh++;
            treeNode = treeNode.right;
        }

        if(lh == rh)
            return (int)Math.pow(2, lh) - 1; // (1<<lh)
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
