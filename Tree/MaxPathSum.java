package ImportantQ.Tree;
import ImportantQ.Tree.Node.Node;
// https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class MaxPathSum {
    // Optimal Approach T->O(n)
    public int maxPathSum(Node root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        pathSum(root, maxSum);
        return maxSum[0];
    }

    int pathSum(Node root, int[] maxSum){
        if(root == null)
            return 0;

        int left = Math.max(0, pathSum(root.left, maxSum));
        int right = Math.max(0, pathSum(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], left + right + root.data);

        return Math.max(left, right) + root.data;
    }
}
