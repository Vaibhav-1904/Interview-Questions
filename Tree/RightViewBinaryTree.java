package ImportantQ.Tree;
import ImportantQ.Tree.Node.Node;
import java.util.*;
// https://leetcode.com/problems/binary-tree-right-side-view/

// Given a Binary Tree, print the right view of Binary Tree starting from root level
public class RightViewBinaryTree {
    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    void rightView(Node root, List<Integer> result, int level){
        if(root == null)
            return;

        if(result.size() == level) // For taking only rightmost level nodes and no same level nodes are taken
            result.add(root.data);

        rightView(root.right, result, level + 1);
        rightView(root.left, result, level + 1);
    }

    void leftView(Node root, List<Integer> result, int level){
        if(root == null)
            return;

        if(result.size() == level)
            result.add(root.data);

        leftView(root.left, result, level + 1);
        leftView(root.right, result, level + 1);
    }
}
