package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// https://leetcode.com/problems/binary-tree-paths/submissions/
// return all the Leaf node paths in form of String in a List of String.
public class LeafNodePaths {
    public List<String> binaryTreePaths(Node root) {
        List<String> result = new ArrayList<>();
        leafPaths(result, root, "");
        return result;
    }

    boolean isLeaf(Node node){
        return node != null && node.left == null && node.right == null;
    }

    void leafPaths(List<String> result, Node root, String current){
        if(root == null)
            return;
        if(isLeaf(root)){
            current += root.data;
            result.add(current);
            return;
        }
        current += (root.data + "->");
        leafPaths(result, root.left, current);
        leafPaths(result, root.right, current);
    }
}
