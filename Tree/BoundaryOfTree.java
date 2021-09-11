package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1#

public class BoundaryOfTree {
    // T -> O(n)  S -> O(n)
    ArrayList <Integer> printBoundary(Node node)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(!isLeaf(node))
            result.add(node.data);
        addLeftBoundary(node, result);
        addLeafNodes(node, result);
        addRightBoundary(node, result);
        return result;
    }

    boolean isLeaf(Node node){
        return (node.left == null) && (node.right == null);
    }
    void addLeftBoundary(Node node, ArrayList<Integer> result){
        Node current = node.left;
        while(current != null){
            if(!isLeaf(current))
                result.add(current.data);

            if(current.left != null)
                current = current.left;
            else
                current = current.right;
        }
    }

    void addLeafNodes(Node node, ArrayList<Integer> result){
        if(isLeaf(node)){
            result.add(node.data);
            return;
        }
        if(node.left != null){
            addLeafNodes(node.left, result);
        }
        if(node.right != null){
            addLeafNodes(node.right, result);
        }
    }

    void addRightBoundary(Node node, ArrayList<Integer> result){
        Node current = node.right;
        Stack<Integer> stack = new Stack<>();
        while(current != null){
            if(!isLeaf(current))
                stack.add(current.data);

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
