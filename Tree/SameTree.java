package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;

// https://leetcode.com/problems/same-tree/
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
            return (p == q);

        if(p.val != q.val)
            return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
}
