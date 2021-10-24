package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
// https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/

public class ChildrenSumProperty {
    public static void changeTree(Node root) {
        if(root == null)
            return;
        int child = 0;
        if(root.left != null)
            child += root.left.data;
        if(root.right != null)
            child += root.right.data;

        if(child > root.data)
            root.data = child;
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

        if(root.left != null || root.right != null)
            root.data = temp;
    }
}
