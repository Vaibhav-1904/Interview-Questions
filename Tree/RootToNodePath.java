package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.ArrayList;
// https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/

public class RootToNodePath {
    public ArrayList<Integer> solve(Node root, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        path(root, result, b);
        return result;
    }

    public boolean path(Node root, ArrayList<Integer> result, int b){
        if(root == null)
            return false;

        result.add(root.data);
        if(root.data == b)
            return true;

        boolean left = false, right = false;

        if(root.left != null)
            left = path(root.left, result, b);

        if(root.right != null)
            right = path(root.right, result, b);

        if(left || right)
            return true;

        result.remove(result.size() - 1);
        return false;
    }
}
