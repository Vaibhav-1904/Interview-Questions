package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTree {

//    //Recursive Approach T->O(n),  S->O(n)
//    Node pre = null;
//    public void flatten(Node root) {
//        if(root == null)
//            return;
//
//        flatten(root.right);
//        flatten(root.left);
//
//        root.left = null;
//        root.right = pre;
//        pre = root;
//    }

    // In Iterative Solution, you use a Stack, here you start from head of LinkedList instead of reverse list
    // like in Recursive approach

    // Optimal Approach using Morris Traversal
    // S -> O(1)
    public void flatten(Node root) {
        if(root == null)
            return;
        Node current = root;
        while(current != null)
        {
            if(current.left != null){

                Node pre = current.left;
                while(pre.right != null)
                    pre = pre.right;

                pre.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
