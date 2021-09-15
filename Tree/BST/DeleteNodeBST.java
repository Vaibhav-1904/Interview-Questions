package ImportantQ.Tree.BST;
import ImportantQ.Tree.TreeNode.Node;

public class DeleteNodeBST {
    public Node deleteNode(Node root, int key) {
        if(root == null)
            return null;
        if(root.data == key)
            return helper(root);

        Node temp = root;
        while(root != null){
            if(root.data > key){
                if(root.left != null && root.left.data == key){
                    root.left = helper(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                if(root.right != null && root.right.data == key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return temp;
    }

    public Node helper(Node root){
        if(root.left == null)
            return root.right;
        else if(root.right == null)
            return root.left;

        Node rightChild = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    public Node findLastRight(Node root){
        while(root.right != null)
            root = root.right;
        return root;
    }
}
