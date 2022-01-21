package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.*;
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
// Construct a Binary Tree from PreOrder and InOrder traversals

public class ConstructBinaryTree1 {
    // T->O(n)  ,  S -> O(N)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);

        return root;
    }

    public TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map){

        if(preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int rootPosition = map.get(root.val);
        int leftNumbers = rootPosition - inStart;

        root.left = buildTree(preOrder, preStart + 1, preStart + leftNumbers, inOrder, inStart, rootPosition - 1, map);

        root.right = buildTree(preOrder, preStart + leftNumbers + 1, preEnd, inOrder, rootPosition + 1, inEnd, map);

        return root;
    }
}
