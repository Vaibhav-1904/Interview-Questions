package ImportantQ.Tree.BST;
import ImportantQ.Tree.TreeNode.Node;
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
    public Node insertIntoBST(Node root, int val) {
        if(root == null)
            return new Node(val);
        Node current = root;
        while(true){
            if(val < current.data){
                if(current.left != null)
                    current = current.left;
                else{
                    current.left = new Node(val);
                    break;
                }
            }else{
                if(current.right != null)
                    current = current.right;
                else{
                    current.right = new Node(val);
                    break;
                }
            }
        }
        return root;
    }
}
