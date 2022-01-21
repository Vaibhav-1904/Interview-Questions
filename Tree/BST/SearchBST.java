package ImportantQ.Tree.BST;
import ImportantQ.Tree.Node.TreeNode;
// Binary Search Tree
// Mostly the height of a BST is log n
public class SearchBST {
    // T -> O(log n) Recursive
//    public Node searchBST(Node root, int val) {
//        if(root == null)
//            return null;
//        if(root.data == val)
//            return root;
//
//        if(root.data > val)
//            return searchBST(root.left, val);
//        else
//            return searchBST(root.right, val);
//    }

    // Iterative Approach
    public TreeNode searchBST(TreeNode root, int val){
        while(root != null && root.val != val){
            root = (val < root.val) ? root.left : root.right;
        }
        return root;
    }
}
