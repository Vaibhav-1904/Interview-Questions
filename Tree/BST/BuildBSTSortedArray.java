package ImportantQ.Tree.BST;
import ImportantQ.Tree.Node.TreeNode;

public class BuildBSTSortedArray {
    // Optimal Approach T -> O(n)
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;

        if (start == end)
            return new TreeNode(nums[start]);
        else {
            int mid = (start + end) >> 1;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums, start, mid - 1);
            root.right = buildTree(nums, mid + 1, end);

            return root;
        }
    }
}
