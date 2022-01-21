package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
// https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/

public class ChildrenSumProperty {
    public static void changeTree(TreeNode root) {
        if(root == null)
            return;
        int childSum = 0;
        if(root.left != null)
            childSum += root.left.val;
        if(root.right != null)
            childSum += root.right.val;

        if(childSum > root.val)
            root.val = childSum;
        else{
            if(root.left != null)
                root.left.val = root.val;
            if(root.right != null)
                root.right.val = root.val;
        }
        changeTree(root.left);
        changeTree(root.right);

        int temp = 0;
        if(root.left != null)
            temp += root.left.val;
        if(root.right != null)
            temp += root.right.val;

        if(root.left != null || root.right != null) // for checking if it is a leaf node or not
            root.val = temp;
    }
}
