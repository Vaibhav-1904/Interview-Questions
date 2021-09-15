package ImportantQ.Tree.BST;
import ImportantQ.Tree.TreeNode.Node;
// Ceil is number in BST which is greatest, smaller number than ceil, present in BST
// we need to return a number in BST which is just greater than ceil
public class CeilBST {
    public  static int findCeil(Node node, int ceil) {

        // Write your code here
        int ans = -1;
        while(node != null){
            if(ceil == node.data){
                ans = node.data;
                break;
            }
            if(ceil > node.data){
                node = node.right;
            }else{
                ans = node.data;
                node = node.left;
            }
        }
        return ans;
    }
}
