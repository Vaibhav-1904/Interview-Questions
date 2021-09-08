package ImportantQ.Tree;
// You need to find Max Depth or height of the Tree.
public class MaxDepthTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // One Approach is to use Level Order (BFS) to find max depth, S-> O(n)

    //recursive auxiliary space T->O(n), where n is number of nodes in a Tree
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1 + Math.max(l, r);
    }
}
