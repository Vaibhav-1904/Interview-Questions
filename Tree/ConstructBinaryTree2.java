package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// https://www.youtube.com/watch?v=LgLRTaEMRVc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=36

// Construct a Binary Tree from PostOrder and InOrder traversals
// T->O(n)  ,  S -> O(N)
public class ConstructBinaryTree2 {
    public Node buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < postorder.length; i++){
            map.put(inorder[i], i);
        }

        Node root = buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, map);

        return root;
    }

    public Node buildTree(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map){

        if(postStart > postEnd || inStart > inEnd)
            return null;

        Node root = new Node(postOrder[postEnd]);

        int rootPosition = map.get(root.data);
        int leftNumbers = rootPosition - inStart;

        root.left = buildTree(postOrder, postStart, postStart + leftNumbers - 1, inOrder, inStart, rootPosition - 1, map);
        root.right = buildTree(postOrder, postStart + leftNumbers, postEnd - 1, inOrder, rootPosition + 1, inEnd, map);

        return root;
    }
}
