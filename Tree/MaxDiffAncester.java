package ImportantQ.Tree;
// https://www.geeksforgeeks.org/maximum-difference-between-node-and-its-ancestor-in-binary-tree/
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
public class MaxDiffAncester {
    class Node{
        int data;
        Node left, right;
    }
    int maxDiff(Node root)
    {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        solve(root, result);

        return result[0];
    }

    public int solve(Node root, int[] result) {
        if(root == null)
            return Integer.MAX_VALUE;

        if(isLeaf(root))
            return root.data;

        int leftMin = solve(root.left, result);
        int rightMin = solve(root.right, result);

        int val = Math.min(leftMin, rightMin);

        result[0] = Math.max(result[0], root.data - val);

        return Math.min(root.data, val);
    }

    public boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

    // Leetcode variant
    public int maxAncestorDiff(Node root) {
        int[] ans = new int[1];
        solve(root, root.data, root.data, ans);
        return ans[0];
    }

    public void solve(Node root, int min, int max, int[] ans){
        if(root == null){
            return;
        }
        min = Math.min(min, root.data);
        max = Math.max(max, root.data);

        ans[0] = Math.max(ans[0], max - min);

        solve(root.left, min, max, ans);
        solve(root.right, min, max, ans);
    }
}
