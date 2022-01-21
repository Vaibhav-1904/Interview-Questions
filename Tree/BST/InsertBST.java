package ImportantQ.Tree.BST;
import ImportantQ.Tree.Node.TreeNode;
// https://leetcode.com/problems/insert-into-a-binary-search-tree/

public class InsertBST {
//    // Recursive
//    public Node insertIntoBST(Node root, int val) {
//        if(root == null)
//        {
//            root = new Node(val);
//            return root;
//        }
//        if(val < root.data){
//            root.left = insertIntoBST(root.left, val);
//        }else{
//            root.right = insertIntoBST(root.right, val);
//        }
//        return root;
//    }

    // Iterative
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        TreeNode current = root;
        while(true){
            if(val < current.val){
                if(current.left != null)
                    current = current.left;
                else{
                    current.left = new TreeNode(val);
                    break;
                }
            }else{
                if(current.right != null)
                    current = current.right;
                else{
                    current.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
