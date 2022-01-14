package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
// https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/

public class ChildrenSumProperty {
    public static void changeTree(Node root) {
        if(root == null)
            return;
        int childSum = 0;
        if(root.left != null)
            childSum += root.left.data;
        if(root.right != null)
            childSum += root.right.data;

        if(childSum > root.data)
            root.data = childSum;
        else{
            if(root.left != null)
                root.left.data = root.data;
            if(root.right != null)
                root.right.data = root.data;
        }
        changeTree(root.left);
        changeTree(root.right);

        int temp = 0;
        if(root.left != null)
            temp += root.left.data;
        if(root.right != null)
            temp += root.right.data;

        if(root.left != null || root.right != null) // for checking if it is a leaf node or not
            root.data = temp;
    }
}
