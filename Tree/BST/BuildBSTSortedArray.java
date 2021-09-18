package ImportantQ.Tree.BST;
import ImportantQ.Tree.TreeNode.Node;

public class BuildBSTSortedArray {
    // Optimal Approach T -> O(n)
    public Node sortedArrayToBST(int[] nums) {
        if(nums.length == 1)
            return new Node(nums[0]);
        return buildTree(nums, 0, nums.length - 1);
    }

    public Node buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;

        if (start == end)
            return new Node(nums[start]);
        else {
            int mid = (start + end) >> 1;
            Node root = new Node(nums[mid]);
            root.left = buildTree(nums, start, mid - 1);
            root.right = buildTree(nums, mid + 1, end);

            return root;
        }
    }
}
