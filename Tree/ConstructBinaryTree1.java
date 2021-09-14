package ImportantQ.Tree;
import ImportantQ.Tree.Node.Node;
import java.util.*;
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
// Construct a Binary Tree from PreOrder and InOrder traversals

public class ConstructBinaryTree1 {
    // T->O(n)  ,  S -> O(N)
    public Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        Node root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);

        return root;
    }

    public Node buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map){

        if(preStart > preEnd || inStart > inEnd)
            return null;

        Node root = new Node(preOrder[preStart]);

        int rootPosition = map.get(root.data);
        int leftNumbers = rootPosition - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + leftNumbers, inOrder, inStart, rootPosition - 1, map);

        root.right = buildTree(preOrder, preStart + leftNumbers + 1, preEnd, inOrder, rootPosition + 1, inEnd, map);

        return root;
    }
}
