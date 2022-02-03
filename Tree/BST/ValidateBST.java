package ImportantQ.Tree.BST;
import ImportantQ.Tree.Node.TreeNode;
// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null ,null);
    }

    private boolean validate(TreeNode root,Integer min,Integer max){
        if(root == null)
            return true;

        if(min != null && root.val <= min)
            return false;
        if(max != null && root.val >= max)
            return false;
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
