package ImportantQ.Tree;
import ImportantQ.Tree.Node.Node;

// https://leetcode.com/problems/same-tree/
public class SameTree {
    public boolean isSameTree(Node p, Node q) {
        if(p == null || q == null)
            return (p == q);

        if(p.data != q.data)
            return false;

        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return left && right;
    }
}
