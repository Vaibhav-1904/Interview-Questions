package ImportantQ.Tree;
import java.util.*;
import ImportantQ.Tree.Node.TreeNode;

// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1#

public class BoundaryOfTree {
    // T -> O(n)  S -> O(n)
    ArrayList <Integer> printBoundary(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(!isLeaf(root))
            result.add(root.val);
        addLeftBoundary(root, result);
        addLeafNodes(root, result);
        addRightBoundary(root, result);
        return result;
    }

    boolean isLeaf(TreeNode node){
        return (node.left == null) && (node.right == null);
    }
    void addLeftBoundary(TreeNode node, ArrayList<Integer> result){
        TreeNode current = node.left;
        while(current != null){
            if(!isLeaf(current))
                result.add(current.val);

            if(current.left != null)
                current = current.left;
            else
                current = current.right;
        }
    }

    void addLeafNodes(TreeNode node, ArrayList<Integer> result){
        if(isLeaf(node)){
            result.add(node.val);
            return;
        }
        if(node.left != null){
            addLeafNodes(node.left, result);
        }
        if(node.right != null){
            addLeafNodes(node.right, result);
        }
    }

    void addRightBoundary(TreeNode node, ArrayList<Integer> result){
        TreeNode current = node.right;
        Stack<Integer> stack = new Stack<>();
        while(current != null){
            if(!isLeaf(current))
                stack.add(current.val);

            if(current.right != null)
                current = current.right;
            else
                current = current.left;
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
    }
}
